import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = ".",tags="@regression",plugin = {
        "pretty", "json:target/cucumber.json"})
public class RunTest {
}
