<!-- TOC -->

- [1. wm.program](#1-wmprogram)
    - [1.1. 目前的模块](#11)
        - [1.1.1. wm-common](#111-wm-common)
        - [1.1.2. business-base](#112-business-base)

<!-- /TOC -->

# 1. wm.program
对所有引用的dependency进行版本和使用的插件进行控制。<br>
对目前的dependency有：<b1>
1. Spring Boot 2.0.0.RELEASE
2. spring cloud Finchley.RC1
3. druid 数据源 1.1.9
4. hutool 工具类 4.0.10
5. tk.mybatis 通用Mapper 2.0.2
6. pagehelper 分页插件 1.2.5
7. jsonwebtoken jjwt 0.9.0
8. boot.admin.ui turbine 1.5.7
9. servlet 4.0.1
10. spring-web  5.0.5.RELEASE

目前使用的插件：<br>
1. spring-boot-maven-plugin <br>
    用于Spring Boot Application的package
2. maven-jar-plugin<br>
    non-execable.jar的package
3. mybatis-generator-maven-plugin<br>
    自动化生成 POJO、Mapper的插件
4. maven-antrun-plugin<br>
    将package的jar包copy到指定位置

## 1.1. 目前的模块

### 1.1.1. wm-common

公共利用的基础包,其中包含的有：<b1>
1. 公用常量类
2. 自定义基础异常类
3. 全局异常处理类
4. 自定义自定义基础response对象

### 1.1.2. business-base
业务模块基础包,其中包含的有：<b1>
1. base-service
2. base-controller


