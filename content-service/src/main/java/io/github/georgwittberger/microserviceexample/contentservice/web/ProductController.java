package io.github.georgwittberger.microserviceexample.contentservice.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/product")
public class ProductController {
  @GetMapping("/{seoName}")
  public String viewProduct(@PathVariable("seoName") String seoName, Model model) {
    model.addAttribute("seoName", seoName);
    return "product";
  }
}
