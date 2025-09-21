package demobasic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class DemoMultiSelect {
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

        By byMultiSelect = By.id("multiselect");
        WebElement multiSelectElement = driver.findElement(byMultiSelect);
        Select multiSelect = new Select(multiSelectElement);
        multiSelect.selectByVisibleText("mOption1");
        multiSelect.selectByVisibleText("mOption2");

        List<WebElement> selectedOptions = multiSelect.getAllSelectedOptions();
        System.out.println(selectedOptions);

        Thread.sleep(3000);

        driver.quit();
    }
}
