package com.example.control.rest;

import com.example.model.journal;
import com.example.model.journal_transaction;
import com.example.repo.repo_journal;
import com.example.repo.repo_journal_transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class control_journal_rest
{

  @Autowired
  private repo_journal rj;
    @Autowired
    private repo_journal_transaction rjt;

        @RequestMapping(path="/JournalAll", method= RequestMethod.GET)
        public List<journal> getjournalAll()
        {

            return (List)this.rj.findAll();
        }

    @RequestMapping(path="/JournalTransactionAll", method= RequestMethod.GET)
    public List<journal_transaction> getJournalTransactionAll()
    {

        return (List)this.rjt.findAll();
    }

    @PostMapping("/JournalSave")
    @ResponseBody()

    public void createjournal( journal j)
    {
         rj.save(j);

    }



}


