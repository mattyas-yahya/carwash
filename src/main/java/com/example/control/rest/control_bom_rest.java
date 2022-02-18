package com.example.control.rest;

import com.example.model.Bom;
import com.example.repo.repo_Bom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/Api")
public class control_bom_rest
{
        @Autowired
        private repo_Bom rebo;

        @RequestMapping(path="/BomAll", method= RequestMethod.GET)
        public List<Bom> BomAll()
        {
                      return (List)this.rebo.findAll();
        }
  @PostMapping("/BomSave")
  @ResponseBody()
  public void BomSave(@Valid Bom b)
  {
    rebo.save(b);
  }

  @PostMapping("/BomPick")
  @ResponseBody()
  public void BomPick(@Valid Bom b, @RequestParam("kode_bom") String kode_bom, @RequestParam("kode_formula") String kode_formula)
  {

  }
    }


