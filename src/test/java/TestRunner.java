import io.cucumber.junit.Cucumber;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;
@CucumberOptions(
        features = "src/test/resources",
        glue={"stepDefinitions"},
        tags="@demo",
        plugin = {"rerun:reRun.txt"}

)
public class TestRunner extends AbstractTestNGCucumberTests
{
    @DataProvider(parallel = true)
    public Object[][] scenarios()
    {
        return super.scenarios();
    }
}
