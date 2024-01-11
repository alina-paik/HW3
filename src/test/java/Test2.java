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

public class Test2 {
    @Test
    public void checkPlaceholder() {
        WebDriver webDriver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
        try {
            webDriver.manage().window().maximize();
            webDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
            webDriver.get("https://mail.google.com");

            By placeholderLocator = By.xpath("//input[@aria-label='Електронна адреса або номер телефону']");

            WebElement placeholderElement = wait.until(ExpectedConditions.elementToBeClickable(placeholderLocator));
            boolean isPlaceholderPresent = placeholderElement.isDisplayed();
            Assert.assertTrue(isPlaceholderPresent, "Placeholder element is not displayed on the page.");


        }finally {
            webDriver.quit();
        }
    }
}
