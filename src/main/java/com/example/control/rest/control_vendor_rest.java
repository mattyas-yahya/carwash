package com.example.control.rest;

import com.example.model.vendor;
import com.example.repo.repo_vendor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin
@RestController
public class control_vendor_rest
{
        @Autowired
        private repo_vendor rev;

        @RequestMapping(path="/VendorAll", method= RequestMethod.GET)
        public List<vendor> getVendorAll()
        {
            return (List)this.rev.findAll();
        }


    }


