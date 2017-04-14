package io.github.georgwittberger.microserviceexample.contentservice.web;

import java.util.Optional;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestHeader;

@ControllerAdvice
public class RouteControllerAdvice {
  @ModelAttribute("contentRoute")
  public String contentRoute(@RequestHeader("X-Public-Content-Service-Route") Optional<String> contentRoute) {
    return contentRoute.orElse("");
  }

  @ModelAttribute("productRoute")
  public String productRoute(@RequestHeader("X-Public-Product-Service-Route") Optional<String> productRoute) {
    return productRoute.orElse("");
  }

  @ModelAttribute("cartRoute")
  public String cartRoute(@RequestHeader("X-Public-Cart-Service-Route") Optional<String> cartRoute) {
    return cartRoute.orElse("");
  }
}
