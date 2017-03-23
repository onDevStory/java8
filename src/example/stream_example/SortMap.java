package example.stream_example;

import java.util.LinkedHashMap;
import java.util.Map;

import example.Mock;
import example.util.PrintUtil;

public class SortMap {

	public static void main(String[] args) {
		Map<String, Integer> unsortMap = Mock.getUnsortMap();
		unsortMap.forEach((k, v) -> System.out.println(k + " : " + v));
		PrintUtil.print("");
		
		Map<String, Integer> sortByKeyMap = new LinkedHashMap<>();
		unsortMap.entrySet().stream()
							.sorted(Map.Entry.<String, Integer>comparingByKey())
							.forEachOrdered(i -> sortByKeyMap.put(i.getKey(), i.getValue()));
		
		sortByKeyMap.forEach((k, v) -> System.out.println(k + " : " + v));
		PrintUtil.print("");
		
		Map<String, Integer> sortByValueMap = new LinkedHashMap<>();
		unsortMap.entrySet().stream()
							.sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
							.forEachOrdered(e -> sortByValueMap.put(e.getKey(), e.getValue()));
		sortByValueMap.forEach((k, v) -> System.out.println(k + " : " + v));
		PrintUtil.print("");
		
		// Create a generic method to sort a Map.
		compareByValue(unsortMap).forEach((k, v) -> System.out.println(k + " : " + v));
		PrintUtil.print("");
		
		compareByKey(unsortMap).forEach((k, v) -> System.out.println(k + " : " + v));
		
	}
	
	public static <K, V extends Comparable<? super V>> Map<K, V> compareByValue(Map<K, V> map) {
		Map<K, V> result = new LinkedHashMap<>();
		map.entrySet().stream()
					.sorted(Map.Entry.comparingByValue())
					.forEachOrdered(e -> result.put(e.getKey(), e.getValue()));
		return result;
	}

	public static <K extends Comparable<? super K>, V> Map<K, V> compareByKey(Map<K, V> map) {
		Map<K, V> result = new LinkedHashMap<>();
		map.entrySet().stream()
					.sorted(Map.Entry.comparingByKey())
					.forEachOrdered(e -> result.put(e.getKey(), e.getValue()));
		return result;
	}
	
}
