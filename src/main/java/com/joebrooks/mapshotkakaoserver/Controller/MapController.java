package com.joebrooks.mapshotkakaoserver.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@Controller
@RequestMapping("/html")
public class MapController {
    @GetMapping
    public String returnHtml(@RequestParam("lat") String lat, @RequestParam("lng") String lng, Model model){
        model.addAttribute("lat", lat);
        model.addAttribute("lng", lng);

        return "index";
    }
}
