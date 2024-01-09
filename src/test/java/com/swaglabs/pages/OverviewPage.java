package com.swaglabs.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OverviewPage {
private WebDriver driver;

public OverviewPage(WebDriver driver) {
	this.driver=driver;
}

private By summury=By.xpath("//div[@class='summary_info']//div[contains(@class,'summary')]");
private By finishbtn=By.xpath("//button[@id='finish']");
private By cancelbtn=By.xpath("//button[@id='cancel']");
private By text=By.xpath("//h2[text()='Thank you for your order!']");



public void getsummury() {
	List<WebElement> alldetails = driver.findElements(summury);
	for(WebElement i:alldetails) {
		System.out.println(i.getText());
	}
}
public String dofinish() {
	driver.findElement(finishbtn).click();
	return  driver.findElement(text).getText();
	
	
}


}
