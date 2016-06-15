package core;

import org.openqa.selenium.WebDriver;

public class Confirmation_Page {
	
	private WebDriver driver;
	String baseUrl = "http://learn2test.net/qa/apps/sign_up/v1/conformation.php";
	
	public Confirmation_Page(WebDriver driver) {
		this.driver = driver;
	}
	
	public boolean verifyTitle(String expectedTitle) {
		String actualTitle = driver.getTitle();
		return expectedTitle.equals(actualTitle);
	}

}