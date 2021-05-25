package com.google;

import com.google.base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchDucksInGoogle2Test extends BaseTest {

    final String task = "ducks";
    final String expectedResult = "Duck - Wikipedia";
    @Test
    public void testSearchDucksInGoogle2() {
        WebElement input = driver.findElement(By.className("gLFyf"));
        input.sendKeys(task);
        input.sendKeys(Keys.ENTER);

        WebElement result = driver.findElement(By.xpath("//h3[contains(text(),'Duck - Wikipedia')]"));
        Assert.assertEquals(result.getText(),expectedResult);
    }
}
