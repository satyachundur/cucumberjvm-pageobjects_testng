package functionalTests.testsite;


import org.openqa.selenium.support.PageFactory;

import functionalTests.helper.WebdriverBase;
import functionalTests.pages.AmazonHomePage;
import functionalTests.pages.AmazonResultsPage;
public class Amazonsite extends WebdriverBase {
		
		public static String url = "http://www.amazon.co.uk";

		public void load(String path) {
			driver.get(url+path);
		}

	    public static AmazonHomePage AmazonHome() {
			return PageFactory.initElements(driver, AmazonHomePage.class);
	    }

	    public static AmazonResultsPage results_page() {
			return PageFactory.initElements(driver, AmazonResultsPage.class);
	    }
	}


