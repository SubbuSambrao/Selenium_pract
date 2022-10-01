package testScripts;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import config.Common;

public class AutocompleteDemo extends Common{

	@Test
	public void autoComplete() throws Exception {
         d.get("https://jqueryui.com/autocomplete/");
         assertEquals(d.getTitle(),"Autocomplete | jQuery UI");
         d.switchTo().frame(0);
         d.findElement(By.id("tags")).sendKeys("a");
         List<WebElement> list = d.findElements(By.className("ui-menu-item"));
         for(WebElement l: list) {
        	 l.findElement(By.id("tags")).sendKeys(Keys.ARROW_DOWN);
        	 if(l.getText().equals("Asp")) {
        		 d.findElement(By.id("tags")).sendKeys(Keys.ENTER);
        	 }
        	 Thread.sleep(2000);
         }
         Thread.sleep(2000);
	}
	
}
