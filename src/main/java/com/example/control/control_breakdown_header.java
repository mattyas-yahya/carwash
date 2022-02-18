package com.example.control;

import com.example.model.breakdown_header;
import com.example.repo.repo_breakdown_header;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;

import javax.validation.Valid;

@Controller
public class control_breakdown_header
{
    @Autowired
    repo_breakdown_header rbreak;

    @RequestMapping(value={"/breakdown_header"})
    public String breakdown_header()
    {
        return "breakdown_header/breakdown_header";
    }

    @GetMapping({"/breakdown_header"})
    public String Dbreakdown_header_form(Model model)
    {
        model.addAttribute("breakdown_header", new breakdown_header());
        return "breakdown_header/breakdown_header";
    }

    @RequestMapping(value={"break_komit"},  method = RequestMethod.POST, params={"break_action=break_simpan"})
    public String prosesForm(@ModelAttribute @Valid breakdown_header de, BindingResult err, SessionStatus status, Model model)
    {
        if (err.hasErrors())
        {

            model.addAttribute("breakdown_header","eror coeg");
            return "redirect:/breakdown_header";
        }
        this.rbreak.save(de);
        return "redirect:/breakdown_header";
    }
}
