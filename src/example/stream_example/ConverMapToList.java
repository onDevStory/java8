package example.stream_example;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import example.Mock;

public class ConverMapToList {

	public static void main(String[] args) {
		Map<Integer, String> map = Mock.getMapIntStr();
		
		List<Integer> keyList = map.entrySet().stream()
				.map(Entry::getKey)
				.collect(Collectors.toList());
		keyList.forEach(System.out::println);
		
		List<String> valueList = map.entrySet().stream()
				.map(Entry::getValue)
				.collect(Collectors.toList());
		valueList.forEach(System.out::println);
	}

}
