package demobasic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DemoTable {
    public static void main(String[] args) throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
//        options.setBrowserVersion("137");
        //disable automation bar
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        options.setExperimentalOption("useAutomationExtension", false);
        options.setAcceptInsecureCerts(true); // accept insecure certificate (https)

        WebDriver driver = new ChromeDriver(options); // khoi tao 1 driver object co kieu ChromeDriver (process chromedriver.exe)
        driver.get("http://dummypoint.com/Tables.html"); // navigate (mở) 1 site
        driver.manage().window().maximize();

        String cellValue = getTableCellByIndex(driver, "//table", 2, 2);
        System.out.println(cellValue);

        Thread.sleep(3000);

        driver.quit();
    }
    public static String getTableCellByIndex(WebDriver driver, String locatorTable, int row, int col) {
        String locatorCellTemplate = locatorTable + "/tbody/tr[%d]/td[%d]";
        String locatorCell = String.format(locatorCellTemplate, row, col); // -->//table/tbody/tr[1]/td[2]
        By byCell = By.xpath(locatorCell); // --> kieu By
        WebElement cellElement = driver.findElement(byCell);
        return cellElement.getText();
    }
}
