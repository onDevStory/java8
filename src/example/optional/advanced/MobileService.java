package example.optional.advanced;

import java.util.Optional;

public class MobileService {

	public int getMobileScreenWidth(Optional<Mobile> mobile) {
		return mobile
				.flatMap(Mobile::getDisplayFeature)
				.flatMap(DisplayFeatures::getResolution)
				.map(ScreenResolution::getWidth).orElse(0);
	}
}
