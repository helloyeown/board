package org.zerock.b52.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Controller
@Log4j2
@RequestMapping("/member/")
@RequiredArgsConstructor
public class MemberController {
    
    @PreAuthorize("permitAll")
    @GetMapping("signup")
    public void signup(){
        log.info("sign up.......................");
    }

    @PreAuthorize("hasRole('USER')")
    @GetMapping("mypage")
    public void mypage(){
        log.info("my page.......................");
    }

    @PreAuthorize("permitAll")
    @GetMapping("signin")
    public void signin(){
        log.info("sign in...........................");
    }

}
