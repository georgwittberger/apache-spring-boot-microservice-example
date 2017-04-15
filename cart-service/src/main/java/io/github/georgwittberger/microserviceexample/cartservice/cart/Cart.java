package io.github.georgwittberger.microserviceexample.cartservice.cart;

import java.util.ArrayList;
import java.util.List;

public class Cart {
  private final List<LineItem> lineItems = new ArrayList<>();

  public List<LineItem> getLineItems() {
    return lineItems;
  }

  public void addLineItem(LineItem lineItem) {
    lineItems.add(lineItem);
  }

  @Override
  public String toString() {
    return "Cart [lineItems=" + lineItems + "]";
  }
}
