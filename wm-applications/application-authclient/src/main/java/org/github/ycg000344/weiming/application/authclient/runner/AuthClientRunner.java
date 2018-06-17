/** 
 * Project Name:auth-client 
 * File Name:AuthClientRunner.java 
 * Package Name:org.github.ycg000344.weiming.authclient.runner 
 * Date:2018年5月16日下午4:03:41 
 * Copyright (c) 2018, lupo.f@outlook.com All Rights Reserved. 
 * 
*/

package org.github.ycg000344.weiming.application.authclient.runner;

import org.github.ycg000344.weiming.application.authclient.config.UserAuthConfig;
import org.github.ycg000344.weiming.application.authclient.feign.ServiceAuthFeign;
import org.github.ycg000344.weiming.common.base.constants.CommonConstants;
import org.github.ycg000344.weiming.common.base.vo.BaseResponse;
import org.github.ycg000344.weiming.common.base.vo.ObjectRestResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.scheduling.annotation.Scheduled;

import lombok.extern.slf4j.Slf4j;

/**
 * ClassName:AuthClientRunner <br/>
 * <br/>
 * Description: 启动后自动向鉴权服务端发送请求获取内存中的公钥 <br/>
 * <br/>
 * Date: 2018年5月16日 下午4:03:41 <br/>
 * <br/>
 * 
 * @author po.lu
 * @version 1.0.0
 * @since JDK 1.8
 * @see
 */
@Slf4j
@Configuration
@Order(value = 1)
public class AuthClientRunner implements CommandLineRunner {

	@Value("${spring.application.name}")
	private String applicationName;
	@Autowired
	private UserAuthConfig userAuthConfig;
	@Autowired
	private ServiceAuthFeign serviceAuthFeign;

	@Override
	public void run(String... args) throws Exception {
		log.info("***weiming专用log***应用【{}】启动成功，准备获取公钥***", applicationName);
		try {
			refreshUserPubKey();
			log.info("***weiming专用log***应用【{}】成功从服务端获取到公钥***",applicationName);
		} catch (Exception e) {
			log.error("初始化加载用户pubKey失败,1分钟后自动重试!", e);
		}
	}

	@SuppressWarnings("unchecked")
	@Scheduled(cron = "0 0/1 * * * ?")
	private void refreshUserPubKey() {
		BaseResponse resp = serviceAuthFeign.getUserPublicKey(applicationName,
				CommonConstants.AUTH_CLIENT_SECRET);
		if (resp.getStatus() == HttpStatus.OK.value()) {
			ObjectRestResponse<byte[]> userResponse = (ObjectRestResponse<byte[]>) resp;
			this.userAuthConfig.setPubKeyByte(userResponse.getData());
		}

	}

}
