package com.swaglabs.TsetCases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.swaglabs.Utility.PropertiesUtile;
import com.swaglabs.Utility.Utility;
import com.swaglabs.pages.CartPage;
import com.swaglabs.pages.CheckoutPage;
import com.swaglabs.pages.InventoryPage;
import com.swaglabs.pages.LoginPage;
import com.swaglabs.pages.OverviewPage;

public class BaseClass {
	public WebDriver driver;
	public LoginPage lp;
	public InventoryPage ip;
	public CartPage cp;
	public CheckoutPage checkp;
	public  OverviewPage ov;
	public PropertiesUtile pr;
	public  ExtentReports extent;
	public ExtentSparkReporter spark;
	public ExtentTest test;
	
	@BeforeSuite
	public void reports() {
		
		
		
		  //create extent report instance
		  extent=new ExtentReports();
		  //using reporter we can add a path
		  spark=new ExtentSparkReporter("report/Swaglabs.html");
		  //u can setup any configerations
		  spark.config().setDocumentTitle("sprint report");
		  spark.config().setReportName("Swaglabs reposrt");
		  spark.config().setTheme(Theme.DARK);
		  //attached the report
		  extent.attachReporter(spark);
		  //we can create a test using extent
		  
		 test = extent.createTest("Swaglabs end to end test");
	}

	@BeforeTest
	public void setUpBrowser() {
         pr=new PropertiesUtile();
		driver=new ChromeDriver();
		driver.get(pr.getData("url"));
		test.pass("Application open sucssesfully");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		lp=new LoginPage(driver);
        ip=new InventoryPage(driver);
        cp=new CartPage(driver);
        checkp =new CheckoutPage(driver);
        ov=new OverviewPage(driver);
        



	}
	@BeforeClass
	public void pageSetup() {
		System.out.println(lp.getUrl());
		System.out.println(lp.getApptitle());
		lp.dologin(pr.getData("un"), pr.getData("psw"));
		test.pass("Login complited");
		Utility.takeScrrenshot(driver);
		System.out.println(ip.getProductCount());
		ip.getProductName();
		
		ip.addToCart(pr.getData("pname1"));
		test.pass("product added sucsessfully");
		
		
		cp.openCart();
		test.pass("cart page open");
		cp.doremoveproduct();
		cp.docontinueshopping();
		ip.addToCart(pr.getData("pname2"));
		test.pass("product 2 added sucssesfully");
		
		cp.openCart();
		cp.docheckout();
		test.pass("check out page is open");
		
		checkp.doContinue(pr.getData("fname"), pr.getData("lastname"), pr.getData("zip"));
        test.pass("checkout complited");
	}

	public void addWait()
	{
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	@AfterClass
	public void teardown() {
		driver.close();
	}
	@AfterSuite
	public void exitReport() {
		
		extent.flush();
		
	}
}
