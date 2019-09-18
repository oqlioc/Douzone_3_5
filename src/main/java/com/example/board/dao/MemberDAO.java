package com.example.board.dao;
 
import java.util.List;

import com.example.board.model.MemberModel;
 
public interface MemberDAO {
    
    public List<MemberModel> selectMember() throws Exception;
}