package org.github.ycg000344.weiming.server.gateway.zuul.vo;

import lombok.Data;

@Data
public class BaseLog {
	

    public BaseLog(String method, String requestURI, String id, String name, String host) {
    	this.opt = method;
    	this.uri = requestURI;
    	this.createHost = host;
    	this.createName = name;
    	this.createUser = id;
	}

	/**
     * 操作
     */
    private String opt;

    /**
     * 请求资源
     */
    private String uri;

    /**
     * user_id
     */
    private String createUser;

    /**
     * user_name
     */
    private String createName;

    /**
     * host
     */
    private String createHost;

}