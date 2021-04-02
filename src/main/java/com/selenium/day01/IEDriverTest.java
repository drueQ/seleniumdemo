package com.selenium.day01;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class IEDriverTest {

    private WebDriver driver;
    private Map<String, Object> vars;
    JavascriptExecutor js;

    @BeforeTest
    public void setUp(){
        System.setProperty("webdriver.ie.driver","G:\\driver\\IEDriverServer.exe");
        driver = new InternetExplorerDriver();
        //driver.manage().window().maximize();
        driver.get("https://mail.163.com");
        vars = new HashMap<String, Object>();
    }

    @Test
    public void IEtest(){
        System.out.println(driver.getTitle());
    }

    @AfterTest
    public void AfterTest(){

    }

}
