package com.tuyano.springboot;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;

import lombok.Data;

@Data
public class SignupForm {
@NotBlank
@Email
	private String userid;
@NotBlank
@Length(min=4,max=100)
@Pattern(regexp="^[a-zA-Z0-9]+$")
	private String password;
@NotBlank
	private String username;
}
