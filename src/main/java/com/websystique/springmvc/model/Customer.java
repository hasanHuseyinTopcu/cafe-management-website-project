package com.websystique.springmvc.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import org.hibernate.validator.constraints.NotEmpty;

@Entity
@Table(name="Customers")
public class Customer  {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id ;
	
	@NotEmpty
	@Size(min=3, max=50)
	@Column(name = "username", nullable = false)
	private String username;
	
	@NotEmpty
	@Size(min=3, max=50)
	@Column(name = "password", nullable = false)
	private String password;
	
	@NotEmpty
	@Size(min=3, max=50)
	@Column(name = "firstName", nullable = false)
	private String firstName;
	
	@NotEmpty
	@Size(min=3, max=50)
	@Column(name = "lastName", nullable = false)
	private String lastName;
	
	@NotEmpty
	@Size(min=1, max=50)
	@Column(name = "buildingNo", nullable = false)
	private String buildingNo;
	
	
	@NotEmpty
	@Size(min=1, max=50)
	@Column(name = "floorNo", nullable = false)
	private String floorNo;
	
	@NotEmpty
	@Size(min=1, max=50)
	@Column(name = "roomNo", nullable = false)
	private String roomNo;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getBuildingNo() {
		return buildingNo;
	}

	public void setBuildingNo(String buildingNo) {
		this.buildingNo = buildingNo;
	}

	public String getFloorNo() {
		return floorNo;
	}

	public void setFloorNo(String floorNo) {
		this.floorNo = floorNo;
	}

	public String getRoomNo() {
		return roomNo;
	}

	public void setRoomNo(String roomNo) {
		this.roomNo = roomNo;
	}
	

	
}
