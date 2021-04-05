package com.firma.student.controller;

import java.util.List;
import java.util.Optional;

import com.firma.student.model.User;
import com.firma.student.repository.UserRepository;
import com.firma.student.service.RequestUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.firma.student.ResponseHandler;


// manandakan sebagai class controller dan membuat sebuah route dengan nama user.

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserRepository userRepo;
    RequestUser reqUser;
    // mengambil semua data user
    @GetMapping("/")
    public List<User> all(){
        return userRepo.findAll();
    }

    // membuat data baru
    @PostMapping("/")
    public User add(@RequestParam("first_name") String firstName, @RequestParam("last_name") String lastName, @RequestParam("address") String address) {

        User user = new User();
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setAddress(address);

        return userRepo.save(user);
    }

    // mengubah data
    @PutMapping("/{id}")
    public User update(@PathVariable("id") Long id, @RequestParam("first_name") String firstName, @RequestParam("last_name") String lastName, @RequestParam("address") String address) {

        User user = new User();
        user.setId(id);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setAddress(address);

        return userRepo.save(user);
    }

    // menghapus data
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long id) {

        User user = new User();
        user.setId(id);

        userRepo.delete(user);
    }

    // mengambil satu data user
    @GetMapping("/{id}")
    public Optional<User> find(@PathVariable("id") Long id){
        Optional<User> user = userRepo.findById(id);
        return user;
    }

    @RequestMapping("/respCostum")
    ResponseEntity<Object> getAllCountry() {
        return ResponseHandler.generateResponse(HttpStatus.OK, false, "Success", userRepo.findAll());
    }

    @ResponseBody @RequestMapping("/reqBody")
    ResponseEntity<Object> getUser(@RequestBody RequestUser user) {
        return ResponseHandler.generateResponse(
                HttpStatus.OK,
                false,
                "Success",
                userRepo.findById(user.getId()));
    }
}