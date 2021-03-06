package com.selenium.day01;

// Generated by Selenium IDE

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class HupuTest {
    private WebDriver driver;
    private Map<String, Object> vars;
    JavascriptExecutor js;
    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver","G:\\driver\\chromedriver.exe");
       // System.setProperty("webdriver.firefox.bin","G:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe");
        driver = new ChromeDriver();
        js = (JavascriptExecutor) driver;
        vars = new HashMap<String, Object>();
    }
    @After
    public void tearDown() {
        driver.quit();
    }
    public String waitForWindow(int timeout) {
        try {
            Thread.sleep(timeout);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Set<String> whNow = driver.getWindowHandles();
        Set<String> whThen = (Set<String>) vars.get("window_handles");
        if (whNow.size() > whThen.size()) {
            whNow.removeAll(whThen);
        }
        return whNow.iterator().next();
    }

    @Test
    public void testContextClick() throws Exception{
        driver.get("https://www.baidu.com");
        WebElement su = driver.findElement(By.id("su"));
        Actions actions = new Actions(driver);
        actions.contextClick(su).perform();
        Thread.sleep(2000);
        actions.contextClick(su).doubleClick();
        Thread.sleep(2000);
    }

    @Test
    public void selectTest() throws Exception{
        driver.get("D:\\测试\\全家桶\\02.Web自动化selenium(java语言版）\\源码\\webdriver_demo\\selenium_html\\index.html");
        driver.manage().window().maximize();
        Select moreSelect = new Select(driver.findElement(By.id("moreSelect")));
        moreSelect.selectByValue("oppe");
        Thread.sleep(2000);
        WebElement identity = driver.findElement(By.name("identity"));
        identity.click();
        System.out.println(identity.isSelected());
        Thread.sleep(2000);
        driver.findElement(By.name("checkbox1")).click();
        driver.findElement(By.name("checkbox2")).click();
        Thread.sleep(3000);
        WebElement multiple = driver.findElement(By.id("selectWithMultipleEqualsMultiple"));
        List<WebElement> options = multiple.findElements(By.tagName("option"));



        Actions actions = new Actions(driver);
        actions.keyDown(Keys.SHIFT).click(options.get(0)).click(options.get(2)).perform();

        Thread.sleep(3000);
        vars.put("window_handles",driver.getWindowHandles());
        driver.findElement(By.linkText("Open new window")).click();
        vars.put("win1",waitForWindow(1000));
        vars.put("root",driver.getWindowHandle());
        driver.switchTo().window(vars.get("win1").toString());
        driver.findElement(By.id("user")).sendKeys("helloworld");
        Thread.sleep(3000);
        driver.close();

        driver.switchTo().window(vars.get("root").toString());
        driver.switchTo().frame("aa");
        driver.findElement(By.id("user")).sendKeys("helloworld");
        Thread.sleep(3000);
        driver.close();
        Thread.sleep(3000);
    }

    @Test
    public void hupu() {
        // Test name: hupu
        // Step # | name | target | value
        // 1 | open | / |
        driver.get("https://www.hupu.com/");
        // 2 | setWindowSize | 1550x848 |
        driver.manage().window().setSize(new Dimension(1550, 848));
        // 3 | click | linkText=NBA |
        vars.put("window_handles", driver.getWindowHandles());
        // 4 | storeWindowHandle | root |
        driver.findElement(By.linkText("NBA")).click();
        // 5 | selectWindow | handle=${win8999} |
        vars.put("win8999", waitForWindow(2000));
        // 6 | click | id=ui-id-13 |
        vars.put("root", driver.getWindowHandle());
        // 7 | selectWindow | handle=${win6523} |
        driver.switchTo().window(vars.get("win8999").toString());
        // 8 | click | linkText=战绩排行 |
        vars.put("window_handles", driver.getWindowHandles());
        // 9 | close |  |
        driver.findElement(By.id("ui-id-13")).click();
        // 10 | selectWindow | handle=${win8999} |
        vars.put("win6523", waitForWindow(2000));
        // 11 | close |  |
        driver.switchTo().window(vars.get("win6523").toString());
        // 12 | selectWindow | handle=${root} |
        driver.findElement(By.linkText("战绩排行")).click();
        driver.close();
        driver.switchTo().window(vars.get("win8999").toString());
        driver.findElement(By.id("search")).sendKeys("james");
        waitForWindow(1000);
        driver.close();
        driver.switchTo().window(vars.get("root").toString());

    }

    @Test
    public void testCtrl() throws Exception{
        driver.get("D:\\测试\\全家桶\\02.Web自动化selenium(java语言版）\\源码\\webdriver_demo\\selenium_html\\index.html");
        WebElement select = driver.findElement(By.id("selectWithMultipleEqualsMultiple"));
        List<WebElement> options = select.findElements(By.tagName("option"));
        Robot robot = new Robot();
        robot.keyPress(KeyEvent.VK_CONTROL);
        options.get(1).click();
        Thread.sleep(5000);
        options.get(2).click();
        Thread.sleep(5000);
        options.get(3).click();
        robot.keyRelease(KeyEvent.VK_CONVERT);
        Thread.sleep(4000);
    }
}
