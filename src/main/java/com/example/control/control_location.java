/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.control;

import com.example.model.Location;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class control_location
{

//  @Autowired
//  private repo_location reloc;

@RequestMapping(value={"/Location"})
public String Location()
{
return "Location/Location";
}

  @GetMapping({"/Location"})
  public String Location_form(Model model)
  {
    model.addAttribute("Location", new Location());
    return "Location/Location";
  }

//@RequestMapping(value={"lkomit"},  method = RequestMethod.POST, params={"laction=lsimpan"})
//  public String simpan(Model model, Location lc)
//  {
//    model.addAttribute("Location");
//    this.reloc.save(lc);
//    return "redirect:/Location";
//  }

// @RequestMapping(value={"komit"}, method=RequestMethod.POST, params={"action=ubah"})
//  public String ubah(@RequestParam("id_asset") String idr, Model model, Asset as)
//  {
//
//    model.addAttribute("asset", this.reas.findById(idr));
//
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
