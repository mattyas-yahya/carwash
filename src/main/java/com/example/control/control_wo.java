package com.example.control;

import com.example.model.work_orders;
import com.example.repo.repo_aud_wo;
import com.example.repo.repo_wo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class control_wo
{
@Autowired
    repo_wo rew;
    @Autowired
repo_aud_wo reaw;


    @RequestMapping(value={"/work_orders"})
    public String wor()
    {
        return "work_orders/work_orders";
    }

    @GetMapping({"/work_orders"})
    public String wo_form(Model model)
    {
        model.addAttribute("work_orders", new work_orders());
        return "work_orders/work_orders";
    }





//  @PostMapping("/addnew")
//@RequestMapping(value={"wo_komit"},  method = RequestMethod.POST)
//@RequestMapping(value={"wo_komit"},  method = RequestMethod.POST, params={"wo_action=wo_simpan"})
//  public String simpan(work_orders wo, aud_wo awo )
//    {
//   this.rew.save(wo);
//        this.reaw.save(awo);
//        return "redirect:/work_orders";
//    }




//     @Transactional
//
//    @RequestMapping(value={"wo_komit"}, params={"wo_action=wo_hapus"})
//    public String hapus(@RequestParam("id_wo") String idw[])
//    {
//       // model.addAttribute("work_order", this.rew.findById(idw));
//        this.rew.hapusdataAll(Arrays.asList(idw));
//        return "redirect:/work_orders";
//    }









//      @RequestMapping(value={"sc_komit"},  method = RequestMethod.POST, params={"sc_action=sc_simpan"})
//    public ModelAndView createSC(@Valid work_order wok,work_order wo, aud_wo awo, BindingResult bindingResult)
//    {
//        String w=wo.getId_wo();
//        ModelAndView modelAndView = new ModelAndView();
//        if (wo != null)
//        {
//            bindingResult.rejectValue("kode_wo", "error.user","There is already a user registered with the email provided");
//        }
//        if (bindingResult.hasErrors()) {
//            modelAndView.setViewName("sc");
//        }
//        else
//        {
//            this.rew.save(wo);
//            this.reaw.save(awo);
//            modelAndView.addObject("successMessage", "Users has been registered successfully");
//            modelAndView.addObject("sc", new work_order());
//            modelAndView.setViewName("sc");
//
//        }
//        return modelAndView;
//    }

//  @RequestMapping(path="/sumDT1", method= RequestMethod.GET)
//  public List ubah(@RequestParam("pembuatan") String t1)
//  {
//    return (List)this.rew.sumDT1(t1,t1);
//  }
}
