package webtest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ContinueCase {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new MyChromeDriver("479d598f3a15c5ef6bc65e5b6a61573e", "http://localhost:48550");
		WebElement e1 =	driver.findElement(By.id("kw"));
		e1.clear();
		e1.sendKeys("调试222");

		driver.findElement(By.className("soutu-btn")).click();
		//upload-pic
//		WebDriverWait wait = new WebDriverWait(driver, 10);
//		wait.until(ExpectedConditions.elementToBeClickable(By.tagName("upload-pic")));
//		driver.findElement(By.className("upload-pic")).click();
		
//		new WebDriverWait(driver, 15).
//		until( ExpectedConditions.presenceOfElementLocated(By.cssSelector("css locator")));

		WebElement ele = (new WebDriverWait( driver, 10)) .until(
				new ExpectedCondition< WebElement>(){
					@Override
					public WebElement apply( WebDriver d) {
						return d.findElement( By.className("upload-pic"));
					}
				}
				);
		System.out.println("______:"+ele.getAttribute("value"));
		Thread.sleep(1000);
		ele.click();
				
				
				
		
		
	}

}
