package com.venturasistemoj.restapi.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

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
