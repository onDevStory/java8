package example.util;

import java.util.List;

public class PrintUtil {

	public static void print(String str) {
		System.out.println(str);
		System.out.println();
	}

	public static void print(String comment, String output) {
		System.out.println(comment);
		System.out.println(output);
		System.out.println();
	}

	public static <T> void printList(String comment, List<T> list) {
		System.out.println(comment);

//		list.forEach(item -> {
//			System.out.println(item);
//		});

		list.forEach(item -> System.out.println(item));
		System.out.println();
	}

}
