/**
 * 
 */
/**
 * @author User
 *         在web容器启动时为提供给第三方组件机会做一些初始化的工作，例如注册servlet或者filtes等，
 *         servlet规范中通过ServletContainerInitializer实现此功能。每个框架要使用ServletContainerInitializer
 *         就必须在对应的jar包的META-INF/services目录创建一个名为javax.servlet.ServletContainerInitializer的文件，
 *         文件内容指定具体的ServletContainerInitializer实现类，那么，当web容器启动时就会运行这个初始化器做一些组件内的初始化工作。
 *         一般伴随着ServletContainerInitializer一起使用的还有HandlesTypes注解，通过HandlesTypes可以将感兴趣的一些类注入到
 *         ServletContainerInitializerde的onStartup方法作为参数传入。
 *         
 *         Tomcat容器的ServletContainerInitializer机制的实现，主要交由Context容器和ContextConfig监听器共同实现，
 *         ContextConfig监听器负责在容器启动时读取每个web应用的WEB-INF/lib目录下包含的jar包的
 *         META-INF/services/javax.servlet.ServletContainerInitializer，
 *         以及web根目录下的META-INF/services/javax.servlet.ServletContainerInitializer，
 *         通过反射完成这些ServletContainerInitializer的实例化，然后再设置到Context容器中，
 *         最后Context容器启动时就会分别调用每个ServletContainerInitializer的onStartup方法，并将感兴趣的类作为参数传入。
 */
package com.denlaku.j2ee.servlet;