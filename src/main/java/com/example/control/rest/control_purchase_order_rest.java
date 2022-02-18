package com.example.control.rest;

import com.example.model.purc_req;
import com.example.model.purchase_order;
import com.example.repo.repo_purchase_order;
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
public class control_purchase_order_rest
{
        @Autowired
        private repo_purchase_order rpo;



  private static final Logger LOGGER = LoggerFactory.getLogger(control_purchase_order_rest.class);


        @RequestMapping(path="/PO_All", method= RequestMethod.GET)
        public List<purchase_order> getPO_All()
        {
            return (List)this.rpo.findAll();
        }

  @PostMapping("/POSave")
  @ResponseBody()
  public purchase_order create_po(@Valid purchase_order po, BindingResult bindingResult)
  {
    if (bindingResult.hasErrors())
    {
      LOGGER.error("errornya tuh di sini");
    }
    return rpo.save(po);
  }

  @DeleteMapping("/PODelete")
  @Transactional
  @ResponseBody()
  public ResponseEntity<purc_req> Delete_purc_req(@RequestParam("id_purchase_order")  String[] id_purchase_order,  purchase_order po)
  {
    rpo.hapusdataAll(Arrays.asList(id_purchase_order));
    return ResponseEntity.ok().build();
  }



    }


