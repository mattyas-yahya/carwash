package com.example.control;

import com.example.model.MtbfMttr;
import com.example.repo.repo_MtbfMttr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@Controller
@CrossOrigin

public class control_MtbfMttr
{
    @Autowired
    repo_MtbfMttr remtb;

    @RequestMapping(value={"/MtbfMttr"})
    public String MtbfMttr()
    {
        return "MtbfMttr/MtbfMttr";
    }

    @GetMapping({"/MtbfMttr"})
    public String MtbfMttr_form(Model model)
    {
        model.addAttribute("MtbfMttr", new MtbfMttr());
        return "MtbfMttr/MtbfMttr";
    }


@RequestMapping(value={"mt_komit"},  method = RequestMethod.POST)
public String simpan(MtbfMttr mt)
    {
        this.remtb.save(mt);
        return "redirect:/MtbfMttr";
    }


}
