package functionalTests.helper;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class WebdriverBase {
	public static WebDriver driver;
	@Parameters({"browser"})
	@BeforeSuite(alwaysRun = true)
	
	public void startDriver(@Optional("firefox") String browser) {	
		if (browser.equals("firefox")) {
			driver = new FirefoxDriver();
		}
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    }

	@AfterSuite(alwaysRun = true)
	public void stopDriver() {
		driver.close();
	}

	public static void assertEquals(Object actual, Object expected) {
		Assert.assertEquals(actual, expected);
	}

	public static void assertTrue(Boolean condition) {
		Assert.assertTrue(condition);
	}

	public static void assertFalse(Boolean condition) {
		Assert.assertFalse(condition);
	}

	public static void sleep(int d) {
		try {
			Thread.currentThread();
			Thread.sleep(d*1000);
		} catch(InterruptedException ie) {
		}
	}

	public static boolean checkRegexp(String regexp, String text) {
		Pattern p = Pattern.compile(regexp);
		Matcher m = p.matcher(text);
		return m.find();
	}

	public static void isTextPresent(String text) {
		driver.findElement(By.xpath("//*[contains(.,'"+text+"')]"));
	}

	public static void isTextNotPresent(String text) {
		boolean found = true;
		try {
			driver.findElement(By.xpath("//*[contains(.,'"+text+"')]"));
		} catch(Exception e) {
			found = false;
		} finally {
			assertFalse(found);
		}
	}

	public static String[][] tableData(List<WebElement> rows) {
		String[][] tablearr = new String[rows.size()][];
		int rown;		
		int celln;
		rown = 0;
		for(WebElement row: rows) {
			rown ++;
			List<WebElement> cells = row.findElements(By.tagName("td"));
			tablearr[rown-1] = new String[cells.size()];
			celln = 0;
			for(WebElement cell: cells) {
				celln ++;				
				tablearr[rown-1][celln-1] = cell.getText();
			}
		}
		return tablearr;
	}

	public static String executeJS(String code) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		return (String)js.executeScript(code);
	}

	public static void executeJS_no_return(String code) {
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript(code);
	}

	public String getAlertText() {
		Alert alert = driver.switchTo().alert();
		return alert.getText();
	}

	public void acceptAlert() {
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}

	public void dismissAlert() {
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
	}

	public void sendKeysAlert(String str) {
		Alert alert = driver.switchTo().alert();
		alert.sendKeys(str);
	}

	public void switchToFrame(String name) {
		driver.switchTo().frame(name);
	}

	public void switchToRoot() {
		driver.switchTo().defaultContent();
	}
}
