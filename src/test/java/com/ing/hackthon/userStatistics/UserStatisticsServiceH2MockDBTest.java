package com.ing.hackthon.userStatistics;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@ActiveProfiles("test")
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserStatisticsServiceH2MockDBTest {
	
	@Autowired
	private UserStatisticsService userStatisticsService;
	
	
	@Test
	public void getAllUsersTest() {
		
		assertNotNull(userStatisticsService.getAllUsers());
		assertEquals("This method tests the size of the returned user list", 4, userStatisticsService.getAllUsers().size());
		
		// Testing the DTO conversion
		assertEquals("This method tests the id of the first user", 4, userStatisticsService.getAllUsers().get(0).getId());
		assertEquals("This method tests the numberOfLogins of the first user", 0, userStatisticsService.getAllUsers().get(0).getNumberOfLogins());
		assertEquals("This method tests the userName of the first user", "test4", userStatisticsService.getAllUsers().get(0).getUserName());
		assertEquals("This method tests the password of the first user", "test4", userStatisticsService.getAllUsers().get(0).getPassword());
				
	}
}
