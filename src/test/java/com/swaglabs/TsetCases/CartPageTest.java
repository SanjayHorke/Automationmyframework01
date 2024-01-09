package com.swaglabs.TsetCases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CartPageTest extends BaseClass {
	@Test(priority = 1)
	public void verifyremove() {
		cp.doremoveproduct();
		addWait();
	}

	@Test(priority = 2)
	public void verifycontinueShopping() throws InterruptedException{
		addWait();
		cp.docontinueshopping();
		addWait();
		ip.addToCart("Sauce Labs Onesie");
		cp.openCart();
		addWait();
		System.out.println("product aded sucsesfully");
	}
	@Test(priority = 3)
	public void verifyCheckout() {
		String check= cp.docheckout();
		Assert.assertTrue(check.contains("checkout-step-one"),"fail :URL does not contains checkout");
		System.out.println("pass URL is containt checkout");
	}

}
