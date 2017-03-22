package example.stream_example;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import example.Mock;
import example.vo.Student;

public class FlatMap {

	public static void main(String[] args) {
		String[][] strArray = new String[][] {{"a", "b"}, {"c", "d"}, {"e", "f"}};
		streamObjectArrayNotWorking(strArray);
		streamObjectArrayWorking(strArray);
		
		List<Student> list = Mock.getStudents();
		streamSet(list);
		
		int[] intArray = {1, 2, 3, 4, 5, 6};
		streamPrimitiveArray(intArray);
	}
	
	public static void streamObjectArrayNotWorking(String[][] array) {
		Stream<String[]> temp = Arrays.stream(array);                         // Stream<String[]>
		Stream<String[]> stream = temp.filter(i -> i.toString().equals("a"));
		stream.forEach(System.out::println); 		                          // Output : empty
	}
	
	public static void streamObjectArrayWorking(String[][] array) {
		// Stream<String[]> temp = Arrays.stream(array);
		// Stream<String> stringStream = temp.flatMap(i -> Arrays.stream(i));
		// Stream<String> stream = stringStream.filter(i -> i.toString().equals("a"));
		// stream.forEach(System.out::println);
		
		Stream<String> finalStream = Arrays.stream(array) // Stream<String[]>
				.flatMap(i -> Arrays.stream(i))           // Stream<String>
				.filter(i -> i.toString().equals("a"));
		finalStream.forEach(System.out::println);
	}

	public static void streamSet(List<Student> list) {
		Stream<String> stream = list.stream()
				.map(i -> i.getBook())          // Stream<Set<String>>
				.flatMap(i -> i.stream());      // Stream<String>
		
		List<String> collect = stream
				.distinct()
				.collect(Collectors.toList());
		
		collect.forEach(System.out::println);
	}

	public static void streamPrimitiveArray(int[] array) {
		Stream<int[]> streamArray = Stream.of(array);
		IntStream intStream = streamArray.flatMapToInt(i -> Arrays.stream(i));
		intStream.forEach(System.out::println);
	}
	
}
