package example;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import example.vo.Developer;
import example.vo.Item;
import example.vo.Student;

public class Mock {

	public static int[] getArrayInt() {
		int[] intArray = {1, 2, 3, 4, 5};
		return  intArray;
	}
	
	public static String[] getArrayStr() {
		return new String[] {"a", "b", "c", "d", "e"};
	}
	
	public static List<Developer> getDevelopers() {
		List<Developer> result = new ArrayList<Developer>();

		result.add(new Developer("sjh", new BigDecimal("70000"), 36));
		result.add(new Developer("alvin", new BigDecimal("80000"), 20));
		result.add(new Developer("jason", new BigDecimal("100000"), 10));
		result.add(new Developer("iris", new BigDecimal("170000"), 55));

		return result;
	}

	public static List<Item> getItems() {
		return Arrays.asList(
			new Item("apple", 10, new BigDecimal("9.99")),
			new Item("banana", 20, new BigDecimal("19.99")),
			new Item("orang", 10, new BigDecimal("29.99")),
			new Item("watermelon", 10, new BigDecimal("29.99")),
			new Item("papaya", 20, new BigDecimal("9.99")),
			new Item("apple", 10, new BigDecimal("9.99")),
			new Item("banana", 10, new BigDecimal("19.99")),
			new Item("apple", 20, new BigDecimal("9.99"))
		);
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

	public static List<String> getListIdentity() {
		return Arrays.asList("A", "B", "C", "D", "E");
	}

	public static List<String> getListDupl() {
		return Arrays.asList("C", "B", "A", "C", "A", "D");
	}

	public static List<Student> getStudents() {
		Student obj1 = new Student();
        obj1.setName("mkyong");
        obj1.addBook("Java 8 in Action");
        obj1.addBook("Spring Boot in Action");
        obj1.addBook("Effective Java (2nd Edition)");

        Student obj2 = new Student();
        obj2.setName("zilap");
        obj2.addBook("Learning Python, 5th Edition");
        obj2.addBook("Effective Java (2nd Edition)");
        
        List<Student> list = new ArrayList<>();
        list.add(obj1);
        list.add(obj2);
        
        return list;
	}
	
	public static Stream<String> getStreamString() {
		return Stream.of("java", "python", "node", null, "ruby", null, "php");
	}
	
	public static Stream<Integer> getStreamInteger() {
		return Stream.of(1, 2, 3, 4, 5);
	}
	
}
