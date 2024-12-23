package com.files.PayementService.external;

import java.time.LocalDate;
import java.time.LocalDateTime;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id; 
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {


	private long user_id;

	private String username;

	private String f_name;

	private String l_name;

	private LocalDate user_dob;

	private LocalDate user_reg_date;

	private LocalDateTime user_update_date;

	private String user_password;


	private String user_email;

	private String user_role;

}