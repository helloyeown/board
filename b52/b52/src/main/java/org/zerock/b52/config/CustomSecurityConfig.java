package org.zerock.b52.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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
@EnableMethodSecurity
@RequiredArgsConstructor
public class CustomSecurityConfig {

    private DataSource dataSource;

    @Bean
	public PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}

    @Bean
    public PersistentTokenRepository persistentTokenRepository() {
        JdbcTokenRepositoryImpl repo = new JdbcTokenRepositoryImpl();
        repo.setDataSource(dataSource);
        return repo;
    }

    @Bean
    public SecurityFilterChain filterChain(final HttpSecurity http) throws Exception {

        log.info("scurity chain...................");

        // /member/signin 경로에서 로그인 페이지가 뜨도록 설정
        http.formLogin(config -> {
            config.loginPage("/member/signin");
        });

        // /login url에서 로그인 페이지 뜨도록 설정
        // http.formLogin(Customizer.withDefaults());

        // 인증 시 참고로 사용하는 ‘_csrf’를 사용하지 않겠다는 설정
        http.csrf(config -> {
            config.disable();
        });

        http.rememberMe(config -> {
            config.tokenRepository(persistentTokenRepository());
            config.tokenValiditySeconds(60*60*24*7);
        });

        return http.build();

    }

}
