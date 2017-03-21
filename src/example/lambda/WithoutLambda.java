package example.lambda;

import java.util.Comparator;
import java.util.List;

import example.util.PrintUtil;
import example.vo.Developer;

public class WithoutLambda {

	public static void start(List<Developer> listDevs) {
		
		// sort by age
//		Collections.sort(listDevs, new Comparator<Developer>() {
//			@Override
//			public int compare(Developer o1, Developer o2) {
//				return o1.getAge() - o2.getAge();
//			}
//		});
//		
		//sort by name
//		Collections.sort(listDevs, new Comparator<Developer>() {
//			@Override
//			public int compare(Developer o1, Developer o2) {
//				return o1.getName().compareTo(o2.getName());
//			}
//		});
//
		//sort by salary
//		Collections.sort(listDevs, new Comparator<Developer>() {
//			@Override
//			public int compare(Developer o1, Developer o2) {
//				return o1.getSalary().compareTo(o2.getSalary());
//			}
//		});
//		
		
		
		//List.sort() since Java 8
//		listDevs.sort(new Comparator<Developer>() {
//			@Override
//			public int compare(Developer o1, Developer o2) {
//				return o2.getAge() - o1.getAge();
//			}
//		});
		
		listDevs.sort(new Comparator<Developer>() {

			@Override
			public int compare(Developer o1, Developer o2) {
				return o1.getName().compareTo(o2.getName());
			}
			
		});

		PrintUtil.printList("After Sort", listDevs);
	}

}
