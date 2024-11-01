package StepDefinitions;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import SwagLabsPages.LoginPage;
import SwagLabsPages.ProductsPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.util.List;
import org.openqa.selenium.WebDriver;

public class ProductsStepDefs {
  private final WebDriver driver;
  private final LoginPage loginPage;
  private final ProductsPage productsPage;

  public ProductsStepDefs(Hooks hooksDriver) {
    driver = hooksDriver.getDriver();
    loginPage = new LoginPage(driver);
    productsPage = new ProductsPage(driver);
  }

  @Then("^the user navigates to the \"([^\"]*)\" page successfully.$")
  public void theUserNavigatesToThePageSuccessfully(String page) {
    assertThat(loginPage.verifyThePageTitle(page), is(true));
  }

  @And("^the user click on cart icon.$")
  public void theUserClickOnCartIcon() {
    productsPage.clickOnShoppingCartIcon();
  }

  @Then("^the user should be able to verify the all the products with price.$")
  public void theUserShouldBeAbleToVerifyTheAllTheProductsWithPrice(DataTable dataTable) {
    List<List<String>> userList = dataTable.asLists(String.class);
    for (List<String> product : userList) {
      productsPage.verifyTheAllTheProductsWithTheirPrices(product);
    }
  }

  @When("^the user add product to the cart.$")
  public void theUserAddProductToTheCart() {
    assertThat(productsPage.verifyTheCartIsEmpty(), is(true));
    productsPage.addProductToTheCart();
  }

  @And("^the user verify the shopping count increase in the cart.$")
  public void theUserVerifyTheShoppingCountIncreaseInTheCart() {
    assertThat(productsPage.verifyThatProductQuantityIncreaseInTheCart(), is(true));
  }

  @And("^the user click on remove button to remove the product from cart.$")
  public void theUserClickOnRemoveButtonToRemoveTheProductFromCart() {
    productsPage.removeProductToTheCart();
  }

  @Then("^the user verify the empty shopping cart.$")
  public void theUserVerifyTheEmptyShoppingCart() {
    assertThat(productsPage.verifyTheCartIsEmpty(), is(true));
  }

  @When("^the user select the products by clicking on add to cart button from product list.$")
  public void theUserSelectTheProductsByClickingOnAddToCartButtonFromProductList(
      DataTable dataTable) {
    List<List<String>> userList = dataTable.asLists(String.class);
    for (List<String> product : userList) {
      productsPage.clickOnAddToCartButton(product);
    }
  }
}
