/** 
 * Project Name:auth-server 
 * File Name:AuthServerAppTest.java 
 * Package Name:org.github.ycg000344.weiming.authserver 
 * Date:2018年5月11日下午4:38:04 
 * Copyright (c) 2018, lupo.f@outlook.com All Rights Reserved. 
 * 
*/  
  
package org.github.ycg000344.weiming.authserver;

import org.github.ycg000344.weiming.application.authserver.AuthServerApp;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/** 
 * ClassName:AuthServerAppTest <br/><br/>  
 * Description: TODO <br/><br/>  
 * Date:     2018年5月11日 下午4:38:04 <br/> <br/> 
 * @author   po.lu 
 * @version  1.0.0
 * @since    JDK 1.8 
 * @see       
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = AuthServerApp.class)
@WebAppConfiguration
public abstract class AuthServerAppTest {

}
  