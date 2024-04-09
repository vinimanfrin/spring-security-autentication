package com.vinimanfrin.autentication.controllers;

import com.vinimanfrin.autentication.domain.user.LoginResponseDTO;
import com.vinimanfrin.autentication.domain.user.UserAuthenticationDTO;
import com.vinimanfrin.autentication.domain.user.UserRegisterDTO;
import com.vinimanfrin.autentication.domain.user.User;
import com.vinimanfrin.autentication.infra.security.service.TokenService;
import com.vinimanfrin.autentication.repositories.UserRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class UserAuthenticationController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TokenService tokenService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid UserAuthenticationDTO data){
        UsernamePasswordAuthenticationToken usernamePasswordToken = new UsernamePasswordAuthenticationToken(data.email(),data.password());
        var auth = this.authenticationManager.authenticate(usernamePasswordToken);

        var token =  this.tokenService.generateToken((User) auth.getPrincipal());

        return ResponseEntity.ok(new LoginResponseDTO(token));
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid UserRegisterDTO data){
        if (this.userRepository.findByEmail(data.email()) != null) return ResponseEntity.badRequest().body("Email ja cadastrado");

        var encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
        User user = new User(data.email(),encryptedPassword, data.role());

        this.userRepository.save(user);

        return ResponseEntity.status(201).build();
    }

}
