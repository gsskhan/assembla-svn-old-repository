package org.dms.web.test.json;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RemoveDuplicates {
	
	public static void main(String[] args) {
		List<NavObject> list = new ArrayList<NavObject>();
		list.add(new NavObject("CE", "RAPID") );
		list.add( new NavObject("RAPID", "CE"));
		list.add( new NavObject("ACE", "RAPID"));
		list.add(new NavObject("CE", "RAPID") );		
		List<NavObject> finallist = clearListFromDuplicateFirstName(list);
		list.clear();
		for (NavObject navObject : finallist) {
			System.out.println(navObject.getFirstapp()+" , "+ navObject.getLastapp());
		}
	}
	
	

	private static List<NavObject> clearListFromDuplicateFirstName(List<NavObject> list1) {

		Map<String, NavObject> cleanMap = new HashMap<String, NavObject>();
		for (int i = 0; i < list1.size(); i++) {
			cleanMap.put(list1.get(i).getFirstapp(), list1.get(i));
		}
		List<NavObject> list = new ArrayList<NavObject>(cleanMap.values());
		return list;
	}

}
