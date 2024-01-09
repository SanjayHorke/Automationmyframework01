package com.swaglabs.TsetCases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseClass{
	@Test(priority = 3)
	public void verifyAppurl() {
		String url = lp.getUrl();
		Assert.assertTrue(url.contains("saucedemo	"),"fail:url is not contains demo");
		System.out.println("URL sucssesfully matches");
	}
	@Test(priority = 2)
	public void verifyTitle() {

		String title = lp.getApptitle();
		Assert.assertTrue(title.contains("Swag"),"fail:title not matches");
		System.out.println("title sucssesfully matches test case pass");
	}
	@Test(priority = 1)
	public void verifyLogin() {
		String curl = lp.dologin("standard_user","secret_sauce");
		Assert.assertTrue(curl.contains("inventory"),"fail:url not matches");
		System.out.println("login  is sucssesfully done test case pass");
	}
}
