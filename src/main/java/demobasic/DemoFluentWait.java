package demobasic;

import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class DemoFluentWait {
    public static void main(String[] args) {
        ChromeOptions options = new ChromeOptions();
//        options.setBrowserVersion("137");
        //disable automation bar
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        options.setExperimentalOption("useAutomationExtension", false);

//        WebDriver driver = new ChromeDriver(options); // khoi tao 1 driver object co kieu ChromeDriver (process chromedriver.exe)
//        driver.get("https://demo1.cybersoft.edu.vn/"); // navigate (mở) 1 site
////        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); // đợi ngầm định 10s cho findElement
//        driver.manage().window().maximize();

        List<String> list = Arrays.asList("Tom", "Peter", "Thomas", "John");
        //Generic wait (wait chung chung)
        FluentWait<List<String>> fluentWait = new FluentWait<>(list)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(1))
                .ignoring(NotFoundException.class);

        //Wait trong list, gap item có length = 6 thì dừng,nguoc lai tim ko thay, tiep tuc wait het timeout
        //moi lan polling (nghỉ) 1s để đợi check
        Function<List<String>, Boolean> isFoundMaxLength = (listItems) -> {
            for (int i = 0; i < listItems.size(); i++) {
                System.out.println("Checking at " + LocalDateTime.now());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                if(listItems.get(i).length() == 6) {
                    return true;
                }
            }
            return false;
        };
        boolean isFound = fluentWait.until(isFoundMaxLength); //neu ko tim thay, quang loi TimeOutException


    }
}
