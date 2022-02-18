package com.example.control.rest;

import com.example.model.inventaris;
import com.example.repo.repo_inventaris;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

@CrossOrigin
@RestController
public class control_inventaris_rest
{
        @Autowired
        repo_inventaris rev;
    private static final Logger LOGGER = LoggerFactory.getLogger(control_purchase_order_rest.class);

  @RequestMapping(path="/inventoryAll", method= RequestMethod.GET)
  public List<inventaris> getInventoryAll()
  {
    return (List)this.rev.findAll();
  }

  @PostMapping("/insave")
  @ResponseBody()
  public inventaris inv_save(@Valid inventaris i)
    {
        return rev.save(i);
    }


    @DeleteMapping("/indelete")
    @Transactional
    @ResponseBody()
    public ResponseEntity<inventaris> Deleteinv(@RequestParam("id_inventaris")  String[] id_inventaris)
    {
        rev.hapusdataAll(Arrays.asList(id_inventaris));
        return ResponseEntity.ok().build();
    }

    }


