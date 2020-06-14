package com.cg.pecuniabank.account.dto;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="account")
public class AccountEntity {
	@Id
	@Min(123412341234L)
	@Column(name="accountno")
	long accountNo;
	@Column(name="branchid")
	long branchId;
	@NotBlank(message = "Account type is mandatory")
	@NotNull(message = "Account type is mandatory")
	@Column(name="accounttype")
	String accountType;
	@NotBlank(message = "Aadhaar is mandatory")
	@NotNull(message = "Aadhaar is mandatory")
	@Column(name="aadhaar")
	String aadhaar ;
	@NotBlank(message = "Pan is mandatory")
	@NotNull(message = "Pan is mandatory")
	@Column(name="pan")
	String pan;
	@Column(name="balance")
	Double balance;
	@NotBlank(message = "Status is mandatory")
	@NotNull(message = "Status is mandatory")
	@Column(name="status")
	String status;
	@NotBlank(message = "Customer Name is mandatory")
	@NotNull(message = "Customer Name is mandatory")
	@Column(name="customername")
	String customerName;
	@NotBlank(message = "Address is mandatory")
	@NotNull(message = "Address is mandatory")
	@Column(name="address")
	String address;
	@Min(6000000000L)
	@Column(name="mobilenumber")
	long mobileNumber;
	@Column(name="dob")
	@DateTimeFormat(pattern="yyyy-mm-dd")
	Date dob;
	@NotBlank(message = "Gender is mandatory")
	@NotNull(message = "Gender is mandatory")
	@Column(name="gender")
	String gender;
	public AccountEntity(@Min(123412341234L) long accountNo, long branchId,
			@NotBlank(message = "Account type is mandatory") @NotNull(message = "Account type is mandatory") String accountType,
			@NotBlank(message = "Aadhaar is mandatory") @NotNull(message = "Aadhaar is mandatory") String aadhaar,
			@NotBlank(message = "Pan is mandatory") @NotNull(message = "Pan is mandatory") String pan, Double balance,
			@NotBlank(message = "Status is mandatory") @NotNull(message = "Status is mandatory") String status,
			@NotBlank(message = "Customer Name is mandatory") @NotNull(message = "Customer Name is mandatory") String customerName,
			@NotBlank(message = "Address is mandatory") @NotNull(message = "Address is mandatory") String address,
			@Min(6000000000L) long mobileNumber, Date dob,
			@NotBlank(message = "Gender is mandatory") @NotNull(message = "Gender is mandatory") String gender) {
		super();
		this.accountNo = accountNo;
		this.branchId = branchId;
		this.accountType = accountType;
		this.aadhaar = aadhaar;
		this.pan = pan;
		this.balance = balance;
		this.status = status;
		this.customerName = customerName;
		this.address = address;
		this.mobileNumber = mobileNumber;
		this.dob = dob;
		this.gender = gender;
	}
	public AccountEntity() {
		
	}
	public long getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(long accountNo) {
		this.accountNo = accountNo;
	}
	public long getBranchId() {
		return branchId;
	}
	public void setBranchId(long branchId) {
		this.branchId = branchId;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	public String getAadhaar() {
		return aadhaar;
	}
	public void setAadhaar(String aadhaar) {
		this.aadhaar = aadhaar;
	}
	public String getPan() {
		return pan;
	}
	public void setPan(String pan) {
		this.pan = pan;
	}
	public Double getBalance() {
		return balance;
	}
	public void setBalance(Double balance) {
		this.balance = balance;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public long getMobileNumber() {
		return mobileNumber;
	}
	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	
	
}
