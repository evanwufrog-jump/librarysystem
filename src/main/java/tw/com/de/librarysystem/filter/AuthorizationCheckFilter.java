package tw.com.de.librarysystem.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

import static org.springframework.http.HttpHeaders.AUTHORIZATION;
import static org.springframework.http.HttpStatus.FORBIDDEN;
import static org.springframework.http.HttpStatus.UNAUTHORIZED;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

//此filter註冊於config/WebSecurityConfig
public class AuthorizationCheckFilter extends OncePerRequestFilter {
    //建立白名單
    private static List<String> whileList = new ArrayList<String>(Arrays.asList("/login","/forgotPassword"));
//檢查授權???
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        boolean isWhite=false;
        //判斷是否在白名單內
        for (String str: whileList) {
            if(request.getServletPath().equals(str)){
                isWhite=true;
                break;
            }
        }

        //如果不是白名單request(如登入、忘記密碼)就攔截
//        if(!StringUtils.equalsAny(request.getServletPath(),"/login","/forgotPassword")){
        if(!isWhite){
//            System.out.println("不是登入，遭到攔截!!");
            String authorHeader =  request.getHeader(AUTHORIZATION);
            String bearer ="Bearer ";

            //以jjwt驗證token，只要驗證成功就放行
            //驗證失敗會拋exception，直接將錯誤訊息傳回
            if(authorHeader!= null && authorHeader.startsWith(bearer)){
                try{
                    String token = authorHeader.substring(bearer.length());
                    Claims claims = Jwts.parser().setSigningKey("libsysKey")
                            .parseClaimsJws(token).getBody();
                    filterChain.doFilter(request, response);
//                    System.out.println("token驗證成功");

                }catch(Exception e){
                    System.err.println("Error : "+e);
                    response.setStatus(FORBIDDEN.value());
                    Map<String, String> err = new HashMap<>();
                    err.put("jwt_err", e.getMessage());
                    response.setContentType(APPLICATION_JSON_VALUE);
                    //此段err為攔截成功後發現token失效的錯誤訊息，需要修改成前端截收到的訊息
                    //前端接收到訊息後可以考慮重新導向回登入頁面
                    new ObjectMapper().writeValue(response.getOutputStream(), err);
//                    System.out.println("token錯誤");
                }
            }else{
                response.setStatus(UNAUTHORIZED.value());
//                System.out.println("缺少token");
            }
        }else{
//            System.out.println("登入方法!! 不需要被filter");
            filterChain.doFilter(request, response);
        }
    }
}

