package com.example.board.service;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.example.board.dao.BbsDAO;
import com.example.board.model.BbsModel;

@Service
public class BbsServiceImpl implements BbsService{
	
	@Inject
	private BbsDAO bbsdao;

	@Override
	public List<BbsModel> getBoardList(Model model) {
		return bbsdao.getBoardList();
	}

	@Override
	public int bbsCreate(Map<String, Object> paramMap) {
		return bbsdao.bbsCreate(paramMap);
	}

	@Override
	public BbsModel bbsRead(int bbsno) {
		return bbsdao.bbsRead(bbsno);
	}

	@Override
	public void bbsDelete(int bbsno) {
		bbsdao.bbsDelete(bbsno);
	}

	@Override
	public void bbsModify(BbsModel bbsmodel) {
		bbsdao.bbsModify(bbsmodel);
	}

}
