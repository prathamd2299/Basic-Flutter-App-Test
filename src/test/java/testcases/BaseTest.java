package testcases;

import java.net.MalformedURLException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import driverManagaer.AndroidDriverManager;


public class BaseTest {
	protected AndroidDriverManager driverManager;

	@BeforeClass(alwaysRun = true)
	public void setup() throws MalformedURLException {
		driverManager = new AndroidDriverManager();
		driverManager.createFlutterDriver();
	}

	@AfterClass(alwaysRun = true)
	public void tearDown() {
		driverManager.quitDriver();
	}
}
