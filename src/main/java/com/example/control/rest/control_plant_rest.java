package com.example.control.rest;

import com.example.model.plant;
import com.example.repo.repo_plant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

@CrossOrigin
@RestController
public class control_plant_rest
{
        @Autowired
        private repo_plant repl;

        @RequestMapping(path="/PlantAll", method= RequestMethod.GET)
        public List<plant> getPlantAll()
        {
            return (List)this.repl.findAll();
        }

    @PostMapping("/PlantSave")
    @ResponseBody()
    public plant createPlant(@Valid plant pl)
    {
        return repl.save(pl);
    }

    @DeleteMapping("/PlantDelete")
    @Transactional
    @ResponseBody()
    public ResponseEntity<plant> DeletePlant(@RequestParam("id_plant")  String[] idde, plant pl)
    {
        repl.hapusdataAll(Arrays.asList(idde));
        return ResponseEntity.ok().build();
    }

    }


