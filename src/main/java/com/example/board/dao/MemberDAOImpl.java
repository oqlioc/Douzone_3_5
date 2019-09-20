package com.example.board.dao;
 
import java.util.List;
 
import javax.inject.Inject;
 
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.example.board.model.MemberModel;
 
@Repository
public class MemberDAOImpl implements MemberDAO {
 
    @Inject
    private SqlSession sqlSession;
    
    private static final String Namespace = "com.example.mapper.memberMapper";
    
    @Override
    public List<MemberModel> selectMember() throws Exception {

        return sqlSession.selectList(Namespace + ".selectMember");
    }

	@Override
	public Boolean login(MemberModel memberModel) {
		String user_id = memberModel.getUser_id();
		MemberModel member = sqlSession.selectOne(Namespace + ".selectMemberLogin", user_id);
		
		if(member == null) {
            return false;
        }
		if(!member.getUser_id().equals(memberModel.getUser_id())){
            return false;
        }
        if(!member.getUser_pw().equals(memberModel.getUser_pw())){
            return false;
        }
        
        return true;
	}
}