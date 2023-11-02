package driverManagaer;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;

public class AndroidDriverManager {
	private AndroidDriver driver;

	public void createFlutterDriver() throws MalformedURLException {
		final DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName", "Pixel 6 Pro API 34");
		capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("app", System.getProperty("user.dir") + "/src/main/java/flutter_app/app-debug.apk");
		capabilities.setCapability("automationName", "Flutter");
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), capabilities);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	}

	public AndroidDriver get() {
		return driver;
	}

	public void quitDriver() {
		driver.quit();
	}
}
