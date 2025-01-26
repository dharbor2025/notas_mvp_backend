package com.yacelly.notas_mvp.auth.mapper;

import com.yacelly.notas_mvp.auth.domain.entity.User;
import com.yacelly.notas_mvp.auth.dto.request.SignupRequestDTO;
import com.yacelly.notas_mvp.auth.dto.response.AuthResponseDTO;
import com.yacelly.notas_mvp.auth.dto.response.UserProfileResponseDTO;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class UserMapper {

  private final ModelMapper modelMapper;
  public UserMapper() {
    this.modelMapper = new ModelMapper();
  }

  public User toUser(SignupRequestDTO signupRequestDTO) {
    return modelMapper.map(signupRequestDTO, User.class);
  }

  public UserProfileResponseDTO toUserProfileResponseDTO(User user) {
    return modelMapper.map(user, UserProfileResponseDTO.class);
  }

  public AuthResponseDTO toAuthResponseDTO(String token, UserProfileResponseDTO userProfile) {
    AuthResponseDTO authResponseDTO = new AuthResponseDTO();
    authResponseDTO.setToken(token);
    authResponseDTO.setUser(userProfile);
    return authResponseDTO;
  }
}
