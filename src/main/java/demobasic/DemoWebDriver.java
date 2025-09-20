package demobasic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class DemoWebDriver {
    public static void main(String[] args) throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
//        options.setBrowserVersion("137");
        //disable automation bar
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        options.setExperimentalOption("useAutomationExtension", false);

        WebDriver driver = new ChromeDriver(options); // khoi tao 1 driver object co kieu ChromeDriver (process chromedriver.exe)
        driver.get("https://demo1.cybersoft.edu.vn/"); // navigate (mở) 1 site
        driver.manage().window().maximize();

//        WebDriver driver = new FirefoxDriver(); // geckodriver.exe
//        driver.get("https://demo1.cybersoft.edu.vn/");

//        WebDriver driver = new EdgeDriver(); // msedgedriver.exe
//        driver.get("https://demo1.cybersoft.edu.vn/");

//        WebDriver driver = new SafariDriver();
//        driver.get("https://demo1.cybersoft.edu.vn/");

        Thread.sleep(3000);

        //Step 1: Click link "Đăng Ký"
        By byBtnRegister = By.xpath("//h3[text()='Đăng Ký']");
        WebElement btnRegister = driver.findElement(byBtnRegister);
        btnRegister.click();

        //Step 2: Enter account
        By byTxtAccount = By.id("taiKhoan");
        WebElement txtAccount = driver.findElement(byTxtAccount);
        txtAccount.sendKeys("N1111");

        //Step 3: Enter password
        By byTxtPassword = By.id("matKhau");
        WebElement txtPassword = driver.findElement(byTxtPassword);
        txtPassword.sendKeys("Test123456@");

        //Step 4: Enter confirm password
        By byTxtConfirmPassword = By.id("confirmPassWord");
        WebElement txtConfirmPassword = driver.findElement(byTxtConfirmPassword);
        txtConfirmPassword.sendKeys("Test123456@");

        //Step 5: Enter name
        By byTxtName = By.id("hoTen");
        WebElement txtName = driver.findElement(byTxtName);
        txtName.sendKeys("John A");

        //Step 6: Enter email
        By byTxtEmail = By.id("email");
        WebElement txtEmail = driver.findElement(byTxtEmail);
        txtEmail.sendKeys("N1111@example.com");

        //Step 7: Click register button
        By byBtnRegisterNewAcc = By.xpath("//button[.='Đăng ký']");
        WebElement btnRegisterNewAcc = driver.findElement(byBtnRegisterNewAcc);
        btnRegisterNewAcc.click();

        Thread.sleep(3000);

        driver.quit(); // quit driver session (kiem tra se ko con chromedriver.exe)
    }
}
