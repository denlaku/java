/**
 * 
 */
/**
 * @author User JNDI Java 命名与目录接口（Java Naming and Directory Interface）
 *
 *         1、Javax.naming：包含了访问命名服务的类和接口。例如，它定义了Context接口，这是命名服务执行查询的入口。
 *         2、Javax.naming.directory：对命名包的扩充，提供了访问目录服务的类和接口。例如，它为属性增加了新的类，提供了表示目录上下文的DirContext接口，定义了检查和更新目录对象的属性的方法。
 *         3、Javax.naming.event：提供了对访问命名和目录服务时的事件通知的支持。例如，定义了NamingEvent类，这个类用来表示命名/目录服务产生的事件，定义了侦听NamingEvents的NamingListener接口。
 *         4、Javax.naming.ldap：这个包提供了对LDAP
 *         版本3扩充的操作和控制的支持，通用包javax.naming.directory没有包含这些操作和控制。
 *         5、Javax.naming.spi：这个包提供了一个方法，通过javax.naming和有关包动态增加对访问命名和目录服务的支持。这个包是为有兴趣创建服务提供者的开发者提供的。
 */
package com.denlaku.j2ee.jndi;