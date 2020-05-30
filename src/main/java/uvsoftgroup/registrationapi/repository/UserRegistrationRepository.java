package uvsoftgroup.registrationapi.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import uvsoftgroup.registrationapi.model.UserRegistration;


public interface UserRegistrationRepository extends PagingAndSortingRepository<UserRegistration, Long> {

	/* @Query Annotation: pass method parameters as named parameters 
	 * with IN, AND, LIKE operators
	 */
	@Query("SELECT ur FROM UserRegistration ur WHERE "
	        + "  userRegistrationFName LIKE %:userRegistrationFName%"
	        + " AND userRegistrationMName LIKE %:userRegistrationMName%"
	        + " AND userRegistrationLName LIKE %:userRegistrationLName%"
	        + " AND userRegistrationfullName LIKE %:userRegistrationfullName%"
	        + " AND userRegistrationName LIKE %:userRegistrationName%"
	        + " AND userNaId LIKE %:userNaId%"
	        + " AND userBirthId LIKE %:userBirthId%"
			+ " AND userPassNum LIKE %:userPassNum%")
	List<UserRegistration> searchUserRegistrationAnd(
			@Param("userRegistrationFName")String userRegistrationFName,
			@Param("userRegistrationMName") String userRegistrationMName, 
			@Param("userRegistrationLName")String userRegistrationLName,
			@Param("userRegistrationfullName")String userRegistrationfullName,
			@Param("userRegistrationName") String userRegistrationName, 
			@Param("userNaId")String userNaId,
			@Param("userBirthId")String userBirthId,
			@Param("userPassNum") String userPassNum,
			Pageable pageable);
	
		
	/* @Query Annotation: pass method parameters as named parameters 
	 * with IN,AND,OR LIKE operators
	 */
	@Query("SELECT ur FROM UserRegistration ur WHERE "
	        + "  userRegistrationFName LIKE %:userRegistrationFName%"
	        + " OR userRegistrationMName LIKE %:userRegistrationMName%"
	        + " OR userRegistrationLName LIKE %:userRegistrationLName%"
	        + " OR userRegistrationfullName LIKE %:userRegistrationfullName%"
	        + " OR userRegistrationName LIKE %:userRegistrationName%"
	        + " OR userNaId LIKE %:userNaId%"
	        + " OR userBirthId LIKE %:userBirthId%"
			+ " OR userPassNum LIKE %:userPassNum%")
	List<UserRegistration> searchUserRegistrationOr(
			@Param("userRegistrationFName")String userRegistrationFName,
			@Param("userRegistrationMName") String userRegistrationMName, 
			@Param("userRegistrationLName")String userRegistrationLName,
			@Param("userRegistrationfullName")String userRegistrationfullName,
			@Param("userRegistrationName") String userRegistrationName, 
			@Param("userNaId")String userNaId,
			@Param("userBirthId")String userBirthId,
			@Param("userPassNum") String userPassNum,
			Pageable pageable);
		
}
