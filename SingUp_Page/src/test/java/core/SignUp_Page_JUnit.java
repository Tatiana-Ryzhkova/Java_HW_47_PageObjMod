package core;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class SignUp_Page_JUnit {
	
	SignUp_Page SignUp_Page;
	// Confirmation_Page Confirmation_Page;
	String expectedTitle = "Welcome to Sign Up v1";
	String expectedConfirmationTitle = "Confirmation";
	
	@Before
	public void setUp() {
		WebDriver driver = new FirefoxDriver();
		SignUp_Page = new SignUp_Page(driver);
	//	Confirmation_Page = new Confirmation_Page(driver);
		SignUp_Page.loadPage();
	}
	
	@Test
	public void testVerifyTitle() {
		Assert.assertEquals("Title is incorrect!", true, SignUp_Page.verifyTitle(expectedTitle));
	}
	
	@Test
	public void testVerifyLinkFacebook() {
		Assert.assertEquals("No Facebook link", true, SignUp_Page.verifyLink("facebook"));
	}
	
	@Test
	public void testVerifyLinkTwitter() {
		Assert.assertEquals("No Twitter link", true, SignUp_Page.verifyLink("twitter"));
	}
	
	@Test
	public void testVerifyLinkFlickr() {
		Assert.assertEquals("No Flickr link", true, SignUp_Page.verifyLink("flickr"));
	}
	
	@Test
	public void testVerifyLinkYoutube() {
		Assert.assertEquals("No Youtube link", true, SignUp_Page.verifyLink("youtube"));
	}
	
	@Test
	public void testVerifyErrorHandlingFirstName() {
		Assert.assertEquals("No First Name error message", true, SignUp_Page.verifyErrorHandling("firstName", "Please enter First Name"));
	}
	
	@Test
	public void testVerifyErrorHandlingLastName() {
		Assert.assertEquals("No Last Name error message", true, SignUp_Page.verifyErrorHandling("lastName", "Please enter Last Name"));
	}
	
	@Test
	public void testVerifyErrorHandlingEmailAddress() {
		Assert.assertEquals("No Email Address error message", true, SignUp_Page.verifyErrorHandling("emailAddress", "Please enter Email Address"));
	}
	
	@Test
	public void testVerifyErrorHandlingPhoneNumber() {
		Assert.assertEquals("No Phone Number error message", true, SignUp_Page.verifyErrorHandling("phoneNumber", "Please enter Phone Number"));
	}
	
	// @Test
	// public void testVerifySubmitForm() {
	//	SignUp_Page.submitForm("Alex", "Moore", "alexmoore@gmail.com", "415 555-1212", "Male", "CA", true);
		// Assert.assertEquals("Not a Confirmation page!", true, (Confirmation_Page).verifyTitle(expectedConfirmationTitle));
	// }
	
	@Test
	public void testVerifyContentQuotes() {
		Assert.assertEquals("Quote was not changed!", true, SignUp_Page.verifyContent("quotes", null));
	}
	
	@Test
	public void testVerifyContentCity() {
		Assert.assertEquals("City is wrong!", true, SignUp_Page.verifyContent("currentCity", "San Francisco, CA"));
	}
	
	@Test
	public void testVerifyContentWeather() {
		Assert.assertEquals("Weather is wrong!", true, SignUp_Page.verifyContent("currentWeather", "/partlycloudy.gif"));
	}
	
	// @Test
	// public void testVerifyContentDate() {
	//	String realDate = LocalDate.now().format(DateTimeFormatter.ofPattern("MMMM d, yyyy"));
	//	Assert.assertEquals("The date is wrong!", true, SignUp_Page.verifyContent("currentDate", realDate));
	// }
	
	@Test
	public void testVerifyContentOs() {
		Assert.assertEquals("OS is not verifyed!", true, SignUp_Page.verifyContent("currentOs", "Windows 10 & Firefox 47"));
	}
	
	@Test
	public void testVerifyContentBrowser() {
		Assert.assertEquals("Browser is not verifyed!", true, SignUp_Page.verifyContent("currentOs", "Firefox"));
	}
	
	@After
	public void tearDown() {
		SignUp_Page.closeBrowser();
	}

}