package com.example.springbootmap;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;

@Controller
public class MapController {
    
    private CapitalsParser capitalsParser;

    public MapController(CapitalsParser capitalsParser) {
        this.capitalsParser = capitalsParser;
    }

    @GetMapping
    public String getMap(Model model) throws IOException {
        model.addAttribute("points", capitalsParser.getCapitalData());
        return "map"; 
    }
}
