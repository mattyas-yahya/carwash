package com.example.control;

import com.example.model.header_cst_op;
import com.example.repo.repo_header_cst_op;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class control_header_cst_op
{
  @Autowired
  private repo_header_cst_op rhco;

    @RequestMapping(value={"/header_cst_op"})
    public String hm()
    {
        return "header_cst_op/header_cst_op";
    }

    @GetMapping({"/header_cst_op"})
    public String header_cst_op_form(Model model)
    {
        model.addAttribute("header_cst_op", new header_cst_op());
        return "header_cst_op/header_cst_op";
    }

    @RequestMapping(value={"hco_komit"},  method = RequestMethod.POST, params={"hco_action=hco_simpan"})
    public String simpan(header_cst_op hco,Model mod)
    {
        this.rhco.save(hco);
        return "redirect:/header_cst_op";
    }




}
