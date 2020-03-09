package pl.codeleak.demos.sbt.home;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.codeleak.demos.sbt.model.Product;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;

@Controller
class HomeController {

    @GetMapping("/")
    String index(Model model) throws ParseException {
        model.addAttribute("now", LocalDateTime.now());

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Product product = new Product("花生油", 129, sdf.parse("2018-02-18"));
        model.addAttribute("product", product);
        // Add message
        model.addAttribute(Product.TYPE, "Food");

        return "index";
    }

    @GetMapping("properties")
    @ResponseBody
    java.util.Properties properties() {
        return System.getProperties();
    }

}
