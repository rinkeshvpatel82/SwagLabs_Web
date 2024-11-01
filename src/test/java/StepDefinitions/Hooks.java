package StepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import utilities.PropertyReader;

public class Hooks {
  private WebDriver driver;

  @Before
  public void setUp() {
    if (PropertyReader.getBrowserName().contains("chrome")) {
      ChromeOptions options = new ChromeOptions();
      options.setAcceptInsecureCerts(true);
      options.addArguments("--ignore-certificate-errors");
      options.addArguments("--window-size=1920,1080");
      options.addArguments("--headless");
      driver = new ChromeDriver(options);
      System.out.println("Created new chrome WebDriver");
    } else if (PropertyReader.getBrowserName().contains("firefox")) {
      FirefoxOptions options = new FirefoxOptions();
      options.setAcceptInsecureCerts(true);
      options.addArguments("--ignore-certificate-errors");
      options.addArguments("--window-size=1920,1080");
      options.addArguments("--headless");
      driver = new FirefoxDriver(options);
      System.out.println("Created new FireFox WebDriver");
    }
    driver.manage().window().maximize();
    driver.manage().deleteAllCookies();
    driver.get(PropertyReader.getLoginUrl());
    driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));
  }

  @After
  public void tearDown() {
    if (driver != null) {
      System.out.println("Termination webdriver");
      driver.quit();
    }
  }

  public WebDriver getDriver() {
    return driver;
  }
}
