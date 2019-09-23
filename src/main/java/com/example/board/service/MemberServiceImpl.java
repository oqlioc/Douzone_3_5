package com.example.board.service;
 
import java.util.List;
 
import javax.inject.Inject;
 
import org.springframework.stereotype.Service;

import com.example.board.dao.MemberDAO;
import com.example.board.model.MemberModel;
 
@Service
public class MemberServiceImpl implements MemberService {
 
    @Inject
    private MemberDAO dao;
    
    @Override
    public List<MemberModel> selectMember() throws Exception {
 
        return dao.selectMember();
    }

	@Override
	public Boolean login(MemberModel memberModel) {
		return dao.login(memberModel);
	}

	@Override
	public Boolean jsonIdCheck(String userId) {
		return dao.jsonIdCheck(userId);
	}

	@Override
	public int insertMember(MemberModel memberModel) {
		return dao.insertMember(memberModel);
	}

	@Override
	public String getPw(String userId) {
		return dao.getPw(userId);
	}
	
	
 
}