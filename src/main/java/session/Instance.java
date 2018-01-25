package session;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class Instance {

    public static WebDriver driver;

    JavascriptExecutor jsExecutor;

    public AjaxElementLocatorFactory ajaxElementLocatorFactory;

    public static void chromeInitConfigAndNavigateTo(String url) {

        System.setProperty("webdriver.chrome.driver",
            "C:\\Users\\tr_lnd_user\\Desktop\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(url);
    }

    public static void quitDriverSession(){
        driver.quit();
    }

}
