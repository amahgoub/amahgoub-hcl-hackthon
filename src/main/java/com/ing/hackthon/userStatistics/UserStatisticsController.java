package com.ing.hackthon.userStatistics;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserStatisticsController {

	@Autowired
    private UserStatisticsService userStatisticsService;
	
	
	@GetMapping("/users")
    public List<UserDTO>  getAllUsers() {
        return userStatisticsService.getAllUsers();
    }
	
	@GetMapping("/statistics/{userId}")
	public UserStatisticsDTO getUserStatistics(@PathVariable int userId) {
		return userStatisticsService.getStatisticsByUserId(userId); 
	}
	
}
