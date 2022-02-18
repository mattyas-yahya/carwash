package com.example.control;

import com.example.model.cost_doc;
import com.example.repo.repo_cost_doc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class control_cost_doc
{
    @Autowired
    private repo_cost_doc rcd;

    @RequestMapping(value={"/cost_doc"})
    public String cost_doc()
    {
        return "cost_doc/cost_doc";
    }

    @GetMapping({"/cost_doc"})
    public String cost_doc_form(Model model)
    {
        model.addAttribute("cost_doc", new cost_doc());
        return "cost_doc/cost_doc";
    }

//    @RequestMapping(value={"cd_komit"},  method = RequestMethod.POST, params={"cd_action=cd_simpan"})
//    public String prosesForm(@ModelAttribute @Valid cost_doc cdo, BindingResult err, SessionStatus status, Model model)
//      {
//        model.addAttribute("cost_doc");
//        this.rcd.save(cdo);
//        return "redirect:/cost_doc";
//}

//  @Transactional
//   @RequestMapping(value={"cd_komit"}, method=RequestMethod.POST, params={"cd_action=cd_hapus"})
//  public String hapus(@RequestParam("id_cost_doc") String[] id_cost_doc, Model model, cost_doc cdo)
//    {
//
//      this.rcd.hapusdataAll(Arrays.asList(id_cost_doc));
//        return "redirect:/cost_doc";
//    }
}
