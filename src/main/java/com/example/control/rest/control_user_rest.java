package com.example.control.rest;

import com.example.model.Users;
import com.example.repo.repo_users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
public class control_user_rest
{
        @Autowired
        private repo_users rs;

        @RequestMapping(path="/UserAll", method= RequestMethod.GET)
        public List<Users> getAll()
        {
            return (List)this.rs.findAll();
        }


    }


