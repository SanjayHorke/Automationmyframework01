package com.swaglabs.TsetCases;

import org.testng.annotations.Test;
import org.testng.annotations.Test;

public class Checkoutpagetest extends BaseClass{
  @Test(priority = 2)
  public void verifycontinueshopping() {
	  checkp.doContinue("sanjay", "horke", "431809");
  }
  @Test
  public void verifyCancel() {
	  checkp.docancel();
	  cp.docheckout();
  }
}
