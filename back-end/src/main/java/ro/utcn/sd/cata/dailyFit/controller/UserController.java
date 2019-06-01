package ro.utcn.sd.cata.dailyFit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import ro.utcn.sd.cata.dailyFit.dto.UserCreateDTO;
import ro.utcn.sd.cata.dailyFit.dto.UserLoginDTO;
import ro.utcn.sd.cata.dailyFit.dto.UserReturnDTO;
import ro.utcn.sd.cata.dailyFit.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserController(UserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/register")
    public UserReturnDTO createUser(@RequestBody UserCreateDTO user){
        return userService.create(user);
    }

    @GetMapping("/login")
    public UserReturnDTO login(@RequestBody UserLoginDTO user){
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userService.findByNameAndPassword(user);
    }

}
