package com.joebrooks.mapshotkakaoserver.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "https://mapshotproxyserver.herokuapp.com")
@Controller
@RequestMapping("/map")
public class MapController {
    @GetMapping
    public String getMaps(@RequestParam("lat") String lat,
                             @RequestParam("lng") String lng,
                             @RequestParam("level") String level,
                             Model model){

        model.addAttribute("lat", lat);
        model.addAttribute("lng", lng);
        model.addAttribute("level", level);

        return "index";
    }
}
