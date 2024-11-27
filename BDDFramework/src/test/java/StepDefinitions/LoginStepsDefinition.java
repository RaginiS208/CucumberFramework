package StepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import Utilities.BrowserFactory;
import Utilities.ConfigReader;
import Utilities.LoggerFile;
import io.cucumber.core.logging.Logger;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageClass.LoginPage;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;
import java.util.logging.LogManager;
import org.apache.log4j.PropertyConfigurator;

public class LoginStepsDefinition {
	
	static WebDriver driver;
	 LoginPage loginPage;
	 
		 
	@Given("User launches the application on {string}")
   	public void user_launches_the_application_on(String browser) {
	    // Write code here that turns the phrase above into concrete actions
		driver = BrowserFactory.getDriver(browser);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	    driver.get(ConfigReader.getProperty("application.url"));
	
		 loginPage = new LoginPage(driver);
		 LoggerFile.logInfo("User launches the application for Login func");
	}

	@When("User enters valid username {string} and password {string}")
	public void user_enters_valid_username_and_password(String username, String password) {
	    // Write code here that turns the phrase above into concrete actions
		loginPage.enterUsername(username);
        loginPage.enterPassword(password);
	}
	

	@And("User clicks on Login button")
	public void user_clicks_on_login_button() {
	    // Write code here that turns the phrase above into concrete actions
		
		loginPage.clickLogin();
		LoggerFile.logInfo("User Clicked Login Btn");
	}

	@Then("User should be able to Navigated to Home Page")
	public void user_should_be_able_to_navigated_to_home_page() {
	    // Write code here that turns the phrase above into concrete actions
		
		System.out.println(driver.getTitle());

		 String actualText = driver.findElement(By.xpath("//h1[@class='post-title']")).getText();
		 
		 System.out.println(actualText);

         // Expected text
         String expectedText = "Logged In Successfully";

         // Assert that the actual text matches the expected text
         Assert.assertEquals(expectedText, actualText);
	}

	@And("close the browser")
	public void close_the_browser() {
	    // Write code here that turns the phrase above into concrete actions
	    driver.close();
	}

	
	@When("User enters invalid username {string} and password {string}")
	public void user_enters_invalid_username_and_password(String username, String password){
	    // Write code here that turns the phrase above into concrete actions
		loginPage.enterUsername(username);
        loginPage.enterPassword(password);
	}

	@Then("User should be shown invalid credential message")
	public void user_should_be_shown_invalid_credential_message() {
		
		
	    // Write code here that turns the phrase above into concrete actions
		
		// Cast WebDriver to JavascriptExecutor
        JavascriptExecutor js = (JavascriptExecutor) driver;

        // Scroll down by a specific amount (e.g., 1000 pixels)
        js.executeScript("window.scrollBy(0, 400);");
        String actualText = driver.findElement(By.xpath("//div[@id='error']")).getText();
		 
		 System.out.println(actualText);

         // Expected text
         String expectedText = "Your username is invalid!";

         // Assert that the actual text matches the expected text
         Assert.assertEquals(expectedText, actualText);
	}

}
