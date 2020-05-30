package uvsoftgroup.registrationapi.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import uvsoftgroup.registrationapi.model.UserRole;

public interface UserRoleRepository extends PagingAndSortingRepository<UserRole, Long>,
		UserRoleRepositoryCustom{
	Page<UserRole> findAll(Pageable pageable);

	// Structure of Derived Query Methods
	List<UserRole> findByUserRoleType(String userRoleType, Pageable pageable);

	// Multiple Condition Expressions "And"
	List<UserRole> findByUserRoleNameAndUserRoleType(
			String userRoleName, 
			String userRoleType, 
			Pageable pageable);

	// Multiple Condition Expressions "OR"
	List<UserRole> findByUserRoleNameOrUserRoleType(
			String userRoleName, 
			String userRoleType, 
			Pageable pageable);

	/*
	 *  @Query Annotation: pass method parameters to the query in the same order
	 *  or position
	 */
	@Query("SELECT ur FROM UserRole ur "
			+ "WHERE ur.userRoleName LIKE %?1%"
			+ "and ur.userRoleType LIKE %?2%")
	List<UserRole> findByUserRoleNameUserRoleTypeWithQueryAnd(
			String userRoleName, 
			String userRoleType,
			Pageable pageable);

	/*
	 *  @Query Annotation: pass method parameters to the query in the same order
	 *  or position
	 */
	
	@Query("SELECT ur FROM UserRole ur "
			+ "WHERE ur.userRoleName LIKE %?1%"
			+ " or ur.userRoleType LIKE %?2%")
	List<UserRole> findByUserRoleNameUserRoleTypeWithQueryOr(
			String userRoleName, 
			String userRoleType,
			Pageable pageable);

	// @Query Annotation: pass method parameters as named parameters
	@Query("SELECT ur FROM UserRole ur "
			+ "WHERE ur.userRoleName LIKE %:userRoleName% "
			+ "and ur.userRoleType LIKE %:userRoleType%")
	List<UserRole> findByUserRoleNameAndTypeWithParams(
			@Param("userRoleType") String userRoleType, 
			@Param("userRoleName") String userRoleName,
			Pageable pageable);

	/*
	 *  @Query Annotation: pass method parameters as named parameters with IN
	 *  operator
	 */
	@Query(value = "SELECT ur FROM UserRole ur "
			     + "WHERE ur.userRoleType IN :userRoleTypes")
	List<UserRole> findFloorInfoByUserRoleTypeList(
			@Param("userRoleTypes") List<String> userRoleTypes,
			Pageable pageable);

	/* @Query Annotation: pass method parameters as named parameters 
	 * with IN, AND, LIKE operators
	 */
	@Query("SELECT ur FROM UserRole ur WHERE 1=1"
	        + " AND ur.userRoleType IN :userRoleTypes"
			+ " AND ur.userRoleName LIKE %:userRoleName%")
	List<UserRole> searchUserRoleInfoAnd(
			@Param("userRoleTypes") List<String> userRoleTypes,
			@Param("userRoleName") String userRoleName, 
			Pageable pageable);
	
	/* @Query Annotation: pass method parameters as named parameters 
	 * with IN,AND,OR LIKE operators
	 */
		@Query("SELECT ur FROM UserRole ur WHERE 1=1" 
				+ " AND (ur.userRoleType IN :userRoleTypes"
				+ " or ur.userRoleName LIKE %:userRoleName%)")
		List<UserRole> searchUserRoleInfoOr(
				@Param("userRoleTypes") List<String> userRoleTypes,
				@Param("userRoleName") String userRoleName, 
				Pageable pageable);
		
		
	// @Query Annotation: Spring Data JPA Projections
		@Query("SELECT ur.userRoleType as userRoleType,"
				+ "count(ur.userRoleType) as count "
				+ "FROM UserRole ur "
				+ "WHERE ur.userRoleType IN :userRoleTypes "
				+ "GROUP BY ur.userRoleType")
		List<UserRoleSummary> countbyUserRoleType(
				@Param("userRoleTypes") List<String> userRoleTypes);
		
}
