package com.yacelly.notas_mvp.auth.repository;

import com.yacelly.notas_mvp.auth.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
  Optional<User> findOneByEmail(String email);
  boolean existsByEmail(String email);
}

