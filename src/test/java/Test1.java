import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Test1 {
    @Test
    public void checkInput() {
        WebDriver webDriver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        try {
            webDriver.manage().window().maximize();
            webDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
            webDriver.get("https://mail.google.com");

            WebElement inputElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='identifierId']")));
            boolean isInputDisplayed = inputElement.isDisplayed();
            Assert.assertTrue(isInputDisplayed, "Input element is not displayed on the page.");

        } finally {
            webDriver.quit();
        }
    }
}