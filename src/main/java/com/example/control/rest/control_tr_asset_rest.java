package com.example.control.rest;

import com.example.model.Tr_asset;
import com.example.model.sparepart;
import com.example.repo.repo_spare;
import com.example.repo.repo_tr_asset;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;



@CrossOrigin
@RestController
public class control_tr_asset_rest
{
        @Autowired
        private repo_tr_asset retaset;
    @Autowired
    repo_spare resp;

    @RequestMapping(path="/asset_info", method= RequestMethod.GET)
    public List getAsset_info()
    {
        return (List)this.retaset.asset_info();
    }


    @RequestMapping(path="/AssetActivationAll", method= RequestMethod.GET)
        public List<Tr_asset> getActiveAssetAll()
        {
            return (List)this.retaset.findAll();
        }
//
//  @RequestMapping(path="/AssetRepair", method= RequestMethod.GET)
//  public List<Tr_asset> getAssetRepair()
//  {
//    return (List)this.retaset.NotRepair();
//  }
//
    @CrossOrigin
  @RequestMapping(path="/TrAssetActive", method= RequestMethod.GET)
  public List<Tr_asset> getAssetActive()
  {
    return (List)this.retaset.findActive();
  }
    @RequestMapping(path="/CountAssetRepair", method= RequestMethod.GET)
    public List<Tr_asset>  getCountAssetRepair()
    {
        return this.retaset.CountRepair();
    }
//  @RequestMapping(path="/sumasset", method= RequestMethod.GET)
//  public List<Tr_asset> sumasset()
//  {
//    return (List)this.retaset.sum_asset();
//  }

  @RequestMapping(path="/c_active_asset", method= RequestMethod.GET)
  public List<Tr_asset> c_active_asset()
  {
    return (List)this.retaset.CountActive();
  }
//
  @RequestMapping(path="/c_disposal_asset", method= RequestMethod.GET)
  public List<Tr_asset> c_disposal_asset()
  {
    return (List)this.retaset.CountDisposal();
  }

  @PostMapping("/AssetActiveSave")
  @ResponseBody()
  public void creatAssetActive(Tr_asset as)
  {
     retaset.save(as);
  }


//  @DeleteMapping("/AssetDelete")
//  @Transactional
//  @ResponseBody()
//  public ResponseEntity<Asset> DeleteAsset(@RequestParam("id_asset")  String[] idde, Asset as)
//  {
//    reas.hapusdataAll(Arrays.asList(idde));
//    return ResponseEntity.ok().build();
//  }
@RequestMapping(path = "/GetSpare", method = RequestMethod.GET)
public List<sparepart> getAll() {
    return (List) resp.findAll();
}



    @PostMapping("/sparesave")
    @ResponseBody()
    public ResponseEntity<sparepart> createSpare(@Valid sparepart spr)
    {
        if(spr.getAsset_code()==null)
        {
            System.out.println(spr.getAsset_code()+"record belom ada");
        }
        else
        {
            System.out.println(spr.getAsset_code()+"record existing ");
        }
         resp.save(spr);
   return ResponseEntity.ok().build();

    }

}



