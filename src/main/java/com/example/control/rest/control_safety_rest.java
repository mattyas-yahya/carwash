package com.example.control.rest;

import com.example.repo.repo_safety;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController

public class control_safety_rest
{
@Autowired
    repo_safety resaf;
    @GetMapping("/SafetyAll")
    public List getSafety()
    {
        return resaf.findAll();
    }
}
