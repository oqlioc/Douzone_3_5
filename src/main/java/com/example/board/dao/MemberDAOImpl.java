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
		String userId = memberModel.getUserId();
		MemberModel member = sqlSession.selectOne(Namespace + ".selectMemberLogin", userId);
		System.out.println("userId = "+userId);
		System.out.println(member.getUserId());
		System.out.println(member.getUserPw());
		
		if(member == null) {
            return false;
        }
		if(!member.getUserId().equals(memberModel.getUserId())){
            return false;
        }
        if(!member.getUserPw().equals(memberModel.getUserPw())){
            return false;
        }
        
        return true;
	}
}