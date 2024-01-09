package com.swaglabs.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage {
	public WebDriver driver;


	public CartPage(WebDriver driver) {
		this.driver=driver;
	}
	private By cart=By.xpath("//a[contains(@class,'shopping_cart')]");
	private By rbtn=By.xpath("//button[text()='Remove']");
	private By cntbtn=By.xpath("//button[text()='Continue Shopping']");
	private By chbtn=By.xpath("//button[@id='checkout']");


	public void openCart() {
		driver.findElement(cart).click();
		System.out.println("cart page got opend");
	}
	public void doremoveproduct() {
		driver.findElement(rbtn).click();
		System.out.println("product got removed sucssesfully");
	}
	public void docontinueshopping() {
		driver.findElement(cntbtn).click();
		System.out.println("inventory page opend :u can select the product");
	
	}
	public String docheckout() {
		driver.findElement(chbtn).click();
		return driver.getCurrentUrl();

	}
}
