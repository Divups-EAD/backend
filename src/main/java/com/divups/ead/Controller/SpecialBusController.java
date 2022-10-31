package com.divups.ead.Controller;

import com.divups.ead.Errors.BusOwnerNotFound;
import com.divups.ead.Model.SpecialBus;
import com.divups.ead.Services.SpecialBusService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/specialbus")
@CrossOrigin
public class SpecialBusController {

    private final SpecialBusService specialBusService;

    public SpecialBusController(SpecialBusService specialBusService) {
        this.specialBusService = specialBusService;
    }


    @GetMapping("/specialbuses")
    public List<SpecialBus> getAllSpecialBuses(){
        return specialBusService.getAllSpecialBuses();
    }


    @GetMapping("/specialbuses/{id}")
    public Object getSpecialBusById(@PathVariable Integer id) throws BusOwnerNotFound {

        SpecialBus specialBus = null;

        try {
            specialBus = specialBusService.getSBusById(id);
            return ResponseEntity.status(HttpStatus.FOUND).body(specialBus);
        } catch (Exception e){
            throw new BusOwnerNotFound("Special Bus not available");
        }
    }

    @PostMapping("/specialbuses")
    public SpecialBus AddSpecialBus(@RequestBody SpecialBus specialBus){
        return specialBusService.AddSBus(specialBus);
    }


    @PutMapping("/specialbuses/{id}")
    public ResponseEntity EditSBus(@PathVariable Integer id, @RequestBody SpecialBus specialBus){
        specialBus = specialBusService.EditSBus(id,specialBus);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("Special Bus Updated");
    }


    @DeleteMapping("specialbuses/{id}")
    public ResponseEntity<Map<String , Boolean>> deleteSBuses(@PathVariable Integer id) {
        boolean deleted = false;

        deleted = specialBusService.SBusDeleted(id);

        Map<String , Boolean> response = new HashMap<>();
        response.put("deleted" , deleted);
        return ResponseEntity.ok(response);
    }
}
