package com.example.control;

import com.example.model.header_pr;
import com.example.model.purc_req;
import com.example.repo.repo_purc_req;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class control_purc_req
{
    @Autowired
    private repo_purc_req rpr;

    @RequestMapping(value={"/purc_req"})
    public String Spurc_req()
    {
        return "purc_req/purc_req";
    }

    @GetMapping({"/purc_req"})
    public String purc_req_form(Model model )
    {
        model.addAttribute("purc_req", new purc_req());
      model.addAttribute("header_pr", new header_pr());

      return "purc_req/purc_req";
    }


}
