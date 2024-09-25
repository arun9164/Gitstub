package TestnG_17;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Frame_1 {
	static WebDriver driver;
	@Test
	void  hi() throws InterruptedException {
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://rahulshettyacademy.com/client/");
		driver.manage().window().maximize();
		

		driver.findElement(By.cssSelector("#userEmail")).sendKeys("arunnatikar@gmail.com");
		driver.findElement(By.cssSelector("#userPassword")).sendKeys("Arun@1234");
		driver.findElement(By.cssSelector("#login")).click();
		Thread.sleep(3000);
		List<WebElement> cards = driver.findElements(By.cssSelector(".card"));
//		Thread.sleep(3000);
		WebElement pro = cards.stream().
		filter(product->product.findElement(By.tagName("b")).getText().equalsIgnoreCase("ZARA COAT 3")).findFirst().orElse(null);
			pro.findElement(By.cssSelector(".card  button:last-of-type")).click();
		
	}
}