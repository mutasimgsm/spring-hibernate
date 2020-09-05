package com.etir.springboot.mycoolapp.rest;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {
	
	// injct properties for: coach.name and team.name
	
	@Value("${coach.name}")
	private String coachName;
	
	@Value("${team.name}")
	private String teamName;
	
	// expose new endpoint for "teaminfo"
	@GetMapping("/teaminfo")
	public String getTeamInfo() {
		
		return "Coach: "+ coachName + ", Team name: "+ teamName;
	}

	@GetMapping("/")
	public String hello() {
		
		return "Hello Workd! Time on the server is: "+ LocalDateTime.now();
	}
	
	@GetMapping("/workout")
	public String getDailyWorkout() {
		
		return "Run a hard 5k!";
	}
}
