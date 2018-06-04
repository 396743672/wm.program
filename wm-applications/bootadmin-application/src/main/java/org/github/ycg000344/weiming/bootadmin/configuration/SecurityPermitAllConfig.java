/** 
 * Project Name:bootadmin-application 
 * File Name:SecurityPermitAllConfig.java 
 * Package Name:org.github.ycg000344.weiming.bootadmin.configuration 
 * Date:2018年6月4日下午7:11:28 
 * Copyright (c) 2018, lupo.f@outlook.com All Rights Reserved. 
 * 
*/  
  
package org.github.ycg000344.weiming.bootadmin.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/** 
 * ClassName:SecurityPermitAllConfig <br/><br/>  
 * Description: TODO <br/><br/>  
 * Date:     2018年6月4日 下午7:11:28 <br/> <br/> 
 * @author   po.lu 
 * @version  1.0.0
 * @since    JDK 1.8 
 * @see       
 */
@Configuration
public class SecurityPermitAllConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().anyRequest().permitAll()  
        .and().csrf().disable();
	}

}
  