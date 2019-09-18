package com.example.board.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.example.board.model.MemberModel;

@Service
public class BbsServiceImpl implements BbsService{

	@Override
	public List<MemberModel> getBoardList(Model model) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MemberModel getDetail(Model model) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setReadCountUpdate(Model model) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isBoardWriter(Model model) {
		// TODO Auto-generated method stub
		return false;
	}

}
