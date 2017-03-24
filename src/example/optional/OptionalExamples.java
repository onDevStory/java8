package example.optional;

import java.util.Optional;

import example.util.PrintUtil;

public class OptionalExamples {

	private static final String Male = "Male";
	private static final String MALE = "MALE";

	private static final Optional<String> optionalEmpty = Optional.empty();
	private static final Optional<String> optionaMale = Optional.of(Male);
	private static final Optional<String> optionaMALE = Optional.of(MALE);

	public static void main(String[] args) {
		// basicExample(); // Optional Basic example
		// mapAndFlatMap(); // Optional.map and flatMap
		// filter(); // Optional.filter
		// isPresentAndIfPresent(); // isPresent and ifPresent
		orElseAndOrElseGet(); // orElse and orElseGet 
	}

	public static void basicExample() {
		// Optional.empty()
		PrintUtil.print("Optional.empty()", Optional.empty());
		PrintUtil.print("Optional.ofNullable(null)", Optional.ofNullable(null));

		// Optional.of(T) - if parameter is null, throws NPE
		// Optional<String> gender = Optional.of(answer0);
		PrintUtil.print("Optional.of(MALE)", optionaMale);

		// Optional.of(T).get()
		PrintUtil.print("Optional.of(MALE).get()", optionaMale.get());

		// Optional.ofNullable(T)
		PrintUtil.print("Optional.ofNullable(MALE)", Optional.ofNullable(MALE));
	}

	public static void mapAndFlatMap() {
		// Optional<?>.map()
		PrintUtil.print("Optional.of(Male).map(String::toUpperCase)", optionaMale.map(String::toUpperCase));
		PrintUtil.print("emptyOptional.map(String::toUpperCase)", optionalEmpty.map(String::toUpperCase));

		// Optional.of(Optional.of(Male))
		Optional<Optional<String>> optionalInOptional = Optional.of(optionaMale);
		PrintUtil.print("optionalInOptional = Optional.of(Optional.of(Male))", optionalInOptional);

		// Optional<Optional<String>>.map(mapper) -> Optional<Optional<String>>
		Optional<Optional<String>> doubleOptionalResult = optionalInOptional.map(i -> i.map(String::toUpperCase));
		PrintUtil.print("optionalInOptional.map(i -> i.map(String::toUpperCase)", doubleOptionalResult);

		// Optional<Optional<Sting>>.flatMap(mapper) -> Optional<String>
		Optional<String> optionalResult = optionalInOptional.flatMap(i -> i.map(String::toString));
		PrintUtil.print("optionalInOptional.flatMap(i -> i.map(String::toString))", optionalResult);
	}

	private static void filter() {
		// Optional.of(Male).filter(i -> i.equals("MALE"))  
		PrintUtil.print("Optional.of(Male).filter(i -> i.equals(\"MALE\"))", optionaMale.filter(i -> i.equals("MALE")));
		
		// Optional.of(Male).filter(i -> i.equalsIgnoreCase(MALE))
		PrintUtil.print("Optional.of(Male).filter(i -> i.equalsIgnoreCase(MALE))", optionaMale.filter(i -> i.equalsIgnoreCase(MALE)));
		
		// Optional.empty().filter(i -> i.equalsIgnoreCase(MALE))
		// Optional.empty() 의 Generic 미 지정 시 cast 필요
		PrintUtil.print("Optional.empty().filter(i -> i.equalsIgnoreCase(MALE))", Optional.empty().filter(i -> ((String) i).equalsIgnoreCase(MALE)));
		PrintUtil.print("Optional.empty().filter(i -> i.equalsIgnoreCase(MALE))", optionalEmpty.filter(i -> i.equalsIgnoreCase(MALE)));
	}

	private static void isPresentAndIfPresent() {
		if(optionaMale.isPresent()) {
			System.out.println("Value available");
		} else {
			System.out.println("Value not available");
		}
		
		optionaMale.ifPresent(i -> System.out.println("ifPresent, this statement executes")); // 실행됨
		optionalEmpty.ifPresent(i -> System.out.println("ifPresent, this statement executes")); // 실행안됨
	}

	private static void orElseAndOrElseGet() {
		PrintUtil.print("optionaMale.orElse(\"<N/A>\")", optionaMale.orElse("<N/A>"));
		PrintUtil.print("optionaEmpty.orElse(\"<N/A>\")", optionalEmpty.orElse("<N/A>"));
		
		PrintUtil.print("optionaMALE.orElseGet(() -> \"<N/A>\")", optionaMALE.orElseGet(() -> "<N/A>"));		
		PrintUtil.print("optionalEmpty.orElseGet(() -> \"<N/A>\")", optionalEmpty.orElseGet(() -> "<N/A>"));
	}
			
}
