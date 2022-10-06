package com.example.demo;

import com.example.demo.service.MelonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ChartController {
    @Autowired
    private MelonService melonService;

    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/melon")
    public String melon(Model model) {
        model.addAttribute("list", melonService.getMelonMusicList());
        return "melon";
    }
}
