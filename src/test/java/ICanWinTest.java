import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;

public class ICanWinTest {
    @Test
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://pastebin.com");

        WebElement searchInput = driver.findElement(By.id("postform-text"));
        searchInput.sendKeys("Hello from WebDriver");
        WebElement searchBtn = driver.findElement(By.xpath("//*[@id='postform-text']"));
        searchBtn.click();

        WebElement searchInputPastName = driver.findElement(By.id("postform-name"));
        searchInputPastName.sendKeys("helloweb");
        WebElement searchBtnPastName = driver.findElement(By.xpath("//*[@id='postform-name']"));
        searchBtnPastName.click();

        driver.findElement(By. id("select2-postform-expiration-container")).click();
        List<WebElement> options = driver.findElements(By. cssSelector("#select2-postform-expiration-container"));

        for (WebElement opt : options) {

            if (opt.getText().equals("10 Minutes")) {
                opt.click();
            }}

        WebElement searchInputCreateNewPaste = driver.findElement(By.xpath("//*[@id='w0']/div[5]/div[1]/div[8]/button"));
        WebElement searchBtnCreateNewPaste = driver.findElement(By.xpath("//*[@id='w0']/div[5]/div[1]/div[8]/button"));
        searchBtnCreateNewPaste.click();

        Thread.sleep( 10000);
        driver.quit();
    }
}