package StepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.time.Duration;

public class DropdownStepsDefinitions {
	 WebDriver driver;
	 WebDriverWait wait;
	
	@Given("I navigate to the MakeMyTrip homepage")
	public void i_navigate_to_the_make_my_trip_homepage() {
	    // Write code here that turns the phrase above into concrete actions
		driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.makemytrip.com/");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	@When("I close any pop-ups if present")
	public void i_close_any_pop_ups_if_present() {
	    // Write code here that turns the phrase above into concrete actions
		// Close the pop-up (if any)
        try {
        	System.out.println("before popup");
            WebElement popupClose = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='commonModal__close']")));
            popupClose.click();
        } catch (Exception ignored) {
        	System.out.println("no pop found");
        }
	}

	@And("I select {string} from the {string} dropdown")
	public void i_select_from_the_dropdown(String string, String string2) {
	    // Write code here that turns the phrase above into concrete actions
		// Click on the "From" dropdown
        WebElement fromCity = driver.findElement(By.id("fromCity"));
        fromCity.click();

        // Enter "Delhi" and select from the dropdown
        WebElement fromInput = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[placeholder='From']")));
        fromInput.sendKeys("Delhi");
        WebElement fromOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'New Delhi')]")));
        fromOption.click();
       
	}
	
	@And("I select {string} to the {string} dropdown")
	public void i_select_to_the_dropdown(String string, String string2) {
		
		 // Click on the "To" dropdown
		
		//  WebElement placeH = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[contains(@placeholder,'To')]")));
		   
        WebElement toCity = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='toCity']")));
        toCity.click();
        
        // Enter "Mumbai" and select from the dropdown
        WebElement toInput = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[placeholder='To']")));
    
        toInput.sendKeys("Mumbai");
        WebElement toOption = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//p[text()='Mumbai, India']")));
        toOption.click();
      
        // Validate that the "To" city is correctly selected
       
	}

	@Then("I should see the {string} city is correctly selected as {string}")
	public void i_should_see_the_city_is_correctly_selected_as(String string, String expectedCity) {
	    // Write code here that turns the phrase above into concrete actions
		 WebElement toSelected = driver.findElement(By.id("toCity"));
        
		
		String selectedCity = toSelected.getAttribute("value");
        if (selectedCity.contains("Mumbai")) {
            System.out.println("Cascading Dropdown Test Passed: 'To' city is correctly selected as Mumbai.");
        } else {
            System.out.println("Cascading Dropdown Test Failed: 'To' city is not correctly selected.");
        }
        Assert.assertEquals(expectedCity, selectedCity);
 
        driver.quit();
    }
	}

