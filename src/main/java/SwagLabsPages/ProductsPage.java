package SwagLabsPages;

import java.util.List;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.BrowserUtilities;

public class ProductsPage extends BrowserUtilities {
  public static final String product1NameTxt_ByXpath = "//a[@id='item_0_title_link']/div[1]";
  public static final String product1PriceValue_ByXpath =
      "//a[@id='item_0_title_link']/div[1]/../../../div[3]/div[1]";
  public static final String product2NameTxt_ByXpath = "//a[@id='item_1_title_link']/div[1]";
  public static final String product2PriceValue_ByXpath =
      "//a[@id='item_1_title_link']/div[1]/../../../div[3]/div[1]";
  public static final String product3NameTxt_ByXpath = "//a[@id='item_2_title_link']/div[1]";
  public static final String product3PriceValue_ByXpath =
      "//a[@id='item_2_title_link']/div[1]/../../../div[3]/div[1]";
  public static final String product4NameTxt_ByXpath = "//a[@id='item_3_title_link']/div[1]";
  public static final String product4PriceValue_ByXpath =
      "//a[@id='item_3_title_link']/div[1]/../../../div[3]/div[1]";
  public static final String product5NameTxt_ByXpath = "//a[@id='item_4_title_link']/div[1]";
  public static final String product5PriceValue_ByXpath =
      "//a[@id='item_4_title_link']/div[1]/../../../div[3]/div[1]";
  public static final String product6NameTxt_ByXpath = "//a[@id='item_5_title_link']/div[1]";
  public static final String product6PriceValue_ByXpath =
      "//a[@id='item_5_title_link']/div[1]/../../../div[3]/div[1]";
  public static final String shoppingCartIcon_ByCss = "svg[role='img']";
  public static final String shoppingCartCounter_ByCss = ".fa-layers-counter.shopping_cart_badge";
  public static final String product1AddToCart_RemoveButton_ByXpath =
      "//a[@id='item_0_title_link']/div[1]/../../../div[3]/button";
  public static final String product5AddToCart_RemoveButton_ByXpath =
      "//a[@id='item_4_title_link']/div[1]/../../../div[3]/button";

  private final By product1NameTxt = By.xpath(product1NameTxt_ByXpath);
  private final By product1PriceValue = By.xpath(product1PriceValue_ByXpath);
  private final By product2NameTxt = By.xpath(product2NameTxt_ByXpath);
  private final By product2PriceValue = By.xpath(product2PriceValue_ByXpath);
  private final By product3NameTxt = By.xpath(product3NameTxt_ByXpath);
  private final By product3PriceValue = By.xpath(product3PriceValue_ByXpath);
  private final By product4NameTxt = By.xpath(product4NameTxt_ByXpath);
  private final By product4PriceValue = By.xpath(product4PriceValue_ByXpath);
  private final By product5NameTxt = By.xpath(product5NameTxt_ByXpath);
  private final By product5PriceValue = By.xpath(product5PriceValue_ByXpath);
  private final By product6NameTxt = By.xpath(product6NameTxt_ByXpath);
  private final By product6PriceValue = By.xpath(product6PriceValue_ByXpath);
  private final By shoppingCartIcon = By.cssSelector(shoppingCartIcon_ByCss);
  private final By shoppingCartCounter = By.cssSelector(shoppingCartCounter_ByCss);
  private final By product1AddToCart_RemoveButton =
      By.xpath(product1AddToCart_RemoveButton_ByXpath);
  private final By product5AddToCart_RemoveButton =
      By.xpath(product5AddToCart_RemoveButton_ByXpath);

  public ProductsPage(WebDriver driver) {
    super(driver);
  }

  public void verifyTheAllTheProductsWithTheirPrices(List<String> productWithPrice) {
    String productWithPriceSubA = productWithPrice.toString();
    String productWithPriceSub = productWithPriceSubA.split("\\[")[1];
    String subSt = productWithPriceSub.split("]")[0];
    String expectedProductWithPrice = subSt.replace(", ", " ");
    if (productWithPrice.contains("Sauce Labs Bike Light")) {
      String product1Name = findElement(product1NameTxt).getText();
      String product1Price = findElement(product1PriceValue).getText();
      Assert.assertEquals(expectedProductWithPrice, product1Name + " " + product1Price);
    } else if (productWithPrice.contains("Sauce Labs Bolt T-Shirt")) {
      String product2Name = findElement(product2NameTxt).getText();
      String product2Price = findElement(product2PriceValue).getText();
      Assert.assertEquals(expectedProductWithPrice, product2Name + " " + product2Price);
    } else if (productWithPrice.contains("Sauce Labs Onesie")) {
      String product3Name = findElement(product3NameTxt).getText();
      String product3Price = findElement(product3PriceValue).getText();
      Assert.assertEquals(expectedProductWithPrice, product3Name + " " + product3Price);
    } else if (productWithPrice.contains("Sauce Labs Backpack")) {
      String product5Name = findElement(product5NameTxt).getText();
      String product5Price = findElement(product5PriceValue).getText();
      Assert.assertEquals(expectedProductWithPrice, product5Name + " " + product5Price);

    } else if (productWithPrice.contains("Sauce Labs Fleece Jacket")) {
      String product6Name = findElement(product6NameTxt).getText();
      String product6Price = findElement(product6PriceValue).getText();
      Assert.assertEquals(expectedProductWithPrice, product6Name + " " + product6Price);

    } else {
      String product4Name = findElement(product4NameTxt).getText();
      String product4Price = findElement(product4PriceValue).getText();
      Assert.assertEquals(expectedProductWithPrice, product4Name + " " + product4Price);
    }
  }

  public boolean verifyTheCartIsEmpty() {
    waitForElementToVisible(shoppingCartIcon, 5);
    return findElements(shoppingCartCounter).isEmpty();
  }

  public void addProductToTheCart() {
    findElement(product5AddToCart_RemoveButton).click();
  }

  public boolean verifyThatProductQuantityIncreaseInTheCart() {
    waitForElementToVisible(shoppingCartIcon, 5);
    String actualCounterValue = findElement(shoppingCartCounter).getText();
    Assert.assertEquals("1", actualCounterValue);
    return true;
  }

  public void removeProductToTheCart() {
    findElement(product5AddToCart_RemoveButton).click();
  }

  public void clickOnShoppingCartIcon() {
    findElement(shoppingCartIcon).click();
  }

  public void clickOnAddToCartButton(List<String> selectedProduct) {
    String productWithPriceSubA = selectedProduct.toString();
    String productWithPriceSub = productWithPriceSubA.split("\\[")[1];
    String subSt = productWithPriceSub.split("]")[0];
    String expectedProductWithPrice = subSt.replace(", ", " $");
    System.out.println("Abc:- " + expectedProductWithPrice);
    if (expectedProductWithPrice.contains("Sauce Labs Bike Light")) {
      String product1Name = findElement(product1NameTxt).getText();
      Assert.assertEquals("Sauce Labs Bike Light", product1Name);
      findElement(product1AddToCart_RemoveButton).click();
    } else if (expectedProductWithPrice.contains("Sauce Labs Backpack")) {
      String product5Name = findElement(product5NameTxt).getText();
      Assert.assertEquals("Sauce Labs Backpack", product5Name);
      findElement(product5AddToCart_RemoveButton).click();

    } else {
      System.out.println("No product were selected.");
    }
  }
}
