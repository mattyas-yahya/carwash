package com.example.control.rest;

import com.example.repo.repo_wo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class control_detil_rest
{
    @Autowired
    repo_wo rs;
//    @RequestMapping(value={"/Detail_Spare"})
//    public String Detail()
//    {
//        return "Detail_Spare/Detail_Spare";
//    }
//
//    @GetMapping({"/Detail_Spare"})
//    public String Detail_form(Model model)
//    {
//        return "Detail_Spare/Detail_Spare";
//    }

    @GetMapping("/Detail_Spare/{kode_spare_part}")
    public List  getDetail(@PathVariable String kode_spare_part)
    {
        return (List)this.rs.findbykode(kode_spare_part)  ;
    }
}
