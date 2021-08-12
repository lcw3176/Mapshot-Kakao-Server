package com.joebrooks.mapshotkakaoserver.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@Controller
@RequestMapping("/html")
public class MapController {
    @GetMapping
    public String returnHtml(@RequestParam("lat") float lat,
                             @RequestParam("lng") float lng,
                             @RequestParam("level") int level,
                             Model model){

        model.addAttribute("lat", lat);
        model.addAttribute("lng", lng);
        model.addAttribute("level", level);

        return "index";
    }
}
