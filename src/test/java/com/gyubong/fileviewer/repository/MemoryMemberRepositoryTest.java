package com.gyubong.fileviewer.repository;

import com.gyubong.fileviewer.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class MemoryMemberRepositoryTest {
    MemoryMemberRepository repository = new MemoryMemberRepository();

    /*
        Test가 끝날때마다 해당 함수를 호출하여 초기화를 진행함
     */
    @AfterEach
    public void afterEach() {
        repository.clearStore();
    }

    @Test
    public void save() {
        Member member = new Member();
        member.setName("gyubong");
        repository.save(member);

        Member result = repository.findById(member.getId()).get();

        assertThat(member).isEqualTo(result);
    }

    @Test
    public void findByName(){
        Member member1 = new Member();
        member1.setName("aa");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("bb");
        repository.save(member2);

        Member result = repository.findByName("aa").get();

        assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll(){
        Member member1 = new Member();
        member1.setName("aa");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("bb");
        repository.save(member2);

        List<Member> resultList = repository.findAll();

        assertThat(resultList.size()).isEqualTo(2);
    }


}
