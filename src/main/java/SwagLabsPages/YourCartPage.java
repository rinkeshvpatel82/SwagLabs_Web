package SwagLabsPages;

import java.util.List;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.BrowserUtilities;

public class YourCartPage extends BrowserUtilities {
  public static final String product1PriceValue_ByXpath =
      "//a[@id='item_0_title_link']/div[1]/../../div[2]/div[1]";
  public static final String product4PriceValue_ByXpath =
      "//a[@id='item_3_title_link']/div[1]/../../div[2]/div[1]";
  public static final String product5PriceValue_ByXpath =
      "//a[@id='item_4_title_link']/div[1]/../../div[2]/div[1]";
  public static final String button_ByXpath = "//a[normalize-space()='$BUTTON$']";
  private final By product1NameTxt = By.xpath(ProductsPage.product1NameTxt_ByXpath);
  private final By product1PriceValue = By.xpath(product1PriceValue_ByXpath);
  private final By product4NameTxt = By.xpath(ProductsPage.product4NameTxt_ByXpath);
  private final By product4PriceValue = By.xpath(product4PriceValue_ByXpath);
  private final By product5NameTxt = By.xpath(ProductsPage.product5NameTxt_ByXpath);
  private final By product5PriceValue = By.xpath(product5PriceValue_ByXpath);

  public YourCartPage(WebDriver driver) {
    super(driver);
  }

  public void verifyTheAllTheProductsWithTheirPrices(List<String> productWithPrice) {
    String productWithPriceSubA = productWithPrice.toString();
    String productWithPriceSub = productWithPriceSubA.split("\\[")[1];
    String subSt = productWithPriceSub.split("]")[0];
    String expectedProductWithPrice = subSt.replace(", ", " ");
    if (expectedProductWithPrice.contains("Sauce Labs Bike Light")) {
      String product1Name = findElement(product1NameTxt).getText();
      String product1Price = findElement(product1PriceValue).getText();
      Assert.assertEquals(expectedProductWithPrice, product1Name + " " + "$" + product1Price);
    } else if (expectedProductWithPrice.contains("Sauce Labs Backpack")) {
      String product5Name = findElement(product5NameTxt).getText();
      String product5Price = findElement(product5PriceValue).getText();
      Assert.assertEquals(expectedProductWithPrice, product5Name + " " + "$" + product5Price);

    } else {
      String product4Name = findElement(product4NameTxt).getText();
      String product4Price = findElement(product4PriceValue).getText();
      Assert.assertEquals(expectedProductWithPrice, product4Name + " " + "$" + product4Price);
    }
  }

  public void clickOnButton(String button) {
    By buttonClick = By.xpath(button_ByXpath.replace("$BUTTON$", button));
    findElement(buttonClick).click();
  }
}
