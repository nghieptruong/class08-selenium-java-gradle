package demobasic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DemoActions {
    public static void main(String[] args) {
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        options.setExperimentalOption("useAutomationExtension", false);

        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("C:\\Data\\Training\\Automation_Testing\\class08\\class08-selenium-java-gradle\\src\\main\\java\\webbasic\\actionsdemo\\actions-click-demo.html");

        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(30));
        By byBtnRightClick = By.id("rightClick");
        WebElement btnRightClick = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(byBtnRightClick));

        Actions actions = new Actions(driver, Duration.ofSeconds(10));
        actions.contextClick(btnRightClick).perform(); // ket thuc 1 chuỗi actions phải có .perform()

        By byTxtReadOnlyLog = By.id("log");
        WebElement txtReadOnlyLog = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(byTxtReadOnlyLog));
        webDriverWait.until(ExpectedConditions.textToBePresentInElementLocated(byTxtReadOnlyLog, "Right Click detected"));
        System.out.println(txtReadOnlyLog.getText());

        driver.quit();
    }
}
