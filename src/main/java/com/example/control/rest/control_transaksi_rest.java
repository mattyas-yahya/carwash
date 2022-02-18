package com.example.control.rest;

import com.example.model.*;
import com.example.repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.sql.Date;

import java.io.IOException;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/TransaksiRest")
public class control_transaksi_rest
{
        @Autowired
        private repo_transaksi rt;
  
        @RequestMapping(path="/TransaksiAll", method= RequestMethod.GET)
        public List<transaksi> getAccountAll()
        {
            return (List)this.rt.findAll();
        }

        @PostMapping("/transaksi_save")
        @ResponseBody()
        public void SaveKendaraan(@Valid transaksi t)
        {
          rt.save(t);
        }

        @RequestMapping(path="/sum_biaya", method= RequestMethod.GET)
        public List<transaksi> getSumBiaya()
        {
            return (List)this.rt.sum_biaya();
        }
        
        @PostMapping("/transaksi_all")
        public List getTransaksi(@RequestParam("start_date")  Date start_date,@RequestParam("end_date")  Date end_date)
        {
            return (List)this.rt.stok_barang2(start_date,end_date);
        }
}


