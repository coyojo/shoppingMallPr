package com.example.shop.config;

import com.example.shop.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity   // Spring Security를 활성화하는 애너테이션, 사용자 정의 보안 설정을 적용할 수 있다.
public class SecurityConfig {
    @Autowired
    MemberService memberService;

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
       return http
               .formLogin(formLoginCustomizer -> formLoginCustomizer
                .loginPage("/members/login") // 사용자 정의 로그인 페이지 경로
                .defaultSuccessUrl("/")  // 로그인 성공 시 이동할 URL
                .usernameParameter("email") // 로그인시 사용할 입력 필드 파라미터 이름을 email로 지정
                .failureUrl("/members/login/error"))  // 로그인 실패 시 리다이렉트할 url
               .logout(logoutCustomizer -> logoutCustomizer
                .logoutRequestMatcher(new AntPathRequestMatcher("/members/logout"))
                .logoutSuccessUrl("/"))
               .build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


}
