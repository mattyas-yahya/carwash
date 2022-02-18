package com.example.control.rest;

import com.example.model.project_labour;
import com.example.repo.repo_project_labour;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
public class control_project_labour_rest
{
        @Autowired
        private repo_project_labour rpl;

        @RequestMapping(path="/project_labour_All", method= RequestMethod.GET)
        public List<project_labour> getProject_labour_All()
        {
            return (List)this.rpl.findAll();
        }
    }


