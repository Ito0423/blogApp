package com.tuyano.springboot;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name="User")
@Data
public class UserData {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column
	private long id;
	
	private String userId;
	private String password;
	private String userName;
}
