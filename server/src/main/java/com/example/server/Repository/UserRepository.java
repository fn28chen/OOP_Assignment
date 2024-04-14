package com.example.server.Repository;

import com.example.server.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    // a plan for this but not details
    @Query( value = "select u.* from User as u where u.email = :email", nativeQuery = true)
    User loadByUserName(@Param("email") String email);

    User findByEmail(String email);


}