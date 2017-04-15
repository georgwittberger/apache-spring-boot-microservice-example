package io.github.georgwittberger.microserviceexample.cartservice.product;

import java.math.BigDecimal;

public class Product {
  private String name;
  private String seoName;
  private String description;
  private BigDecimal price;

  public Product() {
  }

  public Product(String name, String seoName, String description, BigDecimal price) {
    this.name = name;
    this.seoName = seoName;
    this.description = description;
    this.price = price;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getSeoName() {
    return seoName;
  }

  public void setSeoName(String seoName) {
    this.seoName = seoName;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public BigDecimal getPrice() {
    return price;
  }

  public void setPrice(BigDecimal price) {
    this.price = price;
  }

  @Override
  public String toString() {
    return "Product [name=" + name + ", seoName=" + seoName + ", description=" + description + ", price=" + price + "]";
  }
}
