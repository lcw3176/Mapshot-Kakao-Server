package com.joebrooks.mapshotkakaoserver.Controller;

import com.joebrooks.mapshotkakaoserver.Utils.ChromeDrvierEX;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("https://mapshot.netlify.app")
@RestController
@RequestMapping("/main")
public class MainController {

    @GetMapping
    public ResponseEntity getMapCapture(@RequestParam("lat") String lat,
                                        @RequestParam("lng") String lng,
                                        @RequestParam("level") String level,
                                        @RequestParam("type") String type) throws Exception {

        StringBuilder sb = new StringBuilder();
        sb.append("https://mapshotproxyserver.herokuapp.com/map");
        sb.append("?lat=");
        sb.append(lat);
        sb.append("&lng=");
        sb.append(lng);
        sb.append("&level=");
        sb.append(level);
        sb.append("&type=");
        sb.append(type);

        System.setProperty("webdriver.chrome.driver", System.getenv("CHROMEDRIVER_PATH"));
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-gpu");
        options.addArguments("--disable-dev-shm-usage");
        options.setBinary(System.getenv("GOOGLE_CHROME_BIN"));

        ChromeDrvierEX driver = new ChromeDrvierEX(options);

        driver.get(sb.toString());
        WebDriverWait waiter = new WebDriverWait(driver, 30);
        waiter.until(ExpectedConditions.presenceOfElementLocated(By.id("checker-true")));

        byte[] srcFile = driver.getFullScreenshotAs(OutputType.BYTES);

        driver.quit();

        return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(srcFile);
    }
}
