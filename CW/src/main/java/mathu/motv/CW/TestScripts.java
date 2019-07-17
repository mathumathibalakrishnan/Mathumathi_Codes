package mathu.motv.CW;

import org.testng.annotations.Test;

public class TestScripts extends POM {

	POM t = new POM();
	
	@Test
	public void Hoichoi() throws Exception {
	t.LoginS("https://www.hoichoi.tv", "kenneth@viewlift.com", "test1234");
	t.ContinueWatchingS();
	t.LogOut();
		
	}
		@Test
		public void MOTV() throws Exception {
			t.LoginS("https://app.myoutdoortv.com", "arul@viewlift.com", "test1");
			t.ContinueWatchingS();
			t.LogOut();
			
		}
		public void MovieSpree() throws Exception {
			t.LoginS("https://moviespree.com", "eugene+7@viewlift.com", "aaaaaa");
			t.ContinueWatchingS();
			t.LogOut();
		}
	

	
	
}
