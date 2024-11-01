package SwagLabsPages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.BrowserUtilities;

public class FinishPage extends BrowserUtilities {
  public static final String burgerIcon_ByClass = "bm-burger-button";
  public static final String logOut_ById = "logout_sidebar_link";

  private final By burgerIcon = By.className(burgerIcon_ByClass);
  private final By logOut = By.id(logOut_ById);

  public FinishPage(WebDriver driver) {
    super(driver);
  }

  public void userLogout() {
    findElement(burgerIcon).click();
    findElement(logOut).click();
  }
}
