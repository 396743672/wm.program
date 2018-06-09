/** 
 * Project Name:wm-common 
 * File Name:BaseContextHandler.java 
 * Package Name:org.github.ycg000344.weiming.common.context 
 * Date:2018年5月17日下午5:00:54 
 * Copyright (c) 2018, lupo.f@outlook.com All Rights Reserved. 
 * 
*/

package org.github.ycg000344.weiming.basecommon.context;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.github.ycg000344.weiming.basecommon.constants.CommonConstants;

/**
 * ClassName:BaseContextHandler <br/>
 * <br/>
 * Description: TODO <br/>
 * <br/>
 * Date: 2018年5月17日 下午5:00:54 <br/>
 * <br/>
 * 
 * @author po.lu
 * @version 1.0.0
 * @since JDK 1.8
 * @see
 */
public class BaseContextHandler {
	public static ThreadLocal<Map<String, Object>> threadLocal = new ThreadLocal<Map<String, Object>>();

	public static void set(String key, Object value) {
		Map<String, Object> map = threadLocal.get();
		if (map == null) {
			map = new ConcurrentHashMap<String, Object>();
			threadLocal.set(map);
		}
		map.put(key, value);
	}

	public static Object get(String key) {
		Map<String, Object> map = threadLocal.get();
		if (map == null) {
			map = new ConcurrentHashMap<String, Object>();
			threadLocal.set(map);
		}
		return map.get(key);
	}

	public static String getId() {
		Object value = get(CommonConstants.JWT_KEY_ID);
		return returnObjectValue(value);
	}

	public static String getName() {
		Object value = get(CommonConstants.JWT_KEY_NAME);
		return returnObjectValue(value);
	}

	public static String getUniqueName() {
		Object value = get(CommonConstants.JWT_KEY_UNIQUENAME);
		return returnObjectValue(value);
	}

	public static String getToken() {
		Object value = get(CommonConstants.AUTH_USER_TOKEN);
		return returnObjectValue(value);
	}

	public static void setToken(String token) {
		set(CommonConstants.AUTH_USER_TOKEN, token);
	}

	public static void setName(String name) {
		set(CommonConstants.JWT_KEY_NAME, name);
	}

	public static void setId(String id) {
		set(CommonConstants.JWT_KEY_ID, id);
	}

	public static void setUniqueName(String uniqueName) {
		set(CommonConstants.JWT_KEY_UNIQUENAME, uniqueName);
	}

	private static String returnObjectValue(Object value) {
		return value == null ? null : value.toString();
	}

	public static void remove() {
		threadLocal.remove();
	}
}
