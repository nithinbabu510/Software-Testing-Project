package com.BookWagon.Test;

import org.testng.annotations.Test;

import com.BookWagon.Base.BWbaseclass;
import com.BookWagon.page.BWcartpage;

public class BWcartTest extends BWbaseclass {

	@Test(priority = 1)
	public void addtocart() throws InterruptedException
	{
		BWcartpage cart=new BWcartpage(driver);
				cart.addTocart("Atomic Habits");
				
		
	}
	@Test(priority = 2)
	public void cartpage() throws InterruptedException
	{
		BWcartpage cart=new BWcartpage(driver);
		cart.varifycartpage();
		boolean ispresent=driver.getPageSource().contains("Atomic Habits");
		if(ispresent)
		{
			System.out.println("item succesfully added to cart");
		}
		else
		{
			System.out.println("item not present in the cart");
		}
	}
	
	@Test(priority = 3)
	public void removeItemfromCart()
	{
		BWcartpage cart=new BWcartpage(driver);
		cart.removeitem();
		boolean isremoved=driver.getPageSource().contains("Atomic Habits");
		if(isremoved)
		{
			System.out.println("failed to remove item from cart");
		}
		else
		{
			System.out.println("item removed from the cart");
		}
	}
	
		
	
	
	
	
}
