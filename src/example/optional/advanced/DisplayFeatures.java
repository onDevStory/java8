package example.optional.advanced;

import java.util.Optional;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DisplayFeatures {
	private String size;
	private Optional<ScreenResolution> resolution;
}
