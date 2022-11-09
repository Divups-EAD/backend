package com.divups.ead.Controller;

import com.divups.ead.Errors.BusOwnerNotFound;

import com.divups.ead.Model.BusOwner;
import com.divups.ead.Model.User;
import com.divups.ead.Services.BusOwnerService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/busowner")
@CrossOrigin(origins = "http://localhost:3000/")
public class BusOwnerController {

    private BusOwnerService busOwnerService;

    public BusOwnerController (BusOwnerService busOwnerService){
        this.busOwnerService=busOwnerService;
    }


    @GetMapping("/busowners")
    public List<BusOwner> getAllBusOwner(){
        return busOwnerService.getAllBusOwner();
    }


    @GetMapping("/busowners/{id}")
    public Object getBusOwnerById(@PathVariable Integer id) throws BusOwnerNotFound {

       BusOwner busOwner = null;

        try {
            busOwner = busOwnerService.getSBusOwnerById(id);
            return ResponseEntity.status(HttpStatus.FOUND).body(busOwner);
        } catch (Exception e){
            throw new BusOwnerNotFound("Bus Owner not available");
        }
    }


    @PostMapping("/busowners")
    public BusOwner AddBusOwner(@RequestBody BusOwner busOwner){
       return busOwnerService.AddSBusOwner(busOwner);
    }


    @PutMapping("/busowners/{id}")
    public ResponseEntity updateBusOwner(@PathVariable Integer id, @RequestBody BusOwner busOwner){

        busOwner = busOwnerService.EditSBusOwner(id,busOwner);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("Bus Owner updated");
    }

}
