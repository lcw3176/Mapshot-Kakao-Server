package com.joebrooks.mapshotkakaoserver.Service;


import com.joebrooks.mapshotkakaoserver.Components.EXDriver;
import com.joebrooks.mapshotkakaoserver.Components.ExWaiter;
import com.joebrooks.mapshotkakaoserver.Utils.ChromeDrvierEX;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.stereotype.Service;

import javax.annotation.PreDestroy;

@Service
public class EXDriverService{
    private EXDriver drivers;
    private ExWaiter waiter;

    public EXDriverService(EXDriver drivers, ExWaiter waiter){
        this.drivers = drivers;
        this.waiter = waiter;
    }

    public WebDriverWait getWaiter() {
        return waiter.getWaiter();
    }

    public ChromeDrvierEX getDriver() {
        return drivers.getDriver();
    }

    @PreDestroy
    public void close() {
        drivers.getDriver().quit();
    }

}