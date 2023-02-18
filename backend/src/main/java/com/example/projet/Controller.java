package com.example.projet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/users")
@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class Controller {

    @Autowired
    UserRepository repository;
//Select All Users
    @GetMapping
    public List<Users> getUser() {
        return repository.findAll();
    }
    //Select User By ID
    @GetMapping("/{id}")
    public ResponseEntity<Users> getUserById(@PathVariable(value = "id") Integer id) {
        Users user = repository.findById(id)
                .orElse(null);
        if (user == null) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok().body(user);
        }
    }
    //Delete User By Id
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") int id) {
        repository.deleteById(id);
    }
//Create User
    @PostMapping
    public Users createUser(@RequestBody Users user){
        return repository.save(user);}

//Update User
    @PutMapping("/{id}")
    public Users updateUser(@PathVariable Integer id, @RequestBody Users user) {
        Users existingUser = repository.findById(id).orElse(null);
        if (existingUser != null) {

            //existingUser.setId(user.getId());
            existingUser.setFirstName(user.getFirstName());
            existingUser.setLastName(user.getLastName());
            existingUser.setJob(user.getJob());
            return repository.save(existingUser);

        }
        return null;
    }
    }
