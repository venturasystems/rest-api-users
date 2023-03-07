package com.venturasistemoj.restapi.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name = "addresses")
@Data
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long addressId;

	private String publicPlace;
	private String streetAddress;
	private String complement;

	private String city;
	private String state;
	private String zipCode; // CEP "^[\d]{2}\.?[\d]{3}\-?[\d]{3}$"

	@OneToOne(mappedBy = "address", optional = false)
	private User user;

}
