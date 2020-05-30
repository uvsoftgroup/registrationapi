package uvsoftgroup.registrationapi.repository;


import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import uvsoftgroup.registrationapi.model.AddressInfo;


public interface AddressInfoRepository extends PagingAndSortingRepository<AddressInfo, Long> {
	// @Query Annotation: Spring Data JPA Projections
				@Query("SELECT ad.adId as adId,"
						+ "ad.adRefId as adRefId, "
						+ "ad.userRefNrId as userRefNrId, "
						+ "ad.adType as adType, "
						+ "ad.adCat as adCat, "
						+ "ad.adCity as adCity, "
						+ "ad.adRoad as adRoad, "
						+ "ad.adRoadType as adRoadType, "
						+ "ad.adHouseNumber as adHouseNumber, "
						+ "ad.adPostCode as adPostCode, "
						+ "ad.adCountry as adCountry, "
						+ "ad.geoType as geoType, "
						+ "ad.wktToGeometry as wktToGeometry "
						+ "FROM AddressInfo ad ")
				List<AddressInfoSummary> getAddressInfoSummary(Pageable pageable);
				
	 // Structure of Derived Query Methods
	 List<AddressInfo> findByUserRefNrId(long userRefNrId, Pageable pageable);
	
}
