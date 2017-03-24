package example.optional.advanced;

import java.util.Optional;

public class MobileTesterWithoutOptional {

	public static void main(String[] args) {
		ScreenResolution resolution = new ScreenResolution(750, 1334);
		DisplayFeatures dfeatures = new DisplayFeatures("4.7", Optional.of(resolution));
		Mobile mobile = new Mobile(2015001, "Apple", "iPhone 6s", Optional.of(dfeatures));

		MobileService mService = new MobileService();

		int mobileWidth = mService.getMobileScreenWidth(Optional.of(mobile));
		System.out.println("Apple iPhone 6s Screen Width = " + mobileWidth);

		Mobile mobile2 = new Mobile(2015001, "Apple", "iPhone 6s", Optional.empty());
		int mobileWidth2 = mService.getMobileScreenWidth(Optional.of(mobile2));
		System.out.println("Apple iPhone 16s Screen Width = " + mobileWidth2);
	}

}
