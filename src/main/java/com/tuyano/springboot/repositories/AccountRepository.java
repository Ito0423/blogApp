package com.tuyano.springboot.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tuyano.springboot.data.UserData;
@Repository
public interface AccountRepository extends JpaRepository<UserData, Integer> {
	public UserData findById(String loginId);
}