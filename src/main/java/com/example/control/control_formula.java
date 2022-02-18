package com.example.control;

import com.example.model.Formula;
import com.example.repo.repo_formula;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class control_formula
{
    @Autowired
    private repo_formula refo;

    @RequestMapping(value={"/Formula"})
    public String formula()
    {
        return "Formula/Formula";
    }

    @GetMapping({"/Formula"})
    public String Formula_form(Model model)
    {
        model.addAttribute("Formula", new Formula());
        return "Formula/Formula";
    }


}
