package StepDefinitions;

import SwagLabsPages.FinishPage;
import io.cucumber.java.en.And;
import org.openqa.selenium.WebDriver;

public class FinishStepDefs {
  private final WebDriver driver;
  private final FinishPage finishPage;

  public FinishStepDefs(Hooks hooksDriver) {
    driver = hooksDriver.getDriver();
    finishPage = new FinishPage(driver);
  }

  @And("^the user logout successfully.$")
  public void theUserLogoutSuccessfully() {
    finishPage.userLogout();
  }
}