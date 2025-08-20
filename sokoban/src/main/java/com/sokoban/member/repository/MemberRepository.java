package com.sokoban.member.repository;

import com.sokoban.member.aggregate.Member;

import java.io.*;
import java.util.ArrayList;

public class MemberRepository {
    private final ArrayList<Member> members = new ArrayList<>();
    private final String path = "src/main/java/com/sokoban/member/db/memberDB.dat";
    private final File file = new File(path);

    public MemberRepository() {
        if (!file.exists()) {
            ArrayList<Member> member = new ArrayList<>();
            member.add(new Member(1, "userId", "userPwd", "userNickname", 0));
            setMember(member);
        }
        getMember();
    }

    private void setMember(ArrayList<Member> memberArr) {
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)));
            for (Member member : memberArr) {
                oos.writeObject(member);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (oos != null) oos.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private void getMember() {
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)));
            while(true){
                members.add((Member)ois.readObject());
            }
        } catch(EOFException e){
            System.out.println("getMember");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }catch (IOException e) {
            throw new RuntimeException(e);
        }finally{
            try {
                if(ois!=null)ois.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public boolean checkLoginValidation(String id, String pwd) {
        boolean flag = false;
        for(Member member : members){
            if(member.getId().equals(id) && member.getPwd().equals(pwd)){
                flag = true;
                break;
            }
        }
        return flag;
    }
}
