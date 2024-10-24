
package org.step;

import java.io.IOException;
import java.util.List;

import org.baseclass.BaseClass;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.pageclass.FilterOption;
import org.pageclass.LoginPage;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CucumberStepDefinition extends BaseClass {
	public static BaseClass base = new BaseClass();
	public static LoginPage loginPage = new LoginPage();
	public static FilterOption option = new FilterOption();

	@Given("I launch the browser")
	public void i_launch_the_browser() {
		try {
			base = new BaseClass();
			base.getDriver(base.readExcell(1, 2));
		} catch (IOException e) {
			e.printStackTrace();
			Assert.fail("Failed to launch the browser: " + e.getMessage());
		}
	}

	@When("I navigate to the URL")
	public void i_navigate_to_the_URL() {
		try {
			base.getUrl(base.readExcell(1, 3));
		} catch (IOException e) {
			e.printStackTrace();
			Assert.fail("Failed to navigate to the URL: " + e.getMessage());
		}
	}

	@Then("the browser should be open and URL should be loaded")
	public void the_browser_should_be_open_and_URL_should_be_loaded() {
		try {
			Assert.assertNotNull("Driver should be initialized.", driver);
			
		} catch (AssertionError e) {
			e.printStackTrace();
			Assert.fail("Assertion failed: " + e.getMessage());
		}
	}

	@Given("I am on the login page")
	public void i_am_on_the_login_page() {
		loginPage = new LoginPage();
	}

	@When("I search for a user")
	public void i_search_for_a_user() {
		try {
			WebElement search = loginPage.getSearch();
			base.textSend(search, base.readExcell(1, 4));
			Thread.sleep(3000); 
		} catch (InterruptedException e) {
			e.printStackTrace();
			Assert.fail("Interrupted exception occurred while searching for a user: " + e.getMessage());
		} catch (IOException e) {
			e.printStackTrace();
			Assert.fail("IOException occurred while reading data: " + e.getMessage());
		}
	}

	@And("I select the first result")
	public void i_select_the_first_result() {
		loginPage = new LoginPage();
		try {
			WebElement select = loginPage.getSelect();
			base.pressClick(select);
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
			Assert.fail("Interrupted exception occurred while selecting the first result: " + e.getMessage());
		}
	}

	@And("I go to the next page")
	public void i_go_to_the_next_page() {
		loginPage = new LoginPage();
		try {
			WebElement nextpage = loginPage.getNextpage();
			base.pressClick(nextpage);
			Thread.sleep(3000); 
		} catch (InterruptedException e) {
			e.printStackTrace();
			Assert.fail("Interrupted exception occurred while navigating to the next page: " + e.getMessage());
		}
	}

	@Then("I should see the search results")
	public void i_should_see_the_search_results() {
		loginPage = new LoginPage();
	}

	@Given("I am on the product filter page")
	public void i_am_on_the_product_filter_page() {
		option = new FilterOption();
	}

	@When("I filter for Apple Watches")
	public void i_filter_for_Apple_Watches() {
		option = new FilterOption();
		try {
			List<WebElement> appleWatchElements = option.getBrand();
			for (WebElement element : appleWatchElements) {
	            System.out.println(element.getText());
	        }

		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Exception occurred while filtering for Apple Watches: " + e.getMessage());
		}
	}

	@Then("I should see at least 10 Apple Watches")
	public void i_should_see_at_least_10_Apple_Watches() {
		FilterOption option = new FilterOption();
		try {
			List<WebElement> appleWatchElements = option.getBrand();
			Assert.assertTrue("Less than 10 Apple Watches found.", appleWatchElements.size() >= 10);
		} catch (AssertionError e) {
			e.printStackTrace();
			Assert.fail("Assertion failed: " + e.getMessage());
		}
	}

	@And("print the 10th Apple Watch")
	public void print_the_10th_Apple_Watch() {
		FilterOption option = new FilterOption();
		try {
			List<WebElement> appleWatchElements = option.getBrand();
			WebElement tenthWatch = appleWatchElements.get(9);
			System.out.println("10th Apple Watch: " + tenthWatch.getText());
		} catch (IndexOutOfBoundsException e) {
			e.printStackTrace();
			Assert.fail("Less than 10 Apple Watches available: " + e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail("Exception occurred while printing the 10th Apple Watch: " + e.getMessage());
		}
	}
}