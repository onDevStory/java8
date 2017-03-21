package example.lambda;

import java.util.Comparator;
import java.util.List;

import example.util.PrintUtil;
import example.vo.Developer;

public class WithLambda {

	public static void start(List<Developer> listDevs) {

//		// sort by age
//		listDevs.sort((Developer o1, Developer o2) -> o1.getAge() - o2.getAge());
//
//		// lambda, valid, parameter type is optional
//		listDevs.sort((o1, o2) -> o1.getAge() - o2.getAge());
		
		
		Comparator<Developer> salaryDescComparator = (o1, o2) -> o2.getSalary().compareTo(o1.getSalary()); 
		
		// sort by salary desc
		listDevs.sort(salaryDescComparator);
		
		// sort by salary desc
		listDevs.sort(salaryDescComparator.reversed());
		
		PrintUtil.printList("After Sort", listDevs);
	}

}
