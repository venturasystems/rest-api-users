package com.venturasistemoj.restapi.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "phones")
@Data
public class PhoneNumber {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long phoneId;

	private String type;
	private String number; // FONE "^\(?[1-9]{2}\)? ?(?:[2-8]|9[1-9])[0-9]{3}\-?[0-9]{4}$"

	@ManyToOne
	@JoinColumn(name = "userId", nullable = false)
	private User user;

}
