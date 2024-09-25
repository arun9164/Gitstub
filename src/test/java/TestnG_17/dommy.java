package TestnG_17;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class dommy {
	static WebDriver driver;

	@Test
	void hi() throws InterruptedException {
		driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/client/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		driver.findElement(By.cssSelector("#userEmail")).sendKeys("arunnatikar@gmail.com");
		driver.findElement(By.cssSelector("#userPassword")).sendKeys("Arun@1234");
		driver.findElement(By.cssSelector("#login")).click();

		// Adding explicit wait to wait for all cards to be present
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		Thread.sleep(3000);
		List<WebElement> cards = wait
				.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".card")));
		WebElement pro = cards.stream().filter(product -> {
			String jio = product.findElement(By.tagName("b")).getText();
			return jio.equalsIgnoreCase("ADIDAS ORIGINAL") || jio.equalsIgnoreCase("ZARA COAT 3");
		}).findFirst().orElse(null);

		if (pro != null) {
		    pro.findElement(By.cssSelector(".card button:last-of-type")).click();
		}

	}
}
