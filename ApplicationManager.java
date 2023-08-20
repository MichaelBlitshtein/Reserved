package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class ApplicationManager {
    WebDriver wd;
    HelperUser helperUser;

    public HelperUser getHelperUser() {
        return helperUser;
    }

    public void init(){
        wd = new ChromeDriver();
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        wd.navigate().to("https://www.reserved.com/re/en/");

        helperUser = new HelperUser(wd);

    }

    public void stop(){
       // wd.quit();
    }


}