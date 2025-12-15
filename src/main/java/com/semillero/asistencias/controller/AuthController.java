package com.semillero.asistencias.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.DisabledException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.security.core.Authentication;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.semillero.asistencias.Jwt.JwtUtil;
import com.semillero.asistencias.dto.request.LoginForm;
import com.semillero.asistencias.exception.ValidatedRequestException;
import com.semillero.asistencias.service.impl.UserDetailsImpl;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/auth")
@Slf4j
public class AuthController {

 
    @Autowired
    private AuthenticationManager authenticationManager;

    private JwtUtil jwtUtil;

    public AuthController(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;

    }

    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody LoginForm loginForm) {

        try {
            log.info(loginForm.toString());
            String username = loginForm.getUsername();
            String password = loginForm.getPassword();
            
            log.info("Usuario: " + username);
            log.info("Password: " + password);


            Authentication auth = this.authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(username, password)
            );

            List<String> roles = auth.getAuthorities().stream()
                .map(r -> r.getAuthority())
                .toList();
            UserDetailsImpl userdetails = (UserDetailsImpl) auth.getPrincipal();
            Long idUsuario = userdetails.getId();

            Map<String, Object> response = new HashMap<>();
            response.put("token", jwtUtil.generateToken(username, roles, idUsuario));

            return ResponseEntity.status(HttpStatus.OK).body(response);
            
        } 
        catch (DisabledException e){
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Usuario deshabilitado");
        }
        catch (Exception e) {
            System.err.println(e.getMessage());
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Credenciales inválidas");
        }
    }


}
