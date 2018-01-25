package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import session.Instance;

public class VideoTest {

    @BeforeTest
    public void init(){

    }

    @Test
    public void checkVideoIsPlaying(){
        WebElement vid = Instance.driver.findElement(By.tagName("iframe"));
        String actual = vid.getAttribute("class");
        String expected = "player ka-player-iframe centered-when-windowed video_1wp16kd-o_O-centeredWhenWindowed_logtht";
        Assert.assertEquals(actual, expected);
    }

    @Test
    public void validateWritingAComment(){
        WebElement login = Instance.driver.findElement(By.xpath("//a[@href='/login?continue=%2Fpartner-content%2Fpixar%2Fstart%2Fintroduction%2Fv%2Fpipeline-video']"));
        login.click();
        WebElement username = Instance.driver.findElement(By.xpath("//input[@type='text']"));
        username.sendKeys("KhanTest12@gmail.com");
        WebElement password = Instance.driver.findElement(By.xpath("//input[@type='password']"));
        password.sendKeys("KhanTest12");
        WebElement singed = Instance.driver.findElement(By.className("button_1ilkz0g-o_O-common_hqgk90-o_O-large_10vyrhl-o_O-all_tca0ge"));
        singed.click();
        WebDriverWait wait = new WebDriverWait(Instance.driver, 1000);
        wait.until(
            ExpectedConditions.visibilityOfElementLocated(By.className("nicknameDisplay_u7ifp"))
        );
        WebElement comment = Instance.driver.findElement(By.tagName("textarea"));
        comment.sendKeys("Hello, I like your video, i learned so much about it?So?");
        WebElement askQuestionButton = Instance.driver.findElement(By.xpath("//input[@value='Ask your question']"));
        askQuestionButton.click();
        WebElement commented = Instance.driver.findElement(By.xpath("//*[@id='v/pipeline-video-panel']/div[1]/div/div[8]/div/div/div/div[2]/div[6]/div/div/div/div[1]"));
        String actual = commented.getText();
        String expected = "Hello, I like your video, i learned so much about it?So?";
        Assert.assertTrue(actual.contains(expected));
    }
}
