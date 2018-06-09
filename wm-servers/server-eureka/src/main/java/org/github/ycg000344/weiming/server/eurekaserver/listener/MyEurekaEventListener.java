/** 
 * Project Name:eureka-server 
 * File Name:MyEurekaEventListener.java 
 * Package Name:org.github.ycg000344.weiming.eurekaserver.listener 
 * Date:2018年5月8日下午2:25:35 
 * Copyright (c) 2018, lupo.f@outlook.com All Rights Reserved. 
 * 
*/

package org.github.ycg000344.weiming.server.eurekaserver.listener;

import org.github.ycg000344.weiming.server.eurekaserver.rabbitmq.EmailSend;
import org.github.ycg000344.weiming.server.eurekaserver.thread.EmailSendthread;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.eureka.server.event.EurekaInstanceCanceledEvent;
import org.springframework.cloud.netflix.eureka.server.event.EurekaInstanceRegisteredEvent;
import org.springframework.cloud.netflix.eureka.server.event.EurekaInstanceRenewedEvent;
import org.springframework.cloud.netflix.eureka.server.event.EurekaRegistryAvailableEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.netflix.discovery.shared.Applications;
import com.netflix.eureka.EurekaServerContextHolder;
import com.netflix.eureka.registry.PeerAwareInstanceRegistry;

import lombok.extern.slf4j.Slf4j;

/**
 * ClassName:MyEurekaEventListener <br/>
 * <br/>
 * Description: 微服务检测事件 <br/>
 * <br/>
 * Date: 2018年5月8日 下午2:25:35 <br/>
 * <br/>
 * 
 * @author po.lu
 * @version 1.0.0
 * @since JDK 1.8
 * @see
 */
@SuppressWarnings("rawtypes")
@Slf4j
@Configuration
@EnableScheduling
public class MyEurekaEventListener implements ApplicationListener {

	@Autowired
	private EmailSend emailSend;

	public void onApplicationEvent(ApplicationEvent applicationEvent) {
		/** 服务下线事件 **/
		if (applicationEvent instanceof EurekaInstanceCanceledEvent) {
			EurekaInstanceCanceledEvent event = (EurekaInstanceCanceledEvent) applicationEvent;
			// 获取当前Eureka实例中的节点信息
			PeerAwareInstanceRegistry registry = EurekaServerContextHolder.getInstance().getServerContext()
					.getRegistry();
			Applications applications = registry.getApplications();
			// 遍历获取已注册节点中与当前失效节点ID一致的节点信息
			applications.getRegisteredApplications().forEach((registeredApplication) -> {
				registeredApplication.getInstances().forEach((instance) -> {
					if (instance.getInstanceId().equals(event.getServerId())) {
						log.error("***********************服务：{} 宕机**********************", instance.getAppName());
						log.error("***********************服务实例的具体信息：{}**************", instance.toString());
						EmailSendthread.getInstance().setEmailSend(emailSend);
						EmailSendthread.getInstance().offerInstance(instance);
					}
				});
			});
		}
		/** 服务注册事件 **/
		if (applicationEvent instanceof EurekaInstanceRegisteredEvent) {
			EurekaInstanceRegisteredEvent registeredEvent = (EurekaInstanceRegisteredEvent) applicationEvent;
			log.info("******************服务注册成功：{}***************", registeredEvent.getInstanceInfo().getAppName());
		}
		/** 服务续约事件 **/
		if (applicationEvent instanceof EurekaInstanceRenewedEvent) {
			EurekaInstanceRenewedEvent renewedEvent = (EurekaInstanceRenewedEvent) applicationEvent;
			log.info("******************服务续约成功：{}***************", renewedEvent.getInstanceInfo().getAppName());
		}
		/** 服务注册检查可用事件 **/
		if (applicationEvent instanceof EurekaRegistryAvailableEvent) {
			log.info("************************** 服务注册检查可用事件 ***********************");
		}
	}

}
