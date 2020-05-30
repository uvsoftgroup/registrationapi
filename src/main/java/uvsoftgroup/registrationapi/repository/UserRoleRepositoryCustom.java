package uvsoftgroup.registrationapi.repository;

import java.util.List;

import uvsoftgroup.registrationapi.model.UserRole;

public interface UserRoleRepositoryCustom {
	List<UserRole> findUserRoleByUserRoleType(List<String> userRoleTypes);

}
