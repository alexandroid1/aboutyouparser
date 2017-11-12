import finder.AboutYouFinder;
import org.openqa.selenium.WebDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class AboutYouParserRunner extends AboutYouFinder {

    public static void main(String[] args) {
        Thread aboutYouParserThread = new Thread(() -> searchByKeyword("jeans"));
        aboutYouParserThread.start();
    }
}
