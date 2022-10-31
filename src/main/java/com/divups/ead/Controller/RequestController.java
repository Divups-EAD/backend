package com.divups.ead.Controller;

import com.divups.ead.Errors.BusOwnerNotFound;
import com.divups.ead.Model.Bus;
import com.divups.ead.Model.SpecialHire;
import com.divups.ead.Services.BusService;
import com.divups.ead.Services.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/request")
@CrossOrigin

public class RequestController {

    final RequestService requestService;

    public RequestController(RequestService requestService) {
        this.requestService = requestService;
    }


    @GetMapping("/requests")
    public List<SpecialHire> getAllRequests(){
        return requestService.getAllRequests();
    }


    @GetMapping("/requests/{id}")
    public Object getRequestById(@PathVariable Integer id)  throws BusOwnerNotFound {

        SpecialHire specialHire = null;

        try {
            specialHire= requestService.getRequestById(id);
            return ResponseEntity.status(HttpStatus.FOUND).body(specialHire);
        } catch (Exception e){
            throw new BusOwnerNotFound("Bus not available");
        }
    }


    @PostMapping("/requests")
    public SpecialHire AddRequest(@RequestBody SpecialHire specialHire){
        return requestService.AddRequest(specialHire);
    }


    @PutMapping("/requests/{id}")
    public ResponseEntity EditBus(@PathVariable Integer id, @RequestBody SpecialHire specialHire){
        specialHire = requestService.EditRequestStatus(id,specialHire);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body("Requests Updated");
    }

}
