package uvsoftgroup.registrationapi.serviceimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import uvsoftgroup.registrationapi.model.UserRegistration;
import uvsoftgroup.registrationapi.repository.UserRegistrationRepository;
import uvsoftgroup.registrationapi.service.UserRegistrationService;

@Service
public class UserRegistrationServiceImpl implements UserRegistrationService{
	
	@Autowired
	private UserRegistrationRepository userRegistrationRepository;
	
	@Override
	public UserRegistration saveUserRegistration(UserRegistration userRegistration) {
		return userRegistrationRepository.save(userRegistration);
	}
	
	@Override
	public UserRegistration updateUserRegistration(UserRegistration userRegistration) {
		return userRegistrationRepository.save(userRegistration);
	}
	
	@Override
	public void deleteUserRegistration(Long userRegistrationId) {
		userRegistrationRepository.deleteById(userRegistrationId);
	}

	@Override
	public Optional<UserRegistration> findByUserRegistration(Long userRegistrationId) {
		return userRegistrationRepository.findById(userRegistrationId);
	}
	
	@Override
	public List<UserRegistration> findAll(int pageNumber, int pageSize) {
		Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by("userRegistrationId").descending());
		Page<UserRegistration> pageContent =userRegistrationRepository.findAll(pageable);
		if (!pageContent.getContent().isEmpty()) {
			return pageContent.getContent();
		} else {
			return new ArrayList<UserRegistration>(pageContent.getContent());
		}
	}

	@Override
	public long findCounter(int pageNumber, int pageSize) {
		Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by("userRegistrationId").descending());
		Page<UserRegistration> pageContent =userRegistrationRepository.findAll(pageable);
		if (!pageContent.getContent().isEmpty()) {
			return pageContent.getContent().size();
		} else {
			return 0;
		}
	}

	@Override
	public List<UserRegistration> searchUserRegistrationAnd(
			int pageNumber, int pageSize, String userRegistrationFName,
			String userRegistrationMName, String userRegistrationLName, 
			String userRegistrationfullName,String userRegistrationName, 
			String userNaId,String userBirthId, String userPassNum) {
		
		Pageable pageable = PageRequest.of(pageNumber, pageSize, 
				Sort.by("userRegistrationId").descending());
		List<UserRegistration> pageContent = userRegistrationRepository.searchUserRegistrationAnd(
		userRegistrationFName.toUpperCase() != null ? "":userRegistrationFName.toUpperCase(),
		userRegistrationMName.toUpperCase() != null ? "":userRegistrationMName.toUpperCase(),
		userRegistrationLName.toUpperCase() != null ? "":userRegistrationLName.toUpperCase(),
		userRegistrationfullName.toUpperCase() != null ? "":userRegistrationfullName.toUpperCase(),
		userRegistrationName.toUpperCase() != null ? "":userRegistrationName.toUpperCase(),
		userNaId.toUpperCase() != null ? "":userNaId.toUpperCase(),
		userBirthId.toUpperCase() != null ? "":userBirthId.toUpperCase(),
		userPassNum.toUpperCase() != null ? "":userPassNum.toUpperCase(),
		pageable);
		if (!pageContent.isEmpty()) {
			return pageContent;
		} else {
			return new ArrayList<UserRegistration>(pageContent);
		}
	}

	@Override
	public List<UserRegistration> searchUserRegistrationOr(int pageNumber, int pageSize, String userRegistrationFName,
			String userRegistrationMName, String userRegistrationLName, String userRegistrationfullName,
			String userRegistrationName, String userNaId, String userBirthId, String userPassNum) {
		Pageable pageable = PageRequest.of(pageNumber, pageSize, 
				Sort.by("userRegistrationId").descending());
		List<UserRegistration> pageContent = userRegistrationRepository.searchUserRegistrationAnd(
		userRegistrationFName.toUpperCase() != null ? "":userRegistrationFName.toUpperCase(),
		userRegistrationMName.toUpperCase() != null ? "":userRegistrationMName.toUpperCase(),
		userRegistrationLName.toUpperCase() != null ? "":userRegistrationLName.toUpperCase(),
		userRegistrationfullName.toUpperCase() != null ? "":userRegistrationfullName.toUpperCase(),
		userRegistrationName.toUpperCase() != null ? "":userRegistrationName.toUpperCase(),
		userNaId.toUpperCase() != null ? "":userNaId.toUpperCase(),
		userBirthId.toUpperCase() != null ? "":userBirthId.toUpperCase(),
		userPassNum.toUpperCase() != null ? "":userPassNum.toUpperCase(),
		pageable);
		if (!pageContent.isEmpty()) {
			return pageContent;
		} else {
			return new ArrayList<UserRegistration>(pageContent);
		}
	}


}
