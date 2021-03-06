package com.ing.hackthon.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Spring JPA repository for users
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

}
