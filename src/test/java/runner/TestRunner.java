package runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
import org.testng.annotations.AfterClass;

import java.awt.*;
import java.io.File;
import java.io.IOException;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/features/",
        glue = { "stepDefinitions" },
        plugin = {"json:target/cucumber.json"},
        tags = "not @ignore"


)
public class TestRunner {
}
