package com.example.control.rest;

import com.example.model.kendaraan;
import com.example.repo.repo_kendaraan;
import com.example.repo.repo_cost_doc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/kendaraan_rest")
public class control_kendaraan_rest
{
        @Autowired
        private repo_kendaraan rk;
  

        @RequestMapping(path="/kendaraanAll", method= RequestMethod.GET)
        public List<kendaraan> getkendaraanAll()
        {
          
            return (List)this.rk.findAll();
        }



        @PostMapping("/kendaraan_save")
        @ResponseBody()
        public void SaveKendaraan(@Valid kendaraan k)
        {
          rk.save(k);
        }


}


