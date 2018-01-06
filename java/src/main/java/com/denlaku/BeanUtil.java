package com.denlaku;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public abstract class BeanUtil {

	public static <T> Map<String, ? extends Object> beanPropMap(T t) {
		Map<String, Object> map = new HashMap<>();
		if (t ==  null) return map;
		Class<? extends Object> cls = t.getClass();
		try {
			final BeanInfo beanInfo = Introspector.getBeanInfo(cls);
			final PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
			if (propertyDescriptors != null) {
				for (PropertyDescriptor propDesc: propertyDescriptors) {
					Method readMethod = propDesc.getReadMethod();
					if (readMethod != null) {
						String name = propDesc.getName();
						Object value = readMethod.invoke(t);
						map.put(name, value);
					}
				}
			}
		} catch (IntrospectionException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		return map;
	}
	
	private BeanUtil() {}
}
