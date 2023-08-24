package com.github.prestashop.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/com/github/prestashop/features",
        glue = {
                "com/github/prestashop/steps",
                "com/github/prestashop/hooks",
                "com/github/prestashop/transformations"
        },
        plugin = {"io.qameta.allure.cucumber5jvm.AllureCucumber5Jvm"}
)
public class TestRunner {
}

