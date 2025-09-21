package demobasic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DemoClickableElement {
    public static void main(String[] args) throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
//        options.setBrowserVersion("137");
        //disable automation bar
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        options.setExperimentalOption("useAutomationExtension", false);
        options.setAcceptInsecureCerts(true); // accept insecure certificate (https)

        WebDriver driver = new ChromeDriver(options); // khoi tao 1 driver object co kieu ChromeDriver (process chromedriver.exe)
        driver.get("C:\\Data\\Training\\Automation_Testing\\class08\\class08-selenium-java-gradle\\src\\main\\java\\webbasic\\elementToBeClickable\\ElementToBeClickableDemo.html"); // navigate (mở) 1 site
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        By byBtnClickMe = By.id("delayed-btn");
        WebElement btnClickMe = driver.findElement(byBtnClickMe); // nút này đã hiển thị nhưng mà ko enable
        //wait cho enable roi click
        wait.until(ExpectedConditions.elementToBeClickable(btnClickMe)); // wait enable
        btnClickMe.click();

        By byLblStatus = By.id("status");
        WebElement lblStatus = driver.findElement(byLblStatus);
        System.out.println("Recorded Status = " + lblStatus.getText()); // Status: clicked

        Thread.sleep(3000);

        driver.quit();
    }
}
