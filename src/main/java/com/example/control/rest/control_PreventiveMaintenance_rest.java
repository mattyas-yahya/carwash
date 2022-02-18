package com.example.control.rest;

import com.example.model.PreventiveMaintenance;
import com.example.repo.repo_pm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

//import com.example.repo.repo_spare;

@RestController
public class control_PreventiveMaintenance_rest
{
    @Autowired
    private repo_pm repm;

    @RequestMapping(path="/PmAll", method= RequestMethod.GET)
    public List<PreventiveMaintenance> getPmAll()
    {
        System.out.println("---xxxxxxx----"+repm.findAll());
        return (List)this.repm.findAll();
    }

    @PostMapping("/submit_pm")
    @ResponseBody()
    public void submit_pm(PreventiveMaintenance ja)
    {
        this.repm.save(ja);

    }


    @DeleteMapping("/delete_pm")
    @Transactional
    @ResponseBody()
    public ResponseEntity<PreventiveMaintenance> DeletePreventiveMaintenance(@RequestParam("id_pm") String id_pm[])
    {
        this.repm.hapusdata(Arrays.asList(id_pm));
        return ResponseEntity.ok().build();
    }
}
