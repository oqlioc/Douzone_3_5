package com.example.board.dao;
 
import java.util.List;

import com.example.board.model.MemberModel;
 
public interface MemberDAO {
    
    List<MemberModel> selectMember() throws Exception;
    Boolean login(MemberModel memberModel);
    Boolean jsonIdCheck(String userId);
    int insertMember(MemberModel memberModel);
}