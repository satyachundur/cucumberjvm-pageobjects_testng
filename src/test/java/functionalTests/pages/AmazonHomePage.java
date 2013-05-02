package functionalTests.pages;

import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.WebElement;

import functionalTests.testsite.Amazonsite;


public class AmazonHomePage extends Amazonsite {
	
public static String path = "/";
    
    @FindBy(id = "twotabsearchtextbox")
    private WebElement amazonsearch;
    @FindBy(css = ".nav-submit-input")
    private WebElement Searchbutton;
    
    public AmazonResultsPage searchFor(String text) {
    	amazonsearch.sendKeys(text);
    	Searchbutton.submit();
        return PageFactory.initElements(driver, AmazonResultsPage.class);
    }
}
