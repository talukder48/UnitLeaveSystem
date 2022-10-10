

package com.panacea.utils;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class SessionFacade {
	public static Map<String, String>  SessionFacade(Map map) {
		Map<String, String> MapObj = new HashMap<String, String>();
		String method = map.get("Method").toString();
		String className = map.get("Class").toString();
		try {						
			Class classDefinition = Class.forName(className);
	        Object  object = classDefinition.newInstance();	        
		    Method m = object.getClass().getDeclaredMethod(method, Map.class);
		    MapObj = (Map) m.invoke(object, map);			
			m.setAccessible(true);												       
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return MapObj;
	}
	
	
	public static byte[]  SessionFacadeReport(Map map) {
		byte[] data=null;
		String method = map.get("Method").toString();
		String className = map.get("Class").toString();
		try {						
			Class classDefinition = Class.forName(className);
	        Object  object = classDefinition.newInstance();	        
		    Method m = object.getClass().getDeclaredMethod(method, Map.class);
		    data = (byte[]) m.invoke(object, map);			
			m.setAccessible(true);												       
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		
		return data;
	}	
}
