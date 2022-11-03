package tw.com.de.librarysystem.controller;

import com.google.gson.Gson;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import tw.com.de.librarysystem.entity.impl.Member;
import tw.com.de.librarysystem.service.MemberService;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

//驗證使用者帳號密碼並生成token
public class JwtVerifyUser{

    @Autowired
    MemberService memberService;

    public String userVerify(String email, String password){
        Member member = memberService.findMemberByEmail(email);

        //設定30min過期時間
        Date expireDate =
            new Date(System.currentTimeMillis() + 30 * 60 * 1000);
        String jwt = Jwts.builder()
                    .setSubject(email) //以email當subject
                    .setExpiration(expireDate)
                    //libsysKey是整個登入系統使用的私鑰，不可外流，可變更為任意字串
                    //HS512是自選的演算法，可以替換成其他算法
                    .signWith(SignatureAlgorithm.HS512, "libsysKey")
                    .compact();
            //暫時不將權限數值放入token，亦不做主動掌控token入資料庫的設計，只驗證token是否從此本伺服器發出即可
            //之後Token在前端必須存入Cookie，並且對該 Cookie 使用 HttpOnly 和 Secure Flag 讓 Cookie 內容不能被 JavaScript 讀取
            //避免XSS跨站攻擊(XSS)
        Map<String, String> ResponseMap = new HashMap();
        if(null!=member){
            ResponseMap.put("loginStatus","success");
            ResponseMap.put("jwt",jwt);
        }else{
            ResponseMap.put("loginStatus","fail");
        }
        String loginResponse= new Gson().toJson(ResponseMap);

        return loginResponse;
    }

    public void setMemberService(MemberService memberService) {
        this.memberService = memberService;
    }
}
