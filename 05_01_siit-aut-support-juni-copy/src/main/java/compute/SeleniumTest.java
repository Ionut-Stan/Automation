package compute;

import java.time.Duration;
import java.util.List;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumTest {

	@Test
	public void myFirstTest() {

		System.setProperty("webdriver.chrome.driver", "./lib/chromedriver.exe");
		System.setProperty("webdriver.gecko.driver", "./lib/geckodriver.exe");

		WebDriver driver = new ChromeDriver();

		// WebDriver driver2 = new FirefoxDriver();

		driver.get("http://www.google.com");
		// driver.quit();

		// driver2.get("http://www.google.com");
		// driver2.quit();

		// ----------------------------------

		WebElement btnAgree = driver.findElement(By.id("L2AGLb"));
		btnAgree.click();

		WebElement searchBox = driver.findElement(By.name("q"));
		// WebElement searchBox = driver.findElement(By.xpath("//input[@name = 'q'"));

		searchBox.sendKeys("koala", Keys.RETURN);

		WebElement myDynamicElement = (new WebDriverWait(driver, Duration.ofSeconds(10)))
				.until(ExpectedConditions.presenceOfElementLocated(By.id("result-stats")));

		System.out.println(myDynamicElement.getText());

		List<WebElement> resultTitleElements = driver.findElements(By.cssSelector("h3"));

		System.out.println(resultTitleElements.size());

		for (WebElement we : resultTitleElements) {
			System.out.println(we.getText());
			WebElement resultTitle = we.findElement(By.xpath(".."));
			String title = resultTitle.getAttribute("href");
			System.out.println(title);
		}
	}

}
