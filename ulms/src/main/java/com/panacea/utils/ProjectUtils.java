package com.panacea.utils;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.StringTokenizer;

import com.google.gson.Gson;

public class ProjectUtils {

	@SuppressWarnings("unchecked")
	public static Map<String, String> JasonStringToHashMap(String jasonString) throws Exception {
		Gson gson = new Gson();
		@SuppressWarnings("rawtypes")
		Map map = gson.fromJson(jasonString, Map.class);
		return map;
	}

	@SuppressWarnings({ "rawtypes" })
	public static LinkedList GridtoLinkedList(String JasonGridData) {
		LinkedList<Map> transactionclause = new LinkedList<Map>();
		String[] sentance = JasonGridData.split("<sentence>"); 
	    for (String clause : sentance) {
	    	
	    	Map<String, String> map = new HashMap<String, String>(); 
	    	try {
				map=JasonStringToHashMap(clause);
				transactionclause.add(map);  	
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	
	       
	    	
	    }   
	    return transactionclause;
	}
}
