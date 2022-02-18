package com.example.control.rest;

import com.example.model.header_pr;
import com.example.model.purc_req;
import com.example.repo.repo_header_pr;
import com.example.repo.repo_purc_req;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

@CrossOrigin
@RestController
public class control_purch_req_rest
{
        @Autowired
        private repo_purc_req rpr;

  @Autowired
  private repo_header_pr rhp;

  private static final Logger LOGGER = LoggerFactory.getLogger(control_purch_req_rest.class);


        @RequestMapping(path="/PR_All", method= RequestMethod.GET)
        public List<purc_req> getPurc_reqAll()
        {
            return (List)this.rpr.findAll();
        }

  @PostMapping("/PRSave")
  @ResponseBody()
  public purc_req create_purc_req(@Valid purc_req pr, BindingResult bindingResult)
  {
    if (bindingResult.hasErrors()) {
      LOGGER.error("masuk ke sini");
    }
    return rpr.save(pr);
  }

  @DeleteMapping("/PRDelete")
  @Transactional
  @ResponseBody()
  public ResponseEntity<purc_req> Delete_purc_req(@RequestParam("id_pr_req")  String[] id_purc_req,  purc_req pr)
  {
    rpr.hapusdataAll(Arrays.asList(id_purc_req));
    return ResponseEntity.ok().build();
  }

  @RequestMapping(path="/HPR_validate", method= RequestMethod.GET)
  public List<purc_req> getHPR_validate()
  {
    return (List)this.rhp.findByValidate();
  }

  @RequestMapping(path="/HPR_Post", method= RequestMethod.GET)
  public List<purc_req> getHPR_Post()
  {
    return (List)this.rhp.findByPost();
  }

  @PostMapping("/HPRSave")
  @ResponseBody()
  public header_pr create_Hpurc_req(@Valid header_pr hpr,BindingResult bindeng)
  {
    if (bindeng.hasErrors()) {
      LOGGER.error("masuk ke sini");

    }
    return rhp.save(hpr);
  }

  @DeleteMapping("/HPRDelete")
  @Transactional
  @ResponseBody()
  public ResponseEntity<purc_req> Delete_Hpurc_req(@RequestParam("id_header_pr")  String[] id_header_pr,  header_pr hpr)
  {
    rhp.hapusdataAll(Arrays.asList(id_header_pr));
    return ResponseEntity.ok().build();
  }
    }


