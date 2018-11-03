package org.github.ycg000344.weiming.helloworld.demothreadpool.controller;

import org.github.ycg000344.weiming.common.base.vo.ObjectRestResponse;
import org.github.ycg000344.weiming.helloworld.demothreadpool.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * ClassName:MyController <br/>
 * <br/>
 * Description:  <br/>
 * <br/>
 * Date:  2018/11/3 13:53 <br/>
 * <br/>
 *
 * @author po.lu
 * @version 1.0.0
 * @since JDK 1.8
 */
@RestController
public class MyController {

    @Autowired
    private MyService myService;

    @GetMapping("/async")
    public ObjectRestResponse async(@RequestParam Integer id) {
        this.myService.doAsyncTask(id);
        return new ObjectRestResponse<String>().data(id.toString());
    }
}
