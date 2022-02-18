package com.example.control.rest;

import com.example.model.MtbfMttr;
import com.example.repo.repo_MtbfMttr;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class control_MtbfMttr_rest
{
@Autowired
    repo_MtbfMttr remtb;
  @GetMapping("/SumDownTime")
  public List getFailur()
  {

    return (List)this.remtb.SumDT();

  }
    @RequestMapping(path="/MtbfAll", method= RequestMethod.GET)
    public List<MtbfMttr> getMtbfMttr()
    {
        return (List)this.remtb.findAll();
    }
}
