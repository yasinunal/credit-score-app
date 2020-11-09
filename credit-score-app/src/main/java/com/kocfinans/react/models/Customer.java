package com.kocfinans.react.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="customers")
public class Customer {

	@Id
    String id;
	String tckn;
	String nameSurname;
    double monthlySalary;
    String phoneNumber;
    
    
	public Customer() {
	}

	public Customer(String tckn, String nameSurname, double monthlySalary, String phoneNumber) {
		this.tckn = tckn;
		this.nameSurname = nameSurname;
		this.monthlySalary = monthlySalary;
		this.phoneNumber = phoneNumber;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTckn() {
		return tckn;
	}

	public void setTckn(String tckn) {
		this.tckn = tckn;
	}

	public String getNameSurname() {
		return nameSurname;
	}

	public void setNameSurname(String nameSurname) {
		this.nameSurname = nameSurname;
	}

	public double getMonthlySalary() {
		return monthlySalary;
	}

	public void setMonthlySalary(double monthlySalary) {
		this.monthlySalary = monthlySalary;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return "Customer [tckn=" + tckn + ", nameSurname=" + nameSurname + ", monthlySalary=" + monthlySalary
				+ ", phoneNumber=" + phoneNumber + "]";
	}
    
    
  
}
