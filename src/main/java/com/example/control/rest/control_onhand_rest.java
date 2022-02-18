package com.example.control.rest;
import com.example.model.*;
import com.example.repo.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class control_onhand_rest
{
        @Autowired
         repo_onhand reon;
@Autowired
repo_stok_card rsc;
    private static final Logger LOGGER = LoggerFactory.getLogger(control_purchase_order_rest.class);


//      @RequestMapping(path="/OnhandAll", method= RequestMethod.GET)
//        public List<Onhand> getOnhandAll()
//        {
//            return (List)this.reon.findAll();
//        }

    @RequestMapping(path="/OnhandAll", method= RequestMethod.GET)
    public List getOnhandAll()
    {
        return (List)this. rsc.stok_barang();
    }

    @PostMapping("/OnhandAllv2")
    public List<stok_card> getOnhandAllv2(@RequestParam("start_date")  String start_date,@RequestParam("end_date")  String end_date)
    {
        return (List)this.rsc.stok_barang2(start_date,end_date);
    }
    @PostMapping("/StockCard")
    public List<stok_card> getOnhandAllv2(@RequestParam("start_date")  String start_date,@RequestParam("end_date")  String end_date,@RequestParam("kode_inventory")  String kode_inventory)
    {
        return (List)this.rsc.stok_card(start_date,end_date,kode_inventory);
    }

    @PostMapping("/OnhandSave")
    @ResponseBody()
   public ResponseEntity<Onhand> savedata( Onhand oh)
  {
     this.reon.save(oh);
      return ResponseEntity.ok().build();

  }

//  @DeleteMapping("/OnhandDelete")
//  @Transactional
//  @ResponseBody()
//  public ResponseEntity<Items> ItemsDelete(@RequestParam("id_Items")  String[] id_Items, Items it)
//  {
//    reit.hapusdataAll(Arrays.asList(id_Items));
//    return ResponseEntity.ok().build();
//  }

}


