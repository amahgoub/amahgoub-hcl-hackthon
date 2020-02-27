package com.ing.hackthon.userStatistics;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserStatisticsService {
	
	@Autowired
    private UserRepository userRepository;
	
	@Autowired
	private UserStatisticsRepository userStatisticsRepository;
	
	
	public List<UserDTO> getAllUsers() {
        List<User> repoUsers = userRepository.findAll();
        
        return repoUsers.stream()
        		.map(this::convertToDTO)
        		.collect(Collectors.toList());
    }
	
	
	public UserStatisticsDTO getStatisticsByUserId(int userId){
		UserStatistics mockUserStatistics = getMockedUserStatistics().stream().filter(s -> s.getUser().getId() == userId).findFirst().get();
		
		return this.convertToDTO(mockUserStatistics);
	}
	
	
	private UserDTO convertToDTO(User user) {
    	ModelMapper modelMapper = new ModelMapper();
    	return modelMapper.map(user, UserDTO.class);
    }
	
	private UserStatisticsDTO convertToDTO(UserStatistics userStatistics) {
    	ModelMapper modelMapper = new ModelMapper();
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
