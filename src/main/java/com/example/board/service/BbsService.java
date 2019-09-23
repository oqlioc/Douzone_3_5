package com.example.board.service;

import java.util.List;
import java.util.Map;

import org.springframework.ui.Model;

import com.example.board.model.BbsModel;
import com.example.board.model.Criteria;

public interface BbsService {

	List<BbsModel> getBoardList(Model model);
	int bbsCreate(Map<String, Object> paramMap);
	BbsModel bbsRead(int bbsno);
	void bbsDelete(int bbsno);
	void bbsModify(BbsModel bbsmodel);
	
	//-----------------------------------
	List<BbsModel> listCriteria(Criteria criteria);
	int countBbs(Criteria criteria);
}
