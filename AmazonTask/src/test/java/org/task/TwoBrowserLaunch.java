package org.task;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TwoBrowserLaunch {
    public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://adactinhotelapp.com/index.php");
        // Open incognito Chrome window
        ChromeOptions options = new ChromeOptions();
        String currentUrl = driver.getCurrentUrl();
        options.addArguments("--incognito");
        WebDriver incognitoDriver = new ChromeDriver(options);
        incognitoDriver.get(currentUrl);

        driver.quit();
        incognitoDriver.quit();
    }
}


