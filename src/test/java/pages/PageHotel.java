package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PageHotel {
	
	 @FindBy (id = "Tujuan")
	 WebElement frm_Location;
	 
	 @FindBy (xpath = "//label[text()=\"Tanggal Menginap\"]")
	 WebElement frm_date;
	 
	 @FindBy (id = "Kamar & Tamu")
	 WebElement frm_guest;
	 
	 @FindBy (xpath = "//div[text()=\"Cari Hotel\"]")
	 WebElement btn_cari;
	 
	 @FindBy (css = "button.formButton.lastSearch")
	 WebElement btn_PencarianTerakhir;
	 

	 WebDriver driver;
	    
    public PageHotel(WebDriver driver) {
    	this.driver = driver;
    	PageFactory.initElements(driver, this);
    }
    
    public void formGuest(String guest) {
    	frm_guest.sendKeys(guest);
    }
    
    public void formDate () {
    	frm_date.click();
    	
    }
    
    public void formLocation(String location) throws InterruptedException{
    	frm_Location.sendKeys(location);
    	Thread.sleep(2000);
    	frm_Location.sendKeys(Keys.ENTER);
    }
    
    public void buttonCari() {
    	btn_cari.click();
    }
    
    public void buttonPencarianTerakhir() {
    	btn_PencarianTerakhir.click();
    }
     
}
