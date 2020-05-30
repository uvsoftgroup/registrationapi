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

import uvsoftgroup.registrationapi.model.UserRegistration;
import uvsoftgroup.registrationapi.service.UserRegistrationService;

@RestController
@RequestMapping(value = "/userregistration")
public class UserRegistrationController {
	@Autowired
	private UserRegistrationService userRegistrationService;
	
	@RequestMapping(value = "/saveUserRegistration", method = RequestMethod.POST)
	public UserRegistration saveUserRegistration(@Valid @RequestBody UserRegistration userRegistration){
		return userRegistrationService.saveUserRegistration(userRegistration);
	}
	
	@RequestMapping(value = "/updateUserRegistration", method = RequestMethod.PUT)
	public UserRegistration updateUserRegistration(@Valid @RequestBody UserRegistration userRegistration){
		return userRegistrationService.updateUserRegistration(userRegistration);
	}
	
	@RequestMapping(value="deleteUserRegistration/{userRegistrationId}",
			method=RequestMethod.DELETE)
	public void deleteUserRegistration(@PathVariable("userRegistrationId") Long userRegistrationId){
		userRegistrationService.deleteUserRegistration(userRegistrationId);	
	}
	
	@RequestMapping(value="findByUserRegistration/{userRegistrationId}",
			method=RequestMethod.GET)
	public Optional<UserRegistration> findByUserRegistration(@PathVariable("userRegistrationId") Long userRegistrationId){
		return userRegistrationService.findByUserRegistration(userRegistrationId);	
	}
	
	@RequestMapping(value = "/findAll", method = RequestMethod.GET)
	public List<UserRegistration> findAll(
			@RequestParam(name = "pageNumber", required = false, defaultValue = "0") int pageNumber,
			@RequestParam(name = "pageSize", required = false, defaultValue = "30") int pageSize) {
		List<UserRegistration> list =userRegistrationService.findAll(pageNumber, pageSize);
		return list;
	}

	@RequestMapping(value = "/findCounter", method = RequestMethod.GET)
	public long findCounter(
			@RequestParam(name = "pageNumber", required = false, defaultValue = "0") int pageNumber,
			@RequestParam(name = "pageSize", required = false, defaultValue = "30") int pageSize) {
		long counter =userRegistrationService.findCounter(pageNumber, pageSize);
		return counter;
	}
	
	@RequestMapping(value = "/searchUserRegistrationAnd", 
			method = RequestMethod.GET)
	public List<UserRegistration> searchUserRegistrationAnd(
		@RequestParam(name = "pageNumber", required = false, defaultValue = "0") int pageNumber,
		@RequestParam(name = "pageSize", required = false, defaultValue = "30") int pageSize,
		@RequestParam(name = "userRegistrationFName", required = false) String userRegistrationFName,
		@RequestParam(name = "userRegistrationMName", required = false) String userRegistrationMName,
		@RequestParam(name = "userRegistrationLName", required = false) String userRegistrationLName,
		@RequestParam(name = "userRegistrationfullName", required = false) String userRegistrationfullName,
		@RequestParam(name = "userRegistrationName", required = false) String userRegistrationName,
		@RequestParam(name = "userNaId", required = false) String userNaId,
		@RequestParam(name = "userBirthId", required = false) String userBirthId,
		@RequestParam(name = "userPassNum", required = false) String userPassNum){
		
		List<UserRegistration> list =userRegistrationService.searchUserRegistrationAnd(
			pageNumber, pageSize, userRegistrationFName, 
			userRegistrationMName, userRegistrationLName, userRegistrationfullName, 
			userRegistrationName, userNaId, userBirthId, userPassNum);
		return list;
	}
	
	@RequestMapping(value = "/searchUserRegistrationOr", 
			method = RequestMethod.GET)
	public List<UserRegistration> searchUserRegistrationOr(
		@RequestParam(name = "pageNumber", required = false, defaultValue = "0") int pageNumber,
		@RequestParam(name = "pageSize", required = false, defaultValue = "30") int pageSize,
		@RequestParam(name = "userRegistrationFName", required = false) String userRegistrationFName,
		@RequestParam(name = "userRegistrationMName", required = false) String userRegistrationMName,
		@RequestParam(name = "userRegistrationLName", required = false) String userRegistrationLName,
		@RequestParam(name = "userRegistrationfullName", required = false) String userRegistrationfullName,
		@RequestParam(name = "userRegistrationName", required = false) String userRegistrationName,
		@RequestParam(name = "userNaId", required = false) String userNaId,
		@RequestParam(name = "userBirthId", required = false) String userBirthId,
		@RequestParam(name = "userPassNum", required = false) String userPassNum){
		
		List<UserRegistration> list =userRegistrationService.searchUserRegistrationOr(
			pageNumber, pageSize, userRegistrationFName, 
			userRegistrationMName, userRegistrationLName, userRegistrationfullName, 
			userRegistrationName, userNaId, userBirthId, userPassNum);
		return list;
	}
	
	
}
