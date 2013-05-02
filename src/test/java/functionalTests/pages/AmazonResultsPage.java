package functionalTests.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import functionalTests.testsite.Amazonsite;

public class AmazonResultsPage extends Amazonsite{
	
	@FindBy(xpath = "//*[@id='result_0']/ul[1]/li[1]/a/span")
    private WebElement searchresults;
    
    public void checkpriceonpage(String expected) {
        assertEquals(searchresults.getText(), expected);
    }

}
