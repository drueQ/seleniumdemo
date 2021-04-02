package com.selenium.day01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.Map;

public class PhantomJsTest {

    private PhantomJSDriver driver;
    private Map<String,Object> vars;

    @BeforeTest
    public void setUp(){
        System.setProperty("phantomjs.binary.path","G:\\driver\\phantomjs-2.1.1-windows\\bin\\phantomjs.exe");
        driver=new PhantomJSDriver();
    }

    @Test
    public void testPhantomJS(){
        driver.get("https://www.baidu.com");
        String title = driver.getTitle();
        System.out.println(title);
    }

    @AfterTest
    public void tearDown(){
        driver.quit();
    }

}
