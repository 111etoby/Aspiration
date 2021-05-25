package com.google;

import com.google.base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchDucksInGoogle3Test extends BaseTest {

    final String task = "ducks";

    @Test
    public void testSearchDucksInGoogle3() {
        WebElement input = driver.findElement(By.className("gLFyf"));
        input.sendKeys(task);
        input.sendKeys(Keys.ENTER);

        boolean result = driver.getPageSource().contains(task);
        Assert.assertTrue(result);
    }
}
