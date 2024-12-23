package com.Files.UserEntity.DTOs;
 
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChangePassword {
	@NotBlank(message = "Password is required")
    @Pattern(
        regexp = "^(?=.*[A-Z])(?=.*[0-9])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$",
        message = "Password must contain at least one uppercase letter, one digit, one special character, and be at least 8 characters long without spaces.")
	private String new_password;

}
