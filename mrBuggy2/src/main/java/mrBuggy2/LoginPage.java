package mrBuggy2;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginPage {
    WebDriver webDriver;

    public LoginPage() {
        System.setProperty("webdriver.chrome.driver", "C:\\WebDrivers\\chromedriver.exe");
        webDriver = new ChromeDriver();
    }

    public void goTo() {
        webDriver.get("http://demo.mrbuggy2.testarena.pl/zaloguj");
    }

    public void typeLogin(String username) {
        webDriver.findElement(By.id("email")).sendKeys(username);
    }

    public void typePassword(String password) {
        webDriver.findElement(By.id("password")).sendKeys(password);
    }

    public void submitButtonLogin() {
        webDriver.findElement(By.cssSelector("input[type=submit]")).click();
    }

    public void verifyIsLoggedIn() {
        String text = "KOKPIT";
        Assert.assertTrue(getTextAfterLogin().contains(text));
    }

    public void verifyIsNotLoggedIn() {
        String text = "Zaloguj";
        Assert.assertTrue(getTextFailLogin().contains(text));
    }

    private String getTextAfterLogin() {
        return webDriver.findElement(By.className("content_title")).getText();
    }

    private String getTextFailLogin() {
        return webDriver.findElement(By.cssSelector("input[type=submit]")).getAttribute("value");
    }

    public void closeBrowser() {
        webDriver.close();
    }


}


