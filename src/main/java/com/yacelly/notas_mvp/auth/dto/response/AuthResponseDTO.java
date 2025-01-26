package com.yacelly.notas_mvp.auth.dto.response;

import lombok.Data;

@Data
public class AuthResponseDTO {
  private String token;
  private UserProfileResponseDTO user;

  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }

  public UserProfileResponseDTO getUser() {
    return user;
  }

  public void setUser(UserProfileResponseDTO user) {
    this.user = user;
  }


}
