package local.patrickchow0803.crudsprintchallenge.crudsprintchallenge.controllers;

import local.patrickchow0803.crudsprintchallenge.crudsprintchallenge.models.User;
import local.patrickchow0803.crudsprintchallenge.crudsprintchallenge.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    UserService userService;

    // Get the list of users
    // http://localhost:2019/users/users
    @GetMapping(value = "/users",
                produces = {"application/json"})
    public ResponseEntity<?> getAllUsers() {
        List<User> userList = userService.getAllUsers();
        return new ResponseEntity<>(userList, HttpStatus.OK);
    }

    // Get a user's details
    // http://localhost:2019/users/user/1
    @GetMapping(value = "/user/{userid}",
                produces = {"application/json"})
    public ResponseEntity<?> getUserById(@PathVariable long userid){
        User getUser = userService.getUserById(userid);
        return new ResponseEntity<>(getUser, HttpStatus.OK);
    }

    // Add a user
    // http://localhost:2019/users/user
    @PostMapping(value = "/user", produces = {"application/json"})
    public ResponseEntity<?> addUser(@RequestBody User user){
        user = userService.addUser(user);

        HttpHeaders responseHeaders = new HttpHeaders();

        URI userUri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(user.getUserid())
                .toUri();

        responseHeaders.setLocation(userUri);

        return new ResponseEntity<>("New User's Id is " + user.getUserid(), responseHeaders, HttpStatus.CREATED);
    }

}
