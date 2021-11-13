package parallel;

import io.cucumber.junit.Cucumber;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.junit.runner.RunWith;
import org.testng.annotations.DataProvider;

//@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/features"},
        glue = {"parallel"},
        plugin = {"json:target/cucumber.json", "html:target/html/cucumber-pretty"})
public class Parallelism extends AbstractTestNGCucumberTests {


    @DataProvider(parallel = true)
    @Override
    public java.lang.Object[][] scenarios() {
        return super.scenarios();
    }
}
