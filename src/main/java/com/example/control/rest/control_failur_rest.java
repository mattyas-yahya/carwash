package com.example.control.rest;

import com.example.repo.repo_failur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class control_failur_rest
{
@Autowired
repo_failur refa;

    @GetMapping("/failurAll")
    public List getFailur()
    {

        return refa.findRPN();

    }


}
