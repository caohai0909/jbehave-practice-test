package core;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Page {
	
	public Page() {
		PageFactory.initElements(Driver.driver, this);
	}

	protected void navigateTo(String url){
		try {
			Driver.driver.get(url);
		}catch (Exception e){
			System.out.println("Failed to Navigate to: " + url);
			throw e;
		}
	}
	protected void javaScriptClick(String locator){
		JavascriptExecutor executor = (JavascriptExecutor)Driver.driver;
		executor.executeScript("arguments[0].click();", locator);
	}

	protected void waitExplicitlyWebElement(WebElement locator, int seconds) {
		try {
			WebDriverWait waiter = new WebDriverWait(Driver.driver, seconds);
			waiter.until(ExpectedConditions.visibilityOf(locator));
		}catch (Exception e){
			System.out.println("Failed to waitExplicitlyWebElement: " + locator);
			throw e;
		}
	}
	protected void enter(WebElement webElement, String text){
		waitExplicitlyWebElement(webElement, 30);
		try {
			webElement.clear();
			webElement.sendKeys(text);
		}catch (Exception e){
			System.out.println("Failed to enter: " + webElement);
			throw e;
		}
	}
	protected void click(WebElement webElement){
		waitExplicitlyWebElement(webElement, 30);
		try {
			webElement.click();
		}catch (Exception e){
			System.out.println("Failed to click: " + webElement);
			throw e;
		}
	}
	protected static String getProjectPath() {
		String projectPath = System.getProperty("user.dir");
		return projectPath;
	}
	protected void maximizeWindow() {
		try {
			Driver.driver.manage().window().maximize();
		} catch (Exception err) {
			System.out.println("Error maximizeWindow: \n" + err);
			close();
		}
	}
	public void close() {

		if (Driver.driver != null) {
			Driver.driver.close();
		}
	}
}
