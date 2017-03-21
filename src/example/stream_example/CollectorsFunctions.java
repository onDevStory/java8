package example.stream_example;

import java.math.BigDecimal;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import example.Mock;
import example.util.PrintUtil;
import example.vo.Item;

public class CollectorsFunctions {

	public static void main(String[] args) {
		// List<String> (groupingBy -> counting)
		Map<String, Long> result;
		result = Mock.getListDupl().stream().collect(
				Collectors.groupingBy(Function.identity(),
						Collectors.counting()));
		PrintUtil.print("List (groupingBy -> counting)", result.toString());
		
		// Map (sorted -> add to other Map)
		Map<String, Long> finalMap = new LinkedHashMap<>();
		result.entrySet().stream()
						.sorted(Map.Entry.<String, Long>comparingByValue().reversed())
						.forEachOrdered(e -> finalMap.put(e.getKey(), e.getValue()));
		PrintUtil.print("Map (sorted -> add to other Map)", finalMap.toString());
		
		// List<Object> (groupingBy -> counting)
		Map<String, Long> counting =
				Mock.getItems().stream().collect(
						Collectors.groupingBy(Item::getName,
								Collectors.counting()));
		PrintUtil.print("List<Object> (groupingBy -> counting)", counting.toString());
		
		// List<Object> (groupingBy -> summingInt)
		Map<String, Integer> sum = 
				Mock.getItems().stream().collect(
						Collectors.groupingBy(Item::getName,
								Collectors.summingInt(Item::getQty)));
		PrintUtil.print("List<Object> (groupingBy -> summingInt)", sum.toString());
		
		// List<Object> (groupingBy)
		Map<BigDecimal, List<Item>> groupByPriceMap =
				Mock.getItems().stream().collect(
						Collectors.groupingBy(Item::getPrice));
		PrintUtil.print("List<Object> (groupingBy)", groupByPriceMap.toString());
		
		// List<Object> (groupingBy -> Set<String>)
		Map<BigDecimal, Set<String>> setMap = 
				Mock.getItems().stream().collect(
						Collectors.groupingBy(Item::getPrice,
								Collectors.mapping(Item::getName,
										Collectors.toSet())));
		PrintUtil.print("List<Object> (groupingBy -> Set<String>)", setMap.toString());
	}

}
