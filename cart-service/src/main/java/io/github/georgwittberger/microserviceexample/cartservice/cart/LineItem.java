package io.github.georgwittberger.microserviceexample.cartservice.cart;

import java.math.BigDecimal;

public class LineItem {
  private final String productName;
  private final String productSeoName;
  private final BigDecimal productPrice;

  public LineItem(String productName, String productSeoName, BigDecimal productPrice) {
    this.productName = productName;
    this.productSeoName = productSeoName;
    this.productPrice = productPrice;
  }

  public String getProductName() {
    return productName;
  }

  public String getProductSeoName() {
    return productSeoName;
  }

  public BigDecimal getProductPrice() {
    return productPrice;
  }

  @Override
  public String toString() {
    return "LineItem [productName=" + productName + ", productSeoName=" + productSeoName + ", productPrice="
        + productPrice + "]";
  }
}
