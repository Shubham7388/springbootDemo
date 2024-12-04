package com.nt.service;

import java.time.LocalDateTime;
import java.time.Month;

import org.springframework.stereotype.Service;

@Service("seasonFinder")
public class SeasonFinderServiceImpl implements ISeasonFinderService
{
	LocalDateTime ldt=LocalDateTime.now();
	@Override
	public String findSeason() {
		//getting month
		Month monthName=ldt.getMonth();
		int monthVal=ldt.getMonthValue();
		if(monthVal >=7 && monthVal <= 9)
			return "Rainy Season "+monthName; 
		else if(monthVal >= 3 && monthVal <= 6)
			return "Summer Season "+monthName;
		else
			return "Winter Season "+monthName;
	}

	@Override
	public String getWishMsg() {
		int hour=ldt.getHour();
		if(hour>=5 && hour<=12)
			return "Good Morning "+hour;
		else if(hour>=13 && hour<=16)
			return "Good Afternoon "+hour;
		else if(hour>=17 && hour <=24)
			return "Good Evening "+hour;
		else
			return "Good Night "+hour;
	}

	@Override
	public String getResult(int math, int physics, int chemistry) {
		int maxMark=300;
		if(math >= 0 && math <= 100 && physics >= 0 && physics <= 100 && chemistry >= 0 && chemistry <= 100)
		{
			int total=math+physics+chemistry;
			double percentage=(total/(double)maxMark)*100;
			if(percentage >= 80) {
				return "Pass with grade A "+percentage;
			} else 	if(percentage >= 60 ) {
				return "Pass with grade B "+percentage;
			}  else if(percentage >= 40) {
				return "Pass with grade C "+percentage;
			} else {
				return "Fail "+percentage;
			}
		} else {
			return "Wrong input";
		}
	}
}
