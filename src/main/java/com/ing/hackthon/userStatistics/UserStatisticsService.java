package com.ing.hackthon.userStatistics;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ing.hackthon.exceptions.ErrorMessage;
import com.ing.hackthon.exceptions.ErrorMessageCode;
import com.ing.hackthon.exceptions.InvalidUserException;
import com.ing.hackthon.user.User;
import com.ing.hackthon.user.UserDTO;
import com.ing.hackthon.user.UserRepository;

/**
 * Service for providing user statistics data
 */
@Service
public class UserStatisticsService {
	
	private static Logger logger = LoggerFactory.getLogger(UserStatisticsService.class);
	
	@Autowired
    private UserRepository userRepository;
	
	@Autowired
	private UserStatisticsRepository userStatisticsRepository;
	
	@Autowired
	private ModelMapper modelMapper;
	
	/**
	 * This method gets all the users
	 * @return all the users
	 * @throws InvalidUserException in case of access users service exceptions
	 */
	public List<UserDTO> getAllUsers() throws InvalidUserException {
		logger.debug("getAllUsers method start processing");
		
		 try {
			List<User> repoUsers = userRepository.findAll();
			
			return repoUsers.stream()
					.map(this::convertToDTO)
					.collect(Collectors.toList());
		} catch (Exception e) {
			throw new InvalidUserException(new ErrorMessage(ErrorMessageCode.SERVICE_UNAVAILABLE.getCode(), "User Service unreachable"));
		}
    }
	
	/**
	 * This method returns user's statistics
	 * @param userId of the user that should his statistics returned
	 * @return statistics
	 */
	public UserStatisticsDTO getStatisticsByUserId(int userId){
		logger.debug("getStatisticsByUserId method start processing with user id: " + userId);
		
		UserStatistics mockUserStatistics = getMockedUserStatistics().stream().filter(s -> s.getUser().getId() == userId).findFirst().get();
		
		return this.convertToDTO(mockUserStatistics);
	}
	
	/**
	 * Method for converting user domain object to UserDTo
	 * @param user domain object
	 * @return user DTO
	 */
	private UserDTO convertToDTO(User user) {
    	return modelMapper.map(user, UserDTO.class);
    }
	
	/**
	 * Method for converting UserStatistics  domain object to UserStatistics DTO
	 * @param UserStatistics domain object
	 * @return UserStatistics DTO
	 */
	private UserStatisticsDTO convertToDTO(UserStatistics userStatistics) {
    	return modelMapper.map(userStatistics, UserStatisticsDTO.class);
    }
	
	private List<UserStatistics> getMockedUserStatistics(){
		List<UserStatistics> statistics = Arrays.asList(
				new UserStatistics(132, 12, false, 1),
				new UserStatistics(520, 600, false, 2)
				);
		
		statistics.get(0).setUser(new User(1, "user1", "username1", "test1"));
		statistics.get(1).setUser(new User(2, "user2", "username2", "test2"));
		
		return statistics;
	}
}
