package br.com.inmetrics.teste.pageobjectscontrollers;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Driver {
	
	WebDriver webDriver;
	
	public WebDriver instaciarNovaJanela() {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\joseribeiro\\Downloads\\chromedriver_win32 (4)\\chromedriver.exe");
		webDriver = new ChromeDriver();
		return webDriver;
		
	}
	
	public Login navegarAteURLLogin(String string) {
		webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		webDriver.get(string);
		return new Login(webDriver);
		
	}

	public void fecharJanela() {
		webDriver.quit();
	}
	
//	public String obterURL() {
//		return webDriver.getCurrentUrl();
//	}

}
