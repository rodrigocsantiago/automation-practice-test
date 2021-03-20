package br.rsantiago.automation_practice.test.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        tags = "not @wip and not @quarantine",
        plugin = {"pretty", "html:target/reports/features.html"},
        features = {"src/test/resources/features"},
        glue = {"br.rsantiago.automation_practice.test.steps"}
)
public class TestRunner {
}
