package com.divups.ead.Controller;

import com.divups.ead.Model.User;
import com.divups.ead.Services.UserServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "http://localhost:3000/")
public class UserController {

    private final UserServices userServices;
    public UserController(UserServices userServices){this.userServices=userServices;}

    @GetMapping("/users")
    public List<User> getAllUsers(){
        return userServices.getAllUsers();
    }

    @GetMapping("/users/{id}")
    public Object getEmployeeById(@PathVariable Integer id){
        User user = null;
        try {
            user = userServices.getUserById(id);
            return ResponseEntity.status(HttpStatus.OK).body(user);
        } catch (Exception x){
           String sErrorMsg = "Error getting employee; "+x.getMessage();
            return sErrorMsg; // <<-- errant line here was causing the problem

        }


    }

    @PostMapping("/users")
    public User createUser(@RequestBody User user){
        return userServices.createUser(user);
    }


    @PutMapping("/users/{id}")
    public ResponseEntity updateUser(@PathVariable Integer id, @RequestBody User user){
        user = userServices.updateUsers(id, user);
        return ResponseEntity.status(HttpStatus.OK).body("User updated");
    }


    @DeleteMapping("users/{id}")
    public ResponseEntity<Map<String , Boolean>> deleteUsers(@PathVariable Integer id) {
        boolean deleted = false;
        deleted = userServices.userDeleted(id);
        Map<String , Boolean> response = new HashMap<>();
        response.put("deleted" , deleted);
        return ResponseEntity.ok(response);
    }
}
