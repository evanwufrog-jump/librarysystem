package tw.com.de.librarysystem.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import tw.com.de.librarysystem.filter.AuthorizationCheckFilter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //關掉csrf保護
        http.csrf().disable();
        //不寫session了(不確定是否為影響其他人功能)
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        //加入權限驗證filter，之後需要取消註解
//        http.addFilterBefore(new AuthorizationCheckFilter(), BasicAuthenticationFilter.class);
    }
}
