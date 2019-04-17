package com.slnst.springdemo;

public class CricketCoach implements Coach {

	private FortuneService fortuneService;
	
	public CricketCoach(FortuneService theFortuneService) {
		this.fortuneService = theFortuneService;
	}
	
	@Override
	public String getDailyWorkout() {
		
		return "Do bowling for 50 balls";
	}

	@Override
	public String getDailyFortune() {
		
		return fortuneService.getFortune();
	}

}
