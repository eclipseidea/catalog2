package zab.romik.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
/*
* 0.0.1
* */
@Controller
public class IndexController {
    @GetMapping("/")
    public String index() {
        return "index";
    }
}
