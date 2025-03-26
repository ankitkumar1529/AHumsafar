package zGrouping;

import org.testng.annotations.Test;

public class GroupingTC {

	
	@Test(priority=1, groups={"Sanity"})
	public void TC1() 
	{
		System.out.println("Print TC1:"+" "+"Sanity");
	}
	
	@Test(priority=2, groups={"Regression"})
	public void TC2() 
	{
		System.out.println("Print TC2:"+" "+"Regression");
	}
	

	@Test(priority=3, groups={"Master"})
	public void TC3() 
	{
		System.out.println("Print TC3:"+" "+"Master");
	}

//	@Test(priority=4, groups={"Regression","Sanity"})
	public void TC4() 
	{
		System.out.println("Print TC4:"+" "+"Regression"+" "+"Sanity");
	}

}
