package io.github.georgwittberger.microserviceexample.cartservice.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import io.github.georgwittberger.microserviceexample.cartservice.cart.Cart;
import io.github.georgwittberger.microserviceexample.cartservice.cart.CartService;

@Controller
public class CartController {
  @Autowired
  private CartService cartService;

  @GetMapping(value = "/view", produces = MediaType.TEXT_HTML_VALUE)
  public String viewCartHTML(Model model) {
    model.addAttribute("cart", cartService.getCart());
    return "cart";
  }

  @GetMapping(value = "/count", produces = MediaType.APPLICATION_JSON_VALUE)
  @ResponseBody
  public Integer viewLineItemCountJSON() {
    return cartService.getCart().getLineItems().size();
  }

  @GetMapping(value = "/add/{seoName}", produces = MediaType.APPLICATION_JSON_VALUE)
  @ResponseBody
  public Cart addLineItem(@PathVariable("seoName") String seoName) {
    return cartService.addLineItem(seoName);
  }
}
