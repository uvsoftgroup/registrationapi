package uvsoftgroup.registrationapi.serviceimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.vividsolutions.jts.geom.Geometry;

import uvsoftgroup.registrationapi.model.AddressInfo;
import uvsoftgroup.registrationapi.repository.AddressInfoRepository;
import uvsoftgroup.registrationapi.repository.AddressInfoSummary;
import uvsoftgroup.registrationapi.service.AddressInfoService;
import uvsoftgroup.registrationapi.utility.WktToGeometry;

@Service
public class AddressInfoServiceImpl implements AddressInfoService {

	@Autowired
	private AddressInfoRepository addressInfoRepository;

	@Override
	public AddressInfo saveAddressInfo(AddressInfo addressInfo) throws Exception {
		AddressInfo addressInfoSave = new AddressInfo();
		if (addressInfo.getWktToGeometry() != null) {
			Geometry geom = WktToGeometry.wktToGeometry(addressInfo.getWktToGeometry());
			 geom.setSRID(4326);
			 addressInfoSave.setGeom(geom);
			 addressInfoSave.setGeoType(geom.getGeometryType().toUpperCase());
			 addressInfoSave.setWktToGeometry(addressInfo.getWktToGeometry());
			 addressInfoSave.setAdCity(addressInfo.getAdCity());
			 addressInfoSave.setAdCountry(addressInfo.getAdCountry());
			 addressInfoSave.setAdPostCode(addressInfo.getAdPostCode());
			 addressInfoSave.setAdHouseNumber(addressInfo.getAdHouseNumber());
			 addressInfoSave.setAdRefId(addressInfo.getAdRefId());
			 addressInfoSave.setAdRoad(addressInfo.getAdRoad());
			 addressInfoSave.setAdRoadType(addressInfo.getAdRoadType());
			 addressInfoSave.setAdType(addressInfo.getAdType());
			 addressInfoSave.setAdCat(addressInfo.getAdCat());
		} 
			return addressInfoRepository.save(addressInfoSave);
	}

	@Override
	public AddressInfo updateAddressInfo(AddressInfo addressInfo) throws Exception {
		AddressInfo addressInfoSave = new AddressInfo();
		if (addressInfo.getWktToGeometry() != null) {
			Geometry geom = WktToGeometry.wktToGeometry(addressInfo.getWktToGeometry());
			 geom.setSRID(4326);
			 addressInfoSave.setGeom(geom);
			 addressInfoSave.setGeoType(geom.getGeometryType().toUpperCase());
			 addressInfoSave.setWktToGeometry(addressInfo.getWktToGeometry());
			 addressInfoSave.setAdCity(addressInfo.getAdCity());
			 addressInfoSave.setAdCountry(addressInfo.getAdCountry());
			 addressInfoSave.setAdPostCode(addressInfo.getAdPostCode());
			 addressInfoSave.setAdHouseNumber(addressInfo.getAdHouseNumber());
			 addressInfoSave.setAdRefId(addressInfo.getAdRefId());
			 addressInfoSave.setAdRoad(addressInfo.getAdRoad());
			 addressInfoSave.setAdRoadType(addressInfo.getAdRoadType());
			 addressInfoSave.setAdType(addressInfo.getAdType());
			 addressInfoSave.setAdCat(addressInfo.getAdCat());
			 addressInfoSave.setAdId(addressInfo.getAdId());
		} 
			return addressInfoRepository.save(addressInfoSave);
	}
	
	@Override
	public List<AddressInfoSummary> getAddressInfoSummary(int pageNumber, int pageSize) {
		Pageable pageable= PageRequest.of(pageNumber, pageSize, Sort.by("adId").descending());
		List<AddressInfoSummary> pageContent = addressInfoRepository.getAddressInfoSummary(pageable);
		if (!pageContent.isEmpty()) {
			return pageContent;
		} else {
			return new ArrayList<AddressInfoSummary>(pageContent);
		}
	}

	@Override
	public long findCounter(int pageNumber, int pageSize) {
		Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by("adId").descending());
		List<AddressInfoSummary> pageContent = addressInfoRepository.getAddressInfoSummary(pageable);
		if (!pageContent.isEmpty()) {
			return pageContent.size();
		} else {
			return 0;
		}
	}

	
	
	@Override
	public List<AddressInfo> findByUserRefNrId(int pageNumber, int pageSize, long userRefNrId) {
		Pageable pageableByAdId = PageRequest.of(pageNumber, pageSize, Sort.by("adId").descending());
		List<AddressInfo> pageContent = addressInfoRepository.findByUserRefNrId(userRefNrId, pageableByAdId);
		if (!pageContent.isEmpty()) {
			return pageContent;
		} else {
			return new ArrayList<AddressInfo>(pageContent);
		}
	}
	
}
