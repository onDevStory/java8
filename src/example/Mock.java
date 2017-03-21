package example;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import example.vo.Developer;

public class Mock {

	public static List<Developer> getDevelopers() {
		List<Developer> result = new ArrayList<Developer>();

		result.add(new Developer("sjh", new BigDecimal("70000"), 36));
		result.add(new Developer("alvin", new BigDecimal("80000"), 20));
		result.add(new Developer("jason", new BigDecimal("100000"), 10));
		result.add(new Developer("iris", new BigDecimal("170000"), 55));

		return result;
	}

	public static Map<String, Integer> getMapStrInt() {
		Map<String, Integer> items = new HashMap<>();
		items.put("A", 10);
		items.put("B", 20);
		items.put("C", 30);
		items.put("D", 40);
		items.put("E", 50);
		items.put("F", 60);

		return items;
	}

	public static Map<Integer, String> getMapIntStr() {
		Map<Integer, String> items = new HashMap<>();
		items.put(10, "A");
		items.put(20, "B");
		items.put(30, "C");
		items.put(40, "D");
		items.put(50, "E");
		items.put(60, "C");

		return items;
	}

	public static List<String> getList() {
		List<String> items = new ArrayList<>();
		items.add("A");
		items.add("B");
		items.add("C");
		items.add("D");
		items.add("E");
		return items;
	}

}
