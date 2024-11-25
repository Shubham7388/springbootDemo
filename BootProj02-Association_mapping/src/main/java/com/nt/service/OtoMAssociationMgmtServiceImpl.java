package com.nt.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.Accounts;
import com.nt.entity.Customer;
import com.nt.repository.IAccountRepo;
import com.nt.repository.ICustomerRepo;

@Service("OtoMService")
public class OtoMAssociationMgmtServiceImpl implements IOtoMAssociationMgmtService
{
	@Autowired
	private ICustomerRepo customerRepo;
	
	@Autowired
	private IAccountRepo accountRepo;
	
	@Override
	public void saveDataUsingParent()
	{
		//create parent object
		Customer customer=new Customer("Shubham1234", "Bhadohi");
		
		//create childs object
		Accounts accounts1=new Accounts(548268162L, "UnionBankOfIndia", 230000.0);
		Accounts accounts2=new Accounts(263626329L, "HDFC", 340000.0);
		
		//add parent to child
		accounts1.setCustomerInfo(customer);
		accounts2.setCustomerInfo(customer);
		
		//add child to parent
		Set<Accounts> accountSet=new HashSet<Accounts>();
		accountSet.add(accounts1);
		accountSet.add(accounts2);
		customer.setAccountDetails(accountSet);
		
		//save the person object
		customerRepo.save(customer);
		System.out.println("Customer and his account detail saved");
	}

	@Override
	public void saveDataUsingChild()
	{
		//parent object
		Customer customer=new Customer("Raj","Basti");
		
		//child object
		Accounts accounts1=new Accounts(7777777777777L, "SBI", 80000.0);
		Accounts accounts2=new Accounts(888888888888L, "ICICI", 40000.0);
		
		//add parent to child
		accounts1.setCustomerInfo(customer);
		accounts2.setCustomerInfo(customer);
		
		//add child to parent
		Set<Accounts> accountsDetail=new HashSet();
		accountsDetail.add(accounts1);
		accountsDetail.add(accounts2);
		customer.setAccountDetails(accountsDetail);
		
		//save the account object
		accountRepo.save(accounts1);
		accountRepo.save(accounts2);
		System.out.println("Accounts and his associated member added successfully...");
	}

	@Override
	public void loadDataUsingParent()
	{
		Iterable<Customer> iterable=customerRepo.findAll();
		iterable.forEach(customer->{
			System.out.println(customer);
		});
		
		Iterable<Accounts> iterable1=accountRepo.findAll();
		iterable1.forEach(accounts->{
			System.out.println(accounts);
		});
		}
	}

