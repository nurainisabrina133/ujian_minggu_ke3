package com.ujian.pertemuan15;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class LoginTest {

    WebDriver driver;
    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/Users/sabrinalin13/Downloads/chromedriver_mac_arm64/chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    @Test(priority = 1)
    public void tesUrl() {

        String url = "https://shop.demoqa.com/my-account/";
        driver.get(url);
        System.out.println("Get URL");
        driver.manage().window().maximize();
        System.out.println("Maximize Browser");
        String TitleHeader = driver.getTitle();
        System.out.println("ini header judul website: " + TitleHeader);
        //stop verify
        Assert.assertEquals(TitleHeader, "My Account – ToolsQA Demo Site");

    }

    @Test(priority = 2)
    public void testFormIdentity() {
        delay(4);
        WebElement fullName = driver.findElement(By.name("username"));
        fullName.sendKeys("Adminoooooooooo");
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("fhguiy8oiuioj");

        // Submit
        WebElement signUp = driver.findElement(By.xpath("//button[@name='login']"));
        signUp.click();
        System.out.println("Login Berhasil");

        WebElement signU1 = driver.findElement(By.xpath("//span[contains(text(),'ToolsQA Demo Site')]"));
        signU1.click();
        System.out.println("Shopping Time");

    }

    @Test(priority = 3)
    public void addToCart(){
        WebElement addTo = driver.findElement(By.xpath("//a[normalize-space()='pink drop shoulder oversized t shirt']"));
        addTo.click();
        WebElement selectColor = driver.findElement(By.id("pa_color"));
        Select color = new Select(selectColor);
        color.selectByValue("pink");

        WebElement selectSize = driver.findElement(By.id("pa_size"));
        Select size = new Select(selectSize);
        size.selectByValue("37");

        WebElement selectCart = driver.findElement(By.xpath("//button[normalize-space()='Add to cart']"));
        selectCart.click();
        System.out.println("Baju sudah di masukan ke keranjang");
    }

    @AfterClass
    public void quitBrowser() {
        System.out.println("Delay 5 s");
        delay(3);
        driver.quit();
        System.out.println("Quit Browser");
    }
    public static void delay(long detik){
        try {
            Thread.sleep(detik*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}