/**
 * 
 */
/**
 * @author User
 * 1、子类的类型参数必须包含父类所有的类型参数
 * 2、List类型参数为<?> 或 <? extends SuperClass>时，只能添加null
 * 3、类型参数<? extends SuperClass>的用法
 * 4、方法调用带上类型参数 ，例如： this.<T>get();
 * 5、java采用的是伪泛型，泛型擦除机制
 */
package com.dens.generic;