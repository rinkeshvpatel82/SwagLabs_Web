package SwagLabsPages;

import java.util.List;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.BrowserUtilities;
import utilities.PropertyReader;

public class CheckOutPage extends BrowserUtilities {
  public static final String firstName_ById = "first-name";
  public static final String lastName_ById = "last-name";
  public static final String postalCode_ById = "postal-code";
  public static final String continueBtn_ByXpath = "//input[@value='CONTINUE']";
  public static final String product1PriceValue_ByXpath =
      "//a[@id='item_0_title_link']/div[1]/../../div[2]";
  public static final String product5PriceValue_ByXpath =
      "//a[@id='item_4_title_link']/div[1]/../../div[2]";
  public static final String paymentAndShippingInfo_ByClass = "summary_value_label";
  public static final String paymentSummary_ByXpath =
      "//div[@class='summary_" + "$TOTAL$" + "_label']";
  private final By firstNameField = By.id(firstName_ById);
  private final By lastNameField = By.id(lastName_ById);
  private final By postalCodeField = By.id(postalCode_ById);
  private final By continueBtn = By.xpath(continueBtn_ByXpath);
  private final By product1NameTxt = By.xpath(ProductsPage.product1NameTxt_ByXpath);
  private final By product1PriceValue = By.xpath(product1PriceValue_ByXpath);
  private final By product5NameTxt = By.xpath(ProductsPage.product5NameTxt_ByXpath);
  private final By product5PriceValue = By.xpath(product5PriceValue_ByXpath);
  private final By paymentAndShippingInfo = By.className(paymentAndShippingInfo_ByClass);
  private String product1Price;
  private String product5Price;

  public CheckOutPage(WebDriver driver) {
    super(driver);
  }

  public void enterPersonalInformation() {
    findElement(firstNameField).sendKeys(PropertyReader.getFirstName());
    findElement(lastNameField).sendKeys(PropertyReader.getLastName());
    findElement(postalCodeField).sendKeys(PropertyReader.getPostalCode());
  }

  public void clickOnButton() {
    findElement(continueBtn).click();
  }

  public void verifyTheAllTheProductsWithTheirPrices(List<String> productWithPrice) {
    String productWithPriceSubA = productWithPrice.toString();
    String productWithPriceSub = productWithPriceSubA.split("\\[")[1];
    String subSt = productWithPriceSub.split("]")[0];
    String expectedProductWithPrice = subSt.replace(", ", " ");
    if (expectedProductWithPrice.contains("Sauce Labs Bike Light")) {
      String product1Name = findElement(product1NameTxt).getText();
      product1Price = findElement(product1PriceValue).getText();
      Assert.assertEquals(expectedProductWithPrice, product1Name + " " + product1Price);
    } else if (expectedProductWithPrice.contains("Sauce Labs Backpack")) {
      String product5Name = findElement(product5NameTxt).getText();
      product5Price = findElement(product5PriceValue).getText();
      Assert.assertEquals(expectedProductWithPrice, product5Name + " " + product5Price);
    } else {
      System.out.println("Block in not in use.");
    }
  }

  public boolean verifyPaymentInformation() {
    String actualPaymentInfo = findElements(paymentAndShippingInfo).get(0).getText();
    System.out.println("Payment info :- " + actualPaymentInfo);
    Assert.assertEquals(PropertyReader.getPaymentInfo(), actualPaymentInfo);
    return true;
  }

  public boolean verifyShippingInformation() {
    String actualShippingInfo = findElements(paymentAndShippingInfo).get(1).getText();
    System.out.println("Payment info :- " + actualShippingInfo);
    Assert.assertEquals(PropertyReader.getShippingInfo(), actualShippingInfo);
    return true;
  }

  public boolean verifyTheTotalPricePayable() {
    String item1 = product1Price.split("\\$")[1];
    String item2 = product5Price.split("\\$")[1];
    double product1PriceD = Double.parseDouble(item1);
    double product5priceD = Double.parseDouble(item2);
    double itemTotal = product1PriceD + product5priceD;
    String taxTxt =
        findElement(By.xpath(paymentSummary_ByXpath.replace("$TOTAL$", "tax"))).getText();
    String actualTaxPrice = taxTxt.split("\\$")[1];
    double taxD = Double.parseDouble(actualTaxPrice);
    double total = itemTotal + taxD;
    String itemPriceTxt =
        findElement(By.xpath(paymentSummary_ByXpath.replace("$TOTAL$", "subtotal"))).getText();
    String actualItemPrice = itemPriceTxt.split(": ")[1];
    String expectedItemPrice = String.valueOf(itemTotal);
    Assert.assertEquals("$" + expectedItemPrice, actualItemPrice);
    String totalPriceTxt =
        findElement(By.xpath(paymentSummary_ByXpath.replace("$TOTAL$", "total"))).getText();
    String actualTotalPrice = totalPriceTxt.split(": ")[1];
    String expectedTotalPrice = String.valueOf(total);
    Assert.assertEquals("$" + expectedTotalPrice, actualTotalPrice);
    return true;
  }
}
