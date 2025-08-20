package com.sokoban.member.service;

import com.sokoban.member.aggregate.Member;
import com.sokoban.member.repository.MemberRepository;

public class MemberService {
    MemberRepository memberRepository = new MemberRepository();
    public boolean loginValidationCheck(String id,String pwd) {
        return memberRepository.checkLoginValidation(id,pwd);
    }

    public void registMember(Member registMember) {
        int flag = memberRepository.registMember(registMember);
        if(flag==1) System.out.println("회원 가입 처리 완료");
        else{
            System.out.println("회원가입이 실패 했습니다.");
        }
    }
}
