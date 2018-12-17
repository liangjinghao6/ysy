package com.sifude.lejane.filter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.sifude.annotations.ULifePermission;
import com.sifude.lejane.service.ICommonService;
import com.sifude.tool.util.entity.ResultUtil;

/**
 * 
 * @author jinghao.liang
 *
 */
public class MainFilter extends HandlerInterceptorAdapter {
	private static Logger log = LoggerFactory.getLogger(MainFilter.class);

	 @Resource(name = "commonService")
	 private ICommonService commonService;
	
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		String path = request.getRequestURI();
		ULifePermission permissionAnnotation = null;
		if(handler instanceof HandlerMethod) {
			permissionAnnotation = ((HandlerMethod) handler).getMethod().getDeclaredAnnotation(ULifePermission.class);
		}
		String[] permission = permissionAnnotation == null ? null : permissionAnnotation.value();
		log.debug(path + "(" + StringUtils.join(permission, "|") + ")");
		
		try {
			commonService.checkUser(request, permission);
		} catch (Exception e) {
			log.error(e.getMessage());
			response.setContentType("text/html;charset=utf-8");
			response.getWriter().write(ResultUtil.returnJson(e));
			response.getWriter().flush();
			response.getWriter().close();
			return false;
		}
		return true;
	}

}