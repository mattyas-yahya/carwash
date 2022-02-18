package com.example.control;

import com.example.model.jenis_kendaraan;
import com.example.repo.repo_jenis_kendaraan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.validation.Valid;

@Controller
public class control_jenis_kendaraan
{
    @Autowired
    private repo_jenis_kendaraan rjk;

    @RequestMapping(value={"/jenis_kendaraan"})
    public String jenis_kendaraan()
    {
        return "jenis_kendaraan/jenis_kendaraan";
    }

    @GetMapping({"/jenis_kendaraan"})
    public String Account_form(Model model)
    {
        model.addAttribute("jenis_kendaraan", new jenis_kendaraan());
        return "jenis_kendaraan/jenis_kendaraan";
    }




    
}
