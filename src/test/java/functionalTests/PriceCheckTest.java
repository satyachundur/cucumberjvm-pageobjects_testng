package functionalTests;

import java.io.File;

import org.testng.annotations.Factory;

import com.talios.cucumberng.CucumberFactoryBuilder;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import functionalTests.helper.WebdriverBase;
import functionalTests.pages.AmazonHomePage;
import functionalTests.pages.AmazonResultsPage;
import functionalTests.testsite.Amazonsite;

public class PriceCheckTest extends WebdriverBase {
	
	AmazonHomePage amazon_homepage = Amazonsite.AmazonHome();
	AmazonResultsPage amazonresultspage;
	public static String browser = "firefox";
	
	@Factory
	public Object[] create() {
	    return new CucumberFactoryBuilder()
	            .addOption("--format", "html:target/cucumber")
	            .create(new File("src"));
	}

	@Given("^I am on Amazon Homepage$")
	 public void I_am_on_Amazon_Homepage() throws Throwable {
	    //Navigate to Amazon home page
		amazon_homepage.load(AmazonHomePage.path);
	 }
	 @When("^I search for \"([^\"]*)\"$")
	 public void I_search_for(String searchelement) throws Throwable {
	   this.amazonresultspage = this.amazon_homepage.searchFor(searchelement);
	 }

	 @Then("^the search results should display first price as \"([^\"]*)\"$")
	 public void the_search_results_should_display_first_price_as(String expected) throws Throwable {
	     this.amazonresultspage.checkpriceonpage(expected);
	 }
	 

}
