package pageObjectModel;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.android.AndroidDriver;
import io.github.ashwith.flutter.FlutterFinder;

public class LoginPage {
	private final AndroidDriver driver;
	private final FlutterFinder finder;

	public LoginPage(final AndroidDriver driver) {
		this.driver = driver;
		this.finder = new FlutterFinder(driver);
	}

	private WebElement userNameField() {
		return finder.bySemanticsLabel("Username");
	}

	private WebElement passwordField() {
		return finder.bySemanticsLabel("Password");
	}

	private WebElement enterBtn() {
		return finder.byText("ENTER");
	}

	public CatalogPage performLogin(final String userName, final String password) {
		this.userNameField().sendKeys(userName);
		String regex = "^[A-Za-z0-9+_.-]+@(.+){5,12}$";
		Pattern p = Pattern.compile(regex);

		Matcher m = p.matcher(userName);
		if (m.matches()) {
			System.out.println("Valid username\n");
		} else {
			System.out.println("Invalid Username\n");
		}

		this.passwordField().sendKeys(password);
		String regex1 = "^(?=.*[0-9])" + "(?=.*[a-z])(?=.*[A-Z])" + "(?=.*[@#$%^&+=])" + "(?=\\S+$).{8,50}$";
		Pattern p1 = Pattern.compile(regex1);

		Matcher m1 = p1.matcher(password);
		if (m1.matches()) {
			System.out.println("Valid Password\n");
		} else {
			System.out.println("Invalid Password\n");
		}

		this.enterBtn().click();
		return new CatalogPage(this.driver);

	}

}
