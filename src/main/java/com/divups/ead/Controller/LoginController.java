package com.divups.ead.Controller;

import com.divups.ead.Entity.Login;
import com.divups.ead.Entity.UserEntity;
import com.divups.ead.Model.User;
import com.divups.ead.Repository.UserRepository;
import com.divups.ead.Services.LoginServices;
import com.divups.ead.Services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "http://localhost:3000/")
public class LoginController {

    private final LoginServices loginServices;
    @Autowired
    private UserRepository userRepository;
    public  LoginController(LoginServices loginServices){this.loginServices=loginServices;}

    @PostMapping("/login")
    public ResponseEntity Login(@RequestBody Login login) throws Exception{
        try {

            System.out.println(login.getEmail());
            UserEntity user = userRepository.findByEmail(login.getEmail());


            if(user.getPassword().equals(login.getPassword())){
                HashMap<String, String> map = new HashMap<>();
                map.put("role", user.getUser_role());
                map.put("id", String.valueOf(user.getUser_id()));
                map.put("status", "success");
                return ResponseEntity.status(HttpStatus.OK).body(map);
            }else{
                HashMap<String, String> map = new HashMap<>();
                map.put("status", "Invalid Password");
                return ResponseEntity.status(HttpStatus.OK).body(map);
            }
        } catch (Exception e){
            HashMap<String, String> map = new HashMap<>();
            map.put("status", "Invalid Email");
            return ResponseEntity.status(HttpStatus.OK).body(map);
        }
    }
}
