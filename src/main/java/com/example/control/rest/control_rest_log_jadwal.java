package com.example.control.rest;

import com.example.model.log_jadwal;
import com.example.repo.repo_log_jadwal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class control_rest_log_jadwal
{
  @Autowired
  repo_log_jadwal reja;





    @RequestMapping(path="/log_calendar", method= RequestMethod.GET)

    public List<log_jadwal> getAllJadwal()
    {
      return (List)this.reja.findAll();
    }



}
