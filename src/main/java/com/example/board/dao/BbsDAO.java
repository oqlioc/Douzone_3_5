package com.example.board.dao;

import java.util.List;
import java.util.Map;

import com.example.board.model.BbsModel;
import com.example.board.model.Criteria;

public interface BbsDAO {

	int bbsCreate(Map<String, Object> paramMap);
	BbsModel bbsRead(int bbsno);
	void bbsDelete(int bbsno);
	void bbsModify(BbsModel bbsModel);
	List<BbsModel> listPaging(Criteria criteria);
	int countBbs(Criteria criteria);
}