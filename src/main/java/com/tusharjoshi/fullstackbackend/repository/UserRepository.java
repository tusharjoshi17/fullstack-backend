package com.tusharjoshi.fullstackbackend.repository;

import com.tusharjoshi.fullstackbackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

}
