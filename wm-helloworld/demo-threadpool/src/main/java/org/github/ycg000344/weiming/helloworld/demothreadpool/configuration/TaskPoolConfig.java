package org.github.ycg000344.weiming.helloworld.demothreadpool.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * ClassName:TaskPoolConfig <br/>
 * <br/>
 * Description:  <br/>
 * <br/>
 * Date:  2018/11/3 13:48 <br/>
 * <br/>
 *
 * @author po.lu
 * @version 1.0.0
 * @since JDK 1.8
 */
@Configuration
public class TaskPoolConfig {

    public static final String TASKASYNCEXECUTOR = "taskAsyncExecutor";

    @Bean
    public Executor taskAsyncExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(2);
        executor.setMaxPoolSize(4);
        executor.setQueueCapacity(8);
        executor.setKeepAliveSeconds(300);
        executor.setThreadNamePrefix("taskAsyncExecutor-");
        // 拒接策略
        // 1. CallerRunsPolicy 调用线程执行
        // 2. AbortPolicy 抛出异常
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.AbortPolicy());
        executor.initialize();
        return executor;
    }
}
