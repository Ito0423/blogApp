package com.tuyano.springboot.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tuyano.springboot.data.UserData;
public interface AccountRepository extends JpaRepository<UserData, Long> {
    public UserData findByUsername(String username);
    public Optional<UserData> findById(Long name);
}