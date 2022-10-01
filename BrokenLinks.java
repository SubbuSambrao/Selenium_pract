package testScripts;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import javax.net.ssl.HttpsURLConnection;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class BrokenLinks {

	WebDriver d;
	@BeforeMethod
	public void setUp() {
		d=new ChromeDriver();
                
		d.manage().timeouts().implicitlyWait(Duration.ofMillis(60));
		d.manage().timeouts().pageLoadTimeout(Duration.ofMinutes(2));
	}
	
	@Test
	public void brokenlinks() throws IOException, Exception {
		d.get("https://community.microfocus.com/adtd/uft/f/sws-fun_test_sf");
		assertEquals(d.getTitle(),"UFT One User Discussions | Micro Focus Community");
		System.out.println(d.getTitle());
		List<WebElement> l = d.findElements(By.tagName("a"));
		System.out.println("Total links size"+ l.size());
		for(int i=0;i<l.size();i++) {
		WebElement w = l.get(i);
	    String s = w.getAttribute("href");
	     URL u = new URL(s);
	     HttpsURLConnection h = (HttpsURLConnection) u.openConnection();
	      h.connect();
	    int responesecode=  h.getResponseCode();
	      if(responesecode<400) {
	    	  System.out.println("valid link"+ s+"\t"+ responesecode);
	    	  Thread.sleep(2000);
	    	  
	                           }
	     Thread.sleep(2000);
	     
		}
	}
	
	@AfterMethod
	public void teardown() {
		d.quit();
	}

}
