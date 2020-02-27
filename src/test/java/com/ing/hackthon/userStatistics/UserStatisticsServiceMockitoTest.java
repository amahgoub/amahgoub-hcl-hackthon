package com.ing.hackthon.userStatistics;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserStatisticsServiceMockitoTest {
	
	@Autowired
	private UserStatisticsService userStatisticsService;
	
	@MockBean
	private UserRepository userRepository;
	
	@MockBean
	private UserStatisticsRepository userStatisticsRepository;
	
	@Test
	public void getAllUsersTest() {
		when(userRepository.findAll()).thenReturn(getMockedUsers());
		
		assertNotNull(userStatisticsService.getAllUsers());
		assertEquals("This method tests the size of the returned user list", 4, userStatisticsService.getAllUsers().size());
		
		// Testing the DTO conversion
		assertEquals("This method tests the id of the first user", 1, userStatisticsService.getAllUsers().get(0).getId());
		assertEquals("This method tests the numberOfLogins of the first user", 0, userStatisticsService.getAllUsers().get(0).getNumberOfLogins());
		assertEquals("This method tests the userName of the first user", "username1", userStatisticsService.getAllUsers().get(0).getUserName());
		assertEquals("This method tests the password of the first user", "test1", userStatisticsService.getAllUsers().get(0).getPassword());
				
	}
	
	@Test
	public void getStatisticsByUserIdTest() {
		User user = new User(1, "user1", "username1", "test1");
		
		when(userStatisticsRepository.findByUserId(1)).thenReturn(getMockedUserStatistics(user));
		
		assertNotNull(userStatisticsService.getStatisticsByUserId(1));
		
		// Testing the DTO conversion
		assertEquals("This method tests the id of the first user", 0, userStatisticsService.getStatisticsByUserId(1).getId());
		assertEquals("This method tests the numberOfOverviewHits of the first user", 132, userStatisticsService.getStatisticsByUserId(1).getNumberOfOverviewHits());
		assertEquals("This method tests the numberOfDetailsHits of the first user", 12, userStatisticsService.getStatisticsByUserId(1).getNumberOfDetailsHits());
		assertEquals("This method tests the isAlerted of the first user", false, userStatisticsService.getStatisticsByUserId(1).isAlerted());
		assertEquals("This method tests the userName of the first user", "username1", userStatisticsService.getStatisticsByUserId(1).getUserName());
		
	}
	
	private List<User> getMockedUsers() {
		return Arrays.asList(
				new User(1, "user1", "username1", "test1"),
				new User(2, "user2", "username2", "test2"),
				new User(3, "user3", "username3", "test3"),
				new User(4, "user4", "username4", "test4")
				);
	}
	
	private List<UserStatistics> getMockedUserStatistics(User user) {
		List<UserStatistics> statistics = Arrays.asList(
				new UserStatistics(132, 12, false, 1),
				new UserStatistics(520, 600, false, 2)
				);
		
		return statistics.stream()
					.filter(u -> u.getUser().getId() == user.getId())
					.map(u -> {
						u.setUser(user);
						return u;
					})
					.collect(Collectors.toList());
	}
}
