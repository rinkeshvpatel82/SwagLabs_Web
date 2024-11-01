package SwagLabsPages;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.BrowserUtilities;
import utilities.PropertyReader;

public class LoginPage extends BrowserUtilities {
  public static final String userName_ById = "user-name";
  public static final String password_ById = "password";
  public static final String loginButton_ByClass = "btn_action";
  public static final String error_ByCss = " h3[data-test='error']";
  public static final String productsPageTitleTxt_ByCss = ".product_label";
  public static final String yourCartPageTitleTxt_ByCss = ".subheader";
  public static final String expectedCheckoutPageTitleTxt = "Checkout: Your Information";
  public static final String swaglabsLogo_ByClass = "login_logo";
  private static final String expectedCheckoutOverViewPageTitleTxt = "Checkout: Overview";
  private final By swagLabsLogo = By.className(swaglabsLogo_ByClass);
  private final By productPageTitleTxt = By.cssSelector(productsPageTitleTxt_ByCss);
  private final By yourCartPageTitleTxt = By.cssSelector(yourCartPageTitleTxt_ByCss);
  private final By userNameField = By.id(userName_ById);
  private final By passwordField = By.id(password_ById);
  private final By loginBtnButton = By.className(loginButton_ByClass);
  private final By loginError = By.cssSelector(error_ByCss);

  public LoginPage(WebDriver driver) {
    super(driver);
  }

  public boolean verifyThePageTitle(String expectedPageTitleTxt) {
    switch (expectedPageTitleTxt) {
      case "login":
        {
          waitForElementToVisible(swagLabsLogo, 5);
          assertThat(findElement(swagLabsLogo).isDisplayed(), is(true));
          return true;
        }
      case "Products":
        {
          waitForElementToVisible(productPageTitleTxt, 5);
          String actualPageTxt = findElement(productPageTitleTxt).getText();
          Assert.assertEquals(expectedPageTitleTxt, actualPageTxt);
          return true;
        }
      case "YourCart":
        {
          waitForElementToVisible(yourCartPageTitleTxt, 5);
          String actualPageTxt = findElement(yourCartPageTitleTxt).getText();
          Assert.assertEquals(expectedPageTitleTxt, actualPageTxt);
          return true;
        }
      case "Checkout":
        {
          waitForElementToVisible(yourCartPageTitleTxt, 5);
          String actualPageTxt = findElement(yourCartPageTitleTxt).getText();
          Assert.assertEquals(expectedCheckoutPageTitleTxt, actualPageTxt);
          return true;
        }
      case "Overview":
        {
          waitForElementToVisible(yourCartPageTitleTxt, 5);
          String actualPageTxt = findElement(yourCartPageTitleTxt).getText();
          Assert.assertEquals(expectedCheckoutOverViewPageTitleTxt, actualPageTxt);
          return true;
        }
    }
    return true;
  }

  public void enterValidUserName(String userName) {
    findElement(userNameField).sendKeys(userName);
  }

  public void enterValidPassword(String password) {
    findElement(passwordField).sendKeys(password);
  }

  public void clickOnLoginBtn() {
    findElement(loginBtnButton).click();
  }

  public boolean verifyTheLoginErrorMessage(String message) {

    String messageTxt = findElement(loginError).getText();
    String actualLoginError = messageTxt.split(": ")[1];
    Assert.assertEquals(message, actualLoginError);
    return true;
  }

  public void loginWithSpecifiedUser(String userName) {
    enterValidUserName(userName);
    findElement(passwordField).sendKeys(PropertyReader.getPassword());
    clickOnLoginBtn();
  }
}
