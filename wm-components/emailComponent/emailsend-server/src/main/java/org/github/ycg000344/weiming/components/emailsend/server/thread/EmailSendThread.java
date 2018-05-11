/** 
 * Project Name:emailsend-server 
 * File Name:EmailSendThread.java 
 * Package Name:org.github.ycg000344.weiming.components.emailsend.server.thread 
 * Date:2018年5月11日下午2:05:54 
 * Copyright (c) 2018, lupo.f@outlook.com All Rights Reserved. 
 * 
*/

package org.github.ycg000344.weiming.components.emailsend.server.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import org.github.ycg000344.weiming.components.emailsend.api.bean.BaseEmailInfo;
import org.github.ycg000344.weiming.components.emailsend.server.function.EmailSendFunction;

import cn.hutool.core.collection.CollUtil;
import lombok.extern.slf4j.Slf4j;

/**
 * ClassName:EmailSendThread <br/>
 * <br/>
 * Description: 从rabbitmq获取邮件信息，调用EmailSendFunction进行异步发送邮件 <br/>
 * <br/>
 * Date: 2018年5月11日 下午2:05:54 <br/>
 * <br/>
 * 
 * @author po.lu
 * @version 1.0.0
 * @since JDK 1.8
 * @see
 */
@Slf4j
public class EmailSendThread extends Thread {

	private static EmailSendThread emailSendThread;
	private EmailSendFunction emailSendFunction;
	private static BlockingQueue<BaseEmailInfo> emailQueue = new LinkedBlockingQueue<>(1024);

	private EmailSendThread() {
	}

	public static synchronized EmailSendThread getInstance() {
		if (null == emailSendThread) {
			emailSendThread = new EmailSendThread();
		}
		return emailSendThread;
	}

	public void setEmailSendFunction(EmailSendFunction eFunction) {
		if (null == emailSendFunction) {
			this.emailSendFunction = eFunction;
		}
	}

	public void offerEmailInfo(BaseEmailInfo emailInfo) {
		try {
			emailQueue.offer(emailInfo);
		} catch (Exception e) {
			log.error("***********************邮件信息写入失败：{}************", e);
		}
	}

	@Override
	public void run() {
		/** 缓冲队列 */
		List<BaseEmailInfo> bufferList = new ArrayList<>();
		while (true) {
			try {
				bufferList.add(emailQueue.take());
				emailQueue.drainTo(bufferList);
				if (CollUtil.isNotEmpty(bufferList)) {
					bufferList.forEach(i -> emailSendFunction.send(i));
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
