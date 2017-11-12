package finder;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class AboutYouFinder {
    public static void searchByKeyword(String currentKeyword) {
        System.out.println("Keyword = " + currentKeyword + " Loaded  ");

        ChromeDriverManager.getInstance().setup();
        ChromeDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://www.aboutyou.de/");

        WebElement keywordInput = driver.findElement(By.xpath("//input[@id='search-input_autocomplete']"));
        keywordInput.sendKeys(currentKeyword);

        WebElement submitBtn = driver.findElement(By.xpath("//button[@class='submitButton_2ljq6v']"));
        submitBtn.click();

      //--
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//img[contains(@class,'1xu5k6x')]")));

        List<WebElement> allLinks = driver.findElements(By.xpath("//img[contains(@class,'1xu5k6x')]"));

        for ( WebElement link: allLinks) {
            link.click();
            System.out.println(link.getText());

            try {
                driver.wait(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
