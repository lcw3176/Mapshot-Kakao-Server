package com.joebrooks.mapshotkakaoserver.Controller;

import com.joebrooks.mapshotkakaoserver.Service.EXDriverService;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/maps")
public class MainController {

    private EXDriverService driverService;

    public MainController(EXDriverService driverService){
        this.driverService = driverService;
    }

    @GetMapping
    public ResponseEntity home(@RequestParam("lat") float lat,
                               @RequestParam("lng") float lng,
                               @RequestParam("level") int level) throws Exception {
        StringBuilder sb = new StringBuilder();
        sb.append("https://mapshotproxyserver.herokuapp.com/html");
        sb.append("?lat=");
        sb.append(lat);
        sb.append("&lng=");
        sb.append(lng);
        sb.append("&level=");
        sb.append(level);

        driverService.getDriver().get(sb.toString());
        driverService.getWaiter().until(ExpectedConditions.presenceOfElementLocated(By.id("checker-true")));
        byte[] srcFile = driverService.getDriver().getFullScreenshotAs(OutputType.BYTES);

        return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(srcFile);
    }
}
