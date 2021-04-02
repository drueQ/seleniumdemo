package com.selenium.day01;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Test1 {



    public void beforeTest(){

    }


    public void AfterTest(){

    }

    public void beforeMethod(){

    }

    @Test
    public void TestCase1() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","G:\\driver\\chromedriver.exe");
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://www.baidu.com");
//        driver.get("http://www.hupu.com");
        driver.navigate().to("https://nba.hupu.com/");
        driver.navigate().back();
        driver.navigate().forward();
        driver. findElement(By.xpath("//*[@id=\"container\"]/div/div/div[2]/section/div/h2/div/ul/li/li[2]/a")).click();
        Thread.sleep(1000);
        WebElement element = driver.findElement(By.className("btn-login "));
        String href= element.getAttribute("href");
        String text = element.getText();
        Dimension size = element.getSize();
        String dimension = size.toString();
        System.out.println(dimension);
        System.out.println(text);
        System.out.println(href);
        String currentUrl = driver.getCurrentUrl();
        System.out.println(currentUrl);
        driver.switchTo().defaultContent();
        String currentUrl1 = driver.getCurrentUrl();
        System.out.println(currentUrl1);
        driver.close();
        Thread.sleep(1000);
        driver.quit();
    }

    public void AfterMethod(){

    }

}
