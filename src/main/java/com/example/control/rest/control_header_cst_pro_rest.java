package com.example.control.rest;

import com.example.model.header_moveout;
import com.example.repo.repo_header_cst_pro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class control_header_cst_pro_rest
{
    @Autowired
    private repo_header_cst_pro rhcpr;

    @RequestMapping(path="/header_cpro_All", method= RequestMethod.GET)
    public List<header_moveout> get_header_cpro_All()
    {
        return (List)this.rhcpr.findAll();
    }


}
