package com.solera.blockchainquestionare.web;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.SourceType;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

@SpringBootTest
public class UITest {
    static WebDriver driver;

    @BeforeAll
    static void setUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Selenium\\ChromeDriver\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://localhost:3000/");
    }

    @Test
    void whenUserTryRespondQuestionare_withCorrectData_shouldSucess(){

        String oldUrl = driver.getCurrentUrl();

        driver.findElement(By.xpath("//body/div[@id='root']/div[1]/div[1]/div[1]/form[1]/div[1]/input[1]"))
                .sendKeys("angeles@gmail.com");

        driver.findElement(By.xpath("//span[contains(text(),'Go to Questionare')]"))
                .click();

        driver.get(driver.getCurrentUrl());

        driver.findElement(By.xpath("//button[contains(text(),'Fill Questionare')]"))
                .click();

        driver.findElement(By.xpath("//body[1]/div[1]/div[1]/main[1]/div[2]/button[4]"))
                .click();

        driver.findElement(By.xpath("//body[1]/div[1]/div[1]/main[1]/div[2]/button[4]"))
                .click();

        driver.findElement(By.xpath("//button[contains(text(),'See results')]"))
                .click();

        assertEquals("Your afinity is MAX",driver.findElement(By.cssSelector("body:nth-child(2) div:nth-child(2) " +
                "div:nth-child(1) h1:nth-child(1) > p:nth-child(1)")).getText());

    }

    @Test
    void whenUserHoverButton_withMouseHoveringIt_shouldChangeColor(){
        driver.findElement(By.xpath("//body/div[@id='root']/div[1]/div[1]/div[1]/form[1]/div[1]/input[1]"))
                .sendKeys("angeles@gmail.com");

        WebElement button = driver.findElement(By.xpath("//body/div[@id='root']/div[1]/div[1]/div[1]/form[1]/a[1]/button[1]"));

        String color = button.getCssValue("background-color");
        String stColor = Color.fromString(color).asHex();

        Actions actions = new Actions(driver);
        actions.moveToElement(button).perform();

        String newColor = driver.findElement(By.xpath("//body/div[@id='root']/div[1]/div[1]/div[1]/form[1]/a[1]/button[1]")).getCssValue("background-color");
        String newStColor = Color.fromString(newColor).asHex();

        assertNotEquals(stColor,newStColor);
    }

    @Test
    void whenUserClicksButton_withMouseLeftClick_shouldChange(){
        driver.findElement(By.xpath("//body/div[@id='root']/div[1]/div[1]/div[1]/form[1]/div[1]/input[1]"))
                .sendKeys("ANGELES");

        WebElement button = driver.findElement(By.xpath("//body/div[@id='root']/div[1]/div[1]/div[1]/form[1]/a[1]/button[1]"));

        String color = button.getCssValue("color");
        String stColor = Color.fromString(color).asHex();

        // Create an object of actions class and pass reference of WebDriver as a parameter to its constructor.
        Actions actions = new Actions(driver);

        // Move the cursor to the position of element C.
        actions.clickAndHold(button).perform();

        String newColor = driver.findElement(By.xpath("//body/div[@id='root']/div[1]/div[1]/div[1]/form[1]/a[1]/button[1]")).getCssValue("color");
        String newStColor = Color.fromString(newColor).asHex();

        assertNotEquals(stColor,newStColor);
    }

    @Test
    void whenUserEnterEmail_withInvalidEmail_shouldFail(){

        driver.findElement(By.xpath("//body/div[@id='root']/div[1]/div[1]/div[1]/form[1]/div[1]/input[1]"))
                .sendKeys("angeles@gmail");

        List<WebElement> dynamicElement = driver.findElements(By.xpath("//body/div[@id='root']/div[1]/div[1]/div[1]/form[1]/a[1]/button[1]"));

        assertEquals(0,dynamicElement.size());
    }

    @Test
    void whenUserEnterEmail_withValidEmail_shouldSucess(){

        driver.findElement(By.xpath("//body/div[@id='root']/div[1]/div[1]/div[1]/form[1]/div[1]/input[1]"))
                .sendKeys("angeles@gmail.com");

        List<WebElement> dynamicElement = driver.findElements(By.xpath("//body/div[@id='root']/div[1]/div[1]/div[1]/form[1]/a[1]/button[1]"));

        assertNotEquals(0,dynamicElement.size());
    }
}
