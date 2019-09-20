package com.example.board.service;

import java.util.List;

import com.example.board.model.MemberModel;
 
public interface MemberService {
    
    List<MemberModel> selectMember() throws Exception;
    Boolean login(MemberModel memberModel);
    Boolean jsonIdCheck(String userId);
    int insertMember(MemberModel memberModel);
}