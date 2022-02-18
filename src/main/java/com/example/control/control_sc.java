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
public class control_sc
{
    @Autowired
    repo_wo rew;
    @Autowired
    repo_aud_wo reaw;


  @RequestMapping(value={"/service_request"})
  public String scor()
  {
    return "work_orders/service_request";
  }

  @GetMapping({"/service_request"})
  public String sr_form(Model model)
  {
    model.addAttribute("sc", new work_orders());
    return "work_orders/service_request";
  }

//  @RequestMapping(value={"sc_komit"},  method = RequestMethod.POST, params={"sc_action=sc_simpan"})
//  public String simpansc(work_orders wo, aud_wo awo, Model model)
//  {
//    model.addAttribute("sc", new work_orders());
//    this.rew.save(wo);
//    this.reaw.save(awo);
//    return "redirect:/service_request";
//  }
}
