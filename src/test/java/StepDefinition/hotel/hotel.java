package StepDefinition.hotel;

import java.time.Duration;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;
import pages.PageHotel;


public class hotel  {
	
	WebDriver driver = null;
	PageHotel hotel;
	
	
	
	
	@Given("user at hotel section")
	public void user_at_hotel_section() {
		String ProjectPatch = System.getProperty("user.dir");
		System.setProperty("webdriver.chrome.driver", ProjectPatch+"/src/test/resources/driver/chromedriver.exe");
		driver = new ChromeDriver();	
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(30));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(60));

		driver.navigate().to("https://www.pegipegi.com/");
		hotel = new PageHotel(driver);
	}

	@When("^user input location (.*)detail")
	public void user_input_location_jakarta_people_detail(String location) throws InterruptedException {
	  
		hotel.formLocation(location);
		WebElement HotelSelect = driver.findElement(By.xpath("(//strong[text()='"+location+"'])[1]"));
		HotelSelect.click();
		//hotel.formGuest(guest);
	}
	
	@When ("^user input tanggal (.*) and (.*)")
	public void user_input_date(String dateA, String dateB) throws InterruptedException  {
		

//		hotel.formDate();
		driver.findElement(By.xpath("//img[@alt=\"Next Month\"]")).click();
		WebElement tanggal1 = driver.findElement(By.xpath("//button[@aria-label='"+dateA+"']"));
		WebElement tanggal2 = driver.findElement(By.xpath("//button[@aria-label='"+dateB+"']"));

		if (tanggal1.isEnabled()) {
		   tanggal1.click();
		   tanggal2.click();
		} else {
		    // Do something else if the element is not displayed
		    System.out.println("Element is not displayed");
		}
		}

	@And("click cari hotel button")
	public void click_cari_hotel_button() throws InterruptedException {
	
		hotel.buttonCari(); 
		}

	@Then("^user will be directed to hotel list(.*)")
	public void user_will_be_directed_to_hotel_list(String location) {
	  
		String SearchLocation = driver.findElement(By.xpath("//p[@class=\"navbar__title\"]")).getText();
        Assert.assertTrue(SearchLocation, SearchLocation.contains(location));
    	driver.close();
    	driver.quit();
	}

	@When("user click pencarian terakhir")
	public void user_click_pencarian_terakhir() {
	    hotel.buttonPencarianTerakhir();
	}

	@Then("user will see pop up pencarian terakhir")
	public void user_will_see_pop_up_pencarian_terakhir() {
	driver.findElement(By.xpath("//h4[@class=\"modal-title\"]")).isDisplayed();
   
	driver.close();
	driver.quit();	   
	}
}
