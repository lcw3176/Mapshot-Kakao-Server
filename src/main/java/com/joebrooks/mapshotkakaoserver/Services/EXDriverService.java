package com.joebrooks.mapshotkakaoserver.Services;


import com.joebrooks.mapshotkakaoserver.Utils.ChromeDrvierEX;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.annotation.PreDestroy;

@Service
public class EXDriverService{


//    public WebDriverWait getWaiter() {
//        return waiter.getWaiter();
//    }

    @Async("driverExecutor")
    public ChromeDrvierEX getDriver() throws Exception {
        System.setProperty("webdriver.chrome.driver", System.getenv("CHROMEDRIVER_PATH"));
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-gpu");
        options.addArguments("--disable-dev-shm-usage");
        options.setBinary(System.getenv("GOOGLE_CHROME_BIN"));

        ChromeDrvierEX driver = new ChromeDrvierEX(options);

        return driver;
    }

//    @PreDestroy
//    public void close() {
//        drivers.getDriver().quit();
//    }

}