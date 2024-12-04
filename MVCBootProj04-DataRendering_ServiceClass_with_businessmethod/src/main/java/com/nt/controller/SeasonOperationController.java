package com.nt.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nt.service.ISeasonFinderService;

@RequestMapping("/wish-operation")
@Controller
public class SeasonOperationController
{
	@Autowired
		private ISeasonFinderService seasonFinder;
	
	@RequestMapping("/")	//If you are not specifying any path / is by default it will take
	public String showHome()
	{
		return "welcome";
	}
	
	
//	@RequestMapping({"/season","/wish",",/result"})
	@RequestMapping("/season")
	public String showSeason(Map<String,Object> map)
	{
		//user Service
		String msg=seasonFinder.findSeason();
		map.put("resultMsg", msg);
		return "display";
	}

	@RequestMapping("/wish")
	public String showWishMsg(Map<String,Object> map)
	{
		//user Service
		String msg=seasonFinder.getWishMsg();
		map.put("resultMsg", msg);
//		return "display";
		return "forward:/test-operation/season";
	}
	
	@RequestMapping("/result")
	public String showResult(Map<String, Object> map)
	{
		//User Service
		String msg=seasonFinder.getResult(80,60,90);
		map.put("resultMsg", msg);
		return "resultDisplay";
//		return "forward:wish";		//Forwarding one page to another
	}
	
	@GetMapping("/test")
	public String checkgetPost(Map<String,Object> map)
	{
		System.out.println("SeasonOperationController.checkgetPost()");
		map.put("Name","ShubhamChaurasia");
		map.put("Designition", "JavaDeveloper");
		map.put("Phone",7388890916L);
		return "show_test";
	}
	
	@PostMapping("/test")
	public String checkgetPost1()
	{
		System.out.println("SeasonOperationController.checkgetPost1()");
		return "show_test1";
	}
}
