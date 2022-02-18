package com.example.control.rest;

import com.example.model.*;
import com.example.repo.repo_aud_wo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class control_aud_wo_rest
{
    @Autowired
    private repo_aud_wo rewo;

    @RequestMapping(path="/AuditAll", method= RequestMethod.GET)
    public List<Asset> getAllAud()
    {
        return (List)this.rewo.findAll();
    }

    @RequestMapping(path="/AuditAllv2", method= RequestMethod.GET)
    public List<work_orders_aud> getAllwork_orders_aud()
    {
        return (List)this.rewo.NewfindAll();
    }
}
