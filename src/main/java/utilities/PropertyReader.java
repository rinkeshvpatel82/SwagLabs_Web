package utilities;

public class PropertyReader extends PropertyManager {

  public static String getLoginUrl() {
    return get("loginUrl");
  }

  public static String getBrowserName() {
    return get("browser");
  }

  public static String getPassword() {
    return get("password");
  }

  public static String getFirstName() {
    return get("firstName");
  }

  public static String getLastName() {
    return get("lastName");
  }

  public static String getPostalCode() {
    return get("postCode");
  }

  public static String getPaymentInfo() {
    return get("paymentInfo");
  }

  public static String getShippingInfo() {
    return get("shippingInfo");
  }
}