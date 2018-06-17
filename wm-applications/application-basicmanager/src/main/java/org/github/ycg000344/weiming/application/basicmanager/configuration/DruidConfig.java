/** 
 * Project Name:dict-manager 
 * File Name:DruidConfig.java 
 * Package Name:org.github.ycg000344.weiming.dictmanager.configuration 
 * Date:2018年6月4日下午3:24:09 
 * Copyright (c) 2018, lupo.f@outlook.com All Rights Reserved. 
 * 
*/  
  
package org.github.ycg000344.weiming.application.basicmanager.configuration;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;

/** 
 * ClassName:DruidConfig <br/><br/>  
 * Description: druid按照application.yml的进行配置 <br/><br/>  
 * Date:     2018年6月4日 下午3:24:09 <br/> <br/> 
 * @author   po.lu 
 * @version  1.0.0
 * @since    JDK 1.8 
 * @see       
 */
@Configuration
public class DruidConfig {
	
	@Value("${basicmanager.druid.loginname}")
	private String loginName;
	@Value("${basicmanager.druid.password}")
	private String password;
	
	@ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource druid(){
        return DruidDataSourceBuilder.create().build();
    }
    @Bean
    public ServletRegistrationBean<StatViewServlet> startViewServlet()
    {
        //参数可以在StatViewServlet和ResourceServlet中查看
        ServletRegistrationBean<StatViewServlet> bean = new ServletRegistrationBean<StatViewServlet>(new StatViewServlet(),"/druid/*");
        Map<String,String> params = new HashMap<>(16);
        //用户名
        params.put("loginUsername",loginName);
        //密码
        params.put("loginPassword",password);
        //IP白名单 (不填写代表允许所有IP)
        params.put("allow","");
        //IP黑名单 (存在共同时，deny优先于allow)
        //initParameters.put("deny", "192.168.20.38");
        bean.setInitParameters(params);
        return bean;
    }

    @Bean
    public FilterRegistrationBean<WebStatFilter> webStatFilter(){
        FilterRegistrationBean<WebStatFilter> bean = new FilterRegistrationBean<WebStatFilter>();
        bean.setFilter(new WebStatFilter());
        Map<String,String> initParams = new HashMap<>(16);
        //排除拦截
        initParams.put("exclusions","*.js,*.css,/druid/*");
        bean.setInitParameters(initParams);
        bean.setUrlPatterns(Arrays.asList("/*"));
        return  bean;
    }
}
  