package com.nt.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nt.entity.Accounts;

public interface IAccountRepo extends JpaRepository<Accounts, Integer>
{

}
