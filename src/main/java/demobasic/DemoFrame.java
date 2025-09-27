package demobasic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DemoFrame {
    public static void main(String[] args) {
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        options.setExperimentalOption("useAutomationExtension", false);

        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("http://dummypoint.com/Frame.html");

        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(30));

        //switch to frame nào? id or name or xpath
        driver.switchTo().frame("f1");
        By byLblFrame1 = By.id("framename");
        WebElement lblFrame1 = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(byLblFrame1));
        System.out.println(lblFrame1.getText()); // get text lblFrame1

        driver.quit();
    }
}
