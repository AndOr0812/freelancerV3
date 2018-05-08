package com.freelancer.server.repository;

import java.util.List;
import java.util.Optional;

//import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.freelancer.server.model.User;

@Repository
/*@Transactional*/
public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findById(Long userId);
    public User findByEmail(String email);
}
