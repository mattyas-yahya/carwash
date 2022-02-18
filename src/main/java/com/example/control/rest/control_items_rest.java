package com.example.control.rest;

import com.example.model.Items;
import com.example.repo.repo_items;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

@RestController
@CrossOrigin
public class control_items_rest
{
        @Autowired
        private repo_items reit;




  @Cacheable(cacheNames = "ItemsAll")
      @RequestMapping(path="/ItemsAll", method= RequestMethod.GET)
        public List<Items> getItemsAll()
        {
            return (List)this.reit.findAll();
        }

  @PostMapping("/ItemsSave")
  @ResponseBody()
  public void ItemsSave(@Valid Items it)
  {
    reit.save(it);
  }

  @DeleteMapping("/ItemsDelete")
  @Transactional
  @ResponseBody()
  public ResponseEntity<Items> ItemsDelete(@RequestParam("id_Items")  String[] id_Items, Items it)
  {
    reit.hapusdataAll(Arrays.asList(id_Items));
    return ResponseEntity.ok().build();
  }

}


