package com.example.control.rest;

import com.example.model.moveout;
import com.example.repo.repo_moveout;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class control_rest_moveout
{
    @Autowired
    private repo_moveout remov;

    @RequestMapping(path="/MoveoutAll", method= RequestMethod.GET)
    public List<moveout> getAllMoveout()
    {
        return (List)this.remov.findAll();
    }

    @RequestMapping(path="/move", method= RequestMethod.GET)
    public List<moveout> getMove()

    {
        return remov.findMove();
    }
}
