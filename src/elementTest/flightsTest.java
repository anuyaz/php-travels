package elementTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class flightsTest {

	public String baseUrl = "https://www.phptravels.net/login";

	WebElement wEmail, wPassword, wlogin, wFlight, wFlyFrom, wDubai, wToDestination, wSingapore, wDepartureDate,
			wMonthandYear, wDay, wPassengers, wAddAdults, wSearch;

	String email = "user@phptravels.com";
	String pswd = "demouser";

	@Test(priority = 1)
		public void loginPage() throws InterruptedException {

			System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get(baseUrl);
			wEmail = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/form/div[1]/div/input"));
			wPassword = driver
					.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/form/div[2]/div[1]/input"));
			wlogin = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/form/div[3]/button"));
			Thread.sleep(3000);
			wEmail.sendKeys(email);
			wPassword.sendKeys(pswd);
			wlogin.click();
			
			// Flight page
			
			wFlight = driver.findElement(By.xpath("/html/body/header/div[2]/div/div/div/div/div[2]/nav/ul/li[3]/a"));
			wFlight.click();
			Thread.sleep(3000);
			wFlyFrom = driver.findElement(By.id("autocomplete"));
			wFlyFrom.click();
			wFlyFrom.sendKeys("dxb");
			Thread.sleep(2000);
			wDubai = driver.findElement(By.xpath("/html/body/section[1]/section/div/div/form/div[2]/div[1]/div/div[1]/div/div/div/div/div[1]"));
			wDubai.click();

			wToDestination = driver.findElement(By.id("autocomplete2"));
			wToDestination.click();
			wToDestination.sendKeys("sin");
			Thread.sleep(2000);
			wSingapore = driver.findElement(By.xpath("/html/body/section[1]/section/div/div/form/div[2]/div[1]/div/div[2]/div/div/div/div/div[1]"));
			wSingapore.click();
			
			wDepartureDate = driver.findElement(By.id("departure"));
			wDepartureDate.click();
			Thread.sleep(3000);
			wMonthandYear = driver.findElement(By.className("next"));
			wMonthandYear.click();
			Thread.sleep(2000);
//			wDay = driver.findElement(By.xpath("/html/body/div[2]/div[1]/table/tbody/tr[3]/td[3]"));
//			wDay.click();
//		
			wPassengers = driver.findElement(By.xpath("//*[@id=\"onereturn\"]/div[3]/div/div/div/a/span/span"));
			wPassengers.click();
			Thread.sleep(3000);
			wAddAdults = driver.findElement(By.xpath("//*[@id=\"onereturn\"]/div[3]/div/div/div/div/div[1]/div/div/div[2]"));
			wAddAdults.click();
			wPassengers.click();
			
			wSearch = driver.findElement(By.id("flights-search"));
			wSearch.click();
			
  }
}
