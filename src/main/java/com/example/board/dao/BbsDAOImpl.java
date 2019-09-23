package com.example.board.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.board.model.BbsModel;

@Repository
public class BbsDAOImpl implements BbsDAO {

	@Autowired
	SqlSession session;

	private static final String Namespace = "com.example.mapper.bbsMapper";
	
	@Override
	public List<BbsModel> getBoardList() {
		List<BbsModel> boardList = session.selectList(Namespace + ".selectBbslist");

		return boardList;
	}

	@Override
	public int bbsCreate(Map<String, Object> paramMap) {
		 
		return session.insert(Namespace + ".insertBbs", paramMap);
	}

	@Override
	public BbsModel bbsRead(int bbsno) {
		BbsModel bbs = session.selectOne(Namespace + ".selectBbs", bbsno);

		return bbs;
	}

	@Override
	public void bbsDelete(int bbsno) {
		session.delete(Namespace + ".deleteBbs", bbsno);
	}

	@Override
	public void bbsModify(BbsModel bbsModel) {
		System.out.println(bbsModel.toString());
		session.update(Namespace + ".updateBbsModify", bbsModel);
	}
//--------------------------------
	@Override
	public List<BbsModel> listPaging(int page) {
		if (page <= 0) {
			page = 1;
		}
		
		page = (page -1) * 10;
		return session.selectOne(Namespace + ".listpaging", page);
	}
}
