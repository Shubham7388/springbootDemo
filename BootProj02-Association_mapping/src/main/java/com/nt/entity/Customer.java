package com.nt.entity;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="CUSTOMER_INFO")
@Setter
@Getter
@RequiredArgsConstructor
public class Customer
{
	@Id
	@GeneratedValue
	private Integer cid;
	
	@Column(name="CNAME", length = 30)
	@NonNull
	private String cname;
	
	@Column(name="CADDRS", length = 30)
	@NonNull
	private String caddrs;
	
	//,mappedBy = "customerInfo"
	@OneToMany(targetEntity = Accounts.class,cascade = CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "customerInfo")
//	@JoinColumn(name="customer_id",referencedColumnName = "cid")
	private Set<Accounts> accountDetails;

	public Customer() {
		System.out.println("Customer.Customer()::0-param constructor");
	}
	@Override
	public String toString() {
		return "Customer [cid=" + cid + ", cname=" + cname + ", caddrs=" + caddrs + "]";
	}
	
	
}
