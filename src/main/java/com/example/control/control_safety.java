package com.example.control;

import com.example.model.Safety;
import com.example.repo.repo_safety;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;


@Controller
public class control_safety
{
    @Autowired
    repo_safety resaf;

    @RequestMapping(value={"/Safety"})
    public String Safety()
    {
        return "Safety/Safety";
    }

    @GetMapping({"/Safety"})
    public String Safety_form(Model model)
    {
        model.addAttribute("Safety", new Safety());
        return "Safety/Safety";
    }

    @RequestMapping(value={"saf_komit"},  method = RequestMethod.POST, params={"saf_action=saf_simpan"})
    public String simpan(Safety saf)
    {
        this.resaf.save(saf);
        return "redirect:/Safety";
    }


  @Transactional
    @RequestMapping(value={"saf_komit"}, method=RequestMethod.POST, params={"saf_action=saf_hapus"})
    public String hapus(@RequestParam("id_safety") String[] idsaf)
    {
        this.resaf.hapusdataAll(Arrays.asList(idsaf));
        return "redirect:/Safety";
    }

}
