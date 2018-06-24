/** 
 * Project Name:emailsend-api 
 * File Name:CanceledEmailInfo.java 
 * Package Name:org.github.ycg000344.weiming.components.emailsend.api.bean.impl 
 * Date:2018年5月11日上午9:54:56 
 * Copyright (c) 2018, lupo.f@outlook.com All Rights Reserved. 
 * 
*/

package org.github.ycg000344.weiming.common.emailsend.bean.impl;

import java.util.Map;

import org.github.ycg000344.weiming.common.emailsend.bean.BaseEmailInfo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * ClassName:CanceledEmailInfo <br/>
 * <br/>
 * Description: EurekaInstanceCanceledEvent 服务挂掉发送邮件的信息 <br/>
 * <br/>
 * Date: 2018年5月11日 上午9:54:56 <br/>
 * <br/>
 * 
 * @author po.lu
 * @version 1.0.0
 * @since JDK 1.8
 * @see
 */
@Getter
@Setter
@ToString
public class EurekaInstanceCanceledEventEmailinfo extends BaseEmailInfo {

	/**
	 * serialVersionUID
	 * 
	 * @since JDK 1.8
	 */
	private static final long serialVersionUID = 6523835801780377475L;
	private String instanceId;

	private String appName;

	private String appGroupName;

	private String ipAddr;

	private String SID_DEFAULT;

	private int port;
	private int securePort;

	private String homePageUrl;

	private String statusPageUrl;

	private String healthCheckUrl;

	private String secureHealthCheckUrl;

	private String vipAddress;

	private String secureVipAddress;

	private String statusPageRelativeUrl;

	private String statusPageExplicitUrl;

	private String healthCheckRelativeUrl;

	private String healthCheckSecureExplicitUrl;

	private String vipAddressUnresolved;

	private String secureVipAddressUnresolved;

	private String healthCheckExplicitUrl;
	private boolean isUnsecurePortEnabled = true;
	private String hostName;

	private boolean isInstanceInfoDirty = false;

	private Boolean isCoordinatingDiscoveryServer = Boolean.FALSE;

	private Map<String, String> metadata;

	private Long lastUpdatedTimestamp;

	private Long lastDirtyTimestamp;

	private String asgName;
	private String version;
}
