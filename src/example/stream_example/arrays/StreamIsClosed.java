package example.stream_example.arrays;

import java.util.Arrays;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class StreamIsClosed {

	public static void main(String[] args) {
		String[] array = { "a", "b", "c", "d", "e" };

		isClosed(array); // IllegalStateException - Stream is closed!
		useSupplier(array);
	}

	// Stream cannot be reused, once it is consumed or used, the stream will be closed.
	public static void isClosed(String[] array) {
		try {
			Stream<String> stream = Arrays.stream(array);
			
			stream.forEach(x -> System.out.println(x));
			
			long count = stream.filter(x -> "b".equals(x)).count();
			System.out.println(count);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void useSupplier(String[] array) {
		Supplier<Stream<String>> streamSupplier = () -> Stream.of(array);
		
		// get new stream
		streamSupplier.get().forEach(x -> System.out.println(x));
		
		// get another new stream
		long count = streamSupplier.get().filter(x -> x.equals("b")).count();
		System.out.println(count);
	}

}
