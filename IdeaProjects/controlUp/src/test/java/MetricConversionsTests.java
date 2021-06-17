import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class MetricConversionsTests {

    private WebDriver driver;


    @BeforeTest
    public void setupTest() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @AfterTest
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

    @Test
    public void convertingCelsiusToFahrenheitTest() {
        driver.get("https://www.metric-conversions.org/");
        driver.findElement(By.xpath("//*[@id=\"typeMenu\"]/a[1]")).click();
        driver.findElement(By.id("queryFrom")).sendKeys("23 Celsius");
        WebElement element = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"results\"]/ol/li[1]/div/a[2]")));
        element.click();
        String res = driver.findElement(By.id("answer")).getText();

        Assert.assertEquals(res, "23°C= 73.40000°F");
    }

    @Test
    public void convertingMetersToFeet() {
        driver.get("https://www.metric-conversions.org/");
        driver.findElement(By.xpath("//*[@id=\"typeMenu\"]/a[3]")).click();
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/nav/a[5]")).click();
        driver.findElement(By.xpath("/html/body/div[1]/div[3]/nav/a[8]")).click();
        driver.findElement(By.id("argumentConv")).sendKeys("1.60");
        String res = driver.findElement(By.id("answer")).getText();

        Assert.assertEquals(res, "1.60m= 5ft 2.992126in");
    }

    @Test
    public void convertingOuncesToGrams() {
        driver.get("https://www.metric-conversions.org/");
        driver.findElement(By.xpath("//*[@id=\"typeMenu\"]/a[2]")).click();
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/nav/a[5]")).click();
        driver.findElement(By.xpath("/html/body/div[1]/div[3]/nav/a[6]")).click();
        driver.findElement(By.id("argumentConv")).sendKeys("10");
        String res = driver.findElement(By.id("answer")).getText();

        Assert.assertEquals(res, "10oz= 283.4952g");

    }
}
