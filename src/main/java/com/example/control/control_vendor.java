package com.example.control;

import com.example.model.vendor;
import com.example.repo.repo_vendor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;

import javax.validation.Valid;

@Controller
public class control_vendor
{
  @Autowired
  private repo_vendor rev;

    @RequestMapping(value={"/vendor"})
    public String vendor()
    {
        return "vendor/vendor";
    }

    @GetMapping({"/vendor"})
    public String vendor_form(Model model)
    {
        model.addAttribute("vendor", new vendor());
        return "vendor/vendor";
    }

//    @RequestMapping(value={"d_komit"},  method = RequestMethod.POST, params={"d_action=d_simpan"})
//    public String simpan(Departemen de)
//    {
//         this.remen.save(de);
//            return "redirect:/Departemen";
//    }
//



    @RequestMapping(value={"v_komit"},  method = RequestMethod.POST, params={"v_action=v_simpan"})
public String prosesForm(@ModelAttribute @Valid vendor v, BindingResult err, SessionStatus status,Model model)
      {
        model.addAttribute("vendor");
        this.rev.save(v);
        return "redirect:/vendor";
}




//    @RequestMapping(value={"d_komit"}, method= RequestMethod.POST, params={"d_action=d_ubah"})
//    public String ubah(@RequestParam("kode") String kode, Model model, Account de)
//    {
//        model.addAttribute("Account", this.rec.findById(kode));
//        this.rec.save(de);
//        return "redirect:/Account";
//    }
//
//  @Transactional
//    @RequestMapping(value={"ac_komit"}, method=RequestMethod.POST, params={"ac_action=ac_hapus"})
//      public String hapus(@RequestParam("id_dept") String[] idde,Model model,Departemen de)
//    {
//
//   //   this.rec.hapusdata(Arrays.asList(idde));
//        return "redirect:/Departemen";
//    }
}
