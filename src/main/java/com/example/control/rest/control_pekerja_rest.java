package com.example.control.rest;

import com.example.model.pekerja;
import com.example.repo.repo_pekerja;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

@CrossOrigin
@RestController
public class control_pekerja_rest
{
        @Autowired
        private repo_pekerja reang;

        @RequestMapping(path="/PekerjaAll", method= RequestMethod.GET)
        public List<pekerja> getPekerjaAll()
        {
            return (List)this.reang.findAll();
        }


    @PostMapping("/PekerjaSave")
    @ResponseBody()
    public pekerja createPekerja(@Valid pekerja p)
    {
        return reang.save(p);
    }

    @DeleteMapping("/PekerjaDelete")
    @Transactional
    @ResponseBody()
    public ResponseEntity<pekerja> DeletePekerja(@RequestParam("id_pekerja")  String[] idde, pekerja p)
    {
        reang.hapusdataAll(Arrays.asList(idde));
        return ResponseEntity.ok().build();
    }


    }


