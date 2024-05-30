package com.eden.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String index(Model model) {
        return "index"; // 返回index.html模板
    }

    @GetMapping("/buy")
    public String buy(Model model) {
        return "buy";
    }

    @GetMapping("/sell")
    public String sell(Model model) {
        return "sell";
    }

    @GetMapping("/rent")
    public String rent(Model model) {
        return "rent";
    }

    @GetMapping("/lease")
    public String lease(Model model) {
        return "lease";
    }

    @GetMapping("/support")
    public String support(Model model) {
        return "support";
    }


    @GetMapping("/search")
    public String search(Model model) {
        return "search";
    }


}
