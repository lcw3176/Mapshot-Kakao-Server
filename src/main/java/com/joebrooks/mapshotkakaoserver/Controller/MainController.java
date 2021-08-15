package com.joebrooks.mapshotkakaoserver.Controller;

import com.joebrooks.mapshotkakaoserver.Services.EXDriverService;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@CrossOrigin("https://mapshot.netlify.app")
@RestController
@RequestMapping("/main")
public class MainController {
    private EXDriverService service;

    public MainController(EXDriverService service){
        this.service = service;
    }

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


        service.getDriver().get(sb.toString());
        WebDriverWait waiter = new WebDriverWait(service.getDriver(), 30);
        waiter.until(ExpectedConditions.presenceOfElementLocated(By.id("checker-true")));

        byte[] srcFile = service.getDriver().getFullScreenshotAs(OutputType.BYTES);

        service.getDriver().quit();

        return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(srcFile);
    }
}
