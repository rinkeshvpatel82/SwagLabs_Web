package StepDefinitions;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import SwagLabsPages.CheckOutPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import java.util.List;
import org.openqa.selenium.WebDriver;

public class CheckOutStepDefs {
  private final WebDriver driver;
  private final CheckOutPage checkOutPage;

  public CheckOutStepDefs(Hooks hooksDriver) {
    driver = hooksDriver.getDriver();
    checkOutPage = new CheckOutPage(driver);
  }

  @And("^the user add the personal information.$")
  public void theUserAddThePersonalInformation() {
    checkOutPage.enterPersonalInformation();
  }

  @And("^the user click on continue button.$")
  public void theUserClickOnContinueButton() {
    checkOutPage.clickOnButton();
  }

  @And("the user should be able to re-verify the products with price.")
  public void theUserShouldBeAbleToRe_verifyTheProductsWithPrise(DataTable dataTable) {
    List<List<String>> userList = dataTable.asLists(String.class);
    for (List<String> product : userList) {
      checkOutPage.verifyTheAllTheProductsWithTheirPrices(product);
    }
  }

  @And("^the user should be able to verify the payment information.$")
  public void theUserShouldBeAbleToVerifyThePaymentInformation() {
    assertThat(checkOutPage.verifyPaymentInformation(), is(true));
  }

  @And("^the user should be able to verify the shipping information.$")
  public void theUserShouldBeAbleToVerifyTheShippingInformation() {
    assertThat(checkOutPage.verifyShippingInformation(), is(true));
  }

  @And("^the user should be able to verify the total price payable with tax.$")
  public void theUserShouldBeAbleToVerifyTheTotalPricePayableWithTax() {
    assertThat(checkOutPage.verifyTheTotalPricePayable(), is(true));
  }
}