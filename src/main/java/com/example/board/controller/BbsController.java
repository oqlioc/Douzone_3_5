package com.example.board.controller;

import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.board.model.MemberModel;
import com.example.board.service.BbsService;
import com.example.board.service.MemberService;

@Controller
public class BbsController {

	private static final Logger logger = LoggerFactory.getLogger(BbsController.class);

	@Inject
	private MemberService memberservice;
	
	@Inject
	private BbsService bbsservice;
	
	@RequestMapping("/")
	public String home(Model model) throws Exception {
		List<MemberModel> memberList = memberservice.selectMember();

		model.addAttribute("memberList", memberList);

		return "home";
	}
	
//	@RequestMapping("/")
//	public String home() throws Exception {
//
//		return "main";
//	}
	
	@RequestMapping("/loginform")
	public String loginform() throws Exception {

		return "loginform";
	}
	
	@RequestMapping("/board_list")
	public String board_list(Model model, HttpServletRequest request) throws Exception {
		model.addAttribute("request", request);

		List<MemberModel> boardList = bbsservice.getBoardList(model); // ����Ʈ �޾ƿ���
		model.addAttribute("boardlist", boardList);
		return "board_list";
	}

}