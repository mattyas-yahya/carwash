package com.example.control.rest;

import com.example.model.jenis_kendaraan;
import com.example.repo.repo_jenis_kendaraan;
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
@RequestMapping("/jenis_kendaraan_rest")
public class control_jenis_kendaraan_rest
{
        @Autowired
        private repo_jenis_kendaraan rjk;
  

        @RequestMapping(path="/jenis_kendaraanAll", method= RequestMethod.GET)
        public List<jenis_kendaraan> getJenis_kendaraanAll()
        {
          
            return (List)this.rjk.findAll();
        }



        @PostMapping("/jenis_kendaraan_save")
        @ResponseBody()
        public void BomSave(@Valid jenis_kendaraan j)
        {
          rjk.save(j);
        }


}


