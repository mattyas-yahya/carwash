package com.example.control.rest;

import com.example.model.OnHandStok;
import com.example.repo.repo_OnHandStok;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
public class control_OnHandStok_rest
{
        @Autowired
        private repo_OnHandStok roh;

        @RequestMapping(path="/OnHandStokAll", method= RequestMethod.GET)
        public List<OnHandStok> getAllOnHandStok()
        {
            return (List)this.roh.ListOnHandStok();
        }
    }


