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
		
		if(!member.getUserId().equals(memberModel.getUserId())){
            return false;
        }
        if(!member.getUserPw().equals(memberModel.getUserPw())){
            return false;
        }
        
        return true;
	}
	
	@Override
	public Boolean jsonIdCheck(String userId) {
		int count = sqlSession.selectOne(Namespace + ".jsonIdCheck", userId);
		if(count>0) {
			return true;
		}
		return false;
	}

	@Override
	public int insertMember(MemberModel memberModel) {
		int count = sqlSession.insert(Namespace + ".insertMember",memberModel);
		return 0;
	}
	
	
	
}