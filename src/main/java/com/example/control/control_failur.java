package com.example.control;

import com.example.model.failur;
import com.example.repo.repo_failur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class control_failur
{
@Autowired
    repo_failur refa;

    @RequestMapping(value={"/failur"})
    public String failur()
    {
        return "failur/failur";
    }

    @GetMapping({"/failur"})
    public String failur_form(Model model)
    {
        model.addAttribute("failur", new failur());
        return "failur/failur";
    }


    @RequestMapping(value={"r_komit"},  method = RequestMethod.POST, params={"r_action=r_simpan"})
    public String simpan(failur fa)
    {
        this.refa.save(fa);
        return "redirect:/failur";
    }

    @RequestMapping(value={"r_komit"}, method= RequestMethod.POST, params={"r_action=r_ubah"})
    public String ubah(@RequestParam("id_failur") String idf, Model model, failur fa)
    {
        model.addAttribute("failur", this.refa.findById(idf));
        this.refa.save(fa);
        return "redirect:/failur";
    }

    @RequestMapping(value={"r_komit"}, method=RequestMethod.POST, params={"r_action=r_hapus"})
    public String hapus(@RequestParam("id_failur") String idf,Model model,failur fa)
    {
        model.addAttribute("failur", this.refa.findById(idf));
        this.refa.delete(fa);
        return "redirect:/failur";
    }
}
