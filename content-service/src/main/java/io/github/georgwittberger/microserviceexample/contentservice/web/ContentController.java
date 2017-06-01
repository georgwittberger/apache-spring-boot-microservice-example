package io.github.georgwittberger.microserviceexample.contentservice.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ContentController {
  @GetMapping("/")
  public String viewHomePage() {
    return "index";
  }
}
