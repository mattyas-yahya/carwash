/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.control;

import com.example.model.OnHandStok;
import com.example.repo.repo_OnHandStok;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class control_OnHandStok
{

@Autowired
private repo_OnHandStok roh;

@RequestMapping(value={"/OnHandStok"})
public String OnHandStok()
{
return "OnHandStok/OnHandStok";
}

  @GetMapping({"/OnHandStok"})
  public String OnHandStok_form(Model model)
  {
    model.addAttribute("OnHandStok", new OnHandStok());
    return "OnHandStok/OnHandStok";
  }

@RequestMapping(value={"oh_komit"},  method = RequestMethod.POST, params={"oh_action=oh_simpan"})
//@RequestMapping(value={"oh_komit"},  method = RequestMethod.POST)
  public String simpan(Model model,OnHandStok ohh)
  {
    model.addAttribute("OnHandStok");
    this.roh.save(ohh);
    return "redirect:/OnHandStok";
  }
  
// @RequestMapping(value={"komit"}, method=RequestMethod.POST, params={"action=ubah"})
//  public String ubah(@RequestParam("id_asset") String idr, Model model, Asset as)
//  {
//
//    model.addAttribute("asset", this.reas.findById(idr));
//    this.reas.save(as);
//    return "redirect:/asset";
//  }

//  @Transactional
//   @RequestMapping(value={"komit"}, method=RequestMethod.POST, params={"action=hapus"})
//  public String hapus(@RequestParam("id_asset") String ids[],Model model)
//  {
//    this.reas.hapusdataAll(Arrays.asList(ids));
//    return "redirect:/asset";
//  }
}
