package com.example.control.rest;

import com.example.model.self_service;
import com.example.model.suku_cadang;
import com.example.repo.repo_suku_cadang;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Stream;

@CrossOrigin
@RestController
public class control_suku_cadang_rest
{
        @Autowired
        private repo_suku_cadang rcs;
    @RequestMapping(path="/scgAll", method= RequestMethod.GET)
    public Stream<self_service> getself_serviceAll()
    {
        /////   System.out.println("stream data....   "+rcd.findAll().stream().parallel().toString());
        return (Stream)this.rcs.findAll().stream().parallel();
    }
  @PostMapping("/scg_save")
  @Transactional
  @ResponseBody()
  public void ItemsSave( suku_cadang scg)
  {
        rcs.save(scg);
  }



}


