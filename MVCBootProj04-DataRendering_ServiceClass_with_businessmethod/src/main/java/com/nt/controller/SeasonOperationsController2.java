package com.nt.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nt.service.ISeasonFinderService;

@RequestMapping("/test-operation")
@Controller
public class SeasonOperationsController2
{
	@Autowired
	private ISeasonFinderService finderService;
	
	@RequestMapping("/")
	public String getMethodCheck()
	{
		return "welcome";
	}
	
	@RequestMapping("/season")
	public String showSeason(Map<String,Object> map)
	{
		//user Service
		String msg=finderService.findSeason();
		map.put("resultMsg", msg);
		return "display";
	}
	
	@GetMapping("/test")
	public String checkgetPost()
	{
		System.out.println("SeasonOperationController.checkgetPost()");
		return "show_test";
	}
	
	@PostMapping("/test")
	public String checkgetPost1()
	{
		System.out.println("SeasonOperationController.checkgetPost1()");
		return "show_test1";
	}
}
