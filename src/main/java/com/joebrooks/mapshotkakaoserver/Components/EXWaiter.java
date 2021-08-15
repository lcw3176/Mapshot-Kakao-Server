package com.joebrooks.mapshotkakaoserver.Components;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class EXWaiter {
    private EXDriver drivers;

    public EXWaiter(EXDriver drivers){
        this.drivers = drivers;
    }

    @Bean
    public WebDriverWait getWaiter() {
        return new WebDriverWait(drivers.getDriver(), 30);
    }
}
