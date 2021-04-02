package com.selenium.day01;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FirefoxTest {

    private WebDriver driver;
    private Map<String, Object> vars;
    JavascriptExecutor js;

    @BeforeTest
    public void setUp() {
        //这里就是自己装的火狐路径
        System.setProperty("webdriver.firefox.bin","G:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
        //firefox46之后需要手动设置driver
        System.setProperty("webdriver.gecko.driver", "G:\\driver\\geckodriver.exe");
        driver = new FirefoxDriver();
        js = (JavascriptExecutor) driver;
        vars = new HashMap<String, Object>();
    }

    @Test
    public void test(){
        driver.get("https://www.hupu.com");
    }


    public void tearDown(){
        driver.quit();
    }

}
