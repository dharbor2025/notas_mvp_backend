package com.yacelly.notas_mvp.auth.controller;

import com.yacelly.notas_mvp.auth.dto.request.AuthRequestDTO;
import com.yacelly.notas_mvp.auth.dto.request.SignupRequestDTO;
import com.yacelly.notas_mvp.auth.dto.response.AuthResponseDTO;
import com.yacelly.notas_mvp.auth.dto.response.UserProfileResponseDTO;
import com.yacelly.notas_mvp.auth.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@RequiredArgsConstructor
@RestController
@RequestMapping("/auth")
public class AuthController {

  private final UserService userService;
  public AuthController(UserService userService) {
    this.userService = userService;
  }

  @PostMapping("/sign-in")
  public ResponseEntity<AuthResponseDTO> signIn(@RequestBody AuthRequestDTO authRequest) {
    AuthResponseDTO authResponse = userService.signIn(authRequest);
    return new ResponseEntity<>(authResponse, HttpStatus.OK);
  }

  @PostMapping("/sign-up")
  public ResponseEntity<UserProfileResponseDTO> register(@RequestBody @Validated SignupRequestDTO signupRequestDTO) {
    UserProfileResponseDTO userProfileResponseDTO = userService.signup(signupRequestDTO);
    return new ResponseEntity<>(userProfileResponseDTO, HttpStatus.CREATED);
  }

}
