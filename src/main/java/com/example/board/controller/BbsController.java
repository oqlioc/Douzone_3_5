package com.example.board.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.board.model.BbsModel;
import com.example.board.model.MemberModel;
import com.example.board.model.PageModel;
import com.example.board.service.BbsService;
import com.example.board.service.MemberService;

@Controller
@RequestMapping(value="/bbs")
public class BbsController {
	
	@Inject
	private MemberService memberservice;
	
	@Inject
	private BbsService bbsservice;
	
	@RequestMapping("/bbs_list")
	public String board_list(Model model, HttpServletRequest request) throws Exception {
		model.addAttribute("request", request);
		List<BbsModel> boardList = bbsservice.getBoardList(model);
		model.addAttribute("boardlist", boardList);
		return "bbs_list";
	}
    
	@RequestMapping("/write")
	@ResponseBody
	public Object board_write(@RequestParam Map<String, Object> paramMap) throws Exception {
        Map<String, Object> retVal = new HashMap<String, Object>();
 
        int result = bbsservice.bbsCreate(paramMap);
 
        if(result > 0){
            retVal.put("code", "SUCCESS");
            retVal.put("message", "글쓰기에 성공 하였습니다.");
        }else{
            retVal.put("code", "FAIL");
            retVal.put("message", "글쓰기에 실패 하였습니다.");
        }
 
        return retVal;
	}
	
	@RequestMapping("/read")
	public String board_read(@RequestParam(value="bbsno") int bbsno, Model model) throws Exception {		
		BbsModel bbsModel = bbsservice.bbsRead(bbsno);
		model.addAttribute("bbsModel", bbsModel);
		
		return "bbs_detail";
	}
	
	@RequestMapping("/delete")
	public String board_delete(@RequestParam(value="bbsno") int bbsno, Model model) throws Exception {
		bbsservice.bbsDelete(bbsno);
		
		return "redirect:bbs_list";
	}

	@RequestMapping("/modify")
	public String board_modify(BbsModel bbsModel, Model model) throws Exception {
		bbsservice.bbsModify(bbsModel);
		
		return "redirect:bbs_list";
	}
}