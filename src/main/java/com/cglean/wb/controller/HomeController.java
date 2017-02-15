package com.cglean.wb.controller;

import org.springframework.web.bind.annotation.*;
import java.util.UUID;

/**
 * Created by sanrawat on 2/13/2017.
 */

@RestController
public class HomeController {

    @GetMapping("/")
    public String securedCall() {
        return "Success (id: " + UUID.randomUUID().toString().toUpperCase() + ")";
    }

}
