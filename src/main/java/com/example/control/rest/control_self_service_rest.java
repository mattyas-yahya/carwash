package com.example.control.rest;

import com.example.model.self_service;
import com.example.repo.repo_self_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.stream.Stream;

@CrossOrigin
@RestController
public class control_self_service_rest
{

        @Autowired
        private repo_self_service rss;


        @RequestMapping(path="/self_serviceAll", method= RequestMethod.GET)
        public Stream<self_service> getself_serviceAll()
        {
         /////   System.out.println("stream data....   "+rcd.findAll().stream().parallel().toString());
          return (Stream)this.rss.findAll().stream().parallel();
        }




  @PostMapping("/SSave")
  @Transactional
  @ResponseBody()
  public void creatcost_doc(self_service ss)
  {
      rss.save(ss);

  }

 


    }


