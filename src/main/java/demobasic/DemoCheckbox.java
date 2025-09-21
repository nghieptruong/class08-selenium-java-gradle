package demobasic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DemoCheckbox {
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

        By byChkCheckbox1 = By.xpath("//input[@type='checkbox' and @value='c1']");
        By byChkCheckbox2 = By.xpath("//input[@type='checkbox' and @value='c2']");
        By byChkCheckbox3 = By.xpath("//input[@type='checkbox' and @value='c3']");

        setCheckboxAdvance(driver, byChkCheckbox1, true);
        setCheckboxAdvance(driver, byChkCheckbox2, true);
        setCheckboxAdvance(driver, byChkCheckbox3, true);

        Thread.sleep(3000);

        setCheckboxAdvance(driver, byChkCheckbox1, false);
        setCheckboxAdvance(driver, byChkCheckbox2, false);
        setCheckboxAdvance(driver, byChkCheckbox3, false);

        Thread.sleep(3000);

        setCheckboxAdvance(driver, byChkCheckbox1, false);
        setCheckboxAdvance(driver, byChkCheckbox2, true);
        setCheckboxAdvance(driver, byChkCheckbox3, false);

        Thread.sleep(3000);

        driver.quit();
    }
    public static void setCheckboxBasic(WebDriver driver, By locator, boolean checked) {
        WebElement chkElement = driver.findElement(locator);

        //muốn checked (click chọn)
        if(checked) {
            //hiện tại checkbox trang thai dang checked hay unchecked
            if(chkElement.isSelected()) {
               //Do Nothing khi mà nó đang checked
            } else{
                // click lên checkbox khi mà nó chưa checked
                chkElement.click();
            }
        } else {
            //muốn unchecked (click bỏ chọn)
            //hiện tại checkbox trang thai dang checked hay unchecked
            if(chkElement.isSelected()) {
                // click lên checkbox khi mà nó checked
                chkElement.click();
            } else{
                //Do Nothing khi mà nó đang unchecked
            }
        }
    }

    public static void setCheckboxAdvance(WebDriver driver, By locator, boolean checked) {
        WebElement chkElement = driver.findElement(locator);

        if(checked != chkElement.isSelected()) {
            chkElement.click();
        }
    }
}
