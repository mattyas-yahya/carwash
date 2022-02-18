package com.example.control.rest;

import com.example.model.Asset;
import com.example.repo.repo_asset;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;
@CrossOrigin
@RestController
public class control_asset_rest
{
        @Autowired
        private repo_asset reas;

        @RequestMapping(path="/AssetAll", method= RequestMethod.GET)
        public List<Asset> getAllAsset()
        {
            return (List)this.reas.findAll();
        }

  @RequestMapping(path="/AssetRepair", method= RequestMethod.GET)
  public List<Asset> getAssetRepair()
  {
    return (List)this.reas.NotRepair();
  }

//  @RequestMapping(path="/AssetActive", method= RequestMethod.GET)
//  public List<Asset> getAssetActive()
//  {
//    return (List)this.reas.findActive();
//  }

  @RequestMapping(path="/sumasset", method= RequestMethod.GET)
  public List<Asset> sumasset()
  {
    return (List)this.reas.sum_asset();
  }

//  @RequestMapping(path="/c_active_asset", method= RequestMethod.GET)
//  public List<Asset> c_active_asset()
//  {
//    return (List)this.reas.CountActive();
//  }
//
//  @RequestMapping(path="/c_disposal_asset", method= RequestMethod.GET)
//  public List<Asset> c_disposal_asset()
//  {
//    return (List)this.reas.CountDisposal();
//  }

  @PostMapping("/AssetSave")
  @ResponseBody()
  public Asset creatAsset(@Valid Asset as)
  {
    return reas.save(as);
  }


  @DeleteMapping("/AssetDelete")
  @Transactional
  @ResponseBody()
  public ResponseEntity<Asset> DeleteAsset(@RequestParam("id_asset")  String[] idde, Asset as)
  {
    reas.hapusdataAll(Arrays.asList(idde));
    return ResponseEntity.ok().build();
  }

    }


