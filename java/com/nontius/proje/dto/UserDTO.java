package com.nontius.proje.dto;


import com.nontius.proje.validation.EmailValid;
import com.nontius.proje.validation.PasswordMatches;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@PasswordMatches
public class UserDTO {
	
	private Long id;
	@NotNull private String firstname;
	@NotNull private String lastname;
	@NotNull private String username;
	@NotNull @NotBlank private String password;
	@NotNull @NotBlank private String machingPassword;
	
	private boolean enabled;
	
	@EmailValid() private String email;
	/* ya da 
	@NotNull @NotBlank @Pattern(regexp = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$", 
    message = "Invalid email format") private String email;*/
	
}
