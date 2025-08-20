package com.sokoban.member.aggregate;

import java.io.Serializable;

public class Member implements Serializable {
    private int memberNo;
    private String id;
    private String pwd;
    private String name;
    private int highestStageNo;

    public Member() {
    }

    public Member(int memberNo, String id, String pwd, String name, int highestStageNo) {
        this.memberNo = memberNo;
        this.id = id;
        this.pwd = pwd;
        this.name = name;
        this.highestStageNo = highestStageNo;
    }

    public int getMemberNo() {
        return memberNo;
    }

    public void setMemberNo(int memberNo) {
        this.memberNo = memberNo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHighestStageNo() {
        return highestStageNo;
    }

    public void setHighestStageNo(int highestStageNo) {
        this.highestStageNo = highestStageNo;
    }

    @Override
    public String toString() {
        return "Member{" +
                "memberNo=" + memberNo +
                ", id='" + id + '\'' +
                ", pwd='" + pwd + '\'' +
                ", name='" + name + '\'' +
                ", highestStageNo=" + highestStageNo +
                '}';
    }
}
