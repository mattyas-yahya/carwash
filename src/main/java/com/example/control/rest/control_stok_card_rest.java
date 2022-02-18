package com.example.control.rest;

import com.example.model.journal_transaction;
import com.example.model.stok_card;
import com.example.repo.repo_journal_transaction;
import com.example.repo.repo_stok_card;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;

@CrossOrigin
@RestController
public class control_stok_card_rest
{
        @Autowired
        private repo_stok_card rsc;

    @Autowired
    private repo_journal_transaction rjt;

  @PostMapping("/Save")
  @ResponseBody()
  @Transactional
  public void Creatstok_card(stok_card sc, journal_transaction jt)
  {
     rsc.save(sc);
      rjt.save(jt);
  }




    }


