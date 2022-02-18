package com.example.control;

import com.example.model.self_service;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class control_self_service
{


    @RequestMapping(value={"/self_service"})
    public String self_service()
    {
        return "self_service/self_service";
    }

    @GetMapping({"/self_service"})
    public String self_service_form(Model model)
    {
        model.addAttribute("self_service", new self_service());
        return "self_service/self_service";
    }

}
