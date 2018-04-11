/*
+--------------------------------------------------------------------------
|   Mblog [#RELEASE_VERSION#]
|   ========================================
|   Copyright (c) 2014, 2015 mtons. All Rights Reserved
|   http://www.mtons.com
|
+---------------------------------------------------------------------------
*/
package mblog.web.interceptor;

import mblog.base.utils.LogTool;
import mblog.core.data.AccountProfile;
import mblog.core.hook.interceptor.InterceptorHookManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Enumeration;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 
 * 基础拦截器 - 向 request 中添加一些基础变量
 * 
 * @author langhsu
 * 
 */
@Component
public class BaseInterceptor extends HandlerInterceptorAdapter {

	@Autowired
	private InterceptorHookManager interceptorHookManager;

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		interceptorHookManager.preHandle(request, response, handler);
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        String controllerName=handlerMethod.getBean().getClass().getSimpleName();
        String method=handlerMethod.getMethod().getName();

        ConcurrentHashMap reqMap= new ConcurrentHashMap<>();
        Enumeration enu=request.getParameterNames();
        while(enu.hasMoreElements()){
            String paraName=(String)enu.nextElement();
            reqMap.put(paraName,request.getParameter(paraName));
        }
        LogTool.info(request.getRemoteAddr(),this.getClass());
        LogTool.info(request.getRequestURL().toString(),this.getClass());
		LogTool.info(controllerName+"."+method,this.getClass());
		LogTool.print(reqMap,this.getClass());
		HttpSession httpSession = request.getSession();
		AccountProfile profile=(AccountProfile)httpSession.getAttribute("profile");
		if(profile!=null){
			LogTool.info(profile.getUsername());
			LogTool.info(profile.getName());
			System.out.println(profile.getId());
		}
		return true;
	}
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		request.setAttribute("base", request.getContextPath());
		interceptorHookManager.postHandle(request,response,handler,modelAndView);
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
		super.afterCompletion(request, response, handler, ex);
		interceptorHookManager.afterCompletion(request, response, handler, ex);
	}

	@Override
	public void afterConcurrentHandlingStarted(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		super.afterConcurrentHandlingStarted(request, response, handler);
		interceptorHookManager.afterConcurrentHandlingStarted(request, response, handler);
	}

}
