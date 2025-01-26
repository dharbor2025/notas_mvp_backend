package com.yacelly.notas_mvp.auth.dto.response;

import com.yacelly.notas_mvp.auth.domain.enums.Role;
import lombok.Data;

import java.util.UUID;

@Data
public class UserProfileResponseDTO {
  private UUID uuid;
  private String firstName;
  private String lastName;
  private String email;
  private Role role;

  public UUID getUuid() {
    return uuid;
  }

  public void setUuid(UUID uuid) {
    this.uuid = uuid;
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
