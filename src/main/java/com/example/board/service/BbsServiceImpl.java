package com.example.board.service;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.example.board.dao.BbsDAO;
import com.example.board.model.BbsModel;
import com.example.board.model.Criteria;

@Service
public class BbsServiceImpl implements BbsService{
	
	@Inject
	private BbsDAO bbsdao;

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

	@Override
	public List<BbsModel> listCriteria(Criteria criteria) {
		return bbsdao.listPaging(criteria);
	}

	@Override
	public int countBbs(Criteria criteria) {
		return bbsdao.countBbs(criteria);
	}

}
