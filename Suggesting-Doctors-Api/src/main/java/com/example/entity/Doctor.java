package com.example.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
public class Doctor 
{
	@Id
	@GeneratedValue(generator = "doc_seq")
	@SequenceGenerator(name="doc_seq",initialValue = 101,allocationSize = 1)
	private int docid;
	
	
	@NotNull(message = "Name is required")
	@Size(min = 3,message = "Name must have atleast three characters")
	private String name;
	
	
	@NotNull(message = "City is required")
	@Pattern(regexp = "Noida|Delhi|Faridabad",message = "Only Noida or Delhi or Faridabad is valid city")
	private String city;
	
	
	@Pattern(regexp = "^^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,4}$",message = "Email is not valid")
	@NotNull(message = "Email is required")
	private String email;
	
	
	@NotNull(message = "Phone is required")
	@Pattern(regexp = "^[0-9]{10,10}$",message = "Phone number must have 10 digits")
	private String phone;
	
	
	
	@Pattern(regexp = "Orthopedic|Gynecology|Dermatology|ENT",message = "Speciality can be either Orthopedic or Gynecology or Dermatology or ENT ")
	@NotNull(message = "Speciality is required")
	private String speciality;
	
	
	
	public int getDocid() {
		return docid;
	}
	public void setDocid(int docid) {
		this.docid = docid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getSpeciality() {
		return speciality;
	}
	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}
	
}
