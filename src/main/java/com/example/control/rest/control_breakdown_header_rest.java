package com.example.control.rest;

import com.example.model.breakdown_header;
import com.example.repo.repo_breakdown_header;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class control_breakdown_header_rest
{
@Autowired
    repo_breakdown_header rbreak;

    @RequestMapping(path="/Header_Break_Down", method= RequestMethod.GET)
    public List<breakdown_header> getHeader_Break_Down()
    {
        return (List)this.rbreak.findAll();
    }
}
