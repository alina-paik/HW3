import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Test3 {
    @Test
    public void invalidLogIn () {
        final String inputQuery = "00000";
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        WebDriver webDriver = new ChromeDriver(options);

        try {
            webDriver.manage().window().maximize();
            webDriver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
            webDriver.get("https://mail.google.com");

            WebElement inputElement = webDriver.findElement(By.xpath("//input[@id='identifierId']"));
            inputElement.clear();
            inputElement.sendKeys(inputQuery);
            inputElement.sendKeys(Keys.ENTER);

            WebElement validationMessage = new WebDriverWait(webDriver, Duration.ofSeconds(5))
                    .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='o6cuMc Jj6Lae']")));

            boolean isValidationMessageDisplayed = validationMessage.isDisplayed();
            String expectedMessage = "Введіть дійсні електронну адресу або номер телефону";
            Assert.assertTrue(isValidationMessageDisplayed, "Validation message is not displayed");
            Assert.assertEquals(validationMessage.getText(), expectedMessage, "Validation message text is incorrect");
        }finally {
            webDriver.quit();
        }
    }
}
