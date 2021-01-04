package com.gyubong.fileviewer.service;

import com.gyubong.fileviewer.domain.Member;
import com.gyubong.fileviewer.repository.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

    MemberService memberService;
    MemoryMemberRepository memoryMemberRepository;

    @BeforeEach
    public void beforeEach() {
        memoryMemberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memoryMemberRepository);
    }

    @AfterEach
    void afterEach(){
        memoryMemberRepository.clearStore();
    }

    @Test
    void join() {
        // given
        Member member = new Member();
        member.setName("aaa");

        // when
        Long saveId = memberService.join(member);

        // then
        Member member1 = memberService.findOne(saveId).get();
        Assertions.assertThat(member.getName()).isEqualTo(member1.getName());
    }

    @Test
    void dupJoin() {
        Member member1 = new Member();
        member1.setName("aaa");

        Member member2 = new Member();
        member2.setName("aaa");

        memberService.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));

    }

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}