package com.sokoban.member.service;

import com.sokoban.member.aggregate.Member;
import com.sokoban.member.repository.MemberRepository;
import com.sokoban.session.SessionStorage;

public class MemberService {
    private final MemberRepository memberRepository = new MemberRepository();

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

    public void modifyMemberInfo(String modifyValue, String modifyColumn) {
        Member member = SessionStorage.getMember();

        switch (modifyColumn) {
            case "id":
                member.setId(modifyValue);
                break;
            case "pwd":
                member.setPwd(modifyValue);
                break;
            case "name":
                member.setName(modifyValue);
                break;
        }

        int flag = memberRepository.modifyMemberInfo(member,modifyColumn);

        if(flag>0){
            System.out.println("회원 정보가 수정되었습니다.");
        }
        else {
            System.out.println("회원 정보가 수정에 실패했습니다.");
        }
    }
}
