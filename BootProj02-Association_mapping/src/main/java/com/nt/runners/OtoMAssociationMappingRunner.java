package com.nt.runners;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.service.IOtoMAssociationMgmtService;

@Component
public class OtoMAssociationMappingRunner implements CommandLineRunner
{
	@Autowired
	private IOtoMAssociationMgmtService associationService;
	
	
	@Override
	public void run(String... args) throws Exception
	{
//		associationService.saveDataUsingParent();
//		associationService.saveDataUsingChild();
		associationService.loadDataUsingParent();

	}

}
