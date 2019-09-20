package com.example.board.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.board.model.MemberModel;
import com.example.board.service.MemberService;

@Controller
@RequestMapping(value="/member")
public class MemberController {
	
	@Inject
	MemberService memberService;
	
	@RequestMapping("/login")
	public String home(MemberModel memberModel, HttpServletRequest request){
		if (memberService.login(memberModel)) {
			System.out.println(" 로그인 성공 입니다. ");

			HttpSession session = request.getSession();
			session.setAttribute("userId", memberModel.getUserId());

			return "main";
		} else {
			System.out.println(" 아이디와 비밀번호를 다시 확인 하세요. ");
			return "loginform";
		}
	}
	
	@RequestMapping("logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "main";
	}

}
