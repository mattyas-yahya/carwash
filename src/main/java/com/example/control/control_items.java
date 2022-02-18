/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.control;

import com.example.model.Items;
import com.example.repo.repo_items;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class control_items
{

@Autowired
private repo_items reit;

@RequestMapping(value={"/Items"})
public String Items()
{
return "Items/Items";
}

  @GetMapping({"/Items"})
  public String Items_form(Model model)
  {
    model.addAttribute("Items", new Items());
    return "Items/Items";
  }


}
