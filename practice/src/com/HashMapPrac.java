package com;

import java.util.HashMap;
import java.util.Map.Entry;

public class HashMapPrac {

	public static void main(String[] args) {
		HashMap<Integer,String> hm = new HashMap<>();
		
		hm.put(1, "Pradeep");
		hm.put(2, "Servivalue");
		
		for(Entry<Integer, String> h : hm.entrySet() ) {
			System.out.println(h.getKey());
			System.out.println(h.getValue());
		}
 
	}

}
