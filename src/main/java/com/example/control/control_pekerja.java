/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.control;

import com.example.model.pekerja;
import com.example.repo.repo_pekerja;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class control_pekerja
{

@Autowired
private repo_pekerja reang;

@RequestMapping(value={"/pekerja"})
public String pekerja()
{
return "pekerja/pekerja";
}

  @GetMapping({"/pekerja"})
  public String pekerja_form(Model model)
  {
    model.addAttribute("pekerja", new pekerja());
    return "pekerja/pekerja";
  }


}
