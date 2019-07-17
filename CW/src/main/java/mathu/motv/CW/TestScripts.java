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
			t.setup();
			t.LoginS("https://app.myoutdoortv.com", "arul@viewlift.com", "test1");
			t.ContinueWatchingS();
			t.LogOut();
			
		}
	@Test
		public void MovieSpree() throws Exception {
		t.setup();
			t.LoginS("https://moviespree.com", "eugene+7@viewlift.com", "aaaaaa");
			t.ContinueWatchingS();
			t.LogOut();
		}
	@Test
	
	public void MSE() throws Exception {
		t.setup();
			t.LoginS("https://www.monumentalsportsnetwork.com", "aarti+mse@viewlift.com", "test1");
			t.ContinueWatchingS();
			t.LogOut();
		}
	
@Test
	
	public void AFA() throws Exception {
		t.setup();
			t.LoginS("https://afaplay.viewlift.com", "mathumathi+5june@viewlift.com", "Test@1");
			t.ContinueWatchingS();
			t.LogOut();
		}
	
@Test

public void LSN() throws Exception {
	t.setup();
		t.LoginS("https://www.laxsportsnetwork.com", "bobtest956@gmail.com", "aaaaaa");
		t.ContinueWatchingS();
		t.LogOut();
	}
@Test

public void MotoAmerica() throws Exception {
	t.setup();
		t.LoginS("https://www.motoamericaliveplus.com/", "sandeep@gmail.com", "Test@1");
		t.ContinueWatchingS();
		t.LogOut();
	}
@Test

public void TB() throws Exception {
	t.setup();
		t.LoginS("https://www.theidentitytb.com", "mathumathi+15@viewlift.com", "test1");
		t.ContinueWatchingS();
		t.LogOut();
	}

@Test

public void Kronon() throws Exception {
	t.setup();
		t.LoginS("https://www.kronon.tv", "mathumathi+16@viewlift.com", "Test@1");
		t.ContinueWatchingS();
		t.LogOut();
	}

@Test

public void Pll() throws Exception {
	t.setup();
		t.LoginS("https://www.premierlacrosseleague.com/", "bobtest956@gmail.com", "aaaaaa");
		t.ContinueWatchingS();
		t.LogOut();
	}

@Test

public void AFL() throws Exception {
	t.setup();
		t.LoginS("https://www.arenafootball.com", "bobtest956@gmail.com", "aaaaaa");
		t.ContinueWatchingS();
		t.LogOut();
	}

@Test

public void BeatTV() throws Exception {
	t.setup();
		t.LoginS("https://www.be-at.tv/", "bobtest956@gmail.com", "aaaaaa");
		t.ContinueWatchingS();
		t.LogOut();
	}

@Test

public void HereTV() throws Exception {
	t.setup();
		t.LoginS("http://site-here-tv.viewlift.com", "eugene@viewlift.com", "test123");
		t.ContinueWatchingS();
		t.LogOut();
	}



}
