package com.example.control;

import com.example.model.moveout;
import com.example.repo.repo_moveout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class control_moveout
{
    @Autowired
    private repo_moveout remov;
//    @Autowired
//    private repo_spare repar;

    @RequestMapping(value={"/moveout"})
    public String moveout()
    {
        return "moveout/moveout";
    }

    @GetMapping({"/moveout"})
    public String moveout_form(Model model)
    {
        model.addAttribute("moveout", new moveout());
        return "moveout/moveout";
    }

    @RequestMapping(value={"m_komit"},  method = RequestMethod.POST, params={"m_action=m_simpan"})
    public String simpan(moveout mv,@RequestParam("id_spare_part") String id_spare_part,@RequestParam("jumlah") int jumlah)
    {
        this.remov.save(mv);
     //   this.repar.pemakaian(jumlah,id_spare_part);
        return "redirect:/moveout";
    }

    @RequestMapping(value={"m_komit"}, method= RequestMethod.POST, params={"m_action=m_ubah"})
    public String ubah(@RequestParam("id_moveout") String idm, Model model, moveout mv)
    {

        model.addAttribute("moveout", this.remov.findById(idm));
        this.remov.save(mv);
        return "redirect:/moveout";
    }

    @RequestMapping(value={"m_komit"}, method=RequestMethod.POST, params={"m_action=m_hapus"})
    public String hapus(@RequestParam("id_moveout") String idm,Model model, moveout mv)
    {

        model.addAttribute("moveout", this.remov.findById(idm));
        this.remov.delete(mv);
        return "redirect:/moveout";
    }
}
