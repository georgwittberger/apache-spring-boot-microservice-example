package io.github.georgwittberger.microserviceexample.cartservice.cart;

import io.github.georgwittberger.microserviceexample.cartservice.product.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.WebApplicationContext;

@Service
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class CartService {
  @Autowired
  private RestTemplate restTemplate;
  @Value("${service.product.url}")
  private String productServiceURL;
  private final Cart cart = new Cart();

  public Cart getCart() {
    return cart;
  }

  public Cart addLineItem(String productSeoName) {
    Product product = restTemplate.getForObject(productServiceURL + productSeoName, Product.class);
    LineItem lineItem = new LineItem(product.getName(), product.getSeoName(), product.getPrice());
    cart.addLineItem(lineItem);
    return cart;
  }
}
