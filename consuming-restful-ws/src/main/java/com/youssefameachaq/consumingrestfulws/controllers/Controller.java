package com.youssefameachaq.consumingrestfulws.controllers;

import com.youssefameachaq.consumingrestfulws.models.Quote;
import com.youssefameachaq.consumingrestfulws.models.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api")
public class Controller {
    @GetMapping("/random")
    public Quote random() {
        return new Quote("Love", new Value(1L, "Love quote"));
    }
}
