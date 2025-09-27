package demobasic;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Set;

public class DemoAlert {
    public static void main(String[] args) {
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        options.setExperimentalOption("useAutomationExtension", false);

        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/alerts");

        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(30));

        By byBtnInfoAlert = By.id("alertButton");
        WebElement btnInfoAlert = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(byBtnInfoAlert));
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
//        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", btnInfoAlert); //auto scroll toi btnNewTab

        //click
        jsExecutor.executeScript("arguments[0].click();", btnInfoAlert); // handle case bi che, ko click binh thuong dc, buoc phai click bang javascript

        //alert xuat hien
        Alert infoAlert = webDriverWait.until(ExpectedConditions.alertIsPresent()); // handle đợi alert xuat hien

        //get alert text info
        System.out.println(infoAlert.getText());

        driver.quit();
    }
}
