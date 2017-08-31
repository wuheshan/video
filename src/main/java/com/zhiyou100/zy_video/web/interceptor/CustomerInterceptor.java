package com.zhiyou100.zy_video.web.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class CustomerInterceptor implements HandlerInterceptor {

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		

	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		

	}

	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object obj) throws Exception {
		if(req.getSession().getAttribute("admin") != null){
			//System.out.println(req.getSession().getAttribute("user"));
			System.out.println("拦截器放行");
			return true;
		}
		else{
			res.sendRedirect(req.getContextPath()+"/index.jsp");
			System.out.println("拦截器拦截");
			return false;
			
		}
	}

}
