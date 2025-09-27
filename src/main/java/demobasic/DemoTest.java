package demobasic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class DemoTest {
    public static void main(String[] args) throws InterruptedException {
        ChromeOptions options = new ChromeOptions();

        //options.setBrowserVersion("137");
        // disable automation bar
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        options.setExperimentalOption("useAutomationExtension", false);

        WebDriver driver = new ChromeDriver(options); // khoi btao 1 driver object co kieu Chrome Driver ( precess chromedriver)
        driver.get("https://demo6.cybersoft.edu.vn/?"); // navigate ( mo) 1 site
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

        Thread.sleep(3000);

//step: click button dang ky

        By byBtnRegister = By.xpath("//a[text()='Đăng ký']"); // locator
        WebElement btnRegister = driver.findElement(byBtnRegister); // tìm element theo locator
        btnRegister.click(); // click vào nút

//step 2: Enter user name
        By byTxtUsername = By.name("username");                // locator theo name
        WebElement txtUsername = driver.findElement(byTxtUsername); // tìm element theo locator
        txtUsername.sendKeys("Hoang");                         // nhập text


// Step 3: Enter Full name
        By byTxtFullname = By.name("fullname");
        WebElement txtFullname = driver.findElement(byTxtFullname);
        txtFullname.sendKeys("Hoang Test");

// Step 4: Enter Email
        By byTxtYourEmail = By.name("email");
        WebElement txtYourEmail = driver.findElement(byTxtYourEmail);
        txtYourEmail.sendKeys("test@gmail.com");

// Step 5: Enter Phone Number
        By byTxtPhonenumber = By.name("phone");
        WebElement txtPhonenumber = driver.findElement(byTxtPhonenumber);
        txtPhonenumber.sendKeys("0123456789");

// Step 6: Enter Your Password
        By byTxtYouPassword = By.name("password");
        WebElement txtYouPassword = driver.findElement(byTxtYouPassword);
        txtYouPassword.sendKeys("Test123");

// Step 7: Enter Confirm PW
        By byTxtConfirmPassword = By.name("confirmPassword");
        WebElement txtConfirmPassword = driver.findElement(byTxtConfirmPassword);
        txtConfirmPassword.sendKeys("Test123");

// Step 8: Enter Date Of Birth
        By byTxtDateOfBirth = By.name("dateOfBirth");
        WebElement txtDateOfBirth = driver.findElement(byTxtDateOfBirth);
        txtDateOfBirth.sendKeys("01/01/2000");


//Step9: Enter Gender
        By byDropdownGender = By.id("gender");
        WebElement dropdownGender = driver.findElement(byDropdownGender);
// khai báo Select object
        Select selectGender = new Select(dropdownGender);
// chọn option theo value
        selectGender.selectByValue("Female");

        Thread.sleep(3000);

//       driver.quit(); // quit driver sesion ( kiem tra se khong con chromedriver.exe)
    }
}
