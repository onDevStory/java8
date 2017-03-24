package example.optional.advanced;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Mobile {
	private long id;
	private String brand;
	private String name;
	private DisplayFeatures displayFeature;
}
