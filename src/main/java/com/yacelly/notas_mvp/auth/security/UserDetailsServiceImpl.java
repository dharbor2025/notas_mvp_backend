package com.yacelly.notas_mvp.auth.security;

import com.yacelly.notas_mvp.auth.domain.entity.User;
import com.yacelly.notas_mvp.auth.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

  private final UserRepository userRepository;
  public UserDetailsServiceImpl(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    // Busca al usuario en la base de datos por correo electrónico y lanza una excepción si no se encuentra.
    User user = userRepository
      .findOneByEmail(username)
      .orElseThrow(() -> new UsernameNotFoundException(username));

    // Devuelve los detalles del usuario para Spring Security, incluyendo nombre de usuario, contraseña y roles.
    return org.springframework.security.core.userdetails.User
      .withUsername(user.getEmail())
      .password(user.getPassword())
      .roles(user.getRole().name())
      .build();
  }

}
