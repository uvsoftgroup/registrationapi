package uvsoftgroup.registrationapi.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import uvsoftgroup.registrationapi.model.UserRole;
import uvsoftgroup.registrationapi.repository.UserRoleSummary;
import uvsoftgroup.registrationapi.service.UserRoleService;

@RestController
@RequestMapping(value = "/userrole")
public class UserRoleController {
	@Autowired
	private UserRoleService userRoleService;

	@RequestMapping(value = "/saveUserRole", method = RequestMethod.POST)
	public UserRole saveUserRole(@Valid @RequestBody UserRole userRole){
		return userRoleService.saveUserRole(userRole);
	}
	
	@RequestMapping(value = "/updateUserRole", method = RequestMethod.PUT)
	public UserRole updateUserRole(@Valid @RequestBody UserRole userRole){
		return userRoleService.updateUserRole(userRole);
	}
	
	@RequestMapping(value="deleteUserRole/{userRoleId}",
			method=RequestMethod.DELETE)
	public void deleteUserRole(@PathVariable("userRoleId") Long userRoleId){
		userRoleService.deleteUserRole(userRoleId);	
	}
	
	@RequestMapping(value="findByUserRole/{userRoleId}",
			method=RequestMethod.GET)
	public Optional<UserRole> findByUserRole(@PathVariable("userRoleId") Long userRoleId){
		return userRoleService.findByUserRole(userRoleId);	
	}
	
	@RequestMapping(value = "/findAll", method = RequestMethod.GET)
	public List<UserRole> findAll(
			@RequestParam(name = "pageNumber", required = false, defaultValue = "0") int pageNumber,
			@RequestParam(name = "pageSize", required = false, defaultValue = "30") int pageSize) {
		List<UserRole> list =userRoleService.findAll(pageNumber, pageSize);
		return list;
	}

	@RequestMapping(value = "/findCounter", method = RequestMethod.GET)
	public long findCounter(
			@RequestParam(name = "pageNumber", required = false, defaultValue = "0") int pageNumber,
			@RequestParam(name = "pageSize", required = false, defaultValue = "30") int pageSize) {
		long counter =userRoleService.findCounter(pageNumber, pageSize);
		return counter;
	}
	
	
	@RequestMapping(value = "/findByUserRoleType", method = RequestMethod.GET)
	public List<UserRole> findByUserRoleType(
		@RequestParam(name = "pageNumber", required = false, defaultValue = "0") int pageNumber,
		@RequestParam(name = "pageSize", required = false, defaultValue = "30") int pageSize,
		@RequestParam(name = "userRoleType", required = false) String userRoleType) {
		List<UserRole> list =userRoleService.findByUserRoleType(
				pageNumber, pageSize,userRoleType);
		return list;
	}
	

	@RequestMapping(value = "/findByUserRoleNameAndUserRoleType", 
			method = RequestMethod.GET)
	public List<UserRole> findByUserRoleNameAndUserRoleType(
		@RequestParam(name = "pageNumber", required = false, defaultValue = "0") int pageNumber,
		@RequestParam(name = "pageSize", required = false, defaultValue = "30") int pageSize,
		@RequestParam(name = "userRoleName", required = false) String userRoleName,
		@RequestParam(name = "userRoleType", required = false) String userRoleType) {
		List<UserRole> list =userRoleService.findByUserRoleNameAndUserRoleType(
				pageNumber, pageSize,userRoleName, userRoleType);
		return list;
	}
	
	@RequestMapping(value = "/findByUserRoleNameOrUserRoleType", 
			method = RequestMethod.GET)
	public List<UserRole> findByUserRoleNameOrUserRoleType(
		@RequestParam(name = "pageNumber", required = false, defaultValue = "0") int pageNumber,
		@RequestParam(name = "pageSize", required = false, defaultValue = "30") int pageSize,
		@RequestParam(name = "userRoleName", required = false) String userRoleName,
		@RequestParam(name = "userRoleType", required = false) String userRoleType) {
		List<UserRole> list =userRoleService.findByUserRoleNameOrUserRoleType(
				pageNumber, pageSize,userRoleName, userRoleType);
		return list;
	}
	
	
	@RequestMapping(value = "/findByUserRoleNameUserRoleTypeWithQueryAnd", 
			method = RequestMethod.GET)
	public List<UserRole> findByUserRoleNameUserRoleTypeWithQueryAnd(
		@RequestParam(name = "pageNumber", required = false, defaultValue = "0") int pageNumber,
		@RequestParam(name = "pageSize", required = false, defaultValue = "30") int pageSize,
		@RequestParam(name = "userRoleName", required = false) String userRoleName,
		@RequestParam(name = "userRoleType", required = false) String userRoleType) {
		
		List<UserRole> list =userRoleService.findByUserRoleNameUserRoleTypeWithQueryAnd(
				pageNumber, pageSize,userRoleName, userRoleType);
		return list;
	}
	
	@RequestMapping(value = "/findByUserRoleNameUserRoleTypeWithQueryOr", 
			method = RequestMethod.GET)
	public List<UserRole> findByUserRoleNameUserRoleTypeWithQueryOr(
		@RequestParam(name = "pageNumber", required = false, defaultValue = "0") int pageNumber,
		@RequestParam(name = "pageSize", required = false, defaultValue = "30") int pageSize,
		@RequestParam(name = "userRoleName", required = false) String userRoleName,
		@RequestParam(name = "userRoleType", required = false) String userRoleType) {
		
		List<UserRole> list =userRoleService.findByUserRoleNameUserRoleTypeWithQueryOr(
				pageNumber, pageSize,userRoleName, userRoleType);
		return list;
	}
	
	
	@RequestMapping(value = "/findByUserRoleNameAndTypeWithParams", 
			method = RequestMethod.GET)
	public List<UserRole> findByUserRoleNameAndTypeWithParams(
		@RequestParam(name = "pageNumber", required = false, defaultValue = "0") int pageNumber,
		@RequestParam(name = "pageSize", required = false, defaultValue = "30") int pageSize,
		@RequestParam(name = "userRoleName", required = false) String userRoleName,
		@RequestParam(name = "userRoleType", required = false) String userRoleType) {
		
		List<UserRole> list =userRoleService.findByUserRoleNameAndTypeWithParams(
				pageNumber, pageSize,userRoleName, userRoleType);
		return list;
	}
	
	
	@RequestMapping(value = "/findFloorInfoByUserRoleTypeList", 
			method = RequestMethod.GET)
	public List<UserRole> findFloorInfoByUserRoleTypeList(
		@RequestParam(name = "pageNumber", required = false, defaultValue = "0") int pageNumber,
		@RequestParam(name = "pageSize", required = false, defaultValue = "30") int pageSize,
		@RequestParam(name = "userRoleTypes", required = false) List<String> userRoleTypes) {
		
		List<UserRole> list =userRoleService.findFloorInfoByUserRoleTypeList(
				pageNumber, pageSize,userRoleTypes);
		return list;
	}
	
	
	@RequestMapping(value = "/searchUserRoleInfoAnd", 
			method = RequestMethod.GET)
	public List<UserRole> searchUserRoleInfoAnd(
		@RequestParam(name = "pageNumber", required = false, defaultValue = "0") int pageNumber,
		@RequestParam(name = "pageSize", required = false, defaultValue = "30") int pageSize,
		@RequestParam(name = "userRoleTypes", required = false) List<String> userRoleTypes,
		@RequestParam(name = "userRoleName", required = false) String userRoleName) {
		
		List<UserRole> list =userRoleService.searchUserRoleInfoAnd(
				pageNumber, pageSize, userRoleTypes, userRoleName);
		return list;
	}
	
	@RequestMapping(value = "/searchUserRoleInfoOr", 
			method = RequestMethod.GET)
	public List<UserRole> searchUserRoleInfoOr(
		@RequestParam(name = "pageNumber", required = false, defaultValue = "0") int pageNumber,
		@RequestParam(name = "pageSize", required = false, defaultValue = "30") int pageSize,
		@RequestParam(name = "userRoleTypes", required = false) List<String> userRoleTypes,
		@RequestParam(name = "userRoleName", required = false) String userRoleName) {
		
		List<UserRole> list =userRoleService.searchUserRoleInfoOr(
				pageNumber, pageSize, userRoleTypes, userRoleName);
		return list;
	}
	
	@RequestMapping(value = "/countbyUserRoleType", 
			method = RequestMethod.GET)
	public List<UserRoleSummary> countbyUserRoleType(
			@RequestParam(name = "userRoleTypes", required = false) List<String> userRoleTypes) {
		
		List<UserRoleSummary> list =userRoleService.countbyUserRoleType(userRoleTypes);
		return list;
	}
	
	
	@RequestMapping(value = "/findUserRoleByUserRoleType", 
			method = RequestMethod.GET)
	public List<UserRole> findUserRoleByUserRoleType(
			@RequestParam(name = "userRoleTypes", required = false) List<String> userRoleTypes) {
		
		List<UserRole> list =userRoleService.findUserRoleByUserRoleType(userRoleTypes);
		return list;
	}
	
}
