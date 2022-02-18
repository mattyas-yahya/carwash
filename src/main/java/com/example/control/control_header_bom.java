package com.example.control;

import com.example.model.header_bom;
import com.example.repo.repo_header_bom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class control_header_bom
{
  @Autowired
  private repo_header_bom rhb;

    @RequestMapping(value={"/header_bom"})
    public String hbr()
    {
        return "header_bom/header_bom";
    }

    @GetMapping({"/header_bom"})
    public String header_bom_form(Model model)
    {
        model.addAttribute("header_bom", new header_bom());
        return "header_bom/header_bom";
    }






}
