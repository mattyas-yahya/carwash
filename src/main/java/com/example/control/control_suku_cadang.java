/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.control;

import com.example.model.suku_cadang;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class control_suku_cadang
{

@RequestMapping(value={"/suku_cadang"})
public String suku_cadang()
{
return "suku_cadang/suku_cadang";
}

  @GetMapping({"/suku_cadang"})
  public String suku_cadang_form(Model model)
  {
    model.addAttribute("suku_cadang", new suku_cadang());
    return "suku_cadang/suku_cadang";
  }

}
