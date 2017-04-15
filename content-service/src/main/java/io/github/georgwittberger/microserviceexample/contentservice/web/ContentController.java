package io.github.georgwittberger.microserviceexample.contentservice.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ContentController {
  @GetMapping("/")
  public String viewHomePage() {
    return "index";
  }

  @GetMapping("/product/{seoName}")
  public String viewProductPage(@PathVariable("seoName") String seoName, Model model) {
    model.addAttribute("seoName", seoName);
    return "product";
  }

  @GetMapping("/cart")
  public String viewCartPage() {
    return "cart";
  }
}
