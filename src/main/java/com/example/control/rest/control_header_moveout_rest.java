package com.example.control.rest;

import com.example.model.header_moveout;
import com.example.repo.repo_header_moveout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class control_header_moveout_rest
{
    @Autowired
    private repo_header_moveout rehemo;

    @RequestMapping(path="/header_mov_All", method= RequestMethod.GET)
    public List<header_moveout> getAllHeader()
    {
        return (List)this.rehemo.findAll();
    }

    @RequestMapping(path="/header_Close", method= RequestMethod.GET)
    public List<header_moveout> getAllClose()
    {
        return (List)this.rehemo.FindClose();
    }

    @RequestMapping(path="/header_Open", method= RequestMethod.GET)
    public List<header_moveout> getAllOpen()
    {
        return (List)this.rehemo.FindOpen();
    }
}
