package demobasic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DemoRadio {
    public static void main(String[] args) throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
//        options.setBrowserVersion("137");
        //disable automation bar
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        options.setExperimentalOption("useAutomationExtension", false);
        options.setAcceptInsecureCerts(true); // accept insecure certificate (https)

        WebDriver driver = new ChromeDriver(options); // khoi tao 1 driver object co kieu ChromeDriver (process chromedriver.exe)
        driver.get("http://dummypoint.com/seleniumtemplate.html"); // navigate (mở) 1 site
        driver.manage().window().maximize();

        String locatorTemplate = "//input[@type='radio' and @value='%s']";
        setRadio(driver, locatorTemplate, "Button2");

        Thread.sleep(3000);

        driver.quit();
    }
    public static void setRadio(WebDriver driver, String locatorXpath,String name) {
        String strRadLocatorXpath = String.format(locatorXpath, name);
        By byRadLocator = By.xpath(strRadLocatorXpath);
        WebElement radButtonElement = driver.findElement(byRadLocator);
        radButtonElement.click();
    }
}
