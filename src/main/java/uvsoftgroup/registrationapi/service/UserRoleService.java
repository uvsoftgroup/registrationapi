package uvsoftgroup.registrationapi.service;

import java.util.List;
import java.util.Optional;

import uvsoftgroup.registrationapi.model.UserRole;
import uvsoftgroup.registrationapi.repository.UserRoleSummary;

public interface UserRoleService {
	
	UserRole saveUserRole(UserRole userRole);
	UserRole updateUserRole(UserRole userRole);
	void deleteUserRole(Long userRoleId);
	Optional<UserRole> findByUserRole(Long userRoleId);
	
	List<UserRole> findAll(int pageNumber, int pageSize);
	
	long findCounter(int pageNumber, int pageSize);
	
	List<UserRole> findByUserRoleType(
			int pageNumber, 
			int pageSize, 
			String userRoleType);

	List<UserRole> findByUserRoleNameAndUserRoleType(
			int pageNumber, 
			int pageSize,
			String userRoleName,
			String userRoleType);

	List<UserRole> findByUserRoleNameOrUserRoleType(
			int pageNumber, 
			int pageSize, 
			String userRoleName,
			String userRoleType);
	
	List<UserRole> findByUserRoleNameUserRoleTypeWithQueryAnd(
			int pageNumber, 
			int pageSize, 
			String userRoleName,
			String userRoleType);
	
	List<UserRole> findByUserRoleNameUserRoleTypeWithQueryOr(
			int pageNumber, 
			int pageSize, 
			String userRoleName,
			String userRoleType);
	
	List<UserRole> findByUserRoleNameAndTypeWithParams(
			int pageNumber, 
			int pageSize, 
			String userRoleName,
			String userRoleType);
	
	List<UserRole> findFloorInfoByUserRoleTypeList(
			int pageNumber, 
			int pageSize, 
			List<String> userRoleTypes);
	
	List<UserRole> searchUserRoleInfoAnd(
			int pageNumber, 
			int pageSize, 
			List<String> userRoleTypes,
			String userRoleName);
	
	List<UserRole> searchUserRoleInfoOr(
			int pageNumber, 
			int pageSize, 
			List<String> userRoleTypes,
			String userRoleName);
	
	List<UserRoleSummary> countbyUserRoleType(List<String> userRoleTypes);
	
	List<UserRole> findUserRoleByUserRoleType(List<String> userRoleTypes);

}
