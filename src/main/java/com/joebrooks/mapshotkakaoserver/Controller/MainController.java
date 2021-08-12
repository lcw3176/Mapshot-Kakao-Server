package com.joebrooks.mapshotkakaoserver.Controller;

import com.joebrooks.mapshotkakaoserver.Utils.ChromeDrvierEX;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;

@CrossOrigin("*")
@RestController
@RequestMapping("/maps")
public class MainController {

    @GetMapping
    public ResponseEntity home() throws Exception {
        StringBuilder sb = new StringBuilder();
        sb.append("https://mapshotproxyserver.herokuapp.com/html?lat=11&lng=11");


        System.setProperty("webdriver.chrome.driver", System.getenv("CHROMEDRIVER_PATH"));

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-gpu");
        options.addArguments("--disable-dev-shm-usage");
        options.setBinary(System.getenv("GOOGLE_CHROME_BIN"));

        ChromeDrvierEX chromedriverEX = new ChromeDrvierEX(options);
        WebDriverWait webDriverWait = new WebDriverWait(chromedriverEX, 30);
        chromedriverEX.get(sb.toString());


        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.id("checker-true")));
        File srcFile = chromedriverEX.getFullScreenshotAs(OutputType.FILE);

        BufferedImage beforeImg = ImageIO.read(srcFile);
        BufferedImage afterImg = new BufferedImage(beforeImg.getWidth(), beforeImg.getHeight(), BufferedImage.TYPE_INT_RGB);

        afterImg.createGraphics().drawImage(beforeImg, 0, 0, Color.white, null);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ImageIO.write(afterImg, "jpg", outputStream);

        chromedriverEX.quit();
        return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(outputStream.toByteArray());
    }
}
