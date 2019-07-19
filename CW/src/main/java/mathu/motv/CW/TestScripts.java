package mathu.motv.CW;


import org.testng.annotations.Test;

public class TestScripts extends POM {

	POM t = new POM();

	@Test 
	public void Hoichoi() throws Exception {
		
	try {
	t.LoginS("https://www.hoichoi.tv", "kenneth@viewlift.com", "test1234");
	t.ContinueWatchingS();
	t.LogOut();
	}
	catch (Exception p1){
	p1.getStackTrace();
	
	}
		
	finally {
		driver.quit();
		
	}
	}
	
	@Test
		public void MOTV() throws Exception {
			try {
			t.LoginS("https://app.myoutdoortv.com", "shraddhs+3@gmail.com", "test12345");
			t.ContinueWatchingS();
			t.LogOut();
			}
			catch (Exception m1)
			{
				m1.getMessage();
			}
			finally {
				driver.quit();
				
			}
			
		}
	@Test
		public void MovieSpree() throws Exception {
		try {
			t.LoginS("https://moviespree.com", "eugene+7@viewlift.com", "aaaaaa");
			t.ContinueWatchingS();
			t.LogOut();
		}
		catch (Exception m2)
		{
			m2.getMessage();
			}
		finally {
			driver.quit();
			
		}
		}
	
	@Test
	public void MSE() throws Exception {
		try {
			t.LoginS("https://www.monumentalsportsnetwork.com", "aarti+mse@viewlift.com", "test1");
			t.ContinueWatchingS();
			t.LogOut();
		}
		catch (Exception ms1)
		{
			ms1.getMessage();
			}
		finally {
			driver.quit();
			
		}
		}
	@Test
	public void AFA() throws Exception {
	try {
			t.LoginS("https://afaplay.viewlift.com", "mathumathi+5june@viewlift.com", "Test@1");
			t.ContinueWatchingS();
			t.LogOut();
	}
	catch (Exception af1)
	{
		af1.getMessage();
		}
	finally {
		driver.quit();
		
	}
	
		}
	
	@Test

public void LSN() throws Exception {
	try {
		t.LoginS("https://www.laxsportsnetwork.com", "bobtest956@gmail.com", "aaaaaa");
		t.ContinueWatchingS();
		t.LogOut();
	}
	catch (Exception ls1)
	{
		ls1.getMessage();
		}finally {
			driver.quit();
		
	}
	
	}

	@Test
public void MotoAmerica() throws Exception {
	try {
		t.LoginS("https://www.motoamericaliveplus.com/", "sandeep@gmail.com", "Test@1");
		t.ContinueWatchingS();
		t.LogOut();
	}
	catch (Exception mo1)
	{
		mo1.getMessage();
		}
	finally {
		driver.quit();
		
	}
	
	}

	@Test
public void TB() throws Exception {
	try {
		t.LoginS("https://www.theidentitytb.com", "mathumathi+15@viewlift.com", "test1");
		t.ContinueWatchingS();
		t.LogOut();
	}
	catch (Exception tb1)
	{
		tb1.getMessage();
		}
	finally {
		driver.quit();
		
	}
	
	}


	@Test
public void Kronon() throws Exception {
try {
		t.LoginS("https://www.kronon.tv", "mathumathi+16@viewlift.com", "Test@1");
		t.ContinueWatchingS();
		t.LogOut();
}
catch (Exception kr1)
{
	kr1.getMessage();
	}
finally {
	driver.quit();
	
}
	}


	@Test
public void Pll() throws Exception {
	try {
		t.LoginS("https://www.premierlacrosseleague.com/", "bobtest956@gmail.com", "aaaaaa");
		t.ContinueWatchingS();
		t.LogOut();
	}
	catch (Exception pll1)
	{
		pll1.getMessage();
		}
	finally {
		driver.quit();
		
	}
	
	}


	@Test
public void AFL() throws Exception {
	try {
		t.LoginS("https://www.arenafootball.com", "bobtest956@gmail.com", "aaaaaa");
		t.ContinueWatchingS();
		t.LogOut();
	}
	catch (Exception afl1)
	{
		afl1.getMessage();
		}
	finally {
		driver.quit();
		
	}
	}


	@Test
public void BeatTV() throws Exception {
	try {
		t.LoginS("https://www.be-at.tv/", "bobtest956@gmail.com", "aaaaaa");
		t.ContinueWatchingS();
		t.LogOut();
	}
	catch (Exception beat1)
	{
		beat1.getMessage();
		}
	finally {
		driver.quit();
		
	}
	}

	@Test

public void HereTV() throws Exception {
	try {
		t.LoginS("http://site-here-tv.viewlift.com", "eugene@viewlift.com", "test123");
		t.ContinueWatchingS();
		t.LogOut();
	}
	catch (Exception here1)
	{
		here1.getMessage();
		}
	finally {
		driver.quit();
		
	}
	
	}



}
