package com.gyubong.fileviewer;

import com.gyubong.fileviewer.controller.MemberController;
import com.gyubong.fileviewer.repository.MemoryMemberRepository;
import com.gyubong.fileviewer.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public MemberService memberService() {
        return new MemberService(memoryMemberRepository());
    }

    @Bean
    public MemoryMemberRepository memoryMemberRepository() {
        return new MemoryMemberRepository();
    }

}
