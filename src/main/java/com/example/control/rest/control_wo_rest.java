package com.example.control.rest;

import com.example.model.Asset;
import com.example.model.jadwal;
import com.example.model.work_orders;
import com.example.model.work_orders_aud;
import com.example.repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@CrossOrigin
@RestController
public class control_wo_rest
{
@Autowired
    repo_wo rew;

    @Autowired
    repo_aud_wo reaw;
    @Autowired
    repo_tr_asset reas;
  @Autowired
  repo_dashboard redash;
    @Autowired
    repo_jadwal reja;


    @RequestMapping(path="/work_orders_info", method= RequestMethod.GET)
    public List<work_orders> getwork_orders_info()
    {
        return (List)this.rew.work_orders_info();
    }


    @RequestMapping(path="/WoAllv2", method= RequestMethod.GET)
    public List<work_orders> getAll()
    {
//        return (List)this.rew.findAll();
      return (List)this.rew.FindAllv1();
    }

    @RequestMapping(path="/WoAll", method= RequestMethod.GET)
    public List<work_orders> getAllWo()
    {

        return (List)this.rew.findQ();
    }

    @RequestMapping(path="/WoCost", method= RequestMethod.GET)
    public List<work_orders> getWoCost()
    {

        return (List)this.rew.findby_TAKEOVER_WIP();
    }

    @RequestMapping(path="/WoAllEnd", method= RequestMethod.GET)
    public List<work_orders> getAllWoEnd()
    {
        return (List)this.rew.findX();
    }
 // @Cacheable(cacheNames = "WoIncoming")
    @RequestMapping(path="/WoIncoming", method= RequestMethod.GET)
    public List<work_orders> getInWo()
    {
        return (List)this.rew.findByVerified();
    }

    @RequestMapping(path="/WoTake", method= RequestMethod.GET)
    public List<work_orders> WoTake()
    {

        return (List)this.rew.findTake();
    }

    @RequestMapping(path="/sumwo", method= RequestMethod.GET)
    public List<work_orders> sumwo()
    {
      return (List)this.rew.sum_status();
    }


  @RequestMapping(path="/SelectEndJob", method= RequestMethod.GET)
  public List<work_orders> SelectEndJob()
  {
    return (List)this.rew.SelectEndJob();
  }

    @RequestMapping(path="/sumend", method= RequestMethod.GET)
    public List<work_orders> sumend()
    {
        return (List)this.rew.sum_End_Job();
    }

    @RequestMapping(path="/sumwip", method= RequestMethod.GET)
    public List<work_orders> sumwip()
    {

        return (List)this.rew.sum_Work_In_Progrees();
    }

    @RequestMapping(path="/sumtake", method= RequestMethod.GET)
    public List<work_orders> sumtake()
    {

        return (List)this.rew.sum_take_over();
    }

  @RequestMapping(path="/sumDT", method= RequestMethod.GET)
  public List<work_orders> sumDT()
  {
    return (List)this.rew.sumDT();
  }

  @RequestMapping(path="/overview", method= RequestMethod.GET)
  public List<work_orders> list_ov()
  {
    return (List)this.rew.Wo_Overview();
  }

    @PostMapping("/submit_sc")
    @Transactional
    @ResponseBody()
    public void creatcost_doc(@RequestParam("kode_asset")  String kode_asset, work_orders wo, work_orders_aud awo)
    {
        this.rew.save(wo);
        this.reaw.save(awo);
        this.reas.SetRepair(kode_asset);

    }
    @PostMapping("/submit_wo")
    @ResponseBody()
    public void submit_wo(jadwal ja, work_orders wo, work_orders_aud woa)
    {
//        if(kode_pm.contains("PM"))
//        {
//            this.rew.save(wo);
//            this.reja.save_manual(kode_pm,start,end,title,lokasi);
//        }
//        else
//            {
//                this.rew.save(wo);
//                this.reaw.save(woa);
//            }
        this.rew.save(wo);
              this.reaw.save(woa);
              this.reja.save(ja);

    }

    @DeleteMapping("/delete_wo")
    @Transactional
    @ResponseBody()
    public ResponseEntity<Asset> DeleteAsset(@RequestParam("id_wo") String idw[])
    {
        this.rew.hapusdataAll(Arrays.asList(idw));
        return ResponseEntity.ok().build();
    }
}
