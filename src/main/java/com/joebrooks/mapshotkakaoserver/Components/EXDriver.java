package com.joebrooks.mapshotkakaoserver.Components;


import com.joebrooks.mapshotkakaoserver.Utils.ChromeDrvierEX;
import org.openqa.selenium.chrome.ChromeOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class EXDriver {

    private ChromeDrvierEX driver;

    @PostConstruct
    public void initialize() throws Exception {
        System.setProperty("webdriver.chrome.driver", System.getenv("CHROMEDRIVER_PATH"));
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-gpu");
        options.addArguments("--disable-dev-shm-usage");
        options.setBinary(System.getenv("GOOGLE_CHROME_BIN"));

        driver = new ChromeDrvierEX(options);
    }

    @Bean
    public ChromeDrvierEX getDriver() {
        return driver;
    }
}