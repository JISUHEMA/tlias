package com.eden.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.eden.util.JwtUtils;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Component
public class LoginCheckInterceptor implements HandlerInterceptor{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("preHandle run");
		String url = request.getRequestURI().toString();
		System.out.println(url);
		
		if (url.contains("login")||url.contains("regist")||url.contains("Image")) {
			return true;
		}
		HttpSession session = request.getSession();
		
		String jwt=null;
		if(session.getAttribute("token")!=null) {
		    jwt=session.getAttribute("token").toString();
		}
		if(!StringUtils.hasLength(jwt)) {
			response.sendRedirect(request.getContextPath()+"/login.jsp");
			return false;
		}
		try {
			JwtUtils.parseJWT(jwt);
		} catch (Exception e) {
			
			e.printStackTrace();
			response.sendRedirect(request.getContextPath()+"/login.jsp");
			return false;
		}
		
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		System.out.println("posHandle run");
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		System.out.println("pos1Handle run");
	}

	@Override
	public int hashCode() {
		// TODO 自動生成されたメソッド・スタブ
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		// TODO 自動生成されたメソッド・スタブ
		return super.equals(obj);
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO 自動生成されたメソッド・スタブ
		return super.clone();
	}

	@Override
	public String toString() {
		// TODO 自動生成されたメソッド・スタブ
		return super.toString();
	}

	@Override
	protected void finalize() throws Throwable {
		// TODO 自動生成されたメソッド・スタブ
		super.finalize();
	}

}
