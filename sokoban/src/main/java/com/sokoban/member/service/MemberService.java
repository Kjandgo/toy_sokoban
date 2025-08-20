package com.sokoban.member.service;

import com.sokoban.member.repository.MemberRepository;

public class MemberService {
    MemberRepository memberRepository = new MemberRepository();
    public boolean loginValidationCheck(String id,String pwd) {
        return memberRepository.checkLoginValidation(id,pwd);
    }
}
