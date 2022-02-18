package com.example.control.rest;

import com.example.model.*;
import com.example.repo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

@CrossOrigin
@RestController
public class control_cost_doc_rest
{

@Autowired
private repo_cost_doc rcd;
    @Autowired
    private repo_cost_doc_dashboard rcdh;
@Autowired
private repo_cost_doc_aud rcda;
@Autowired
private repo_wo rw;
@Autowired
private repo_jadwal rj;
@Autowired
repo_tr_asset retas;
@Autowired
repo_tr_asset rta;
@Autowired
repo_stok_card rsc;

    @RequestMapping(path="/SumCostByMonth", method= RequestMethod.GET)
    public List<cost_doc_dashboard> getSumCostByMonth()
    {
        return (List)this.rcd.SumCostByMonth();
    }


@RequestMapping(path="/Cbd", method= RequestMethod.GET)
public List<cost_doc> getCostByDate()
{
return (List)this.rcd.sumCostbyDate();
}


@RequestMapping(path="/CostDocAll", method= RequestMethod.GET)
public Stream<cost_doc> getCostDocAll()
{
/////   System.out.println("stream data....   "+rcd.findAll().stream().parallel().toString());
return (Stream)this.rcd.findAll().stream().parallel();
}

@RequestMapping(path="/Issue", method= RequestMethod.GET)
public Stream<cost_doc> getIssue()
{
/////   System.out.println("stream data....   "+rcd.findAll().stream().parallel().toString());
return (Stream)this.rcd.issue().stream().parallel();
}

@RequestMapping(path="/IssueCosting", method= RequestMethod.GET)
public Stream<cost_doc> getIssueCosting()
{
/////   System.out.println("stream data....   "+rcd.findAll().stream().parallel().toString());
return (Stream)this.rcd.issue_costing().stream().parallel();
}

@RequestMapping(path="/CostDocAudAll", method= RequestMethod.GET)
public List<cost_doc_aud> getCostDocAudAll()
{
return (List)this.rcda.findAll();
}
//  @PostMapping("/CostSave")
//  @ResponseBody()
//  public cost_doc creatcost_doc(@Valid cost_doc cd)
//  {
//    return rcd.save(cd);
//
//  }

@PostMapping("/CostSave")
@Transactional
@ResponseBody()
public void creatcost_doc(@RequestParam("kode")  String wo_code,@RequestParam("id_inv_org")  String id_inv_org,@RequestParam("quantity")  int quantity,@RequestParam("id_cost_doc") String id_cost_doc,@RequestParam("pembuatan") String date_transaction,@RequestParam("item") String kode_inventory,@RequestParam("cost") int harga,@RequestParam("quantity") int consume, cost_doc cd, cost_doc_aud cda,stok_card sc)
{

String id_Stok_card= UUID.randomUUID().toString();
System.out.println("id_Stok_card"+id_Stok_card);
if(cda.getKode()==null)
{
System.out.println(cda.getKode()+"record belom ada");
}
else
{
System.out.println(cda.getKode()+"record existing ");
}
    rcd.save(cd);
    rsc.SAVE_COST_DOC_TO_STOCK_CARD(id_Stok_card,date_transaction,kode_inventory,harga,consume);
rcd.pemakaian(quantity,id_inv_org);
rcda.save(cda);
retas.SetActive(wo_code);
}

@DeleteMapping("/CostDelete")
@Transactional
@ResponseBody()
public ResponseEntity<cost_doc> Deletecost_doc(@RequestParam("id_cost_doc")  String[] idde, cost_doc cd)
{
rcd.hapusdataAll(Arrays.asList(idde));
return ResponseEntity.ok().build();
}

@PostMapping("/Costing")
@ResponseBody()
public ResponseEntity<cost_doc> costing_doc(@RequestParam("kode")  String kode1,@RequestParam("kode")  String kode)
{
rw.Costingin(kode1);
rw.Costinginpm(kode1);
rta.SetActive(kode);
return ResponseEntity.ok().build();

}


}


