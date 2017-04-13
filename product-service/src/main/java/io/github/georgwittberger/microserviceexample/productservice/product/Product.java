package io.github.georgwittberger.microserviceexample.productservice.product;

import java.math.BigDecimal;

public class Product {
  private final String name;
  private final String description;
  private final BigDecimal price;

  public Product(String name, String description, BigDecimal price) {
    this.name = name;
    this.description = description;
    this.price = price;
  }

  public String getName() {
    return name;
  }

  public String getDescription() {
    return description;
  }

  public BigDecimal getPrice() {
    return price;
  }

  @Override
  public String toString() {
    return "Product [name=" + name + ", description=" + description + ", price=" + price + "]";
  }
}
