package com.DYC.demo;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.net.Authenticator;

@Controller
@RequiredArgsConstructor
public class MemberController {
    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    @GetMapping("/signUp")
    String signUp(){
        return "signUp";
    }

    @PostMapping("/logadd")
    String addPost(String username, String password, String displayName) {
        var hashedPass = new BCryptPasswordEncoder().encode(password);
        Member member = new Member();
        member.username = username;
        member.password = hashedPass;
        member.displayName = displayName;

        Member saved = memberRepository.save(member);
        System.out.println(saved.toString());
        return "redirect:/list";
    }

    @GetMapping("/login")
    public String login(){
        var result = memberRepository.findByUsername("어드민");
        System.out.println(result);
        return "login";
    }

    @GetMapping("/mypage")
    public String mypage(Authentication auth){

        return "mypage";
    }
}
