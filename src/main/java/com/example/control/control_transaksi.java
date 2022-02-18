package com.example.control;

import com.example.model.transaksi;
import com.example.repo.repo_transaksi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

import javax.validation.Valid;

@Controller
public class control_transaksi
{
   

    @RequestMapping(value={"/transaksi"})
    public String transaksi()
    {
        return "transaksi/transaksi";
    }

    @GetMapping({"/transaksi"})
    public String transaksi_form(Model model)
    {
        model.addAttribute("transaksi", new transaksi());
        return "transaksi/transaksi";
    }




    
}
