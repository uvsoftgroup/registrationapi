package uvsoftgroup.registrationapi.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uvsoftgroup.registrationapi.model.UserRole;

@Service
public class UserRoleRepositoryCustomImpl implements UserRoleRepositoryCustom {
	@Autowired
	private EntityManager entityManager;

	@Override
	public List<UserRole> findUserRoleByUserRoleType(List<String> userRoleTypes) {
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<UserRole> query = cb.createQuery(UserRole.class);
        Root<UserRole> user = query.from(UserRole.class);
 
        Path<String> userRoleTypePath = user.get("userRoleType");
        List<Predicate> predicates = new ArrayList<>();
        
        for (String userRoleType : userRoleTypes) {
            predicates.add(cb.like(userRoleTypePath,userRoleType));
        }
        query.select(user)
            .where(cb.or(predicates.toArray(new Predicate[predicates.size()])));
 
        return entityManager.createQuery(query).getResultList();
	}

}
