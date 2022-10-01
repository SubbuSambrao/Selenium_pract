package stepDefi;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import net.bytebuddy.asm.Advice.This;

public class OR {
	@FindBy(id="login-link") public WebElement lnkLogin;
	@FindBy(xpath="//input[@type='text']") public WebElement tfUserName;
	@FindBy(xpath="//input[@type='password']") public WebElement tfPassword;
	@FindBy(xpath="//span[contains(.,'Submit')]") public WebElement btnSubmit;
	@FindBy(id="logout-trigger") public WebElement lnkLogout;
	@FindBy(partialLinkText = "Receive QR-code payment") public WebElement lnkQRCodePayment;
	@FindBy(xpath="//input") public WebElement tfAmount;
	@FindBy(xpath="//button[contains(.,'Next')]") public WebElement btnNext;
	@FindBy(xpath="//receive-qr-payment-step-pending/div/img") public WebElement imgQRCode;
	@FindBy(xpath="//label-value[3]/div/div/div") public WebElement urlQRCode;
	
	
	public OR(WebDriver driver)
	{
		PageFactory.initElements(driver,this); 
	}
	
	public void fillLogin(String uname,String password)
	{
		//lnkLogin.click();
		tfUserName.sendKeys(uname);
		tfPassword.sendKeys(password);
		btnSubmit.click();
	}

}
