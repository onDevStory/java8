package example.stream_example;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import example.Mock;
import example.util.PrintUtil;

public class ConvertStreamToList {

	public static void main(String[] args) {
		Stream<String> streamStr = Mock.getStreamString();
		List<String> result1 = streamStr.collect(Collectors.toList());
		PrintUtil.printList("result1", result1);
		
		Stream<Integer> streamInt = Mock.getStreamInteger();
		List<Integer> result2 = streamInt
				.filter(i -> i != 3)
				.collect(Collectors.toList());
		PrintUtil.printList("result2", result2);
	}

}
