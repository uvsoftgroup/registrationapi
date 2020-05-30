package uvsoftgroup.registrationapi.service;

import java.util.List;
import java.util.Optional;

import uvsoftgroup.registrationapi.model.GeometryGisDataInfo;
import uvsoftgroup.registrationapi.repository.GeometryGisDataInfoSummary;


public interface GeometryGisDataInfoService {
	GeometryGisDataInfo saveGeometryGisDataInfo(GeometryGisDataInfo userRegistration);
	GeometryGisDataInfo updateGeometryGisDataInfo(GeometryGisDataInfo userRegistration);
	void deleteGeometryGisDataInfo(Long ggdId);
	Optional<GeometryGisDataInfo> findByGeometryGisDataInfo(Long ggdId);
	List<GeometryGisDataInfo> findAll(int pageNumber, int pageSize);
	long findCounter(int pageNumber, int pageSize);
	
	List<GeometryGisDataInfoSummary> getGeometryGisDataInfoSummary(int pageNumber, 
			int pageSize, String adPostCode);

}
