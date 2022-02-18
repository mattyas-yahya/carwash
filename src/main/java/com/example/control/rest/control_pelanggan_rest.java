package com.example.control.rest;

import com.example.model.*;
import com.example.repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/PelangganRest")
public class control_pelanggan_rest
{
        @Autowired
        private repo_pelanggan rpc;
 

        @RequestMapping(path="/PelangganAll", method= RequestMethod.GET)
        public List<pelanggan> getpelangganAll()
        {
          
            return (List)this.rpc.findAll();
        }

        @PostMapping("/PelangganSave")
        @ResponseBody()
                public void savepelanggan(@Valid pelanggan p)
        {
          
rpc.save(p);
        }

}


