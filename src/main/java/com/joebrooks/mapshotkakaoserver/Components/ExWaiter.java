package com.joebrooks.mapshotkakaoserver.Components;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class ExWaiter {
    private EXDriver drivers;

    public ExWaiter(EXDriver drivers){
        this.drivers = drivers;
    }

    @Bean
    public WebDriverWait getWaiter() {
        return new WebDriverWait(drivers.getDriver(), 30);
    }
}
