package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PoliticalPage {

    WebDriver driver;
    By politicalTitle = By.xpath("/html/body/div[6]/main/header/h1");
    By menuToolBar = By.xpath("/html/body/nav");


    public PoliticalPage(WebDriver driver){
        this.driver = driver;
    }

    public boolean politicalTitleIsDisplay(){
        WebElement element = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(politicalTitle));
        if (driver.findElement(politicalTitle).isDisplayed()){
            return true;
        }
        return false;
    }

    public void scrollDown(){
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0,500)");
    }

    public boolean menuToolBarIsDisplay(){
        return driver.findElement(menuToolBar).isDisplayed();
    }
}
