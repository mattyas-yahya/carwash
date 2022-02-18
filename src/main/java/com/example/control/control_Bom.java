package com.example.control;

import com.example.model.Bom;
import com.example.repo.repo_Bom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class control_Bom
{
    @Autowired
    private repo_Bom rebo;

    @RequestMapping(value={"/Bom"})
    public String Bom()
    {
        return "Bom/Bom";
    }

    @GetMapping({"/Bom"})
    public String Bom_form(Model model)
    {
        model.addAttribute("Bom", new Bom());
        return "Bom/Bom";
    }


}
