package com.swaglabs.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {
private WebDriver driver;

public CheckoutPage(WebDriver driver) {
	this.driver=driver;
	
	

}
private By firstname=By.id("first-name");
private By lastname=By.id("last-name");
private By zipcode=By.id("postal-code");
private By countinue=By.id("continue");
private By cancel=By.id("cancel");



public void doContinue(String fn,String ln,String zip ) {
	driver.findElement(firstname).sendKeys(fn);
	driver.findElement(lastname).sendKeys(ln);
	driver.findElement(zipcode).sendKeys(zip);
	driver.findElement(countinue).click();
}
public void docancel() {
	driver.findElement(cancel).click();
}

}
