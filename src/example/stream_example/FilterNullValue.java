package example.stream_example;

import java.util.List;
import java.util.Objects;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import example.Mock;
import example.util.PrintUtil;

public class FilterNullValue {

	public static void main(String[] args) {
		Supplier<Stream<String>> streamSupplier = () -> Mock.getStreamString();
		
		// non filtering null value
		List<String> nonFiltering = streamSupplier.get()
				.collect(Collectors.toList());
		PrintUtil.printList("non filtering null value", nonFiltering);
		
		// filtering null value
		List<String> filtering = streamSupplier.get()
				.filter(i -> i!=null)
				.collect(Collectors.toList());
		PrintUtil.printList("filtering null value", filtering);
		
		// Alternatively, filter with Objects::nonNull
		List<String> result = streamSupplier.get()
				.filter(Objects::nonNull)
				.collect(Collectors.toList());
		PrintUtil.printList("filter with Objects::nonNull", result);
	}

}
