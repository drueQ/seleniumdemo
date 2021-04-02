package com.selenium.day01;

import com.selenium.tools.SeleniumTools;
import org.junit.After;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

public class Mail163 {

    private WebDriver driver;
    private Map<String , Object> vars;
    JavascriptExecutor js;

    @BeforeTest
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","G:\\driver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://mail.163.com");
        vars = new HashMap<String, Object>();
    }

    @Test
    public void register() throws Exception{
       // System.out.println(driver.getWindowHandle());
        vars.put("window_handles",driver.getWindowHandles());
        driver.findElement(By.linkText("注册网易邮箱")).click();
        vars.put("register", SeleniumTools.waitForWindow(driver,vars));
        //Thread.sleep(2000);

        driver.switchTo().window(vars.get("register").toString());

        //显示等待
        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("立即注册")));

        driver.findElement(By.id("username")).sendKeys("drue18124936640");
        driver.findElement(By.id("password")).sendKeys("qjw8157789");
        driver.findElement(By.id("phone")).sendKeys("18124936640");
        WebElement element = driver.findElement(By.xpath("//*[@id=\"service\"]"));

        //#判断元素是否可见，True表示可见，False表示隐藏
        System.out.println(element.isDisplayed());

        //对于隐藏的元素是不可以直接调用的。但是可以通过JS进行调用，方法如下
        js=(JavascriptExecutor) driver;
        js.executeScript("document.getElementById(\"service\").click()");
        Thread.sleep(2000);
        driver.findElement(By.className("j-register")).click();


    }

    @Test
    public void login(){
        System.out.println(driver.getTitle());
        driver.switchTo().frame(0);
        driver.findElement(By.name("email")).sendKeys("drue18124936640");
        driver.findElement(By.name("password")).sendKeys("qjw8157789");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        driver.findElement(By.id("dologin")).click();

        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("spnUid")));
        String spnUid = driver.findElement(By.id("spnUid")).getText();
        Assert.assertEquals(spnUid,"drue18124936640@163.com");

    }

    @Test
    public void loginQQ(){
        driver.get("https://mail.qq.com/");
        System.out.println(driver.getTitle());
        driver.switchTo().frame(0);
        driver.findElement(By.name("u")).sendKeys("820699539");
        driver.findElement(By.name("p")).sendKeys("13457454249");
        driver.findElement(By.id("login_button")).click();
    }


    @Test
    public void sendMail(){

        System.out.println(driver.getTitle());
        driver.switchTo().frame(0);
        driver.findElement(By.name("email")).sendKeys("drue18124936640");
        driver.findElement(By.name("password")).sendKeys("qjw8157789");
        driver.findElement(By.id("dologin")).click();

        WebDriverWait wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("spnUid")));
        String spnUid = driver.findElement(By.id("spnUid")).getText();

        driver.findElement(By.xpath("//*[@id=\"dvNavTop\"]/ul/li[2]/span[2]")).click();
        //输入主题
        driver.findElement(By.xpath("//*[@aria-label=\"收件人地址输入框，请输入邮件地址，多人时地址请以分号隔开\"]")).
                sendKeys("drue18124936640@163.com");
        driver.findElement(By.xpath("//*[@aria-label=\"邮件主题输入框，请输入邮件主题\"]/input")).sendKeys("send to myself");

        driver.findElement(By.xpath("//*[@title=\"一次可发送2000张照片，600首MP3，一部高清电影\"]/input"))
                .sendKeys("C:\\Users\\Administrator\\Desktop\\tets.py");

        //定位iframe
        WebElement iframe = driver.findElement(By.className("APP-editor-iframe"));
        driver.switchTo().frame(iframe);
        driver.findElement(By.xpath("/html/body")).sendKeys("66666666666666" +
                "6666666666666666666666666666666666666666666666666666");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //发送
        driver.switchTo().defaultContent();
        driver.findElement(By.xpath("//*[text()=\"发送\"]")).click();
        //driver.findElement(By.xpath("/html/body/div[9]/div[2]/div/div[2]/table/tbody/tr/td/div/input")).sendKeys("drue");
        Actions actions = new Actions(driver);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //actions.keyDown(Keys.ENTER).perform();
        driver.findElement(By.xpath("/html/body/div[9]/div[3]/div[2]/div[1]/span")).click();

    }

    @AfterTest
    public void tearDown(){
        //driver.quit();
    }

}
