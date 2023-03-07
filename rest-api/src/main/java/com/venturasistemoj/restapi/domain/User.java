package com.venturasistemoj.restapi.domain;

import java.time.LocalDate;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Table(name = "users")
@Data
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long userId;

	@NotNull private String name;
	@NotNull private String surName;
	@NotNull private LocalDate birthDate;
	@NotNull private String cpf; // "^[\d]{3}\.?[\d]{3}\.?[\d]{3}\-?[\d]{2}$" sem dígito verificador
	@NotNull private String email; // "/^[a-zA-Z0-9.!#$%&'*+\/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$/"

	@OneToOne
	@JoinColumn(name = "addressId", nullable = false)
	private Address address;

	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
	private Set<PhoneNumber> phones;

}