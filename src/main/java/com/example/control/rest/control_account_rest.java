package com.example.control.rest;

import com.example.model.Account;
import com.example.repo.repo_account;
import com.example.repo.repo_cost_doc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/AccountRest")
public class control_account_rest
{
        @Autowired
        private repo_account reac;
  @Autowired
  private repo_cost_doc reco;

        @RequestMapping(path="/AccountAll", method= RequestMethod.GET)
        public List<Account> getAccountAll()
        {
          HttpRequestHandler rh = new HttpRequestHandler() {
            @Override
            public void handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException, IOException {
              System.out.println("log"+reac.findAll());
            }
          };
            return (List)this.reac.findAll();
        }

  @RequestMapping(path="/CountAccount", method= RequestMethod.GET)
  public List<Account> getCountAccount()
  {
    return (List)this.reco.CountAccount();
  }

  @RequestMapping(path="/sumCostbyAccount", method= RequestMethod.GET)
  public List<Account> getsumCostbyAccount()
  {
    return (List)this.reco.sumCostbyAccount();
  }



}


