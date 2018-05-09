/** 
 * Project Name:emailsend-server 
 * File Name:EmailSendFunction.java 
 * Package Name:org.github.ycg000344.weiming.components.emailsend.server.function 
 * Date:2018年5月9日下午2:07:06 
 * Copyright (c) 2018, lupo.f@outlook.com All Rights Reserved. 
 * 
*/  
  
package org.github.ycg000344.weiming.components.emailsend.server.function;

import org.github.ycg000344.weiming.components.emailsend.api.bean.EmailInfo;

/** 
 * ClassName:EmailSendFunction <br/><br/>  
 * Description: 邮件发送功能接口 <br/><br/>  
 * Date:     2018年5月9日 下午2:07:06 <br/> <br/> 
 * @author   po.lu 
 * @version  1.0.0
 * @since    JDK 1.8 
 * @see       
 */
public interface EmailSendFunction {
	
	boolean send(EmailInfo emailInfo);

}
  