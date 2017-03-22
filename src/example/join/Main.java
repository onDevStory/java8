package example.join;

import java.util.StringJoiner;
import java.util.stream.Collectors;

import example.Mock;
import example.util.PrintUtil;

public class Main {

	public static void main(String[] args) {

		String result;
		StringJoiner sj;
		
		// Join String by a delimiter
		sj = new StringJoiner(",");
		sj.add("aaa");
		sj.add("bbb");
		sj.add("ccc");
		PrintUtil.print("new StringJoiner(\",\")", sj.toString());
		
		// Join String by a delimiter and starting with a supplied prefix and ending with a supplied suffix.
		sj = new StringJoiner("/", "prefix-", "-suffix");
		sj.add("2016");
		sj.add("02");
		sj.add("26");
		PrintUtil.print("new StringJoiner(\"/\", \"prefix-\", \"-suffix\")", sj.toString());
		
		
		// String.join("-", "2015", "10", "31" );
		PrintUtil.print("String.join(\"-\", \"2015\", \"10\", \"31\" )", String.join("-", "2015", "10", "31" ));
		
		PrintUtil.print("Join a List by a delimiter ㅡㅡㅡㅡㅡㅡ");
		
	 	// String.join(", ", Mock.getList())
		PrintUtil.print("String.join(\", \", Mock.getList())", String.join(", ", Mock.getListIdentity()));
	
		// Join List<String> by using stream, map, collect(Collector c).
		result = Mock.getListIdentity().stream()
							.map(item -> item)
							.collect(Collectors.joining(" | "));
		PrintUtil.print("Join List<String> by using stream, map, collect(Collector c)", result);
		
		// Join List<Object> by using stream, map, collect(Collector c)
		result = Mock.getDevelopers().stream()
									.map(item -> item.getName())
									.collect(Collectors.joining(", ", "{", "}"));
		PrintUtil.print("Join List<Object> by using stream, map, collect(Collector c)", result);
	}

}
