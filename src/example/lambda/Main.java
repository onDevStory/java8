package example.lambda;

import java.util.List;

import example.Mock;
import example.util.PrintUtil;
import example.vo.Developer;

public class Main {

	public static void main(String[] args) {
		List<Developer> listDevs = Mock.getDevelopers();
		PrintUtil.printList("Before Sort", listDevs);

		WithoutLambda.start(listDevs);

		WithLambda.start(listDevs);
	}

}
