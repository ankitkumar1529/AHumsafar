package zCaptureScreenn;

import org.testng.annotations.Test;

public class Master {
	
	@Test(priority=1, groups={"Sanity","Regression","Master"})
	public void masterTCOne()
	{
		System.out.println("Master TC one");
	}

	@Test(priority=2, groups={"Sanity","Regression","Master"})
	public void masterTCtwo()
	{
		System.out.println("Master TC one");
	}
}
