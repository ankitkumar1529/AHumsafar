package zCaptureScreenn;

import org.testng.annotations.Test;

public class Sanity {

	@Test(priority=1, groups={"Sanity","Master"})
	public void sanityTCOne()
	{
		System.out.println("Sanity TC one");
	}

	@Test(priority=2, groups={"Sanity","Master"})
	public void sanityTCtwo()
	{
		System.out.println("Sanity TC one");
	}
}
