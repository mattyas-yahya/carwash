/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.control;

import com.example.model.TakeOver;
import com.example.repo.repo_takeOver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class control_takeOver
{
@Autowired
private repo_takeOver retak;

@RequestMapping(value={"/takeover"})
public String Formtakeover()
{
return "takeover/takeover";
}

  @GetMapping({"/takeover"})
  public String takeover_form(Model model)
  {
    model.addAttribute("TakeOver", new TakeOver());
    return "takeover/takeover";
  }

//@RequestMapping(value={"tkomit"},  method = RequestMethod.POST,  params={"taction=tsimpan"})
@RequestMapping(value={"tkomit"},  method = RequestMethod.POST)
public String simpan(TakeOver to)
  {
    this.retak.save(to);
    return "redirect:/takeover";
  }
  

}
