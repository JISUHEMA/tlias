package com.eden.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.eden.entity.User;
import com.eden.service.UserService;
import com.eden.util.VerifyCodeUtils;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("user")
public class UserController {
	
	private static final Logger log=LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("login")
	public String login(String username,String password,HttpSession session ) throws UnsupportedEncodingException {
		
		log.debug("受けたユーザー名:{},パスワード:{}",username,password);
		
		try {
			User user=userService.login(username,password);
			
			session.setAttribute("user",user);
			
		} catch (Exception e) {
			
			e.printStackTrace();
			return "redirect:/login.jsp?msg="+URLEncoder.encode(e.getMessage(),"UTF-8");
		}
		
		    return "redirect:/employee/list" ;
		
	}
	@RequestMapping("register")
	public String register(User user,String code,HttpSession session) throws UnsupportedEncodingException {
		/*System.out.println(user.getUsername());
		System.out.println(user.getRealname());
		System.out.println(user.getPassword());
		System.out.println(user.isGender());
		System.out.println(code);*/
		
		log.debug("受けた検証コード:{}",code);
		log.debug("ユーザー名:{},名前:{},パスワード:{},性別:{}",
				user.getUsername(),user.getRealname(),user.getPassword(),user.isGender());
		
		try {
			String sessionCode =session.getAttribute("code").toString();
			
			if(!sessionCode.equalsIgnoreCase(code)) throw new RuntimeException("入力した検証コードが間違いています");
			
			userService.register(user);
		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
			
			return "redirect:/regist.jsp?msg="+URLEncoder.encode(e.getMessage(),"UTF-8");
		}
		
		return "redirect:/login.jsp";
	}
	
	@RequestMapping("generateImageCode")
	public void generateImageCode(HttpSession session,HttpServletResponse response) throws IOException {
		
		String code=VerifyCodeUtils.generateVerifyCode(4);
		
		session.setAttribute("code", code);
		
		response.setContentType("image/png");
		
		ServletOutputStream os=response.getOutputStream();
		
		VerifyCodeUtils.outputImage(200, 60, os, code);
	}

}
