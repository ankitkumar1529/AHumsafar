package zGrouping;

import org.testng.annotations.Test;

public class GroupingTC002 {
	
	
	@Test(priority=1, groups={"Sanity"})
	public void TC01() 
	{
		System.out.println("Print TC01:"+" "+"Sanity");
	}
	
	@Test(priority=2, groups={"Regression"})
	public void TC02() 
	{
		System.out.println("Print TC02:"+" "+"Regression");
	}
	

	@Test(priority=3, groups={"Master"})
	public void TC03() 
	{
		System.out.println("Print TC03:"+" "+"Master");
	}

	@Test(priority=4, groups={"Master","Sanity"})
	public void TC04() 
	{
		System.out.println("Print TC04:"+" "+"Master"+" "+"Sanity");
	}
	
	
	@Test(priority=5, groups={"Regression","Sanity"})
	public void TC05() 
	{
		System.out.println("Print TC05:"+" "+"Regression"+" "+"Sanity");
	}
	
	@Test(priority=6, groups={"Regression","Master"})
	public void TC06() 
	{
		System.out.println("Print TC06:"+" "+"Regression"+" "+"Master");
	}


}
