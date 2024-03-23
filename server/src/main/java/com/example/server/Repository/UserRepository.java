package com.example.server.Repository;

import com.example.server.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {

//    @Query( value = "select u.* from User  as u where u.username = :name", nativeQuery = true)
//    User loadByUserName(@Param("name") String name);

    User findByEmail(String email);
}
