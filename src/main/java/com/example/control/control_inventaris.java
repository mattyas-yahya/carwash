package com.example.control;


import com.example.model.inventaris;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class control_inventaris
{


  @RequestMapping(value={"/inventaris"})
  public String inventaris()
  {
    return "inventaris/inventaris";
  }

  @GetMapping({"/inventaris"})
  public String inventaris_form(Model model)
  {
    model.addAttribute("inventaris", new inventaris());
    return "inventaris/inventaris";
  }

//  @RequestMapping(value={"inv_komit"},  method = RequestMethod.POST, params={"inv_action=inv_simpan"})
//  //@RequestMapping(value={"inv_komit"},  method = RequestMethod.POST)
//  public String simpan(Model model,Inventory inv)
//  {
//    model.addAttribute("Inventory");
//    this.revi.save(inv);
//    return "redirect:/Inventory";
//  }




//  @Transactional
//  @RequestMapping(value={"inv_komit"}, method=RequestMethod.POST, params={"inv_action=inv_hapus"})
//  public String hapus(@RequestParam("id_inventory") String ids[],Model model)
//  {
//    this.revi.hapusdataAll(Arrays.asList(ids));
//    return "redirect:/Inventory";
//  }
}
