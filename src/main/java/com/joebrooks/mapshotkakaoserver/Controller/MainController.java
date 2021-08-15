package com.joebrooks.mapshotkakaoserver.Controller;

import com.joebrooks.mapshotkakaoserver.Services.EXDriverService;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.ui.ExpectedConditions;
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

        //Open new tab
        JavascriptExecutor jse = (JavascriptExecutor)service.getDriver();
        jse.executeScript("window.open()");

        //Switch to new tab
        ArrayList<String> tabs = new ArrayList<String> (service.getDriver().getWindowHandles());
        service.getDriver().switchTo().window(tabs.get(tabs.size() - 1));
        service.getDriver().get(sb.toString());
        service.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.id("checker-true")));

        byte[] srcFile = service.getDriver().getFullScreenshotAs(OutputType.BYTES);

        service.getDriver().close();

        return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(srcFile);
    }
}
