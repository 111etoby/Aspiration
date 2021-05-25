package com.google;

import com.google.base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchDucksInGoogle4Test extends BaseTest {

    final String task = "ducks";
    final String expectedTitle = "ducks - Google Search";

    @Test
    public void testSearchDucksInGoogle4() {
        WebElement input = driver.findElement(By.className("gLFyf"));
        input.sendKeys(task);
        input.sendKeys(Keys.ENTER);

        String title = driver.getTitle();
        Assert.assertEquals(title, expectedTitle);
    }
}
