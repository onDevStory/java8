package example.optional.advanced;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DisplayFeatures {
	private String size;
	private ScreenResolution resolution;
}
