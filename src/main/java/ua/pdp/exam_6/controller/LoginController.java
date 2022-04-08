package ua.pdp.exam_6.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.pdp.exam_6.dto.UserDto;
import ua.pdp.exam_6.security.JWTProvider;
import ua.pdp.exam_6.service.UserServiceImpl;

@RestController
@RequestMapping("/api/login")
public class LoginController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserServiceImpl userService;

    @Autowired
    JWTProvider jwtProvider;

    @PostMapping
    public ResponseEntity login(@RequestBody UserDto userDto) {

        UserDetails userDetails = userService.loadUserByUsername(userDto.getUsername());
        String generatedToken = jwtProvider.generateToken(userDetails.getUsername());

        return ResponseEntity.ok(generatedToken);


    }
}
