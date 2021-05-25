package com.google;

import com.google.base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SearchDucksInGoogle1Test extends BaseTest {

    @Test
    public void testSearchDucksInGoogle() {
        WebElement input = driver.findElement(By.className("gLFyf"));
        input.sendKeys("ducks\n");

        WebElement result = driver.findElement(By.xpath("//h3[contains(text(),'Duck - Wikipedia')]"));
        Assert.assertEquals(result.getText(), "Duck - Wikipedia");
    }
}
