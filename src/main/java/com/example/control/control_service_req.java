//package com.example.control;
//
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.ui.Model;
//import com.example.model.work_orders;
//@Controller
//public class control_service_req
//{
//
//
//      @RequeastMapping(value={"/service_request"})
//  public String scor()
//  {
//    return "work_orders/service_request";
//  }
//
//  @GetMapping({"/service_request"})
//  public String sr_form(Model model)
//  {
//    model.addAttribute("sc", new work_orders());
//    return "work_orders/service_request";
//  }
////    @RequestMapping(value={"sc_komit"},  method = RequestMethod.POST, params={"wo_action=wo_simpan"})
////    public String simpan(Model model, work_order wo, aud_wo awo)
////    {
////        model.addAttribute("sc");
////        this.rew.save(wo);
////        this.reaw.save(awo);
////        return "work_order/service_request";
////    }
//  //    @RequestMapping(value={"sc_komit"},  method = RequestMethod.POST, params={"sc_action=sc_simpan"})
////  @RequestMapping(value={"sc_komit"},  method = RequestMethod.POST)
////  public String simpansc(work_orders wo, aud_wo awo, Model model,@RequestParam("kode_asset") String kode_asset)
////  {
////    model.addAttribute("sc", new work_orders());
////    this.rew.save(wo);
////    this.reaw.save(awo);
////    this.reas.SetRepair(kode_asset);
////    return "redirect:/service_request";
////  }
//
//}
