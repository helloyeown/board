package org.zerock.b52.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Configuration
@Log4j2
@RequiredArgsConstructor
@EnableMethodSecurity
// 어노테이션으로 시큐리티(권한)에 대한 설정 가능하게 함 
public class CustomSecurityConfig {

    private final DataSource dataSource;
    // private final CustomOAuth2UserService customOAuth2UserService;

    @Bean
    public PasswordEncoder passwordEncoder(){
        // 패스워드 검증하는 과정에서 패스워드 인코더를 사용하겠다는 설정
        return new BCryptPasswordEncoder();
    }


    public PersistentTokenRepository persistentTokenRepository() {
        JdbcTokenRepositoryImpl repo = new JdbcTokenRepositoryImpl();
        repo.setDataSource(dataSource);
        // 데이터베이스와의 연결을 설정
        return repo;
    }


    @Bean
    public SecurityFilterChain filterChain(final HttpSecurity http) throws Exception {
        log.info("filter chain...............");

        // http.formLogin(Customizer.withDefaults());

        http.formLogin(config -> {
            config.loginPage("/member/signin");
        });

        http.csrf(config -> {
            config.disable();
        });

        http.rememberMe(config -> {
            config.tokenRepository(persistentTokenRepository());
            config.tokenValiditySeconds(60 * 60 * 24 * 7);
        });

        // http.oauth2Login(config -> {
        //     config.loginPage("/member/signin");
        //     config.successHandler(new CustmOAuthSuccessHandler());
		// });

        return http.build();
    }

}
