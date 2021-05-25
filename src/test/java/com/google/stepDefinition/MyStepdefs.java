package com.google.stepDefinition;

import io.cucumber.java.*;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class MyStepdefs {

    private static final String WIKI_FORMAT = "%s - Wikipedia";
    private static final String GOOGLE_TITLE_FORMAT = "%s - Google Search";

    private WebDriver driver;
    private String word;

    @Before
    public void iLaunchChromeBrowser() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @When("I open {string}")
    public void iOpenGoogle(String url) {
        driver.get(url);
    }

    @Then("I input search word: {string}")
    public void iInputSearchWord(String word) {
        WebElement input = driver.findElement(By.className("gLFyf"));
        input.sendKeys(word + "\n");

        this.word = word;
    }

    @And("I verify that search result include Wikipedia link by {string}")
    public void iVerifyThatSearchResult(String name) {
        final String str = String.format(WIKI_FORMAT, name);
        WebElement result = driver.findElement(By.xpath(String.format("//h3[contains(text(),'%s')]", str)));
        Assert.assertEquals(result.getText(), str);
    }

    @Then("I input search word {string} and click Enter on the keyboard")
    public void iInputSearchWordAndClickOnTheKeyboard(String word) {
        WebElement input = driver.findElement(By.className("gLFyf"));
        input.sendKeys(word);
        input.sendKeys(Keys.ENTER);

        this.word = word;
    }

    @And("I verify that search result include Wikipedia link by {string} \\(second way)")
    public void iVerifyThatSearchResultIncludeWikipediaLinkSecondWay(String name) {
        final String str = String.format(WIKI_FORMAT, name);
        WebElement result = driver.findElement(By.xpath(String.format("//h3[contains(text(),'%s')]", str)));
        Assert.assertEquals(result.getText(), str);
    }

    @And("I verify that there is a search word on the page with the search result")
    public void iVerifyThatThereIsASearchWordOnThePageWithTheSearchResult() {
        boolean result = driver.getPageSource().contains(word);
        Assert.assertTrue(result);
    }

    @And("I verify that the title of the page contains the search word")
    public void iVerifyThatTheTitleOfThePageContainsTheSearchWord() {
        String title = driver.getTitle();
        Assert.assertEquals(title, String.format(GOOGLE_TITLE_FORMAT, word));
    }

    @After
    public void iCloseBrowser() {
        driver.quit();
    }
}