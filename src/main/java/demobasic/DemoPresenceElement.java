package demobasic;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DemoPresenceElement {
    public static void main(String[] args) throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
//        options.setBrowserVersion("137");
        //disable automation bar
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        options.setExperimentalOption("useAutomationExtension", false);
        options.setAcceptInsecureCerts(true); // accept insecure certificate (https)

        WebDriver driver = new ChromeDriver(options); // khoi tao 1 driver object co kieu ChromeDriver (process chromedriver.exe)
        driver.get("C:\\Data\\Training\\Automation_Testing\\class08\\class08-selenium-java-gradle\\src\\main\\java\\webbasic\\PresenceOfElementLocated\\PresenceOfElementLocatedDemo.html"); // navigate (mở) 1 site
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        By byLblDisplayText = By.xpath("//div[@id='delayed-element']");
        WebElement lblDisplayText = driver.findElement(byLblDisplayText); // ko care visible or invisible (miễn là trong DOM)
        System.out.println(lblDisplayText.isDisplayed()); // false

        By byBtnCreateDelay = By.id("show-element");
        WebElement btnCreateDelay = driver.findElement(byBtnCreateDelay);
        wait.until(ExpectedConditions.elementToBeClickable(btnCreateDelay));
        btnCreateDelay.click();

        //đợi byLblDisplayText hiển thị lên (5s)
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", lblDisplayText);
//        int height = driver.manage().window().getSize().getHeight();
//        js.executeScript("window.scrollTo(0, " + Integer.valueOf(height/2) + ");");
        wait.until(ExpectedConditions.visibilityOf(lblDisplayText));
        System.out.println(lblDisplayText.isDisplayed()); // true

        Thread.sleep(3000);

        driver.quit();

    }
}
