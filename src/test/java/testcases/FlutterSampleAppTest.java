package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjectModel.CatalogPage;
import pageObjectModel.LoginPage;

public class FlutterSampleAppTest extends BaseTest {
	@Test
	public void testProviderShopperApp() {
		final LoginPage loginPage = new LoginPage(this.driverManager.get());
		System.out.println("User logged in successfully");
		final CatalogPage catalogPage = loginPage.performLogin("pratham@gmail.com", "Pass1234");
		String actualCatelogPageTitle = catalogPage.pageTitle();
		String expectedCatalogPageTitle = "Catalog";
		Assert.assertEquals(actualCatelogPageTitle, expectedCatalogPageTitle);
		System.out.println("User navigated successfully to catalog page.");

	}
}
