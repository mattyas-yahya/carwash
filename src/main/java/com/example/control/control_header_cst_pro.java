package com.example.control;

import com.example.model.header_cst_pro;
import com.example.repo.repo_header_cst_pro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class control_header_cst_pro
{
  @Autowired
  private repo_header_cst_pro rhcpr;

    @RequestMapping(value={"/header_cst_pro"})
    public String hcpr()
    {
        return "header_cst_pro/header_cst_pro";
    }

    @GetMapping({"/header_cst_pro"})
    public String header_cst_pro_form(Model model)
    {
        model.addAttribute("header_cst_pro", new header_cst_pro());
        return "header_cst_pro/header_cst_pro";
    }

    @RequestMapping(value={"hcp_komit"},  method = RequestMethod.POST, params={"hcp_action=hcp_simpan"})
    public String simpan(header_cst_pro hcpo,Model mod)
    {
        this.rhcpr.save(hcpo);
        return "redirect:/header_cst_pro";
    }




}
