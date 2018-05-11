/** 
 * Project Name:eureka-server 
 * File Name:EmailSendthread.java 
 * Package Name:org.github.ycg000344.weiming.eurekaserver.thread 
 * Date:2018年5月11日上午10:13:26 
 * Copyright (c) 2018, lupo.f@outlook.com All Rights Reserved. 
 * 
*/

package org.github.ycg000344.weiming.eurekaserver.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import org.github.ycg000344.weiming.components.emailsend.api.bean.impl.EurekaInstanceCanceledEventEmailinfo;
import org.github.ycg000344.weiming.eurekaserver.rabbitmq.EmailSend;
import org.springframework.beans.BeanUtils;

import com.netflix.appinfo.InstanceInfo;

import cn.hutool.core.collection.CollUtil;
import lombok.extern.slf4j.Slf4j;

/**
 * ClassName:EmailSendthread <br/>
 * <br/>
 * Description: 邮件信息发送到rabbitmq的线程 <br/>
 * <br/>
 * Date: 2018年5月11日 上午10:13:26 <br/>
 * <br/>
 * 
 * @author po.lu
 * @version 1.0.0
 * @since JDK 1.8
 * @see
 */
@Slf4j
public class EmailSendthread extends Thread {

	private EmailSend emailSend;
	
	private EurekaInstanceCanceledEventEmailinfo emailinfo = new EurekaInstanceCanceledEventEmailinfo();
	private static EmailSendthread emailSendthread;
	private static BlockingQueue<EurekaInstanceCanceledEventEmailinfo> emailQueue = new LinkedBlockingQueue<>(1024);

	private EmailSendthread() {
	}

	public static synchronized EmailSendthread getInstance() {
		if (null == emailSendthread) {
			emailSendthread = new EmailSendthread();
		}
		return emailSendthread;
	}
	
	public void setEmailSend(EmailSend emailSend) {
		if (null == this.emailSend) {
			this.emailSend = emailSend;
		}
	}

	public void offerInstance(InstanceInfo instance) {
		try {
			//BeanUtils.copyProperties(instance, emailinfo);
			emailQueue.offer(emailinfo);
		} catch (Exception e) {
			log.error("***********************邮件信息写入失败：{}************", e);
		}
	}

	@Override
	public void run() {
		/** 缓冲队列 */
		List<EurekaInstanceCanceledEventEmailinfo> bufferList = new ArrayList<>();
		while (true) {
			try {
				bufferList.add(emailQueue.take());
				emailQueue.drainTo(bufferList);
				if (CollUtil.isNotEmpty(bufferList)) {
					bufferList.forEach(i -> emailSend.send(i));
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
				/** 防止缓冲队列填充数据出现异常时不断刷屏 */
				try {
					Thread.sleep(1000);
				} catch (Exception eee) {
					log.error("******************防止缓冲队列填充数据出现异常时不断刷屏,{}***************", eee.getMessage());
				}
			} finally {
				if (CollUtil.isNotEmpty(bufferList)) {
					try {
						bufferList.clear();
					} catch (Exception e) {
						log.error("***************防止缓冲队列填充数据出现异常时不断刷屏,{}***************", e.getMessage());
					}
				}
			}

		}
	}

}
