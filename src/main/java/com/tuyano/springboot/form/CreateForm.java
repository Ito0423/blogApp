package com.tuyano.springboot.form;

import javax.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CreateForm {
@NotBlank
private String title;
@NotBlank
private String memo;
	
}
