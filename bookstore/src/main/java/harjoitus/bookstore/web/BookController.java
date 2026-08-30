package harjoitus.bookstore.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@ResponseBody
public class BookController {

  @GetMapping("/index")
  public String index() {
      return "This is the index page of the bookstore application.";
  }
  
  @GetMapping("/*")
  public String fallback() {
      return "The requested page was not found.";
  }

}
