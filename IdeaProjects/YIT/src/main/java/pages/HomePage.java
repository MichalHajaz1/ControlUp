package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.text.DateFormat;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Date;

public class HomePage {

    WebDriver driver;


    By politicalButton = By.xpath("/html/body/nav/ul/li[1]/ul/li[3]/a");
    By pageDate = By.xpath("/html/body/header/div/span");
    By weatherButton = By.id("tns1");

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }


    public void clickPoliticalButton(){
        driver.findElement(politicalButton).click();
    }

    public String currentDateFormat(){
        SimpleDateFormat fmt = new SimpleDateFormat("dd.MM.yy");
         Date date = new Date();
          String currentDate = fmt.format(date);
          return currentDate;
    }

    public String getPageDate(){
       return driver.findElement(pageDate).getText();
    }

    public boolean dateValidation(String pageDate, String currentDate){
        if(pageDate.contains(currentDate)){
            return true;
        }
        else return false;
    }

    public void clickOnWeatherButton(){
        driver.findElement(weatherButton).click();
    }




}
