package demobasic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.UUID;

public class DemoWebDriver {
    public static void main(String[] args) throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
//        options.setBrowserVersion("137");
        //disable automation bar
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        options.setExperimentalOption("useAutomationExtension", false);

        WebDriver driver = new ChromeDriver(options); // khoi tao 1 driver object co kieu ChromeDriver (process chromedriver.exe)
        driver.get("https://demo1.cybersoft.edu.vn/"); // navigate (mở) 1 site
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // đợi ngầm định 10s cho findElement
        driver.manage().window().maximize();

//        WebDriver driver = new FirefoxDriver(); // geckodriver.exe
//        driver.get("https://demo1.cybersoft.edu.vn/");

//        WebDriver driver = new EdgeDriver(); // msedgedriver.exe
//        driver.get("https://demo1.cybersoft.edu.vn/");

//        WebDriver driver = new SafariDriver();
//        driver.get("https://demo1.cybersoft.edu.vn/");

        //Step 1: Click link "Đăng Ký"
        By byBtnRegister = By.xpath("//h3[text()='Đăng Ký']");
        ZonedDateTime start = ZonedDateTime.now();
        System.out.println("Start = " + start);
        WebElement btnRegister = driver.findElement(byBtnRegister); // throw exception "NoSuchElementException" neu ko thay element
        ZonedDateTime end = ZonedDateTime.now();
        System.out.println("End = " + end);
        long duration = ChronoUnit.SECONDS.between(start, end);
        System.out.println("Duration = " + duration);
        btnRegister.click();

        //Step 2: Enter account
        String account = UUID.randomUUID().toString();
        By byTxtAccount = By.id("taiKhoan");
        WebElement txtAccount = driver.findElement(byTxtAccount);
        txtAccount.sendKeys(account);

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
        String email = account + "@example.com";
        By byTxtEmail = By.id("email");
        WebElement txtEmail = driver.findElement(byTxtEmail);
        txtEmail.sendKeys(email);

        //Step 7: Click register button
        By byBtnRegisterNewAcc = By.xpath("//button[.='Đăng ký']");
        WebElement btnRegisterNewAcc = driver.findElement(byBtnRegisterNewAcc);
        btnRegisterNewAcc.click();

        Thread.sleep(3000);

        driver.quit(); // quit driver session (kiem tra se ko con chromedriver.exe)
    }
}
