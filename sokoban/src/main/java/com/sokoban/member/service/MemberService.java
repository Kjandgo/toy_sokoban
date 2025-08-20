package com.sokoban.member.service;

import com.sokoban.member.aggregate.Member;
import com.sokoban.member.repository.MemberRepository;
import com.sokoban.session.SessionStorage;

public class MemberService {
    MemberRepository memberRepository = new MemberRepository();

    public boolean loginValidationCheck(String id, String pwd) {
        Member returnMember = memberRepository.checkLoginValidation(id, pwd);
        if (SessionStorage.getMember() == null) {
            SessionStorage.setMember(returnMember);
        } else {
            System.out.println("이미 로그인되어 있습니다.");
        }
        if (returnMember != null) return true;
        else return false;
    }

    public void logoutCheck() {
        if (SessionStorage.getMember() != null) {
            SessionStorage.setMember(null);
        } else {
            System.out.println("이미 로그아웃되어 있습니다.");
        }
    }

    public void registMember(Member registMember) {
        int flag = memberRepository.registMember(registMember);
        if (flag == 1) System.out.println("회원 가입 처리 완료");
        else {
            System.out.println("회원가입이 실패 했습니다.");
        }
    }
}
