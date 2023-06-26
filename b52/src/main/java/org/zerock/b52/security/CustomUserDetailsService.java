package org.zerock.b52.security;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class CustomUserDetailsService implements UserDetailsService {

    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        log.info("===============================");
		log.info("loaduser..." + username);
		log.info("------------------------------------------");

        UserDetails user = User.builder().username(username).password(passwordEncoder.encode("1111")).authorities("ROLE_USER", "ROLE_G1").build();

        return user;

    }
    
}
