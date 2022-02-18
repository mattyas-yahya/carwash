package com.example.control.rest;

import com.example.model.Formula;
import com.example.repo.repo_formula;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/Api")
public class control_formula_rest
{
        @Autowired
        private repo_formula refo;

        @RequestMapping(path="/FormulaAll", method= RequestMethod.GET)
        public List<Formula> getFormulaAllAll()
        {
                      return (List)this.refo.findAll();
        }
  @PostMapping("/FormulaSave")
  @ResponseBody()
  public void FormulaSave(@Valid Formula fr)
  {
    refo.save(fr);
  }
    }


