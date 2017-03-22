package example.stream_example.arrays;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import example.Mock;

public class ConvertArrayToStream {

	public static void main(String[] args) {
		convertObjectArrayToStream(Mock.getArrayStr());
		convertPrimitiveArrayToStream(Mock.getArrayInt());
	}

	public static void convertObjectArrayToStream(String[] array) {
		// Arrays.stream
		Stream<String> stream1 = Arrays.stream(array);
		stream1.forEach(i -> System.out.println(i));

		// Stream.of
		Stream<String> stream2 = Stream.of(array);
		stream2.forEach(i -> System.out.println(i));
	}
	
	public static void convertPrimitiveArrayToStream(int[] array) {
		// Arrays.stream -> IntStream
		IntStream intStream1 = Arrays.stream(array);
		intStream1.forEach(i -> System.out.println(i));
		
		// Stream.of -> Stream<int[]>
		// Cant print Stream<int[]> directly, convert / flat it to IntStream 
		Stream<int[]> temp = Stream.of(array);
		IntStream intStream2 = temp.flatMapToInt(i -> Arrays.stream(i));
		intStream2.forEach(i -> System.out.println(i));
		
		// For primitive arrays, I prefer Arrays.stream as well
		IntStream intStream3 = Arrays.stream(array);
		intStream3.forEach(i -> System.out.println(i));
	}

}
