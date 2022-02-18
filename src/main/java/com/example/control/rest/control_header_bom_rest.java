package com.example.control.rest;

import com.example.model.Bom;
import com.example.model.header_bom;
import com.example.repo.repo_Bom;
import com.example.repo.repo_header_bom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/h_bom_Rest")
public class control_header_bom_rest
{
        @Autowired
        private repo_header_bom rhb;
  @Autowired
  private repo_Bom rebo;

        @RequestMapping(path="/h_bom_All", method= RequestMethod.GET)
        public List<header_bom> HeaderAll()
        {
            return (List)this.rhb.findAll();
        }

  @PostMapping("/h_bom_Save")
  @ResponseBody()
  @Transactional
  public void h_bom_Save(@Valid header_bom hb, @RequestParam("kode_bom") String kode_bom, @RequestParam("kode_formula") String kode_formula, @RequestParam("Quantity") int Quantity)
  {
    rhb.save(hb);
    this.rebo.bom_pl(kode_bom,kode_formula,Quantity);
    System.out.println("succes !!!!!!");

  }
  @RequestMapping(path="/bomAll", method= RequestMethod.GET)
  public List<Bom> bom_()
  {
    return (List)this.rebo.SelectAllByTotal();
  }



//  @DeleteMapping("/AssetDelete")
//  @Transactional
//  @ResponseBody()
//  public ResponseEntity<Asset> DeleteAsset(@RequestParam("id_asset")  String[] idde, Asset as)
//  {
//    reas.hapusdataAll(Arrays.asList(idde));
//    return ResponseEntity.ok().build();
//  }

    }


