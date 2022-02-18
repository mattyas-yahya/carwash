package com.example.control;

import com.example.model.jadwal;
import com.example.model.log_jadwal;
import com.example.repo.repo_jadwal;
import com.example.repo.repo_log_jadwal;
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
public class control_jadwal
{
    @Autowired
    repo_jadwal reja;

  @Autowired
  repo_log_jadwal rejal;

    @RequestMapping(value={"/jadwal"})
    public String jad()
    {
        return "jadwal/jadwal";
    }

    @GetMapping({"/jadwal"})
    public String jadwal_form(Model model)
    {
        model.addAttribute("jadwal", new jadwal());
        return "jadwal/jadwal";
    }

    @RequestMapping(value={"j_komit"},  method = RequestMethod.POST)
    public String simpan(jadwal ja, log_jadwal jal)
    {

        this.reja.save(ja);
        this.rejal.save(jal);
        return "redirect:/jadwal";
    }


  @Transactional
    @RequestMapping(value={"j_komit"}, method=RequestMethod.POST, params={"j_action=j_hapus"})
    public String hapus(@RequestParam("id_jadwal") String idj[])
    {

       // model.addAttribute("jadwal", this.reja.findById(idj));
        this.reja.hapusdataAll(Arrays.asList(idj));
        return "redirect:/jadwal";
    }
}
