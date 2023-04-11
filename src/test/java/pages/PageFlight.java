package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class PageFlight {

	@FindBy (id = "cari_tiket")
	WebElement btn_cariTiket;
	
	 @FindBy (id = "dewasa")
	 WebElement frm_Dewasa;
	  	 
	 WebDriver driver;
	    
    public PageFlight(WebDriver driver) {
    	this.driver = driver;
    	PageFactory.initElements(driver, this);
    }
    
    public void cariTiket() {
    	btn_cariTiket.click();
    }
    
    public void formDewasa(String passenger){
    	frm_Dewasa.click();
    	frm_Dewasa.sendKeys(passenger);
    }
    
	
}
