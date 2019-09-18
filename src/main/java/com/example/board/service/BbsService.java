package com.example.board.service;

import java.util.List;

import org.springframework.ui.Model;

import com.example.board.model.MemberModel;

public interface BbsService {

	List<MemberModel> getBoardList(Model model);
	MemberModel getDetail(Model model);
	void setReadCountUpdate(Model model);
	boolean isBoardWriter(Model model);
}
