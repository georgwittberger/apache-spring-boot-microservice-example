package io.github.georgwittberger.microserviceexample.productservice.product;

import java.math.BigDecimal;

public class Product {
  private final String name;
  private final String seoName;
  private final String description;
  private final BigDecimal price;

  public Product(String name, String seoName, String description, BigDecimal price) {
    this.name = name;
    this.seoName = seoName;
    this.description = description;
    this.price = price;
  }

  public String getName() {
    return name;
  }

  public String getSeoName() {
    return seoName;
  }

  public String getDescription() {
    return description;
  }

  public BigDecimal getPrice() {
    return price;
  }

  @Override
  public String toString() {
    return "Product [name=" + name + ", seoName=" + seoName + ", description=" + description + ", price=" + price + "]";
  }
}
