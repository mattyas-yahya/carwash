/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.control;

import com.example.model.project_detail;
import com.example.model.project_labour;
import com.example.model.project_material;
import com.example.repo.*;
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
public class control_project_detail
{

  @Autowired
  private repo_project_detail rpd;
  @Autowired
  private repo_project_material rpm;
  @Autowired
  private repo_wo rw;
  @Autowired
  repo_inventaris revi;
  @Autowired
  repo_project_labour repl;

@RequestMapping(value={"/project_detail"})
public String asset()
{
return "project_detail/project_detail";
}

  @GetMapping({"/project_detail"})
  public String project_detail_form(Model model)
  {
    model.addAttribute("project_detail", new project_detail());
    model.addAttribute("project_material", new project_material());
    model.addAttribute("project_labour", new project_labour());

    return "project_detail/project_detail";
  }
  @Transactional
@RequestMapping(value={"pdkomit"},  method = RequestMethod.POST, params={"pdaction=pdsimpan"})
//@RequestMapping(value={"komit"},  method = RequestMethod.POST)
  public String simpan(Model model,project_detail pd,@RequestParam("id") String id)
  {
    model.addAttribute("project_detail");
    this.rpd.save(pd);
    this.rw.Costingin(id);
    this.rw.Costinginpm(id);
    return "redirect:/project_detail";
  }
  


  @Transactional
   @RequestMapping(value={"pdkomit"}, method=RequestMethod.POST, params={"pdaction=pdhapus"})
  public String hapus_all(@RequestParam("id_project_detail") String ids[],Model model)
  {
    this.rpd.hapusdataAll(Arrays.asList(ids));
    return "redirect:/project_detail";
  }


  @RequestMapping(value={"pmkomit"},  method = RequestMethod.POST)
  public String simpan(Model model, project_material pm,@RequestParam("id_inventory") String id_inventory,@RequestParam("quantity") int penjualan)
  {
    model.addAttribute("project_material");
    this.rpm.pembelian(penjualan,id_inventory);
    this.rpm.save(pm);
    return "redirect:/project_detail";
  }

  @RequestMapping(value={"lbrkomit"}, method=RequestMethod.POST, params={"lbraction=lbrsimpan"})
  public String simpanPekerja(Model model, project_labour pl)
  {
    model.addAttribute("project_labour");
    this.repl.save(pl);
    return "redirect:/project_detail";
  }


  @Transactional
  @RequestMapping(value={"pmkomit"}, method=RequestMethod.POST, params={"pmaction=pmhapus"})
  public String hapus(@RequestParam("id_project_material") String ids[],Model model)
  {
    this.rpm.hapusdataAll(Arrays.asList(ids));
    return "redirect:/project_detail";
  }
}
