package io.github.georgwittberger.microserviceexample.cartservice.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import io.github.georgwittberger.microserviceexample.cartservice.cart.Cart;
import io.github.georgwittberger.microserviceexample.cartservice.cart.CartService;

@RestController
public class CartController {
  @Autowired
  private CartService cartService;

  @GetMapping(value = "/view")
  public Cart viewCart() {
    return cartService.getCart();
  }

  @GetMapping(value = "/count")
  public Integer viewLineItemCount() {
    return cartService.getCart().getLineItems().size();
  }

  @GetMapping(value = "/add/{seoName}")
  public Cart addLineItem(@PathVariable("seoName") String seoName) {
    return cartService.addLineItem(seoName);
  }
}
