package com.example.board.controller;

import java.util.List;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.board.model.MemberModel;
import com.example.board.service.MemberService;

@Controller
public class HongController {

	private static final Logger logger = LoggerFactory.getLogger(HongController.class);

	@Inject
	private MemberService service;
	
//	@RequestMapping("/")
//	public String home(Model model) throws Exception {
//		List<MemberModel> memberList = service.selectMember();
//
//		model.addAttribute("memberList", memberList);
//
//		return "home";
//	}
	
	@RequestMapping("/")
	public String home(Model model) throws Exception {
		List<MemberModel> memberList = service.selectMember();

		model.addAttribute("memberList", memberList);

		return "home";
	}

}