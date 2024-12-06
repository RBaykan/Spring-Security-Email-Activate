package com.nontius.proje.model;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.Calendar;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Data
@AllArgsConstructor
public class VerifiticationToken {

	// Tokenin geçerli olduğu süre
	private static final int expiration = 60 * 24;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@OneToOne(targetEntity = User.class, fetch = FetchType.EAGER)
	@JoinColumn(nullable = false, name = "user_id")
	private User user;
	
	private String token;
	
	private Date expiryDate;
	
	private Date calculateExpiryDate(int expiryTimeInMinutes) 
	{
		Calendar cal = Calendar.getInstance();
		cal.setTime(new Timestamp(cal.getTime().getTime()));
		cal.add(Calendar.MINUTE, expiryTimeInMinutes);
		
		return new Date(cal.getTime().getTime());
	}
	
	public VerifiticationToken() {
		
		this.expiryDate = calculateExpiryDate(expiration);
	}
	
	
}
