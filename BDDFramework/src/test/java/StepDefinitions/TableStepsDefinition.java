package StepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.text.DecimalFormat;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import Utilities.ConfigReader;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TableStepsDefinition {
	
	static WebDriver driver;
	int actualCount;

@Given("I open the browser and navigate to the company page")
public void i_open_the_browser_and_navigate_to_the_company_page() {
    // Write code here that turns the phrase above into concrete actions
	driver = new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	driver.get(ConfigReader.getProperty("rediff.url"));
	driver.manage().window().maximize();
}

@When("I locate the list of company names on the webpage")
public void i_locate_the_list_of_company_names_on_the_webpage() {
    // Write code here that turns the phrase above into concrete actions
	//create list of all companies.
			List<WebElement>allCompanies = driver.findElements(By.xpath("//table[@class=\"dataTable\"]/tbody/tr/td[1]/a"));
			System.out.println("companies list count "+ allCompanies.size());
			 actualCount = allCompanies.size();
}

@Then("I should count the total number of company names and total value of pricelist displayed")
public void i_should_count_the_total_number_of_company_names_and_total_value_of_pricelist_displayed()  {
    // Write code here that turns the phrase above into concrete actions
	List<WebElement>priceList = driver.findElements(By.xpath("//table[@class=\"dataTable\"]/tbody/tr/td[4]"));
	
    System.out.println("Total number of company names: " + actualCount);
    System.out.println("price list count "+ priceList.size());
		// Calculate the total value of the column
    double total = 0.0;
    for (WebElement cell : priceList) {
        String cellText = cell.getText();
        try {
           // Remove the comma (thousands separator)
                   
            total += Double.parseDouble(cellText);
         
        } catch (NumberFormatException e) {
           // System.out.println("Skipping non-numeric value: " + cellText);
        }
    }
 // Round to 2 decimal places using DecimalFormat
    DecimalFormat df = new DecimalFormat("#.##");
    String roundedValue = df.format(total);
    System.out.println("Total price value is :"+roundedValue);
}

@And("close the website")
public void close_the_website() {
    // Write code here that turns the phrase above into concrete actions
    driver.close();
}

}
