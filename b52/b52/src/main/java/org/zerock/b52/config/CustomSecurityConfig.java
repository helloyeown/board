import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import lombok.extern.log4j.Log4j2;

@Configuration
@Log4j2
@EnableMethodSecurity
public class CustomSecurityConfig {
    
    @Bean
	public PasswordEncoder passwordEncoder(){

		return new BCryptPasswordEncoder();
	}
	
	@Bean
	public SecurityFilterChain filterChain(final HttpSecurity http) throws Exception{

		log.info("filter chain------------------------------");

		// /login 경로 로그인 페이지 띄우기

		// http.formLogin(Customizer.withDefaults());

		http.formLogin(config -> {
			config.loginPage("/member/signin");
		});

		http.csrf(config -> {
			config.disable();
		});

		return http.build();
	}

}
