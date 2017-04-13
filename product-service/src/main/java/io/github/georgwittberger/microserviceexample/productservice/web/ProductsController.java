package io.github.georgwittberger.microserviceexample.productservice.web;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import io.github.georgwittberger.microserviceexample.productservice.product.Product;

@Controller
@RequestMapping("/products")
public class ProductsController {
  private Set<Product> products = new HashSet<>();

  public ProductsController() {
    products.add(new Product("Apple", "Fresh and tasty.", new BigDecimal(0.39)));
    products.add(new Product("Orange", "Sweet and juicy.", new BigDecimal(0.49)));
    products.add(new Product("Banana", "Yellow and bent. ;-)", new BigDecimal(0.29)));
  }

  @GetMapping(produces = MediaType.TEXT_HTML_VALUE)
  public String viewProductsHTML(Model model) {
    model.addAttribute("products", products);
    return "products";
  }
}
