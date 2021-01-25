import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertTrue;

public class BringItOnTest {
    @Test
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://pastebin.com");

        WebElement searchInputCode = driver.findElement(By.id("postform-text"));
        searchInputCode.sendKeys("git config --global user.name  \"New Sheriff in Town\"\n" +
                                                "git reset $(git commit-tree HEAD^{tree} -m \"Legacy code\")\n" +
                                                    "git push origin master --force\n");
        WebElement searchBtnCode = driver.findElement(By.xpath("//*[@id='postform-text']"));
        searchBtnCode.click();

        WebElement searchInputSyntaxField = driver.findElement(By.id("select2-postform-format-container"));
        searchInputSyntaxField.click();
        WebElement searchInputSyntax = driver.findElement(By.xpath("/html/body/span[2]/span/span[1]/input"));
        searchInputSyntax.click();
        searchInputSyntax.sendKeys("bash");
        WebElement textbox = driver. findElement(By.xpath("/html/body/span[2]/span/span[1]/input"));
        textbox. sendKeys(Keys. RETURN);

        driver.findElement(By. id("select2-postform-expiration-container")).click();
        List<WebElement> options = driver.findElements(By. cssSelector("#select2-postform-expiration-container"));

        for (WebElement opt : options) {

            if (opt.getText().equals("10 Minutes")) {
                opt.click();
            }}

        WebElement searchInputPastName = driver.findElement(By.id("postform-name"));
        searchInputPastName.sendKeys("how to gain dominance among developers");
        WebElement searchBtnPastName = driver.findElement(By.xpath("//*[@id='postform-name']"));
        searchBtnPastName.click();

        WebElement searchInputCreateNewPaste = driver.findElement(By.xpath("//*[@id='w0']/div[5]/div[1]/div[8]/button"));
        WebElement searchBtnCreateNewPaste = driver.findElement(By.xpath("//*[@id='w0']/div[5]/div[1]/div[8]/button"));
        searchBtnCreateNewPaste.click();

        System.out.println("Page title is : " + driver.getTitle());
        if(driver.getTitle().contains("how to gain dominance among developers"))
            //Pass
            System.out.println("Page title contains \"how to gain dominance among developers\" ");
        else
            //Fail
            System.out.println("Page title doesn't contain \"how to gain dominance among developers\" ");

        WebElement searchInputCheckCode = driver.findElement(By.xpath("/html/body/div[2]/div[2]/div[1]/div[2]/textarea"));
        if (searchInputCheckCode == searchInputCode)
            System.out.println("The same code is displayed");
        else
            System.out.println("Code not found");

        WebElement searchInputBash = driver.findElement(By.xpath("//span[text()='git config' and @class='kw2']"));
        if (searchInputBash != null)
            System.out.println("The syntax highlights bash");
        else
            System.out.println("The syntax does not highlight bash");

        Thread.sleep( 100000);
        driver.quit();
    }
}