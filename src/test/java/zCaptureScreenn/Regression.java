package zCaptureScreenn;

import org.testng.annotations.Test;

public class Regression {

	
	@Test(priority=1, groups={"Regression","Master"})
	public void regressionTCOne()
	{
		System.out.println("Regression TC one");
	}

	@Test(priority=2, groups={"Regression","Master"})
	public void regressionTCtwo()
	{
		System.out.println("Regression TC one");
	}
}
