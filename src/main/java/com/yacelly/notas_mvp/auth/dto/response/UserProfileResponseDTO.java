package com.yacelly.notas_mvp.auth.dto.response;

import com.yacelly.notas_mvp.auth.domain.enums.Role;
import lombok.Data;

@Data
public class UserProfileResponseDTO {
  private Long id;
  private String firstName;
  private String lastName;
  private String email;
  private Role role;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public Role getRole() {
    return role;
  }

  public void setRole(Role role) {
    this.role = role;
  }
}
