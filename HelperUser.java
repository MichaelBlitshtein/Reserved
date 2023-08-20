package manager;

import model.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import javax.lang.model.element.Element;
import javax.swing.*;
import java.util.List;

public class HelperUser extends HelperBase{

    public HelperUser(WebDriver wd) {
        super(wd);
    }

    public void openTopSection() {
        WebElement element = wd.findElement(By.cssSelector("[href$='woman']"));
        Actions action = new Actions(wd);
        action.moveToElement(element);
        action.perform();

        click(By.xpath("//*[text()='Tops']"));
    }

    public void acceptCookiesAndChooseLanguage() {
        wd.findElement(By.xpath("//button[@id='cookiebotDialogOkButton'][text()='OK']")).click();
        wd.findElement(By.xpath("//*[text()='United Kingdom']")).click();

    }

    public void chooseTopModel() {
        wd.findElement(By.cssSelector("#categoryProducts>article:nth-child(10)")).click();

    }

    public void chooseSize() {

//        WebElement popUpWindow = wd.findElement(By.cssSelector("[class*='outline-close']"));
//        if( popUpWindow.isDisplayed()) {
//            popUpWindow.click();
//        }

        wd.findElement(By.xpath("//span[text()='Choose size']")).click();
        wd.findElement(By.cssSelector(".sizes-list>li:nth-child(3)")).click();
    }

    public void addToShoppingCart() {
        wd.findElement(By.xpath("//button[contains(@class,'primary')]")).click();
    }

    public boolean productHasBeenAddedToCart() {
        WebElement element = wd.findElement(By.xpath("//*[@data-selen='cart-confirmation-title']"));
       String text = element.getText();
        return text.equals("Product was added to your shopping cart");
    }

    public void openLoginForm() {
        WebElement account = wd.findElement(By.xpath("//*[@data-testid='account-info-logged-false']"));
        Actions action = new Actions(wd);
        action.moveToElement(account);
        action.perform();

        wd.findElement(By.xpath("//*[@data-testid='login']")).click();
    }

    public void fillInLoginForm(User user) {
        type(By.xpath("//*[@type='email']"), user.getEmail());
        type(By.xpath("//*[@name='login[password]']"), user.getPassword());

    }

    public void submitLogin() {
        wd.findElement(By.xpath("//button[text()='Sign in']")).click();
    }

    public boolean isLogged() {
        List<WebElement> list = wd.findElements(By.xpath("//*[@data-testid='account-info-logged-true']"));
    return list.size()>0;
    }
}
