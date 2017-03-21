package example.stream_example;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import example.Mock;
import example.util.PrintUtil;

public class FilterStringList {

	public static void main(String[] args) {
		normalExample();
		evolvedExample();
	}

	private static void normalExample() {
		List<String> result = new ArrayList<>();
		for (String item : Mock.getListIdentity()) {
			if (!item.equals("E")) {
				result.add(item);
			}
		}
		PrintUtil.printList("normalExample", result);
	}

	private static void evolvedExample() {
		List<String> result =
				Mock.getListIdentity().stream() 						// convert list to stream
							.filter(item -> !item.equals("E"))  // filters the line, equals to "mkyong"
							.collect(Collectors.toList());      // collect the output and convert streams to a List
		PrintUtil.printList("evolvedExample", result);
	}
	
}
