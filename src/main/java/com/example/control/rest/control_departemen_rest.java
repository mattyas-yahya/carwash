package com.example.control.rest;

import com.example.model.Departemen;
import com.example.repo.repo_departemen;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

@CrossOrigin
@RestController
public class control_departemen_rest
{
    @Autowired
private repo_departemen remen;


    @GetMapping("/DeptAll")
    public List<Departemen> getAllDept()
    {
        return (List)this.remen.findAll();
    }

  @PostMapping("/DeptSave")
  @ResponseBody()
  public Departemen creatDepartemen(@Valid  Departemen d)
    {
    return remen.save(d);
  }

  @DeleteMapping("/DeptDelete")
  @Transactional
  @ResponseBody()
  public ResponseEntity<Departemen> DeleteDepartemen(@RequestParam("id_dept")  String[] idde, Departemen de)
  {
    remen.hapusdata(Arrays.asList(idde));
    return ResponseEntity.ok().build();
  }

  }

