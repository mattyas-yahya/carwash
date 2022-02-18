package com.example.control;

import com.example.model.PreventiveMaintenance;
import com.example.repo.repo_jadwal;
import com.example.repo.repo_pm;
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
public class control_PreventiveMaintenance
{
    @Autowired
    repo_pm rpm;
  @Autowired
  repo_jadwal rj;

  String status="Verified";
  String id_jadwal="";
  @RequestMapping(value={"/PM"})
    public String pm()
    {
        return "PM/PM";
    }

    @GetMapping({"/PM"})
    public String pm_form(Model model)
    {
        model.addAttribute("PreventiveMaintenance", new PreventiveMaintenance());
        return "PM/PM";
    }

    @RequestMapping(value={"pm_komit"},  method = RequestMethod.POST, params={"pm_action=pm_simpan"})
    public String simpan(PreventiveMaintenance pm)
    {
        this.rpm.save(pm);
        return "redirect:/PM";
    }

    @RequestMapping(value={"pm_komit"}, method= RequestMethod.POST, params={"pm_action=pm_ubah"})
    public String ubah(@RequestParam("id_pm") String idpm, Model model, PreventiveMaintenance pm)
    {

        model.addAttribute("PreventiveMaintenance", this.rpm.findById(idpm));
        this.rpm.save(pm);
        return "redirect:/PM";
    }

    @Transactional
    @RequestMapping(value={"pm_komit"}, method=RequestMethod.POST, params={"pm_action=pm_hapus"})
    public String hapus(@RequestParam("id_pm") String[] idpm)
    {
       this.rpm.hapusdata(Arrays.asList(idpm));
        return "redirect:/PM";
    }
  @Transactional
  @RequestMapping(value={"pm_komit"},  method = RequestMethod.POST, params={"pm_action=pm_reschedule"})
  public String reschedule(@RequestParam("id_pm") String idpm,@RequestParam("next_due_date") String start,@RequestParam("kode_pm") String kode_pm,@RequestParam("deskripsi") String title)
  {
    this.rpm.insertdata(id_jadwal,idpm, start, kode_pm, title,status);
    return "redirect:/PM";
  }
}
