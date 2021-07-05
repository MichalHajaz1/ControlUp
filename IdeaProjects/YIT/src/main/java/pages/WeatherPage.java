package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class WeatherPage {

    WebDriver driver;

    By cities = By.xpath("/html/body/main/div[2]/ul");

    public WeatherPage(WebDriver driver){
       this.driver = driver;
    }

    public List<WebElement> pageCitiesList(){
        WebElement cityUL = driver.findElement(cities);
        List<WebElement> weatherCityList = cityUL.findElements(By.tagName("a"));
        return weatherCityList;
    }

    public void clickOnCity(){
        WebElement parent = driver.findElement(By.xpath("/html/body/main/div[2]/ul"));
        parent.findElement(By.tagName("a")).click();
    }

    public boolean verifiedCityPage(){
        //get the text from the title
        return true;
    }










}
