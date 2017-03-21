package example.vo;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Developer {
	private String name;
	private BigDecimal salary;
	private int age;
}
