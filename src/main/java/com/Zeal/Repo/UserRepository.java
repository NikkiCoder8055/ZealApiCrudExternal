package com.Zeal.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Zeal.Model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

}
