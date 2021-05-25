package com.google.testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/com/google/Features/GoogleSearch.feature",
        glue = "com/google/stepDefinition"
)
public class TestRunner {
}
