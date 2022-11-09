package com.divups.ead.Controller;

import com.divups.ead.Errors.BusOwnerNotFound;
import com.divups.ead.Model.Bus;
import com.divups.ead.Services.BusService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/bus")
@CrossOrigin(origins = "http://localhost:3000/")

public class BusController {

    private final BusService busService;

    public BusController(BusService busService) {
        this.busService = busService;
    }


    @GetMapping("/buses")
    public List<Bus> getAllBuses(){
        return busService.getAllBuses();
    }


    @GetMapping("/buses/{id}")
    public Object getBusById(@PathVariable Integer id) throws BusOwnerNotFound {

        Bus bus = null;

        try {
            bus = busService.getBusById(id);
            return ResponseEntity.status(HttpStatus.OK).body(bus);
        } catch (Exception e){
            throw new BusOwnerNotFound("Bus not available");
        }
    }

    @PostMapping("/buses")
    public Bus AddBus(@RequestBody Bus bus){
        return busService.AddBus(bus);
    }


    @PutMapping("/buses/{id}")
    public ResponseEntity EditBus(@PathVariable Integer id, @RequestBody Bus bus){
        bus = busService.EditBus(id,bus);
        return ResponseEntity.status(HttpStatus.OK).body("Bus Updated");
    }


    @DeleteMapping("buses/{id}")
    public ResponseEntity<Map<String , Boolean>> deleteBuses(@PathVariable Integer id) {
        boolean deleted = false;

        deleted = busService.BusDeleted(id);

        Map<String , Boolean> response = new HashMap<>();
        response.put("deleted" , deleted);
        return ResponseEntity.ok(response);
    }
}
