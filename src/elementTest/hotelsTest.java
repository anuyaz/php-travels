package elementTest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import common.TestBase;

public class hotelsTest extends TestBase {

	WebElement wIncorrectEmail, wCorrectPassword, wEmail, wPassword, wlogin, wHotel, wCity, wSing, wText, wCheckIn,
			wDatePick, wDateBody, wCheckOut, wDateNext, wTravelers, wChild, wChildAge, wAge, wNationality, wSriLanka,
			wSearch, wDetails, wBook, wTitle1, wFname1, wLname1, wTitle2, wFname2, wLname2, wFname3, wLname3,
			wPaymentMethod, wAgree, wConfirmBooking, wMr, wMrs, wCookies, wInvoice;

	String incorrectEmail = "user+phptravels.com";
	String incorrectPswd = "123";
	String email = "user@phptravels.com";
	String pswd = "demouser";

	@BeforeTest
	public void beforeTest() throws Exception {
		super.beforeTest();
	}

	@BeforeMethod
	public void beforeMethod() throws InterruptedException {
		driver.navigate().refresh();
		wEmail = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/form/div[1]/div/input"));
		wPassword = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/form/div[2]/div[1]/input"));
		wlogin = driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/div[2]/div/form/div[3]/button"));
	}

	@Test(priority = 1)
	public void incorrectLoginTest1() throws InterruptedException {
		wEmail.sendKeys(incorrectEmail);
		wPassword.sendKeys(pswd);
		Thread.sleep(1000);
		wlogin.click();
	}

	@Test(priority = 2)
	public void incorrectLoginTest2() throws InterruptedException {
		wEmail.sendKeys(email);
		wPassword.sendKeys(incorrectPswd);
		Thread.sleep(1000);
		wlogin.click();
	}

	@Test(priority = 3)
	public void incorrectLoginTest3() throws InterruptedException {
		wEmail.sendKeys(incorrectEmail);
		wPassword.sendKeys(incorrectPswd);
		Thread.sleep(1000);
		wlogin.click();
	}

	@Test(priority = 4)
	public void loginPage() throws InterruptedException {
		wEmail.sendKeys(email);
		wPassword.sendKeys(pswd);
		Thread.sleep(1000);
		wlogin.click();

		wHotel = driver.findElement(By.xpath("/html/body/header/div[2]/div/div/div/div/div[2]/nav/ul/li[2]/a"));
		wHotel.click();

		wCity = driver.findElement(By.id("select2-hotels_city-container"));
		wCity.click();
		wText = driver.findElement(By.xpath("/html/body/span/span/span[1]/input"));
		wText.sendKeys("sin");

		Thread.sleep(3000);
		wSing = driver.findElement(By.xpath("//*[@id=\"select2-hotels_city-results\"]/li[1]"));
		wSing.click();

		// Open checkin datepicker
		wCheckIn = driver.findElement(By.id("checkin"));
		wCheckIn.click();
		Thread.sleep(500);

		// Find all date pickers in the page
		List<WebElement> datePickerElements = driver.findElements(By.cssSelector(".datepicker-days"));
		WebElement checkinDatePicker = datePickerElements.get(0);
		WebElement checkoutDatePicker = datePickerElements.get(1);

		// Select checkin date
		wDatePick = driver.findElements(By.cssSelector(".datepicker-days .next")).get(0);
		wDatePick.click();
		Thread.sleep(500);
		checkinDatePicker.findElement(By.cssSelector("tr:nth-child(2) td:nth-child(6)")).click();

		// Focus body
		wDateBody = driver.findElement(By.cssSelector("body"));
		wDateBody.click();

		// Open checkout datepicker
		wCheckOut = driver.findElement(By.id("checkout"));
		wCheckOut.click();
		Thread.sleep(500);

		// Select checkout date
		wDateNext = driver.findElements(By.cssSelector(".datepicker-days .next")).get(1);
		wDateNext.click();
		Thread.sleep(500);
		checkoutDatePicker.findElement(By.cssSelector("tr:nth-child(3) td:nth-child(6)")).click();

		// Search
		wSearch = driver.findElement(By.id("submit"));
		wSearch.click();
		// Select Travelers
		wTravelers = driver.findElement(By.xpath("//*[@id=\"hotels-search\"]/div/div/div[3]/div/div/div/a/p"));
		wTravelers.click();
		Thread.sleep(2000);

		// Select children
		wChild = driver.findElement(
				By.xpath("//*[@id=\"hotels-search\"]/div/div/div[3]/div/div/div/div/div[3]/div/div/div[2]/i"));
		wChild.click();
		Thread.sleep(3000);

		wChildAge = driver.findElement(By.name("ages[1]"));
		wChildAge.click();
		Thread.sleep(2000);
		wAge = driver.findElement(By.xpath("//*[@id=\"ages1\"]/option[8]"));
		wAge.click();

		// Select Nationality
		wNationality = driver.findElement(By.xpath("//*[@id=\"nationality\"]"));
		wNationality.click();
		Thread.sleep(2000);
		wNationality.sendKeys("sr");
		Thread.sleep(3000);
		wSriLanka = driver.findElement(By.cssSelector("#nationality > option:nth-child(211)"));
		wSriLanka.click();

		// Search
		wSearch = driver.findElement(By.id("submit"));
		wSearch.click();
		Thread.sleep(3000);

		// Get details
		wDetails = driver.findElement(By.xpath("//*[@id=\"rendezvous hotels\"]/div/div[2]/div/div[2]/div/a"));
		wDetails.click();
		
		JavascriptExecutor scroll = (JavascriptExecutor) driver;
		scroll.executeScript("window.scrollBy(0,1000)", "");
		Thread.sleep(10000);
		// Book the room
		wBook = driver.findElement(By.cssSelector(
				"#availability > div.single-content-item.padding-top-40px.padding-bottom-30px.rooms > div:nth-child(1) > div.card-body > div > div.col-md-9 > form > div > div.col-md-3.booked_53 > div > div > button > span.ladda-label"));
		wBook.click();
		
		// Fill the application 
		JavascriptExecutor scroll2 = (JavascriptExecutor) driver;
		scroll2.executeScript("window.scrollBy(0,450)", "");
		wTitle1 = driver.findElement(By.name("title_1"));
		wTitle1.click();
		wMr = driver.findElement(By.xpath("/html/body/div[2]/form/section/div/div/div[1]/div[2]/div[2]/div[1]/div[2]/div/div[1]/select/option[1]"));
		wMr.click();
		wFname1 = driver.findElement(By.name("firstname_1"));
		wFname1.sendKeys("Jhon");
		wLname1 = driver.findElement(By.name("lastname_1"));
		wLname1.sendKeys("Smith");
		Thread.sleep(2000);
		JavascriptExecutor scroll3 = (JavascriptExecutor) driver;
		scroll3.executeScript("window.scrollBy(0,100)", "");
		wTitle2 = driver.findElement(By.name("title_2"));
		wTitle2.click();
		wMrs = driver.findElement(By.xpath("/html/body/div[2]/form/section/div/div/div[1]/div[2]/div[2]/div[2]/div[2]/div/div[1]/select/option[3]"));
		wFname2 = driver.findElement(By.name("firstname_2"));
		wFname2.sendKeys("Andria");
		wLname2 = driver.findElement(By.name("lastname_2"));
		wLname2.sendKeys("Gomas");
		Thread.sleep(2000);
		JavascriptExecutor scroll4 = (JavascriptExecutor) driver;
		scroll4.executeScript("window.scrollBy(0,100)", "");
		wFname3 = driver.findElement(By.name("child_firstname_1"));
		wFname3.sendKeys("Jonny");
		wLname3 = driver.findElement(By.name("child_lastname_1"));
		wLname3.sendKeys("Smith");
		Thread.sleep(2000);
		wPaymentMethod = driver.findElement(By.xpath("//*[@id=\"gateway_pay-later\"]"));
		wPaymentMethod.click();
		
		JavascriptExecutor scroll5 = (JavascriptExecutor) driver;
		scroll5.executeScript("window.scrollBy(0,1000)", "");
		
		wCookies = driver.findElement(By.id("cookie_stop"));
		wCookies.click();
		Thread.sleep(2000);
		wAgree = driver.findElement(By.cssSelector("body > div.booking_data > form > section > div > div > div.col-lg-8 > div:nth-child(4) > div > div > div > label"));
		wAgree.click();
		Thread.sleep(2000);
		wConfirmBooking = driver.findElement(By.id("booking"));
		wConfirmBooking.click();
		
		// Invoice download
		JavascriptExecutor scroll6 = (JavascriptExecutor) driver;
		scroll6.executeScript("window.scrollBy(0,1500)", "");
		wInvoice = driver.findElement(By.cssSelector("#download"));
		wInvoice.click();
		
	}
}
