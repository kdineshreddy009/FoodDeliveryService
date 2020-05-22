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
@Table(name = "Admins")
public class Admin extends Person {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "AdminId", updatable = false, nullable = false)
	private Long adminId;
	
	@Column(name="StaffType")
	private static StaffType staff;// = StaffType.admin
	
	@OneToOne
	@JoinColumn(name="AddressId")
	private StaffAddress staffAddress;

	public Long getAdminId() {
		return adminId;
	}

	public void setAdminId(Long adminId) {
		this.adminId = adminId;
	}

	public static StaffType getStaff() {
		return staff;
	}

	public static void setStaff(StaffType staff) {
		Admin.staff = staff;
	}

	public StaffAddress getStaffAddress() {
		return staffAddress;
	}

	public void setStaffAddress(StaffAddress staffAddress) {
		this.staffAddress = staffAddress;
	}

}

