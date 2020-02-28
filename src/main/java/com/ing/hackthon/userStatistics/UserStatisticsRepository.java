package com.ing.hackthon.userStatistics;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Spring JPA repository for user statistics
 */
@Repository
public interface UserStatisticsRepository extends JpaRepository<UserStatistics, Integer>{
	/**
	 * This method should return all the user statistics related to the user id
	 * @param userId
	 * @return user statistics
	 */
	List<UserStatistics> findByUserId(int userId);
	
}
