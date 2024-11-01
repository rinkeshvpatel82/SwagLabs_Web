package StepDefinitions;

import SwagLabsPages.YourCartPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import java.util.List;
import org.openqa.selenium.WebDriver;

public class YourCartStepDefs {

  private final WebDriver driver;
  private final YourCartPage yourCartPage;

  public YourCartStepDefs(Hooks hooksDriver) {
    driver = hooksDriver.getDriver();
    yourCartPage = new YourCartPage(driver);
  }

  @And("^the user should be able to verify the products with price.$")
  public void theUserShouldBeAbleToVerifyTheProductsWithPrice(DataTable dataTable) {
    List<List<String>> userList = dataTable.asLists(String.class);
    for (List<String> product : userList) {
      yourCartPage.verifyTheAllTheProductsWithTheirPrices(product);
    }
  }

  @When("^the user click on \"([^\"]*)\" button.$")
  public void theUserClickOnButton(String button) {
    yourCartPage.clickOnButton(button);
  }
}