package core;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SignUp_Page {
	
	private WebDriver driver;
	String baseUrl = "http://learn2test.net/qa/apps/sign_up/v1/";
	
	public SignUp_Page(WebDriver driver) {
		this.driver = driver;
	}
	
	public boolean verifyTitle(String expectedTitle) {
		String actualTitle = driver.getTitle();
		return expectedTitle.equals(actualTitle);
	}
	
	public void loadPage() {
		driver.get(baseUrl);
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	public void closeBrowser() {
		driver.quit();
	}

	public boolean verifyLink(String linkType) {
		boolean result = false;
		switch (linkType) {
		case "facebook":
			result = driver.findElements(By.id("id_link_facebook")).size() > 0;
			break;
		case "twitter":
			result = driver.findElements(By.id("id_link_twitter")).size() > 0;
			break;
		case "flickr":
			result = driver.findElements(By.id("id_link_flickr")).size() > 0;
			break;
		case "youtube":
			result = driver.findElements(By.id("id_link_youtube")).size() > 0;
			break;
		default:
			break;
		}
		return result;
	}

	public boolean verifyErrorHandling(String errorType, String expectedErrorText) {
		boolean result = false;
		switch (errorType) {
		case "firstName":
			driver.findElement(By.id("id_submit_button")).click();
			String firstNameError = driver.findElement(By.id("ErrorLine")).getText();
			result = firstNameError.equals(expectedErrorText);
			break;
		case "lastName":
			driver.findElement(By.id("id_fname")).sendKeys("Iryna");
			driver.findElement(By.id("id_submit_button")).click();
			String lastNameError = driver.findElement(By.id("ErrorLine")).getText();
			result = lastNameError.equals(expectedErrorText);
			break;
		case "emailAddress":
			driver.findElement(By.id("id_fname")).sendKeys("Iryna");
			driver.findElement(By.id("id_lname")).sendKeys("Kaleniuk");
			driver.findElement(By.id("id_submit_button")).click();
			String emailAddressError = driver.findElement(By.id("ErrorLine")).getText();
			result = emailAddressError.equals(expectedErrorText);
			break;
		case "phoneNumber":
			driver.findElement(By.id("id_fname")).sendKeys("Iryna");
			driver.findElement(By.id("id_lname")).sendKeys("Kaleniuk");
			driver.findElement(By.id("id_email")).sendKeys("oseznotest4@gmail.com");
			driver.findElement(By.id("id_submit_button")).click();
			String phoneNumber = driver.findElement(By.id("ErrorLine")).getText();
			result = phoneNumber.equals(expectedErrorText);
			break;
		default:
			break;
		}
		return result;
	}
	
	public void submitForm(String firstName, String lastName, String emailAddress, String phoneNumber, String gender,
			String state, boolean checkTerms) {
		driver.findElement(By.id("id_reset_button")).click();
		driver.findElement(By.id("id_fname")).sendKeys(firstName);
		driver.findElement(By.id("id_lname")).sendKeys(lastName);
		driver.findElement(By.id("id_email")).sendKeys(emailAddress);
		driver.findElement(By.id("id_phone")).sendKeys(phoneNumber);
		if (gender.equals("Female")) {
			driver.findElement(By.id("id_g_radio_01")).click();
		} else {
			driver.findElement(By.id("id_g_radio_02")).click();
		}
		driver.findElement(By.id("id_state")).sendKeys("CA");
		driver.findElement(By.id("id_checkbox")).click();
		if (checkTerms) {
			driver.findElement(By.id("id_submit_button")).click();
		}
	}

	public boolean verifyContent(String contentType, String contentText) {
		boolean result = false;
		switch (contentType) {
		case "quotes":
			driver.findElement(By.id("id_quotes")).getText();
			String quote = driver.findElement(By.id("id_quotes")).getText();
			//refresh the page and verify that quote has changed
			driver.navigate().refresh();
			String quoteAfterRefresh = driver.findElement(By.id("id_quotes")).getText();
			return !quote.equals(quoteAfterRefresh);
		case "currentCity":
			String actualCity = driver.findElement(By.id("id_current_location")).getText();
			return actualCity.equals(contentText);
		case "currentWeather":
			String actualWeather = driver.findElement(By.id("id_weather_icon")).getAttribute("src");
			return actualWeather.contains(contentText);
		case "currentDate":
			String currentDate = driver.findElement(By.id("timestamp")).getText().trim();
			return currentDate.equals(contentText);
		case "currentOs":
			String currentOs = driver.findElement(By.id("os_browser")).getText();
			return currentOs.startsWith("OS X 10.10 Yosemite");
		case "currentBrowser":
			String currentBrowser = driver.findElement(By.id("os_browser")).getText();
			return currentBrowser.startsWith("Firefox");
		default:
			break;
		}
		return result;
	}
}

//  **************

// public class SignUp_Page {
   
	// String url = null;
   	// String title_SignUp_expected = null;

	// String title_facebook_expected = null;
	// String title_twitter_expected = null;
	// String title_flickr_expected = null;
	// String title_youtube_expected = null;
	
// 	String error_fname_empty_expected = null;
	// String error_lname_empty_expected = null;
// 	String error_email_empty_expected = null;
//	String error_phone_empty_expected = null;
	
//	String error_firstName_invalidImput_expected = null;
//	String error_lastName_invalidImput_expected = null;
//	String error_email_invalidImput_expected = null;
//	String error_phone_invalidImput_expected = null;
	
//	String fname = null;
//	String lname = null;
//	String email = null;
//	String phone = null;	

	//public static WebDriver  driver;
	 
	//WebDriver driver = new HtmlUnitDriver();
//	WebDriver driver = new FirefoxDriver();  
	
//	public SignUp_Page(WebDriver driver2) {
		// TODO Auto-generated constructor stub
//	}


//	public void before(){
	
	//	driver = new FirefoxDriver();
	//	driver.get(url);
	//	driver.manage().window().maximize();
	//	driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS); 	}

	
//	public void after(){		
//		driver.close();
//		driver.quit();
//		System.out.println("Finished"); 	}
	
//	public  String getTitlePage (){
//		String actual_title = driver.getTitle();
//        return actual_title; 	}
	
//	public static Boolean isElementExist(WebDriver driver, String element_id,  String elementName)  {
//		boolean isExist = true;
//		try { 
//			driver.findElement(By.id(element_id)).isDisplayed();		} 

//		catch ( NoSuchElementException e  ){
//			isExist = false; 				}		
	//		return isExist;  	}

//	public  Boolean verifyTitlePage (String expected_title){
//		Boolean b =    getTitlePage ().equals(expected_title);
// return b; }

//	public String verify_imageLINK( String id_link) {
//		driver.findElement(By.id(id_link)).click();
//		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
  	
//		ArrayList<String> allTabs = new ArrayList<String>(
//			   driver.getWindowHandles());
//		driver.switchTo().window(allTabs.get(1));
//		String title_link_actual = getTitlePage();
//		System.out.println("Title acctual is: " + title_link_actual);
//		driver.close();
//		driver.switchTo().window(allTabs.get(0));
//		return title_link_actual; }
	
	
//	public void readProperties (String file_path){
	// String	file_path = "./src/main/resources/DataSource.properties";	
// try {
//	Properties property = new Properties();
//	property.load(new FileInputStream(file_path));
	
// url = property.getProperty("url");
// title_SignUp_expected = property.getProperty("title_SignUp_expected" );

// title_facebook_expected = property.getProperty("title_facebook_expected");
// title_twitter_expected = property.getProperty("title_twitter_expected");
// title_flickr_expected = property.getProperty("title_flickr_expected");
// title_youtube_expected = property.getProperty("title_youtube_expected");
	
// error_fname_empty_expected = property.getProperty("error_fname_empty_expected");
// error_lname_empty_expected = property.getProperty("error_lname_empty_expected");
// error_email_empty_expected = property.getProperty("error_email_empty_expected");
// error_phone_empty_expected = property.getProperty("error_phone_empty_expected");
	
// error_firstName_invalidImput_expected = property.getProperty("error_firstName_invalidImput_expected");
// error_lastName_invalidImput_expected =  property.getProperty("error_lastName_invalidImput_expected");
// error_email_invalidImput_expected =  property.getProperty("error_email_invalidImput_expected");
// error_phone_invalidImput_expected =  property.getProperty("error_phone_invalidImput_expected");
	
// fname = property.getProperty("fname");
// lname = property.getProperty("lname");
// email = property.getProperty("email");
// phone = property.getProperty("phone");
	
	
	
// } catch (FileNotFoundException e) {
//	System.out.println("Method 'readProperties()' - BLOCK");
//	System.out.println();
//	System.out.println(e.getMessage());
// } catch (IOException e) {
//	System.out.println("Method 'readProperties()' - BLOCK");
//	System.out.println();
//	System.out.println(e.getMessage()); }	}//END readProperties	


// }//End of Class