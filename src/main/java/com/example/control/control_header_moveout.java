package com.example.control;

import com.example.model.header_moveout;
import com.example.repo.repo_header_moveout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class control_header_moveout
{
    @Autowired
    repo_header_moveout rehemov;

    @RequestMapping(value={"/header_moveout"})
    public String hm()
    {
        return "moveout/header_moveout";
    }

    @GetMapping({"/header_moveout"})
    public String hmoveout_form(Model model)
    {
        model.addAttribute("header_moveout", new header_moveout());
        return "moveout/header_moveout";
    }

    @RequestMapping(value={"he_komit"},  method = RequestMethod.POST, params={"he_action=he_simpan"})
    public String simpan(header_moveout hm,Model mod)
    {
        this.rehemov.save(hm);
        return "redirect:/header_moveout";
    }




}
