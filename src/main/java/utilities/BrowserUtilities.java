package utilities;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BrowserUtilities {
  private final WebDriver driver;
  private final WebDriverWait wait;

  public BrowserUtilities(WebDriver driver) {
    this.driver = driver;
    this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
  }

  public WebDriverWait getWait(Duration timeOutInSeconds) {
    return new WebDriverWait(driver, timeOutInSeconds);
  }

  public void waitForElementToBeClickable(By locator, long timeOutSeconds) {
    waitForElement(ExpectedConditions.elementToBeClickable(locator), timeOutSeconds);
  }

  public void waitForElementToVisible(By locator, long timeInSeconds) {
    waitForElement(ExpectedConditions.visibilityOfElementLocated(locator), timeInSeconds);
    waitForElementToBeClickable(locator, timeInSeconds);
  }

  private <V> V waitForElement(ExpectedCondition<WebElement> condition, long second) {
    return (V) getWait(Duration.ofSeconds(second)).until(condition);
  }

  public WebElement findElement(By byLocator) {
    wait.until(ExpectedConditions.visibilityOfElementLocated(byLocator));
    WebElement element = driver.findElement(byLocator);
    highlightElement(element);
    return element;
  }

  public List<WebElement> findElements(By byLocator) {
    List<WebElement> elements = driver.findElements(byLocator);
    for (WebElement element : elements) {
      highlightElement(element);
    }
    return elements;
  }

  private void highlightElement(WebElement element) {
    executeScript("arguments[0].style.border='1px solid red'", element);
  }

  public Object executeScript(String script, Object... objects) {
    JavascriptExecutor js = (JavascriptExecutor) driver;
    return js.executeScript(script, objects);
  }
}
