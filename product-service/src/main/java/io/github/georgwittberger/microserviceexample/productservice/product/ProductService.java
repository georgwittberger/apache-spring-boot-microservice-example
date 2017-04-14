package io.github.georgwittberger.microserviceexample.productservice.product;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Service;

@Service
public class ProductService {
  private final Set<Product> products = new HashSet<>(
      Arrays.asList(new Product[] {
          new Product("Apple", "apple", "Fresh and tasty.", new BigDecimal(0.39)),
          new Product("Orange", "orange", "Sweet and juicy.", new BigDecimal(0.49)),
          new Product("Banana", "banana", "Yellow and bent. ;-)", new BigDecimal(0.29))
      }));

  public Set<Product> getProducts() {
    return products;
  }

  public Product getProductBySeoName(String seoName) {
    return products.stream().filter((product) -> product.getSeoName().equals(seoName)).findAny().orElse(null);
  }
}
