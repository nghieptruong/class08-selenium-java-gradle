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
import java.util.Set;

public class DemoWindowsHandle {
    public static void main(String[] args) {
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        options.setExperimentalOption("useAutomationExtension", false);

        WebDriver driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.get("https://demoqa.com/browser-windows");

        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(30));

        By byBtnNewTab = By.id("tabButton");
        WebElement btnNewTab = webDriverWait.until(ExpectedConditions.presenceOfElementLocated(byBtnNewTab));
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].scrollIntoView(true);", btnNewTab); //auto scroll toi btnNewTab

        String mainWindow = driver.getWindowHandle(); // get window handle ID của main windows
        System.out.println("Main Window = " + mainWindow);
        //click button New Tab
        btnNewTab.click();

        //New Window xuat hien
        Set<String> allWindows = driver.getWindowHandles();
        System.out.println("All Windows = " + allWindows);

        //Switch sang window moi
        for(String id : allWindows) {
            if(!id.equals(mainWindow)) //kiem tra de lay new window id
                driver.switchTo().window(id); //chuyen sang new window
        }

        By byLblHeading = By.id("sampleHeading");
        WebElement lblHeading = webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(byLblHeading));
        System.out.println(lblHeading.getText()); // get text lbl heading ở new window

        driver.quit();
    }
}
