/** 
 * Project Name:auth-server 
 * File Name:AuthServerRunner.java 
 * Package Name:org.github.ycg000344.weiming.authserver 
 * Date:2018年5月14日下午6:18:09 
 * Copyright (c) 2018, lupo.f@outlook.com All Rights Reserved. 
 * 
*/

package org.github.ycg000344.weiming.authserver.runner;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.github.ycg000344.weiming.authcommon.jjwt.helper.RsaKeyHelper;
import org.github.ycg000344.weiming.authserver.configuration.KeyConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

/**
 * ClassName:AuthServerRunner <br/>
 * <br/>
 * Description: 鉴权服务应用启动后自动生成公钥、私钥加载到内存和Redis当中 <br/>
 * <br/>
 * Date: 2018年5月14日 下午6:18:09 <br/>
 * <br/>
 * 
 * @author po.lu
 * @version 1.0.0
 * @since JDK 1.8
 * @see
 */
@Component
@Slf4j
public class AuthServerRunner implements CommandLineRunner {

	@Autowired
	private RedisTemplate<String, String> redisTemplate;
	private static final String REDIS_USER_PRI_KEY = "WM:AUTH:JWT:PRI";
	private static final String REDIS_USER_PUB_KEY = "WM:AUTH:JWT:PUB";

	@Autowired
	private KeyConfiguration keyConfiguration;
	@Value("${spring.application.name}")
	private String name;

	@Override
	public void run(String... args) throws Exception {
		log.info("******************** 应用程序:{}启动成功，准备向内存和Redis中写入密钥 ***************************",name);
        if (redisTemplate.hasKey(REDIS_USER_PRI_KEY)&&redisTemplate.hasKey(REDIS_USER_PUB_KEY)) {
            keyConfiguration.setUserPriKey(RsaKeyHelper.getInstance().toBytes(redisTemplate.opsForValue().get(REDIS_USER_PRI_KEY).toString()));
            keyConfiguration.setUserPubKey(RsaKeyHelper.getInstance().toBytes(redisTemplate.opsForValue().get(REDIS_USER_PUB_KEY).toString()));
        } else {
            Map<String, byte[]> keyMap = RsaKeyHelper.getInstance().generateKey(keyConfiguration.getUserSecret());
            keyConfiguration.setUserPriKey(keyMap.get(RsaKeyHelper.PRI));
            keyConfiguration.setUserPubKey(keyMap.get(RsaKeyHelper.PUB));
            redisTemplate.opsForValue().set(REDIS_USER_PRI_KEY, RsaKeyHelper.getInstance().toHexString(keyMap.get(RsaKeyHelper.PRI)),30,TimeUnit.MINUTES);
            redisTemplate.opsForValue().set(REDIS_USER_PUB_KEY, RsaKeyHelper.getInstance().toHexString(keyMap.get(RsaKeyHelper.PUB)),30,TimeUnit.MINUTES);
        }
        log.info("**************************************成功向内存和Redis中写入密钥******************************************");
    }

}
