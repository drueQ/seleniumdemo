package com.selenium.tools;

import org.openqa.selenium.WebDriver;

import java.util.Map;
import java.util.Set;

public class SeleniumTools {


    public static String waitForWindow(WebDriver driver, Map<String,Object> vars)  {
        Set<String> whNow = driver.getWindowHandles();
        Set<String> whThen = (Set<String>) vars.get("window_handles");
        if (whNow.size() > whThen.size()) {
            whNow.removeAll(whThen);
        }
        return whNow.iterator().next();
    }
}
