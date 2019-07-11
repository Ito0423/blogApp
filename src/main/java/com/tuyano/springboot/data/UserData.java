package com.tuyano.springboot.data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="user")
@Data
public class UserData {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	private String userid;
	
	private String password;
	
	private String username;
}
