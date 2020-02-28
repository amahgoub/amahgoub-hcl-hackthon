package com.ing.hackthon.userStatistics;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.ing.hackthon.exceptions.InvalidUserException;
import com.ing.hackthon.user.UserDTO;

/**
 * Rest controller to handle users and user statistics requests
 */
@RestController
public class UserStatisticsController {

	private static Logger logger = LoggerFactory.getLogger(UserStatisticsController.class);

	
	@Autowired
    private UserStatisticsService userStatisticsService;
	
	
	/**
	 * This method gets all the users
	 * @return all the users
	 * @throws InvalidUserException in case of access users service exceptions
	 */
	@GetMapping("/users")
    public List<UserDTO>  getAllUsers() throws InvalidUserException {
		logger.debug("getAllUsers method starts processing ");
		
		return userStatisticsService.getAllUsers();
    }
	
	/**
	 * This method returns user's statistics
	 * @param userId of the user that should his statistics returned
	 * @return statistics
	 */
	@GetMapping("/statistics/{userId}")
	public UserStatisticsDTO getUserStatistics(@PathVariable int userId) {
		logger.debug("getUserStatistics method starts processing with user id: " + userId);
		
		return userStatisticsService.getStatisticsByUserId(userId); 
	}
	
}
