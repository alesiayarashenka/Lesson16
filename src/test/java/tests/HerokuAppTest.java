package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class HerokuAppTest {
    @Test
    public void herokuLoginPageTest(){

        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        WebDriver driver= new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/login");
        driver.findElement(By.id("username")).sendKeys("tomsmith");
        driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
        driver.findElement(By.xpath("//*[@type = \"submit\"]")).click();
        String expectedResult = "Welcome to the Secure Area. When you are done click logout below.";
        String actualResult =  driver.findElement(By.xpath("//*[@class = \"subheader\"]")).getText();
        Assert.assertEquals(expectedResult,actualResult);
        driver.quit();
    }
}
