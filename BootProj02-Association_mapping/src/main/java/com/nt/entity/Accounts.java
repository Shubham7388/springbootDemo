package com.nt.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "ACCOUNT_INFO")
@RequiredArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Accounts {
	@Id
	@SequenceGenerator(name = "gen1",sequenceName = "ac_id", initialValue = 1000, allocationSize = 1)
	@GeneratedValue(generator = "gen1", strategy = GenerationType.SEQUENCE)
	private Integer aid;
	
	@Column(name="Account_Number",length = 15)
	@NonNull
	private Long acNumber;
	
	@Column(name="Bank_Name",length = 30)
	@NonNull
	private String bankName;
	
	@Column(name="Bank_Balance",length = 30)
	@NonNull
	private Double balance;

	@ManyToOne(targetEntity = Customer.class, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//	@JoinColumn(name="customer_id",referencedColumnName = "cid")
	private Customer customerInfo;
	
	public Accounts() {
		System.out.println("Accounts.Accounts()::0-param constructor");
	}

	@Override
	public String toString() {
		return "Accounts [aid=" + aid + ", acNumber=" + acNumber + ", bankName=" + bankName + ", balance=" + balance
				+ "]";
	}
	
	
}
