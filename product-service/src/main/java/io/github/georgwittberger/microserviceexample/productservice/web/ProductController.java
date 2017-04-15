package io.github.georgwittberger.microserviceexample.productservice.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import io.github.georgwittberger.microserviceexample.productservice.product.Product;
import io.github.georgwittberger.microserviceexample.productservice.product.ProductService;

@Controller
public class ProductController {
  @Autowired
  private ProductService productService;

  @GetMapping(value = "/products", produces = MediaType.TEXT_HTML_VALUE)
  public String viewProductsHTML(Model model) {
    model.addAttribute("products", productService.getProducts());
    return "products";
  }

  @GetMapping(value = "/products/{seoName}", produces = MediaType.TEXT_HTML_VALUE)
  public String viewProductHTML(@PathVariable("seoName") String seoName, Model model) {
    model.addAttribute("product", productService.getProductBySeoName(seoName));
    return "product";
  }

  @GetMapping(value = "/products/{seoName}", produces = MediaType.APPLICATION_JSON_VALUE)
  @ResponseBody
  public Product viewProductJSON(@PathVariable("seoName") String seoName) {
    return productService.getProductBySeoName(seoName);
  }
}
