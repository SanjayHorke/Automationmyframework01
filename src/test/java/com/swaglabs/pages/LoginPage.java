package com.swaglabs.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
	private WebDriver driver;

	public LoginPage(WebDriver driver) {
		this.driver=driver;

	}
	private By username=By.name("user-name");
	private By password=By.id("password");
	private By btn=By.id("login-button");


	public String getUrl() {

		return driver.getCurrentUrl();

	}
	public String getApptitle() {

		return driver.getTitle();
	}
	public String dologin(String un,String psw) {
		driver.findElement(username).sendKeys(un);
		driver.findElement(password).sendKeys(psw);
		driver.findElement(btn).click();
		String curl=driver.getCurrentUrl();
		return curl;
		
	}
}
