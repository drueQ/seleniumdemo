package com.selenium.day02;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class GridTest {


    @DataProvider(name = "data")
    public Object[][] createParam(){
        return new Object[][]{{"IE","http://192.168.246.1:4444"},
                {"chrome","http://192.168.246.1:4444"},
                {"firefox","http://192.168.246.1:4444"}};
    }


    @Test(dataProvider = "data")
    public void test1(String b,String url) throws MalformedURLException {
        DesiredCapabilities dc;
        if (b.equals("IE")){
            dc = DesiredCapabilities.internetExplorer();
        }else if (b.equals("chrome")){
            dc = DesiredCapabilities.chrome();
        }else {
            dc = DesiredCapabilities.firefox();
        }
        RemoteWebDriver driver = new RemoteWebDriver(new URL("http://192.168.246.1:4444/wd/hub"), dc);
        driver.get("https://www.hupu.com");
        System.out.println(driver.getTitle());
    }

}
