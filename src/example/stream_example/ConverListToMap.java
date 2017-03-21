package example.stream_example;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import example.Mock;
import example.util.PrintUtil;
import example.vo.Developer;

public class ConverListToMap {

	public static void main(String[] args) {
		Map<String, Integer> result;
		List<Developer> developerList = Mock.getDevelopers();
		
		// List to Map 1 
		result = developerList.stream()
				.collect(Collectors.toMap(Developer::getName, Developer::getAge));
		PrintUtil.print("List -> Stream -> Map Example 1", result.toString());
		
		// List to Map 2 
		result = developerList.stream()
				.collect(Collectors.toMap(i -> i.getName(), i -> i.getAge()));
		PrintUtil.print("List -> Stream -> Map Example 2", result.toString());
	}

}
