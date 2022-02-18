package com.example.control;

import com.example.model.plant;
import com.example.repo.repo_plant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class control_plant
{
    @Autowired
    private repo_plant repl;

    @RequestMapping(value={"/plant"})
    public String plant()
    {
        return "plant/plant";
    }

    @GetMapping({"/plant"})
    public String plant_form(Model model)
    {
        model.addAttribute("plant", new plant());
        return "plant/plant";
    }


}
