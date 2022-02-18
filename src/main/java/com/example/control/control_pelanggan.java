package com.example.control;

import com.example.model.pelanggan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.validation.Valid;

@Controller
public class control_pelanggan
{
   

    @RequestMapping(value={"/pelanggan"})
    public String pelanggan()
    {
        return "pelanggan/pelanggan";
    }

    @GetMapping({"/pelanggan"})
    public String pelanggan_form(Model model)
    {
        model.addAttribute("pelanggan", new pelanggan());
        return "pelanggan/pelanggan";
    }


}
