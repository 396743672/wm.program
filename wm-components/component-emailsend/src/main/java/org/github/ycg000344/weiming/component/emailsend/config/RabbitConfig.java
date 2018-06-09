/** 
 * Project Name:emailsend-server 
 * File Name:RabbitConfig.java 
 * Package Name:org.github.ycg000344.weiming.components.emailsend.server.config 
 * Date:2018年5月11日上午9:37:13 
 * Copyright (c) 2018, lupo.f@outlook.com All Rights Reserved. 
 * 
*/  
  
package org.github.ycg000344.weiming.component.emailsend.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/** 
 * ClassName:RabbitConfig <br/><br/>  
 * Description: TODO <br/><br/>  
 * Date:     2018年5月11日 上午9:37:13 <br/> <br/> 
 * @author   po.lu 
 * @version  1.0.0
 * @since    JDK 1.8 
 * @see       
 */
@Configuration
public class RabbitConfig {
	
	@Bean
    public Queue emailQueue() {
        return new Queue("email");
    }

}
  