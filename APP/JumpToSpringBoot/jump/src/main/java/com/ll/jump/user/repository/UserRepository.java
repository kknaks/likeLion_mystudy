package com.ll.jump.user.repository;

import com.ll.jump.user.entity.SiteUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<SiteUser, Long> {
  Optional<SiteUser> findByusername(String username);
}
