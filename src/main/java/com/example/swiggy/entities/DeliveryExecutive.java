package com.example.swiggy.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "DELIVERY_EXECUTIVES")
public class DeliveryExecutive extends Person {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "DeliveryExecutiveId", updatable = false, nullable = false)
	private Long de_id;

	@Column(name = "STAFF_TYPE")
	private static StaffType staff = StaffType.worker;

	@OneToOne
	@JoinColumn(name = "ADDRESS_ID")
	private StaffAddress staffAddress;

	public Long getDe_id() {
		return de_id;
	}

	public void setDe_id(Long de_id) {
		this.de_id = de_id;
	}

	public static StaffType getStaff() {
		return staff;
	}

	public static void setStaff(StaffType staff) {
		DeliveryExecutive.staff = staff;
	}

	public StaffAddress getStaffAddress() {
		return staffAddress;
	}

	public void setStaffAddress(StaffAddress staffAddress) {
		this.staffAddress = staffAddress;
	}
}
