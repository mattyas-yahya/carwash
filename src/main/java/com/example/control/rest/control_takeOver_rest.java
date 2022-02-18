package com.example.control.rest;

import com.example.model.TakeOver;
import com.example.repo.repo_takeOver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class control_takeOver_rest
{
        @Autowired
        private repo_takeOver retak;

        @RequestMapping(path="/TakeAll", method= RequestMethod.GET)
        public List<TakeOver> getAllTake()

        {
            return (List)this.retak.findAll();
        }
    }


