package com.nontius.proje.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;


@Data
@Builder
@AllArgsConstructor
@Entity
@Table(name="Account")
public class User {
	
	
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY) private Long id; 
	
	private String firstname;
	private String lastname;
	private String username;
	private String password;
	private String email;
	
	
	private boolean enabled;
	
	
	public User() {
		super();
		this.enabled = false;
	}
	
}
