package com.sokoban.session;

import com.sokoban.member.aggregate.Member;

public class SessionStorage {
    private static Member member;

    public static void setMember(Member member) {
        SessionStorage.member = member;
    }

    public static Member getMember() {
        return member;
    }
}
