package com.example.control.rest;

import com.example.model.*;
import com.example.repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class control_rest_jadwal
{
  @Autowired
  repo_jadwal reja;
  @Autowired
  repo_wo rewo;

  @RequestMapping(path="/jadwal_info", method= RequestMethod.GET)
  public List getJadwal_info()
  {
    return (List)this.reja.jadwal_info();
  }


//
//    @RequestMapping(path="/calendar", method= RequestMethod.GET)
//    public List<jadwal> getAllJadwal()
//    {
//      return (List)this.reja.findAll();
//     // return (List)this.reja.new_findall();
//
//    }
  @RequestMapping(path="/calendar", method= RequestMethod.GET)
  public List<work_orders> getAllWork_orders()
  {
    return (List)this.rewo.findAll();

  }

  @RequestMapping(path="/AllPm", method= RequestMethod.GET)
  public List<jadwal> getAll()
  {
    return (List)this.reja.sum_all_pm();
  }

  @RequestMapping(path="/End_JobPm", method= RequestMethod.GET)
  public List<jadwal> End_JobPm()
  {
    return (List)this.reja.sum_End_Job();
  }

  @RequestMapping(path="/Work_In_ProgreesPm", method= RequestMethod.GET)
  public List<jadwal> Work_In_ProgreesPm()
  {
    return (List)this.reja.sum_Work_In_Progrees();
  }

  @RequestMapping(path="/take_overPm", method= RequestMethod.GET)
  public List<jadwal> take_overPm()
  {
    return (List)this.reja.sum_take_over();
  }

}
