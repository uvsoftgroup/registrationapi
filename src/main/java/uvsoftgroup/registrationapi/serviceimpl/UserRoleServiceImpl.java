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

import uvsoftgroup.registrationapi.model.UserRole;
import uvsoftgroup.registrationapi.repository.UserRoleRepository;
import uvsoftgroup.registrationapi.repository.UserRoleSummary;
import uvsoftgroup.registrationapi.service.UserRoleService;

@Service
public class UserRoleServiceImpl implements UserRoleService {

	@Autowired
	private UserRoleRepository userRoleRepository;
	
	@Override
	public UserRole saveUserRole(UserRole userRole) {
		return userRoleRepository.save(userRole);
	}
	
	@Override
	public UserRole updateUserRole(UserRole userRole) {
		return userRoleRepository.save(userRole);
	}
	
	@Override
	public void deleteUserRole(Long userRoleId) {
		userRoleRepository.deleteById(userRoleId);
	}

	@Override
	public Optional<UserRole> findByUserRole(Long userRoleId) {
		return userRoleRepository.findById(userRoleId);
	}
	
	@Override
	public List<UserRole> findAll(int pageNumber, int pageSize) {
		Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by("userRoleId").descending());
		Page<UserRole> pageContent = userRoleRepository.findAll(pageable);
		if (!pageContent.getContent().isEmpty()) {
			return pageContent.getContent();
		} else {
			return new ArrayList<UserRole>(pageContent.getContent());
		}
	}

	@Override
	public long findCounter(int pageNumber, int pageSize) {
		Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by("userRoleId").descending());
		Page<UserRole> pageContent = userRoleRepository.findAll(pageable);
		if (!pageContent.getContent().isEmpty()) {
			return pageContent.getContent().size();
		} else {
			return 0;
		}
	}

	@Override
	public List<UserRole> findByUserRoleType(
			int pageNumber, 
			int pageSize, 
			String userRoleType) {
		Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by("userRoleId").descending());
		List<UserRole> pageContent = userRoleRepository.findByUserRoleType(userRoleType, pageable);
		if (!pageContent.isEmpty()) {
			return pageContent;
		} else {
			return new ArrayList<UserRole>(pageContent);
		}
	}

	@Override
	public List<UserRole> findByUserRoleNameAndUserRoleType(
			int pageNumber, 
			int pageSize, 
			String userRoleName,
			String userRoleType) {
		Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by("userRoleId").descending());
		List<UserRole> pageContent = userRoleRepository.findByUserRoleNameAndUserRoleType(userRoleName, userRoleType,
				pageable);
		if (!pageContent.isEmpty()) {
			return pageContent;
		} else {
			return new ArrayList<UserRole>(pageContent);
		}
	}

	@Override
	public List<UserRole> findByUserRoleNameOrUserRoleType(
			int pageNumber, 
			int pageSize, 
			String userRoleName,
			String userRoleType) {
		Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by("userRoleId").descending());
		List<UserRole> pageContent = userRoleRepository.findByUserRoleNameOrUserRoleType(userRoleName, userRoleType,
				pageable);
		if (!pageContent.isEmpty()) {
			return pageContent;
		} else {
			return new ArrayList<UserRole>(pageContent);
		}
	}

	@Override
	public List<UserRole> findByUserRoleNameUserRoleTypeWithQueryAnd(
			int pageNumber, 
			int pageSize, 
			String userRoleName,
			String userRoleType) {
		Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by("userRoleId").descending());
		List<UserRole> pageContent = userRoleRepository.findByUserRoleNameUserRoleTypeWithQueryAnd(userRoleName,
				userRoleType, pageable);
		if (!pageContent.isEmpty()) {
			return pageContent;
		} else {
			return new ArrayList<UserRole>(pageContent);
		}
	}

	@Override
	public List<UserRole> findByUserRoleNameUserRoleTypeWithQueryOr(
			int pageNumber, 
			int pageSize, 
			String userRoleName,
			String userRoleType) {
		Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by("userRoleId").descending());
		List<UserRole> pageContent = userRoleRepository.findByUserRoleNameUserRoleTypeWithQueryOr(
				userRoleName.toLowerCase() != null ? "":userRoleName.toLowerCase(),
				userRoleType.toLowerCase() != null ? "":userRoleType.toLowerCase(),
				pageable);
		if (!pageContent.isEmpty()) {
			return pageContent;
		} else {
			return new ArrayList<UserRole>(pageContent);
		}
	}

	@Override
	public List<UserRole> findByUserRoleNameAndTypeWithParams(
			int pageNumber, 
			int pageSize, 
			String userRoleName,
			String userRoleType) {
		Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by("userRoleId").descending());
		List<UserRole> pageContent = userRoleRepository.findByUserRoleNameAndTypeWithParams(
				userRoleName.toLowerCase() != null ? "":userRoleName.toLowerCase(),
				userRoleType.toLowerCase() != null ? "":userRoleType.toLowerCase(),
				pageable);
		if (!pageContent.isEmpty()) {
			return pageContent;
		} else {
			return new ArrayList<UserRole>(pageContent);
		}
	}

	@Override
	public List<UserRole> findFloorInfoByUserRoleTypeList(
			int pageNumber, 
			int pageSize, 
			List<String> userRoleTypes) {
		Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by("userRoleId").descending());
		List<UserRole> pageContent = userRoleRepository.findFloorInfoByUserRoleTypeList(
				userRoleTypes, 
				pageable);
		if (!pageContent.isEmpty()) {
			return pageContent;
		} else {
			return new ArrayList<UserRole>(pageContent);
		}
	}

	@Override
	public List<UserRole> searchUserRoleInfoAnd(
			int pageNumber, 
			int pageSize, 
			List<String> userRoleTypes,
			String userRoleName) {
		Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by("userRoleId").descending());
		List<UserRole> pageContent = userRoleRepository.searchUserRoleInfoAnd(
				userRoleTypes,
				userRoleName.toLowerCase() != null ? "":userRoleName.toLowerCase(), 
				pageable);
		if (!pageContent.isEmpty()) {
			return pageContent;
		} else {
			return new ArrayList<UserRole>(pageContent);
		}
	}

	@Override
	public List<UserRole> searchUserRoleInfoOr(
			int pageNumber, 
			int pageSize, 
			List<String> userRoleTypes,
			String userRoleName) {
		Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by("userRoleId").descending());
		List<UserRole> pageContent = userRoleRepository.searchUserRoleInfoOr(
				userRoleTypes,
				userRoleName.toLowerCase() != null ? "":userRoleName.toLowerCase(), 
				pageable);
		if (!pageContent.isEmpty()) {
			return pageContent;
		} else {
			return new ArrayList<UserRole>(pageContent);
		}
	}

	@Override
	public List<UserRoleSummary> countbyUserRoleType(List<String> userRoleTypes) {
		return userRoleRepository.countbyUserRoleType(userRoleTypes);
	}

	@Override
	public List<UserRole> findUserRoleByUserRoleType(List<String> userRoleTypes) {
		return userRoleRepository.findUserRoleByUserRoleType(userRoleTypes);
	}

}
