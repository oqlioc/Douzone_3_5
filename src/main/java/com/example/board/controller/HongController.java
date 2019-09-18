package com.example.board.controller;

import java.util.List;
import java.util.Locale;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.board.model.MemberModel;
import com.example.board.service.MemberService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HongController {

	private static final Logger logger = LoggerFactory.getLogger(HongController.class);

	@Inject
	private MemberService service;

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping("/")
	public String home(Model model) throws Exception {
		List<MemberModel> memberList = service.selectMember();

		model.addAttribute("memberList", memberList);

		return "home";
	}

}
