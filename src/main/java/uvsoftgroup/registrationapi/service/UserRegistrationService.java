package uvsoftgroup.registrationapi.service;

import java.util.List;
import java.util.Optional;

import uvsoftgroup.registrationapi.model.UserRegistration;

public interface UserRegistrationService {
	UserRegistration saveUserRegistration(UserRegistration userRegistration);
	UserRegistration updateUserRegistration(UserRegistration userRegistration);
	void deleteUserRegistration(Long userRegistrationId);
	Optional<UserRegistration> findByUserRegistration(Long userRegistrationId);
	List<UserRegistration> findAll(int pageNumber, int pageSize);
	long findCounter(int pageNumber, int pageSize);
	
	List<UserRegistration> searchUserRegistrationAnd(
			int pageNumber, 
			int pageSize, 
			String userRegistrationFName,
			String userRegistrationMName, 
			String userRegistrationLName,
			String userRegistrationfullName,
			String userRegistrationName, 
			String userNaId,
			String userBirthId,
			String userPassNum
			);
	
	List<UserRegistration> searchUserRegistrationOr(
			int pageNumber, 
			int pageSize, 
			String userRegistrationFName,
			String userRegistrationMName, 
			String userRegistrationLName,
			String userRegistrationfullName,
			String userRegistrationName, 
			String userNaId,
			String userBirthId,
			String userPassNum
			);

}
