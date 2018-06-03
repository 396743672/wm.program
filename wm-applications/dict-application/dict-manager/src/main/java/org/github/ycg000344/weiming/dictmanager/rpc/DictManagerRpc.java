/** 
 * Project Name:dict-manager 
 * File Name:DictManagerRpc.java 
 * Package Name:org.github.ycg000344.weiming.dictmanager 
 * Date:2018年6月3日下午2:56:39 
 * Copyright (c) 2018, lupo.f@outlook.com All Rights Reserved. 
 * 
*/  
  
package org.github.ycg000344.weiming.dictmanager.rpc;

import org.github.ycg000344.weiming.dictmanager.service.DictManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/** 
 * ClassName:DictManagerRpc <br/><br/>  
 * Description: TODO <br/><br/>  
 * Date:     2018年6月3日 下午2:56:39 <br/> <br/> 
 * @author   po.lu 
 * @version  1.0.0
 * @since    JDK 1.8 
 * @see       
 */
@RestController
@RequestMapping("/dictmanager")
public class DictManagerRpc {
	
	@Autowired
	private DictManagerService dictManagerService;
	
	

}
  