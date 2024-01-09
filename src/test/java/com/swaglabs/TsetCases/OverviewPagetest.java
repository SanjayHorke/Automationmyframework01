package com.swaglabs.TsetCases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.Assert;

public class OverviewPagetest extends BaseClass{
  @Test(priority = 1)
  public void verifysummury() {
	  
	  ov.getsummury();
	  
  }
  @Test(priority = 2)
  public void verifyfinish() {
	  String result = ov.dofinish();
	  Assert.assertTrue(result.contains("Thank you for your order!"),"Fail:resut dont caontains");
	  System.out.println("orderd sucsessfully");
  }
}
