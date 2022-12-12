package com.questionnaires.questionnaireapp.restController.securityRestController;

import com.questionnaires.questionnaireapp.dto.security.AuthenticationRequestDTO;
import com.questionnaires.questionnaireapp.entity.securityEntity.Role;
import com.questionnaires.questionnaireapp.entity.securityEntity.Status;
import com.questionnaires.questionnaireapp.entity.securityEntity.User;
import com.questionnaires.questionnaireapp.service.securityService.JwtTokenProvider;
import com.questionnaires.questionnaireapp.service.securityService.UserDetailsServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthenticationRestController {

    private final AuthenticationManager authenticationManager;

    private final UserDetailsServiceImpl userDetailsService;

    private final JwtTokenProvider jwtTokenProvider;

    @PostMapping("/login")
    public ResponseEntity<?> authenticate(@RequestBody AuthenticationRequestDTO request) {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword()));
            User user = userDetailsService.findByEmail(request.getEmail());
            String token = jwtTokenProvider.createToken(request.getEmail(), user.getRole().name());
            Map<Object, Object> response = new HashMap<>();
            response.put("email", request.getEmail());
            response.put("token", token);
            return ResponseEntity.ok(response);
        } catch (AuthenticationException e) {
            return new ResponseEntity<>("Invalid credential", HttpStatus.FORBIDDEN);
        }
    }

    @PostMapping("/logout")
    public void logout(HttpServletRequest request, HttpServletResponse response) {
        SecurityContextLogoutHandler securityContextLogoutHandler = new SecurityContextLogoutHandler();
        securityContextLogoutHandler.logout(request, response, null);
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody AuthenticationRequestDTO request) {
        try {
            User user = new User(
                    null,
                    request.getEmail(),
                    null,
                    null,
                    request.getPassword(),
                    Role.ROLE_USER,
                    Status.ACTIVE,
                    null);
            userDetailsService.saveUser(user);
            return ResponseEntity.ok().body(HttpStatus.CREATED);
        } catch (AuthenticationException e) {
            return new ResponseEntity<>("User has already exist", HttpStatus.FORBIDDEN);
        }
    }
}
