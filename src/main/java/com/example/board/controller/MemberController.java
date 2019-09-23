package com.example.board.controller;
import java.io.IOException;
import java.io.PrintWriter;
import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
	
	@RequestMapping("/join_form")
	public String join(HttpServletRequest request){
		return "joinform";	
	}
	
//	joinIdCheckJson
	@RequestMapping("/joinIdCheckJson")
	public String joinIdCheckJson(HttpServletRequest request, HttpServletResponse response ){
		String userId = request.getParameter("userId");
		Boolean isDuplicated = false;
		isDuplicated = memberService.jsonIdCheck(userId);
		response.setContentType("application/json; charset=UTF-8");
		PrintWriter out;
		try {
			out = response.getWriter();
			out.println(isDuplicated);	
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@RequestMapping("/joinPro")
	public String joinPro(HttpServletRequest request, HttpServletResponse response , MemberModel memberModel, String userAdd1,String userAdd2,String userAdd3,String userAdd4){
		if("".equals(userAdd1)) {
			userAdd1="";
		}
		if("".equals(userAdd2)) {
			userAdd2="";
		}
		if("".equals(userAdd3)) {
			userAdd3="";
		}
		if("".equals(userAdd4)) {
			userAdd4="";
		}
		memberModel.setUserAdd(userAdd1+" "+userAdd3+" "+userAdd4);
		
		//아이디 중복 확인
		Boolean isDuplicated = false;
		isDuplicated = memberService.jsonIdCheck(memberModel.getUserId());
		response.setContentType("text/html; charset=UTF-8");
        PrintWriter out;
		if(isDuplicated) {
			try {
				out = response.getWriter();
				out.println("<script>");
		        out.println("alert('아이디 중복검사 해야된다. 버튼 못봄?');");
		        out.println("history.back();");
		        out.println("</script>");
		        out.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		memberService.insertMember(memberModel);
		
		try {
			out = response.getWriter();
			out.println("<script>");
	        out.println("alert('회원가입 완료');");
	        out.println("location.href='/loginform';");
	        out.println("</script>");
	        out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
		}
		return null;
			
	}
	
	@RequestMapping(value="/findPw", method=RequestMethod.GET)
	public String findPw() {
		
		return "findPwView";
	}
	
	@RequestMapping(value="/findPw", method=RequestMethod.POST)
	public String findPwPro(HttpServletRequest request, HttpServletResponse response ,String userId, String userPw){
		
		//아이디 중복 확인
		Boolean isDuplicated = true;
		isDuplicated = memberService.jsonIdCheck(userId);
		response.setContentType("text/html; charset=UTF-8");
        PrintWriter out;
		if(!isDuplicated) {
			try {
				out = response.getWriter();
				out.println("<script>");
		        out.println("alert('존재하지 않는 아이디 입니다.');");
		        out.println("history.back();");
		        out.println("</script>");
		        out.close();
		        return null;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
//		memberService.insertMember(memberModel);
		String pw = memberService.getPw(userId);
		try {
			out = response.getWriter();
			out.println("<script>");
	        out.println("alert('당신의 비밀번호는 "+pw+" 입니다.');");
	        out.println("location.href='/loginform';");
	        out.println("</script>");
	        out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
		}
		return null;
			
	}
}
