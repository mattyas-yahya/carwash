/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.control;

import com.example.repo.repo_onhand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class control_onhand
{

  @Autowired
  repo_onhand reon;

@RequestMapping(value={"/Onhand_Inventory"})
public String formOnhand()
{
return "Onhand/Onhand_Inventory";
}

  @RequestMapping(value={"/OnhandInventory"})
  public String formOnhandInventory()
  {
    return "Onhand/Onhand_Inventory";
  }

  @GetMapping({"/Onhand_Inventory"})
  public String Onhand_form(Model model)
  {
   // model.addAttribute("Onhand", new Onhand());
    return "Onhand_Inventory/Onhand_Inventory";
  }


}
