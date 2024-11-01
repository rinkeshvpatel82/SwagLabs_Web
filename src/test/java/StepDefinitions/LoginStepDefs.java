package StepDefinitions;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import SwagLabsPages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class LoginStepDefs {

  private final WebDriver driver;
  private final LoginPage loginPage;

  public LoginStepDefs(Hooks hooksDriver) {
    driver = hooksDriver.getDriver();
    loginPage = new LoginPage(driver);
  }

  @Given("^the user is on the Swaglabs login page.$")
  public void theUserIsOnTheSwaglabsLoginPage() {
    assertThat(loginPage.verifyThePageTitle("login"), is(true));
  }

  @When("^the user enter valid username as a \"([^\"]*)\".$")
  public void theUserEnterValidUsernameAsA(String userName) {
    loginPage.enterValidUserName(userName);
  }

  @And("^the user enter valid password as a \"([^\"]*)\".$")
  public void theUserEnterValidPasswordAsA(String password) {
    loginPage.enterValidPassword(password);
  }

  @And("^the user click on login button.$")
  public void theUserClickOnLoginButton() {
    loginPage.clickOnLoginBtn();
  }

  @And("^the user login with \"([^\"]*)\".$")
  public void theUserLoginWith(String userName) {
    loginPage.loginWithSpecifiedUser(userName);
    assertThat(loginPage.verifyThePageTitle("Products"), is(true));
  }

  @Then("^the user able to see the \"([^\"]*)\" message successfully.$")
  public void theUserAbleToSeeTheMessageSuccessfully(String errorMessage) {
    assertThat(loginPage.verifyTheLoginErrorMessage(errorMessage), is(true));
  }
}
