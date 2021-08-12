package com.joebrooks.mapshotkakaoserver.Controller;

import com.joebrooks.mapshotkakaoserver.Service.EXDriverService;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("https://testservermapshot.netlify.app")
@RestController
@RequestMapping("/test")
public class TestController {

    private EXDriverService driverService;

    public TestController(EXDriverService driverService){
        this.driverService = driverService;
    }

    @GetMapping
    public ResponseEntity getMapCapture(@RequestParam("lat") String lat,
                                        @RequestParam("lng") String lng,
                                        @RequestParam("level") String level) {
        StringBuilder sb = new StringBuilder();
        sb.append("https://mapshotproxyserver.herokuapp.com/map");
        sb.append("?lat=");
        sb.append(lat);
        sb.append("&lng=");
        sb.append(lng);
        sb.append("&level=");
        sb.append(level);
        HttpHeaders headers = new HttpHeaders();
        headers.add("Access-Control-Allow-Origin", "https://testservermapshot.netlify.app");
        driverService.getDriver().get(sb.toString());
        driverService.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.id("checker-true")));
        byte[] srcFile = driverService.getDriver().getFullScreenshotAs(OutputType.BYTES);

        return ResponseEntity.ok().headers(headers).contentType(MediaType.IMAGE_JPEG).body(srcFile);
    }
}
