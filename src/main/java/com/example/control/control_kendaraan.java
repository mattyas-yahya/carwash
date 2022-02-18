package com.example.control;

import com.example.model.kendaraan;
import com.example.repo.repo_kendaraan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.validation.Valid;

@Controller
public class control_kendaraan
{
    @Autowired
    private repo_kendaraan rk;

    @RequestMapping(value={"/kendaraan"})
    public String kendaraan()
    {
        return "kendaraan/kendaraan";
    }

    @GetMapping({"/kendaraan"})
    public String kendaraan_form(Model model)
    {
        model.addAttribute("kendaraan", new kendaraan());
        return "kendaraan/kendaraan";
    }




    
}
