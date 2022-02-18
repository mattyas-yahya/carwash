package com.example.control.rest;

import com.example.model.Location;
import com.example.repo.repo_location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

@CrossOrigin
@RestController
public class control_location_rest
{
        @Autowired
        private repo_location reloc;

        @RequestMapping(path="/LocationAll", method= RequestMethod.GET)
        public List<Location> getLocationAll()
        {
            return (List)this.reloc.findAll();
        }

    @PostMapping("/LocationSave")
    @ResponseBody()
    public Location createLocation(@Valid Location l)
    {
        return reloc.save(l);
    }

    @DeleteMapping("/LocationDelete")
    @Transactional
    @ResponseBody()
    public ResponseEntity<Location> DeleteLocation(@RequestParam("id_location")  String[] idde, Location l)
    {
        reloc.hapusdata(Arrays.asList(idde));
        return ResponseEntity.ok().build();
    }
    }


