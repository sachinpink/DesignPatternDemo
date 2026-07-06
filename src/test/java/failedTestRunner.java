import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = {"@reRun.txt"},
        glue = "stepDefinitions",
        plugin = {"rerun:reRun.txt","pretty","io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"}
)
public class failedTestRunner extends AbstractTestNGCucumberTests {
    @DataProvider(parallel = true)
    public Object[][] scenarios()
    {
        return super.scenarios();
    }
}
