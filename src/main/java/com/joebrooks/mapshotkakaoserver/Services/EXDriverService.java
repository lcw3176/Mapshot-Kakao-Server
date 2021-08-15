//package com.joebrooks.mapshotkakaoserver.Services;
//
//import com.joebrooks.mapshotkakaoserver.Utils.ChromeDrvierEX;
//import org.openqa.selenium.By;
//import org.openqa.selenium.OutputType;
//import org.openqa.selenium.PageLoadStrategy;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.remote.CapabilityType;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.springframework.scheduling.annotation.Async;
//import org.springframework.scheduling.annotation.AsyncResult;
//import org.springframework.stereotype.Service;
//
//import java.util.concurrent.Future;
//
//@Service
//public class EXDriverService {
//
//    @Async("executor")
//    public Future<byte[]> getImage(String url) throws Exception {
//        System.setProperty("webdriver.chrome.driver", System.getenv("CHROMEDRIVER_PATH"));
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--headless");
//        options.addArguments("--no-sandbox");
//        options.addArguments("--disable-gpu");
//        options.addArguments("--disable-dev-shm-usage");
//        options.setBinary(System.getenv("GOOGLE_CHROME_BIN"));
//
//        ChromeDrvierEX driver = new ChromeDrvierEX(options);
//
//        driver.get(url);
//        WebDriverWait waiter = new WebDriverWait(driver, 30);
//        waiter.until(ExpectedConditions.presenceOfElementLocated(By.id("checker-true")));
//
//        byte[] srcFile = driver.getFullScreenshotAs(OutputType.BYTES);
//
//        driver.quit();
//
//        return new AsyncResult<>(srcFile);
//    }
//}
