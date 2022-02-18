package com.example.control;

import com.example.model.Account;
import com.example.model.Departemen;
import com.example.repo.repo_account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.validation.Valid;

@Controller
public class control_account
{
    @Autowired
    private repo_account rec;

    @RequestMapping(value={"/Account"})
    public String account()
    {
        return "Account/Account";
    }

    @GetMapping({"/Account"})
    public String Account_form(Model model)
    {
        model.addAttribute("Account", new Account());
        return "Account/Account";
    }

//    @RequestMapping(value={"d_komit"},  method = RequestMethod.POST, params={"d_action=d_simpan"})
//    public String simpan(Departemen de)
//    {
//         this.remen.save(de);
//            return "redirect:/Departemen";
//    }
//



    @RequestMapping(value={"ac_komit"},  method = RequestMethod.POST, params={"ac_action=ac_simpan"})
public String prosesForm(@ModelAttribute @Valid Account de, BindingResult err, SessionStatus status,Model model)
      {
        model.addAttribute("Account");
        this.rec.save(de);
        return "redirect:/Account";
}




//    @RequestMapping(value={"d_komit"}, method= RequestMethod.POST, params={"d_action=d_ubah"})
//    public String ubah(@RequestParam("kode") String kode, Model model, Account de)
//    {
//        model.addAttribute("Account", this.rec.findById(kode));
//        this.rec.save(de);
//        return "redirect:/Account";
//    }

  @Transactional
    @RequestMapping(value={"ac_komit"}, method=RequestMethod.POST, params={"ac_action=ac_hapus"})
      public String hapus(@RequestParam("id_dept") String[] idde,Model model,Departemen de)
    {

   //   this.rec.hapusdata(Arrays.asList(idde));
        return "redirect:/Departemen";
    }
}
