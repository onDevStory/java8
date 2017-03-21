package example.loop;

import java.util.List;
import java.util.Map;

import example.Mock;
import example.util.PrintUtil;

public class Main {

	public static void main(String[] args) {

		Map<String, Integer> map = Mock.getMapStrInt();

		// Normal way to loop a Map.
		PrintUtil.print("Normal way to loop a Map.");
		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			System.out.println("Item : " + entry.getKey() + " Count : " + entry.getValue());
		}

		// In Java 8, you can loop a Map with forEach + lambda expression.
		PrintUtil.print("");
		map.forEach((k, v) -> System.out.println(String.format("Items : %s Count : %d", k, v)));

		PrintUtil.print("");
		map.forEach((k, v) -> {
			if (k.equals("E")) {
				return;
			}
			System.out.println(String.format("Items : %s Count : %d", k, v));
		});

		List<String> list = Mock.getList();

		// lambda - Output : A,B,C,D,E
		PrintUtil.print("");
		list.forEach(item -> System.out.println(item));

		// method reference - Output : A,B,C,D,E
		PrintUtil.print("");
		list.forEach(System.out::println);

		// Stream and filter - Output : B
		PrintUtil.print("");
		list.stream()
			.filter(item -> item.contains("B"))
			.forEach(System.out::println);

	}

}
