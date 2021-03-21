package exo19;

import java.util.ArrayList;
import java.util.List;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;



public class AnalyzeBean {

	
	public static String getClassName(Object o) {
		
		Class<?> classe1 = o.getClass();
		return classe1.getName(); 
	}
	
	public Object getInstance(String className) {
		try {
			
			Class<?> classe2 = Class.forName(className);
			Object newInstance = classe2.newInstance();
			return newInstance;
			
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		return null;
	}
		
	public List<String> getProperties(Object o) {
		List<String> properties = new ArrayList<>();
		Method[] declaredMethods = o.getClass().getDeclaredMethods();
		System.out.println("\n# declared methods = " + declaredMethods.length);
		for (Method method : declaredMethods) {
			String methodName = method.getName();
			if ((methodName.startsWith("get") ||
				 methodName.startsWith("is")) && 
				method.getParameterCount() == 0 &&
				Modifier.isPublic(method.getModifiers())) {
				
					 System.out.println(methodName);
					String propertyName = "";
					if (methodName.startsWith("get")) {
						propertyName = methodName.substring(3);
					} else {
						propertyName = methodName.substring(2);
					}
					 propertyName = 
							propertyName.substring(0, 1).toLowerCase() + 
							propertyName.substring(1);
					System.out.println(propertyName);
					properties.add(propertyName);
				}
		}
		return properties;
	}
	
	String get(Object bean, String property) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException
	{
	
		Object test = new Object();
		
		Method[] declaredMethods = bean.getClass().getDeclaredMethods();
		for (Method method : declaredMethods) {
			String methodName = method.getName();
			if (methodName.equals(property))
			{
				test = method.invoke(bean);
				
			}
		}
		
		String s=test.toString();  
		return s;
	
	}
	
	void set(Object bean, String property, Object value) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException
	{
		String valeur = value.toString();
		String methodName = 
				"set" + property.substring(0, 1).toLowerCase() + property.substring(1); 
		Method set1 = bean.getClass().getMethod(methodName, String.class);
		set1.invoke(bean, valeur);		
	}
}
