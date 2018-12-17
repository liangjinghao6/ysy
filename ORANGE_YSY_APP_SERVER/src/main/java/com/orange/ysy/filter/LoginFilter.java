package com.orange.ysy.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

//@WebFilter(filterName="myFilter",urlPatterns="/*/*")
public class LoginFilter implements Filter {
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		System.out.println("Filter启动");
	}

	/*
	 * @Override public void doFilter(ServletRequest request, ServletResponse
	 * response, FilterChain chain) throws IOException, ServletException {
	 * System.out.println("==>DemoFilter拦截请求"); chain.doFilter(request,
	 * response);
	 * 
	 * }
	 */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		// 不过滤的uri
		String[] notFilter = new String[] { "/login" , "/css/", "/AdminLTE/", "/js/", "/images/", "/service/", "/time"};

		// 请求的uri
		String uri = ((HttpServletRequest) request).getRequestURI();
		// response.reset();
		boolean doFilter = true;
		for (String s : notFilter) {
			if (uri.indexOf(s) != -1) {
				// 如果uri中包含不过滤的uri，则不进行过滤
				doFilter = false;
				break;
			}
		}
		// boolean doFilter = true;

		if (doFilter) {
			// 执行过滤
			// 从session中获取登录者实体

			Object authUser = ((HttpServletRequest) request).getSession().getAttribute("user");
			response.setContentType("text/html; charset=utf-8");

			// response.reset();

			if (null == authUser) {
				// 如果session中不存在登录者实体，则弹出框提示重新登录
				// 设置request和response的字符集，防止乱码
				// request.setCharacterEncoding("UTF-8");
				// response.setCharacterEncoding("UTF-8");
				PrintWriter out = response.getWriter();
				StringBuilder builder = new StringBuilder();
				builder.append("<script type=\"text/javascript\">");
				builder.append("alert('网页过期，请重新登录！');");
				builder.append("window.top.location.href='" + ((HttpServletRequest) request).getContextPath()
						+ "/login';");
				builder.append("</script>");
				out.print(builder.toString());
				// response.getWriter().close();
				// ((HttpServletResponse)
				// response).sendRedirect(((HttpServletRequest)
				// request).getContextPath()+"/user/login");
			} else {
				// 如果session中存在登录者实体，则继续
				/*
				 * boolean havePrivi = false; for (Sys_Action act :
				 * authUser.getAuthorizedActions()) { if
				 * (uri.contains(act.getActionHref())) { havePrivi = true;
				 * break; }
				 */
				// }
				/*
				 * if (havePrivi) { filterChain.doFilter(request, response); }
				 * else { out.print("你没有该页面的访问权限"); }
				 */
				// response.getWriter().close();

				filterChain.doFilter(request, response);

			}
		} else {
			// 如果不执行过滤，则继续
			// response.getWriter().close();
			filterChain.doFilter(request, response);

		}

	}

	@Override
	public void destroy() {

	}

}
