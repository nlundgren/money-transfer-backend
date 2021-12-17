package com.revature.moneytransfer.repository;

import com.revature.moneytransfer.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {

    public User findByEmail(String email);

}
