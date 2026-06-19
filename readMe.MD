# DesignPatternDemo

Small automation project using Cucumber, TestNG and Selenium WebDriver.

## Prerequisites

- Java 11+ installed
- Maven installed
- Chrome browser installed (if running UI tests locally)
- Chromedriver in PATH (or managed by your driver manager)

## Run UI tests (local Chrome)

Use the following Maven command to run the UI tests with Chrome locally and filter by the `@login` tag:

```powershell
mvn clean test -Dbrowser=chrome -DUI_Execution=yes -DlocalExecution=yes -Dcucumber.filter.tags=@login
```

Notes:
- The project uses Cucumber with TestNG runners located under `src/test/java`.
- A rerun file (`reRun.txt`) is produced by the test runner when scenarios fail; use the `failedTestRunner` to re-run failed scenarios.

## Useful files

- `src/test/resources/UI/login.feature` - sample login feature
- `src/test/java/TestRunner.java` - main TestNG Cucumber runner
- `src/test/java/failedTestRunner.java` - runner for re-running failed scenarios

## Contact

If you need any help running the tests or updating drivers, open an issue or contact the repository owner.

