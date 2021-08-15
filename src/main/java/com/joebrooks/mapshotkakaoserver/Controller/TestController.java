//package com.joebrooks.mapshotkakaoserver.Controller;
//
//import com.joebrooks.mapshotkakaoserver.Utils.ChromeDrvierEX;
//import org.openqa.selenium.By;
//import org.openqa.selenium.OutputType;
//import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/test")
//public class TestController {
//
//    @GetMapping
//    public ResponseEntity getMapCapture() throws Exception {
//
//        StringBuilder sb = new StringBuilder();
//        sb.append("http://localhost:8080/map");
//        sb.append("?lat=37.591477227475686");
//        sb.append("&lng=127.04637814466867");
//        sb.append("&level=1");
//        sb.append("&type=satellite_base");
//
//        System.setProperty("webdriver.chrome.driver", "D:/chromedriver.exe");
//        ChromeOptions options = new ChromeOptions();
//        options.addArguments("--headless");
//        options.addArguments("--no-sandbox");
//        options.addArguments("--disable-gpu");
//        options.addArguments("--disable-dev-shm-usage");
//
//        ChromeDrvierEX driver = new ChromeDrvierEX(options);
//
//        driver.get(sb.toString());
//        WebDriverWait waiter = new WebDriverWait(driver, 30);
//        waiter.until(ExpectedConditions.presenceOfElementLocated(By.id("checker_true")));
//
//        byte[] srcFile = driver.getFullScreenshotAs(OutputType.BYTES);
//
//        driver.quit();
//        return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(srcFile);
//    }
//}
