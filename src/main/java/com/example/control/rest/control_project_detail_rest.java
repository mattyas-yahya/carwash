package com.example.control.rest;

import com.example.model.project_detail;
import com.example.repo.repo_project_detail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
public class control_project_detail_rest
{
        @Autowired
        private repo_project_detail rpd;

        @RequestMapping(path="/project_detail_All", method= RequestMethod.GET)
        public List<project_detail> getproject_detail_All()
        {
            return (List)this.rpd.findAll();
        }
    }


