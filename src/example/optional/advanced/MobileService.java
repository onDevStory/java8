package example.optional.advanced;

public class MobileService {

	public int getMobileScreenWidth(Mobile mobile) {
		if (mobile != null) {
			DisplayFeatures displayFeatures = mobile.getDisplayFeature();
			if (displayFeatures != null) {
				ScreenResolution screenResolution = displayFeatures.getResolution();
				if (screenResolution != null) {
					return screenResolution.getWidth();
				}
			}
		}
		return 0;
	}

}
