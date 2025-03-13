package co.develhope.gameez_progetto.controller;

import co.develhope.gameez_progetto.entity.User;
import co.develhope.gameez_progetto.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/create-user")
    public ResponseEntity<User> createUser(@RequestBody User user){
        User user1 = userService.createUser(user);
        return ResponseEntity.ok(user1);
    }

    @GetMapping("/get-all-user-attivi")
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> users = userService.getAllUsers();
        return ResponseEntity.ok(users);
    }

    @GetMapping("/find-by-id/{id}")
    public ResponseEntity<Optional<User>> findById(@PathVariable Long id){
        Optional<User> userOptional = userService.findById(id);
        if (userOptional.isPresent()){
            return ResponseEntity.ok(userOptional);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Optional<User>> updateUser(@PathVariable Long id, @RequestBody User userUpdate){
        Optional<User> userOptional = userService.updateUser(id, userUpdate);
        if (userOptional.isPresent()){
            return ResponseEntity.ok(userOptional);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/delete-logical/{id}")
    public ResponseEntity<Optional<User>> deleteLogical(@PathVariable Long id){
        Optional<User> userOptional = userService.deleteLogicalUser(id);
        if (userOptional.isPresent()){
            return ResponseEntity.ok(userOptional);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/active-status/{id}")
    public ResponseEntity<Optional<User>> activeStatus(@PathVariable Long id){
        Optional<User> userOptional = userService.activeStatusUser(id);
        if (userOptional.isPresent()){
            return ResponseEntity.ok(userOptional);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
