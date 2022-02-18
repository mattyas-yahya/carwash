package com.example.control;

import com.example.model.journal;
import com.example.repo.repo_journal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class control_journal
{
    @Autowired
    private repo_journal rj;

    @RequestMapping(value={"/journal"})
    public String journal()
    {
        return "journal/journal";
    }

    @GetMapping({"/journal"})
    public String journal_form(Model model)
    {
        model.addAttribute("journal", new journal());
        return "journal/journal";
    }




}
