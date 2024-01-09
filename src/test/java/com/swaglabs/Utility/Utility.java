package com.swaglabs.Utility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;







public class Utility {
	
	
	public static void takeScrrenshot(WebDriver driver) {
		TakesScreenshot ts=(TakesScreenshot)driver;
		File temp = ts.getScreenshotAs(OutputType.FILE);
		File dest=new File("./"+"\\ScreenShots\\projectname"+System.currentTimeMillis()+".png");
		try {
			FileHandler.copy(temp, dest);
		} catch (IOException e) {
		
			e.printStackTrace();
		}
		
	}
	
	
	
	
	
	
	public static WebElement waitforPresenceofElement(WebDriver driver,By loc) {
		
		WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5));
		return wait.until(ExpectedConditions.presenceOfElementLocated(loc));
		
	}
	public static WebElement waitforElementClickable(WebDriver driver,By loc) {
		
		WebDriverWait wait1=new WebDriverWait(driver, Duration.ofSeconds(10));
		return wait1.until(ExpectedConditions.elementToBeClickable(loc));
	}
	
	public static Boolean waitforUrlcontains(WebDriver driver,String loc) {
		WebDriverWait wait2=new WebDriverWait(driver, Duration.ofSeconds(8));
		return wait2.until(ExpectedConditions.urlContains(loc));
		
	}
	public static boolean waitForTitleContains(WebDriver driver,String title)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
		return wait.until(ExpectedConditions.titleContains(title));
				
	}
	public static WebElement waitForVisibilityOfElement(WebDriver driver,By loc)
	{
		WebDriverWait obj=new WebDriverWait(driver,Duration.ofSeconds(5));
		return obj.until(ExpectedConditions.visibilityOfElementLocated(loc));
	}
	
	
	
	
	
	
   // utility for select class dropdowns
	
	
	public static void selectBaseDropdown(WebElement ele,String value) {
		Select dd=new Select(ele);
		
		System.out.println(dd.isMultiple());

		List<WebElement> alloptions = dd.getOptions();
		
		System.out.println(alloptions.size());
		
        for(WebElement i:alloptions) {
        	
		   System.out.println(i.getText());

		if(	i.getText().contains(value)) {
				i.click();
				break;
			}

		}
	}
}
