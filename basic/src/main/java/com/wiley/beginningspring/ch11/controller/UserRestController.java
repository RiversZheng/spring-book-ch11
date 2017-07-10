package com.wiley.beginningspring.ch11.controller;

import com.wiley.beginningspring.ch11.domain.User;
import com.wiley.beginningspring.ch11.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by nanquanyuhao
 * on 18/09/14.
 */
@RestController
@RequestMapping("/rest")
public class UserRestController {

    @Autowired
    private UserRepository userRepository;

    @RequestMapping(value = "/users", method=RequestMethod.POST)
    public void save(@RequestBody User user) {
        userRepository.save(user);
    }

    @RequestMapping(value = "/users", method=RequestMethod.GET)
    public List<User> list() {
        System.out.println("ceshiyixia");
        return userRepository.findAll();
    }

    @RequestMapping(value="/users/{id}", method=RequestMethod.GET)
    public User get(@PathVariable("id") int id) {
        return userRepository.find(id);
    }

    @RequestMapping(value="/users/{id}", method=RequestMethod.PUT)
    public void update(@PathVariable("id") int id, @RequestBody User user) {
        userRepository.update(id, user);
    }

    @RequestMapping(value="/users/{id}", method=RequestMethod.DELETE)
    public ResponseEntity<Boolean> delete(@PathVariable("id") int id) {
        userRepository.delete(id);
        return new ResponseEntity<Boolean>(Boolean.TRUE, HttpStatus.OK);
    }
}
