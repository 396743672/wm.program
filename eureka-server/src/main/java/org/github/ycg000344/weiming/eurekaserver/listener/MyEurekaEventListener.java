/** 
 * Project Name:eureka-server 
 * File Name:MyEurekaEventListener.java 
 * Package Name:org.github.ycg000344.weiming.eurekaserver.listener 
 * Date:2018年5月8日下午2:25:35 
 * Copyright (c) 2018, lupo.f@outlook.com All Rights Reserved. 
 * 
*/

package org.github.ycg000344.weiming.eurekaserver.listener;

import org.springframework.cloud.netflix.eureka.server.event.EurekaInstanceCanceledEvent;
import org.springframework.cloud.netflix.eureka.server.event.EurekaInstanceRegisteredEvent;
import org.springframework.cloud.netflix.eureka.server.event.EurekaInstanceRenewedEvent;
import org.springframework.cloud.netflix.eureka.server.event.EurekaRegistryAvailableEvent;

import com.netflix.discovery.EurekaEvent;
import com.netflix.discovery.EurekaEventListener;

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
public class MyEurekaEventListener implements EurekaEventListener {

	@Override
	public void onEvent(EurekaEvent event) {
		/** 服务下线事件 **/
		if (event instanceof EurekaInstanceCanceledEvent) {

		}
		/** 服务注册事件 **/
		if (event instanceof EurekaInstanceRegisteredEvent) {

		}
		/** 服务续约事件 **/
		if (event instanceof EurekaInstanceRenewedEvent) {

		}
		/** 服务注册检查可用事件 **/
		if (event instanceof EurekaRegistryAvailableEvent) {

		}

	}

}
