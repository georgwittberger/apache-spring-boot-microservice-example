package io.github.georgwittberger.microserviceexample.cartservice.web;

import io.github.georgwittberger.microserviceexample.cartservice.cart.Cart;
import io.github.georgwittberger.microserviceexample.cartservice.cart.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CartController {
  @Autowired
  private CartService cartService;

  @GetMapping("/")
  public String viewCart(Model model) {
    model.addAttribute("cart", cartService.getCart());
    return "cart";
  }

  @GetMapping(value = "/count")
  @ResponseBody
  public Integer viewLineItemCount() {
    return cartService.getCart().getLineItems().size();
  }

  @GetMapping(value = "/add/{seoName}")
  @ResponseBody
  public Cart addLineItem(@PathVariable("seoName") String seoName) {
    return cartService.addLineItem(seoName);
  }
}
