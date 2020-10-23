package com.seven.team01.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.seven.team01.model.User;
import com.seven.team01.service.UserService;

@Controller
@RequestMapping("/insertUser.do")
public class UserCreateController {
	private String formViewName = "insertUser";
	@Autowired
	private UserService userService;

	@RequestMapping(method = RequestMethod.GET)
	public String insertUser() {
		return formViewName;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String insertUser(HttpServletRequest request, @Valid @ModelAttribute("user")User user,Errors errors) {
		System.out.println(">>>> UserCreateController  : insertUser");	
		if(errors.hasErrors()){
			return formViewName;
		}
			//Service 메소드 호출
			userService.createUser(user);
			System.out.println(">>>>> Service 메소드 호출");
			return "redirect:/";  //메인페이지
	}

	@ResponseBody //자바 객체를 HTTP 응답 몸체로 전송
	@RequestMapping(value="/ID_Check.do", method=RequestMethod.POST)
	public int checkID(@RequestBody String paramData) { //@RequestBody: HTTP 요청 몸체를 자바 객체로 전달받음
		System.out.println(paramData);
		//클라이언트가 보낸 ID값
		String ID = paramData.trim();
		System.out.println("controller: "+ID);
		int result = userService.checkID(ID);
		return result;
	}
}	


