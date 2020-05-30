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

import com.vividsolutions.jts.geom.Geometry;

import uvsoftgroup.registrationapi.model.GeometryGisDataInfo;
import uvsoftgroup.registrationapi.repository.GeometryGisDataInfoRepository;
import uvsoftgroup.registrationapi.repository.GeometryGisDataInfoSummary;
import uvsoftgroup.registrationapi.service.GeometryGisDataInfoService;
import uvsoftgroup.registrationapi.utility.WktToGeometry;

@Service
public class GeometryGisDataInfoServiceImpl implements GeometryGisDataInfoService {

	@Autowired
	private GeometryGisDataInfoRepository geometryGisDataInfoRepository;
	
	@Override
	public GeometryGisDataInfo saveGeometryGisDataInfo(GeometryGisDataInfo geometryGisDataInfo) {
		GeometryGisDataInfo geometryGisDataInfoSave=new GeometryGisDataInfo();
		
		if (geometryGisDataInfo.getWktToGeometry() != null) {
			Geometry geom = WktToGeometry.wktToGeometry(geometryGisDataInfo.getWktToGeometry());
			 geom.setSRID(4326);
			 geometryGisDataInfoSave.setGeom(geom);
			 geometryGisDataInfoSave.setGeoType(geom.getGeometryType().toUpperCase());
			 geometryGisDataInfoSave.setWktToGeometry(geometryGisDataInfo.getWktToGeometry());
			 geometryGisDataInfoSave.setAdCity(geometryGisDataInfo.getAdCity());
			 geometryGisDataInfoSave.setAdCountry(geometryGisDataInfo.getAdCountry());
			 geometryGisDataInfoSave.setAdPostCode(geometryGisDataInfo.getAdPostCode());
			 geometryGisDataInfoSave.setAdHouseNumber(geometryGisDataInfo.getAdHouseNumber());
			 geometryGisDataInfoSave.setAdRefId(geometryGisDataInfo.getAdRefId());
			 geometryGisDataInfoSave.setAdRoad(geometryGisDataInfo.getAdRoad());
			 geometryGisDataInfoSave.setAdRoadType(geometryGisDataInfo.getAdRoadType());
			 geometryGisDataInfoSave.setAdType(geometryGisDataInfo.getAdType());
		} 
		return geometryGisDataInfoRepository.save(geometryGisDataInfoSave);
	}
	
	@Override
	public GeometryGisDataInfo updateGeometryGisDataInfo(GeometryGisDataInfo geometryGisDataInfo) {
         
		GeometryGisDataInfo geometryGisDataInfoSave=new GeometryGisDataInfo();
		if (geometryGisDataInfo.getWktToGeometry() != null) {
			Geometry geom = WktToGeometry.wktToGeometry(geometryGisDataInfo.getWktToGeometry());
			 geom.setSRID(4326);
			 geometryGisDataInfoSave.setGeom(geom);
			 geometryGisDataInfoSave.setGeoType(geom.getGeometryType().toUpperCase());
			 geometryGisDataInfoSave.setWktToGeometry(geometryGisDataInfo.getWktToGeometry());
			 geometryGisDataInfoSave.setAdCity(geometryGisDataInfo.getAdCity());
			 geometryGisDataInfoSave.setAdCountry(geometryGisDataInfo.getAdCountry());
			 geometryGisDataInfoSave.setAdPostCode(geometryGisDataInfo.getAdPostCode());
			 geometryGisDataInfoSave.setAdHouseNumber(geometryGisDataInfo.getAdHouseNumber());
			 geometryGisDataInfoSave.setAdRefId(geometryGisDataInfo.getAdRefId());
			 geometryGisDataInfoSave.setAdRoad(geometryGisDataInfo.getAdRoad());
			 geometryGisDataInfoSave.setAdRoadType(geometryGisDataInfo.getAdRoadType());
			 geometryGisDataInfoSave.setAdType(geometryGisDataInfo.getAdType());
			 geometryGisDataInfoSave.setGgdId(geometryGisDataInfo.getGgdId());
		} 
			return geometryGisDataInfoRepository.save(geometryGisDataInfoSave);

	}
	
	@Override
	public void deleteGeometryGisDataInfo(Long ggdId) {
		geometryGisDataInfoRepository.deleteById(ggdId);
	}

	@Override
	public Optional<GeometryGisDataInfo> findByGeometryGisDataInfo(Long ggdId) {
		return geometryGisDataInfoRepository.findById(ggdId);
	}
	
	@Override
	public List<GeometryGisDataInfo> findAll(int pageNumber, int pageSize) {
		Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by("userRegistrationId").descending());
		Page<GeometryGisDataInfo> pageContent =geometryGisDataInfoRepository.findAll(pageable);
		if (!pageContent.getContent().isEmpty()) {
			return pageContent.getContent();
		} else {
			return new ArrayList<GeometryGisDataInfo>(pageContent.getContent());
		}
	}

	@Override
	public long findCounter(int pageNumber, int pageSize) {
		Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by("ggdId").descending());
		Page<GeometryGisDataInfo> pageContent =geometryGisDataInfoRepository.findAll(pageable);
		if (!pageContent.getContent().isEmpty()) {
			return pageContent.getContent().size();
		} else {
			return 0;
		}
	}

	@Override
	public List<GeometryGisDataInfoSummary> getGeometryGisDataInfoSummary(
			int pageNumber,
			int pageSize,
			String adPostCode) {
		Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by("ggdId").descending());
		List<GeometryGisDataInfoSummary> pageContent = geometryGisDataInfoRepository
				.getGeometryGisDataInfoSummary(
						adPostCode.toUpperCase()!=null? adPostCode.toUpperCase():"",
						pageable);
		if (!pageContent.isEmpty()) {
			return pageContent;
		} else {
			return new ArrayList<GeometryGisDataInfoSummary>(pageContent);
		}
	}
	
}
