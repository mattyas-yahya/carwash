package com.example.control;

import com.example.model.Departemen;
import com.example.repo.repo_departemen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class control_departemen
{
    @Autowired
    private repo_departemen remen;

    @RequestMapping(value={"/Departemen"})
    public String Departemen()
    {
        return "Departemen/Departemen";
    }

    @GetMapping({"/Departemen"})
    public String Departemen_form(Model model)
    {
        model.addAttribute("Departemen", new Departemen());
        return "Departemen/Departemen";
    }





//    @RequestMapping(value={"d_komit"},  method = RequestMethod.POST, params={"d_action=d_simpan"})
//public String prosesForm(@ModelAttribute @Valid Departemen de, BindingResult err, SessionStatus status, Model model) {
//    if (err.hasErrors())
//    {
//
//        model.addAttribute("ci","eror coeg");
//        return "redirect:/Departemen";
//    }
//        this.remen.save(de);
//    return "redirect:/Departemen";
//}




//    @RequestMapping(value={"d_komit"}, method= RequestMethod.POST, params={"d_action=d_ubah"})
//    public String ubah(@RequestParam("id_dept") String idde, Model model, Departemen de)
//    {
//        model.addAttribute("Departemen", this.remen.findById(idde));
//        this.remen.save(de);
//        return "redirect:/Departemen";
//    }

//  @Transactional
//    @RequestMapping(value={"d_komit"}, method=RequestMethod.POST, params={"d_action=d_hapus"})
//      public String hapus(@RequestParam("id_dept") String[] idde,Model model,Departemen de)
//    {
//
//      this.remen.hapusdata(Arrays.asList(idde));
//        return "redirect:/Departemen";
//    }
}
