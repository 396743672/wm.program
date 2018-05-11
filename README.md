<!-- TOC -->

- [1. wm.program](#1-wmprogram)
    - [1.1. Modules](#11-modules)
        - [1.1.1. hello-world](#111-hello-world)
        - [1.1.2. wm-common](#112-wm-common)
        - [1.1.3. business-base](#113-business-base)
    - [1.2. Components](#12-components)
        - [1.2.1. email-component](#121-email-component)
            - [1.2.1.1. email API](#1211-email-api)
                - [1.2.1.1.1. email-templates-bean](#12111-email-templates-bean)
            - [1.2.1.2. email send  server](#1212-email-send-server)
    - [1.3. Application Server](#13-application-server)
        - [1.3.1. Eureka Server](#131-eureka-server)

<!-- /TOC -->

# 1. wm.program
对所有引用的dependency进行版本和使用的插件进行控制。<br>
对目前的dependency有：<b1>
1. `Spring Boot` 2.0.0.RELEASE
2. `spring cloud` Finchley.RC1
3. `druid` 数据源 1.1.9
4. `hutool` 工具类 4.0.10
5. `tk.mybatis` 通用Mapper 2.0.2
6. `pagehelper` 分页插件 1.2.5
7. `jsonwebtoken` jjwt 0.9.0
8. `boot.admin.ui` turbine 1.5.7
9. `servlet` 4.0.1
10. `spring-web`  5.0.5.RELEASE

目前使用的插件：<br>
1. `spring-boot-maven-plugin` <br>
    用于Spring Boot Application的package
2. `maven-jar-plugin`<br>
    non-execable.jar的package
3. `mybatis-generator-maven-plugin`<br>
    自动化生成 POJO、Mapper的插件
4. `maven-antrun-plugin`<br>
    将package的jar包copy到指定位置

## 1.1. Modules

### 1.1.1. hello-world
关于学习一些新的知识所进行的代码记录集

### 1.1.2. wm-common

公共利用的基础包,其中包含的有：<b1>
1. 公用常量类
2. 自定义基础异常类
3. 全局异常处理类
4. 自定义自定义基础response对象

### 1.1.3. business-base
业务模块基础包,其中包含的有：<b1>
1. base-service
2. base-controller


## 1.2. Components

### 1.2.1. email-component

#### 1.2.1.1. email API
封装了*对象基类*，即*收件人*、*主题*、*抄送人*
##### 1.2.1.1.1. email-templates-bean
目前已经实现的邮件信息字段bean：

1. `EurekaInstanceCanceledEventEmailinfo` EurekaInstanceCanceledEvent 服务挂掉发送邮件的信息

#### 1.2.1.2. email send  server
使用`freemarker`模板进行邮件的发送.<br>
从消息队列 `rabbitmq` 获取消息进行消费，即发送邮件，采用**异步**的方式进行邮件的发送。
>Tips: <a href="https://si.gnatu.re/?utm_source=next.36kr.com" target="_blank">在线制作签名</a>




## 1.3. Application Server

### 1.3.1. Eureka Server
服务注册中心，提供服务的注册、监听，当检测到已经注册的服务出现宕机的情况时自动向消息队列中间件 `rabbitmq` 采取**异步**的方式发送宕机的服务实例的信息，如服务名称、服务端口号等。

