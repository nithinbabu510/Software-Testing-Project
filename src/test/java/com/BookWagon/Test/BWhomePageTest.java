package com.BookWagon.Test;

import java.io.IOException;

import org.testng.annotations.Test;

import com.BookWagon.Base.BWbaseclass;
import com.BookWagon.page.BWhomePage;

public class BWhomePageTest extends BWbaseclass {
	
	@Test(priority = 4)
	public void brokenlinks()
	{
		BWhomePage home=new BWhomePage(driver);
		home.brokenlinks();
	}
	@Test(priority = 2)
	public void titlevarification()
	{
		BWhomePage home=new BWhomePage(driver);
		home.titlevarification();
	}
@Test(priority = 1)
public void logovarification()
{
	BWhomePage home=new BWhomePage(driver);
	home.validatingLogo();
}

@Test(priority = 3)
public void logoScreenshot() throws IOException
{
    BWhomePage home=new BWhomePage(driver);
       home.screenshot();
}
}
