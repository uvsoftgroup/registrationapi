package uvsoftgroup.registrationapi.repository;

import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import uvsoftgroup.registrationapi.model.GeometryGisDataInfo;

public interface GeometryGisDataInfoRepository extends PagingAndSortingRepository<GeometryGisDataInfo, Long> {

	// @Query Annotation: Spring Data JPA Projections
			@Query("SELECT geo.ggdId as ggdId,"
					+ "geo.adRefId as adRefId, "
					+ "geo.referenceNr as referenceNr, "
					+ "geo.adType as adType, "
					+ "geo.adCity as adCity, "
					+ "geo.adRoad as adRoad, "
					+ "geo.adRoadType as adRoadType, "
					+ "geo.adHouseNumber as adHouseNumber, "
					+ "geo.adPostCode as adPostCode, "
					+ "geo.adCountry as adCountry, "
					+ "geo.geoType as geoType, "
					+ "geo.wktToGeometry as wktToGeometry "
					+ "FROM GeometryGisDataInfo geo "
					+ "WHERE geo.adPostCode LIKE %:adPostCode%")
			List<GeometryGisDataInfoSummary> getGeometryGisDataInfoSummary(
					@Param("adPostCode") String adPostCode,
					Pageable pageable);
			
			
}
