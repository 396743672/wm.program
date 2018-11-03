package org.github.ycg000344.weiming.helloworld.demothreadpool.service;

import cn.hutool.core.date.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.github.ycg000344.weiming.helloworld.demothreadpool.configuration.TaskPoolConfig;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * ClassName:MyService <br/>
 * <br/>
 * Description:  <br/>
 * <br/>
 * Date:  2018/11/3 13:50 <br/>
 * <br/>
 *
 * @author po.lu
 * @version 1.0.0
 * @since JDK 1.8
 */
@Service
@Slf4j
public class MyService {

    @Async(TaskPoolConfig.TASKASYNCEXECUTOR)
    public void doAsyncTask(int id) {
        int i = 0;
        while (i < 999999) {
            if (0 == i / 10) {
                log.info("【{}】：【{}】", id, DateUtil.date().toString());
            }
            ++i;
        }
    }
}
