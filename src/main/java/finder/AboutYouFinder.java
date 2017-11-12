package finder;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

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
    }
}
