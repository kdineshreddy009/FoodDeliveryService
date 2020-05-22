package com.example.swiggy.entities;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "StaffAddresses")
public class StaffAddress extends Address {
	
//	@OneToOne
//	private Person person;
	
}
