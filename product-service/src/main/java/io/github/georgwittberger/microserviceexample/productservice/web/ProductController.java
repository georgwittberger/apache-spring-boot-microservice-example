package io.github.georgwittberger.microserviceexample.productservice.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import io.github.georgwittberger.microserviceexample.productservice.product.ProductService;

@Controller
@RequestMapping("/product")
public class ProductController {
  @Autowired
  private ProductService productService;

  @GetMapping(value = "/{seoName}", produces = MediaType.TEXT_HTML_VALUE)
  public String viewProductHTML(@PathVariable("seoName") String seoName, Model model) {
    model.addAttribute("product", productService.getProductBySeoName(seoName));
    return "product";
  }
}
