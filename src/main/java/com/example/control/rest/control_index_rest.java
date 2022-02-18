package com.example.control.rest;

import com.example.model.work_orders;
import com.example.repo.repo_wo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class control_index_rest
{
    @Autowired
    repo_wo rw;
    @RequestMapping(path="/quartal", method= RequestMethod.GET)
    public List<work_orders> getQuartal()

    {
//        return rw.findQrtl();
        return null;

    }
}
