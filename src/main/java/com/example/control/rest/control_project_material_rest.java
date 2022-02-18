package com.example.control.rest;

import com.example.model.project_material;
import com.example.repo.repo_project_material;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
public class control_project_material_rest
{
        @Autowired
        private repo_project_material rpm;

        @RequestMapping(path="/project_material_All", method= RequestMethod.GET)
        public List<project_material> getproject_material_All()
        {
            return (List)this.rpm.findAll();
        }
    }


