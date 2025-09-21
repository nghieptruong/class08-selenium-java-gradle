package demobasic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class DemoSelect {
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

        By bySelDropDown = By.id("dropdown");
        WebElement selDropDownElement = driver.findElement(bySelDropDown);
        Select selDropDown = new Select(selDropDownElement);
//        selDropDown.selectByVisibleText("Option1");
//        selDropDown.selectByIndex(1);
//        selDropDown.selectByValue("OptionOne");

         List<WebElement> listElementOptions = selDropDown.getOptions();
         for(WebElement element : listElementOptions){
             System.out.println(element.getText());
         }

        Thread.sleep(3000);

        driver.quit();
    }
}
