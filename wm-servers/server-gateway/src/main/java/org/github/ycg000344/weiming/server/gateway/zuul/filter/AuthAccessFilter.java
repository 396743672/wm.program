/** 
 * Project Name:gateway-zuul 
 * File Name:AuthAccessFilter.java 
 * Package Name:org.github.ycg000344.weiming.gateway.zuul.filter 
 * Date:2018年5月17日下午4:52:07 
 * Copyright (c) 2018, lupo.f@outlook.com All Rights Reserved. 
 * 
*/

package org.github.ycg000344.weiming.server.gateway.zuul.filter;

import javax.servlet.http.HttpServletRequest;

import org.github.ycg000344.weiming.application.authclient.config.UserAuthConfig;
import org.github.ycg000344.weiming.application.authclient.jjwt.UserAuthUtil;
import org.github.ycg000344.weiming.common.auth.exception.AuthException;
import org.github.ycg000344.weiming.common.auth.jjwt.bean.IJWTinfo;
import org.github.ycg000344.weiming.common.base.context.BaseContextHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.context.annotation.Configuration;

import com.alibaba.fastjson.JSON;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

import cn.hutool.core.util.StrUtil;
import lombok.extern.slf4j.Slf4j;

/**
 * ClassName:AuthAccessFilter <br/>
 * <br/>
 * Description: 鉴权过滤器 <br/>
 * 判断请求是否属于白名单， <br/>
 * 请求中是否含有token， <br/>
 * 验证token合法性 <br/>
 * <br/>
 * Date: 2018年5月17日 下午4:52:07 <br/>
 * <br/>
 * 
 * @author po.lu
 * @version 1.0.0
 * @since JDK 1.8
 * @see
 */
@Configuration
@Slf4j
public class AuthAccessFilter extends ZuulFilter {

	@Value("${zuul.prefix}")
	private String prefix;
	@Value("${gateway.ignore.startWith}")
	private String startWith;

	@Autowired
	private UserAuthConfig userAuthConfig;
	@Autowired
	private UserAuthUtil userAuthUtil;

	@SuppressWarnings("unused")
	@Override
	public Object run() throws ZuulException {
		log.debug("***weiming专用log***路由网关鉴权过滤器***start***");
		BaseContextHandler.remove();
		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();

		String requestURI = request.getRequestURI().substring(prefix.length());
		String method = request.getMethod();

		if (isStartWith(requestURI)) {
			log.debug("***weiming专用log***路由网关鉴权过滤器***本次请求：【{}】属于请求白名单***",requestURI);
			return null;
		}

		IJWTinfo user = null;
		try {
			user = getJWTUser(request, ctx);
			log.debug("***weiming专用log***路由网关鉴权过滤器***token信息为：标识id：【{}】，名称：【{}】***",user.getUniqueName(),user.getName());
			log.debug("***weiming专用log***路由网关鉴权过滤器***successful***");
		} catch (Exception e) {
			log.error("***weiming专用log***路由网关鉴权过滤器***error***请求token非法***");
			setFailedRequest(JSON.toJSONString(new AuthException(e.getMessage())), 500);
		}
		return null;
	}

	/**
	 * setFailedRequest:网关抛异常. <br/>
	 * 
	 * @author po.lu
	 * @param body
	 * @param code
	 * @since JDK 1.8
	 * @see
	 */
	private void setFailedRequest(String body, int code) {
		log.debug("***weiming专用log***路由网关鉴权过滤器***Reporting error ({}): {}***",code, body);
		RequestContext ctx = RequestContext.getCurrentContext();
		ctx.setResponseStatusCode(code);
		if (ctx.getResponseBody() == null) {
			ctx.setResponseBody(body);
			ctx.setSendZuulResponse(false);
		}
	}

	/**
	 * getJWTUser:. <br/>
	 * 
	 * @author po.lu
	 * @param request
	 * @param ctx
	 * @return
	 * @throws Exception 
	 * @since JDK 1.8
	 * @see
	 */
	private IJWTinfo getJWTUser(HttpServletRequest request, RequestContext ctx) throws Exception {
		String authToken = request.getHeader(userAuthConfig.getTokenHeader());
		if (StrUtil.isBlank(authToken)) {
			authToken = request.getParameter("token");
		}
		ctx.addZuulRequestHeader(userAuthConfig.getTokenHeader(), authToken);
		BaseContextHandler.setToken(authToken);
		return userAuthUtil.getInfoFromToken(authToken);
	}

	/**
	 * isStartWith:拦截白名单. <br/>
	 * 
	 * @author po.lu
	 * @param requestURI
	 * @return
	 * @since JDK 1.8
	 * @see
	 */
	private boolean isStartWith(String requestURI) {
		return StrUtil.split(startWith, StrUtil.C_COMMA).parallelStream().anyMatch(s -> requestURI.startsWith(s));
	}

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public int filterOrder() {
		return 0;
	}

	@Override
	public String filterType() {
		return FilterConstants.PRE_TYPE;
	}

}
