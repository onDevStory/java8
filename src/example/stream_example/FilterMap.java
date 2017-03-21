package example.stream_example;

import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import example.Mock;
import example.util.PrintUtil;

public class FilterMap {

	public static void main(String[] args) {
		normalExample();
		evolvedExample();
	}

	private static void normalExample() {
		String result = null;
		for (Entry<Integer, String> entry : Mock.getMapIntStr().entrySet()) {
			if (entry.getValue() == "C") {
				result = entry.getValue();
			}
		}
		PrintUtil.print("normalExample", result);
	}

	private static void evolvedExample() {
		// Map.Entry -> Stream -> Filter -> String
		String result;
		result = Mock.getMapIntStr().entrySet().stream()
												.filter(e -> e.getValue().equals("C"))
												.map(e -> e.getKey().toString())
												.collect(Collectors.joining(", "));
		PrintUtil.print("evolvedExample : Map.Entry -> Stream -> Filter -> String", result);
		
		// Map.Entry -> Stream -> Filter -> Map
		Map<Integer, String> map;
		map = Mock.getMapIntStr().entrySet().stream()
											.filter(e -> e.getKey() == 30)
											.collect(Collectors.toMap(e -> e.getKey(), e -> e.getValue()));
		PrintUtil.print("evolvedExample : Map.Entry -> Stream -> Filter -> Map", map.toString());
											
								
	}

}
