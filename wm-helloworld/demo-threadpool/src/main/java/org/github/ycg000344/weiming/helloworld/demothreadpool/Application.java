package org.github.ycg000344.weiming.helloworld.demothreadpool;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * ClassName:Application <br/>
 * <br/>
 * Description:  <br/>
 * <br/>
 * Date:  2018/11/3 13:45 <br/>
 * <br/>
 *
 * @author po.lu
 * @version 1.0.0
 * @since JDK 1.8
 */
@SpringBootApplication
@EnableAsync
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
