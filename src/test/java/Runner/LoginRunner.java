package Runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
@CucumberOptions(
        features = {"src/test/java/Feature/deneme.feature"},
        glue = {"Steps"},
        dryRun = false
)
public class LoginRunner  extends AbstractTestNGCucumberTests {



}
