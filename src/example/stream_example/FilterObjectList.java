package example.stream_example;

import example.Mock;
import example.util.PrintUtil;
import example.vo.Developer;

public class FilterObjectList {

	public static void main(String[] args) {
		normalExample();
		evolvedExample();
	}

	private static void normalExample() {
		Developer developer = null;
		for(Developer item : Mock.getDevelopers()) {
			if(item.getName().equals("sjh")) {
				developer = item;
			}
		}
		PrintUtil.print("normalExample", developer.toString());
	}
	
	private static void evolvedExample() {
		Developer developer;
		
		// One condition
		developer = Mock.getDevelopers().stream()									// Convert to steam
									.filter(item -> item.getName().equals("sjh"))   // we want "michael" only
									.findAny()                                      // If 'findAny' then return found
									.orElse(null);                                  // If not found, return null
		PrintUtil.print("evolvedExample - One condition", developer.toString());
		
		// Multiple condition 1 
		developer = Mock.getDevelopers().stream()
										.filter(item -> item.getName().equals("sjh") && item.getAge() > 30)
										.findAny()
										.orElse(null);
		PrintUtil.print("evolvedExample - Multiple condition 1", developer.toString());
		
		// Multiple condition 2
		developer = Mock.getDevelopers().stream()
										.filter(item -> {
											if(item.getName().equals("sjh") && item.getAge() > 30) {
												return true;
											}
											return false;
										})
										.findAny()
										.orElse(null);
		PrintUtil.print("evolvedExample - Multiple condition 2", developer.toString());
		
		// filter - map
		String name = Mock.getDevelopers().stream()
										.filter(item -> item.getName().equals("sjh"))
										.map(Developer::getName)						// convert stream to String
										.findAny()
										.orElse("");
		PrintUtil.print("filter - .map(Developer::getName)", name);
	}

}
