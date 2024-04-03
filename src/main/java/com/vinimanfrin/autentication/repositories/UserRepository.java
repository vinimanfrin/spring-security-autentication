package com.vinimanfrin.autentication.repositories;

import com.vinimanfrin.autentication.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
}