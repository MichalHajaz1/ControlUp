import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.PoliticalPage;
import pages.WeatherPage;

import java.util.List;

public class n12Tests {

    WebDriver driver;
    HomePage homePage;
    PoliticalPage politicalPage;
    WeatherPage weatherPage;


    @BeforeTest
    public void setupTest() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        homePage = new HomePage(driver);
        politicalPage = new PoliticalPage(driver);
        weatherPage = new WeatherPage(driver);

    }

    @AfterTest
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void politicalTest(){
        driver.get("https://www.n12.co.il/");
        homePage.clickPoliticalButton();
        politicalPage.politicalTitleIsDisplay();
        politicalPage.scrollDown();

        Assert.assertTrue(politicalPage.menuToolBarIsDisplay());

    }

    @Test
    public void dateValidation(){
        driver.get("https://www.n12.co.il/");
        String date = homePage.currentDateFormat();
        String pageDate = homePage.getPageDate();
        Assert.assertTrue(homePage.dateValidation(pageDate, date));

    }

    @Test
    public void validationWeatherList(){
        driver.get("https://www.n12.co.il/");
        homePage.clickOnWeatherButton();
        weatherPage.pageCitiesList();
        weatherPage.clickOnCity();
        Assert.assertTrue(weatherPage.verifiedCityPage());



    }





}
