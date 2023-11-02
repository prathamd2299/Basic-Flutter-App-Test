package pageObjectModel;

import io.appium.java_client.android.AndroidDriver;
import io.github.ashwith.flutter.FlutterFinder;

public class CatalogPage {
	private final FlutterFinder finder;

	public CatalogPage(final AndroidDriver driver) {
		finder = new FlutterFinder(driver);
	}

	public String pageTitle() {
		return finder.byText("Catalog").getText();
	}
}
