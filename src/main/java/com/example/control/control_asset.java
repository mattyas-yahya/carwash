/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.control;

import com.example.model.Asset;
import com.example.model.Tr_asset;
import com.example.model.suku_cadang;
import com.example.repo.repo_asset;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;

@Controller
public class control_asset
{

@Autowired
private repo_asset reas;

@RequestMapping(value={"/asset"})
public String asset()
{
return "asset/asset";
}

  @GetMapping({"/asset"})
  public String asset_form(Model model)
  {
    model.addAttribute("asset", new Asset());
    model.addAttribute("Tr_asset", new Tr_asset());
    model.addAttribute("suku_cadang", new suku_cadang());
    return "asset/asset";
  }

//@RequestMapping(value={"komit"},  method = RequestMethod.POST, params={"action=simpan"})
@RequestMapping(value={"komit"},  method = RequestMethod.POST)
  public String simpan(Model model,Asset as)
  {
    model.addAttribute("asset");
    this.reas.save(as);
    return "redirect:/asset";
  }

// @RequestMapping(value={"komit"}, method=RequestMethod.POST, params={"action=ubah"})
//  public String ubah(@RequestParam("id_asset") String idr, Model model, Asset as)
//  {
//
//    model.addAttribute("asset", this.reas.findById(idr));
//
//    this.reas.save(as);
//    return "redirect:/asset";
//  }

  @Transactional
   @RequestMapping(value={"komit"}, method=RequestMethod.POST, params={"action=hapus"})
  public String hapus(@RequestParam("id_asset") String ids[],Model model)
  {
    this.reas.hapusdataAll(Arrays.asList(ids));
    return "redirect:/asset";
  }
}
