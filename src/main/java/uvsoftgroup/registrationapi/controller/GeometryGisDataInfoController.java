package uvsoftgroup.registrationapi.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import uvsoftgroup.registrationapi.model.GeometryGisDataInfo;
import uvsoftgroup.registrationapi.repository.GeometryGisDataInfoSummary;
import uvsoftgroup.registrationapi.service.GeometryGisDataInfoService;

@RestController
@RequestMapping(value = "/geometrygisdatainfo")
public class GeometryGisDataInfoController {

	@Autowired
	private GeometryGisDataInfoService geometryGisDataInfoService;
	
	@RequestMapping(value = "/saveGeometryGisDataInfo", method = RequestMethod.POST)
	public GeometryGisDataInfo saveGeometryGisDataInfo(@Valid @RequestBody GeometryGisDataInfo geometryGisDataInfo){
		return geometryGisDataInfoService.saveGeometryGisDataInfo(geometryGisDataInfo);
	}
	
	@RequestMapping(value = "/updateGeometryGisDataInfo", method = RequestMethod.PUT)
	public GeometryGisDataInfo updateUserRegistration(@Valid @RequestBody GeometryGisDataInfo geometryGisDataInfo){
		return geometryGisDataInfoService.updateGeometryGisDataInfo(geometryGisDataInfo);
	}
	
	@RequestMapping(value="deleteGeometryGisDataInfo/{ggdId}",
			method=RequestMethod.DELETE)
	public void deleteGeometryGisDataInfo(@PathVariable("ggdId") Long ggdId){
		geometryGisDataInfoService.deleteGeometryGisDataInfo(ggdId);	
	}
	
	@RequestMapping(value="findByGeometryGisDataInfo/{ggdId}",
			method=RequestMethod.GET)
	public Optional<GeometryGisDataInfo> findByGeometryGisDataInfo(@PathVariable("ggdId") Long userRegistrationId){
		return geometryGisDataInfoService.findByGeometryGisDataInfo(userRegistrationId);	
	}
	
	@RequestMapping(value = "/findAll", method = RequestMethod.GET)
	public List<GeometryGisDataInfo> findAll(
			@RequestParam(name = "pageNumber", required = false, defaultValue = "0") int pageNumber,
			@RequestParam(name = "pageSize", required = false, defaultValue = "30") int pageSize) {
		List<GeometryGisDataInfo> list =geometryGisDataInfoService.findAll(pageNumber, pageSize);
		return list;
	}

	@RequestMapping(value = "/findCounter", method = RequestMethod.GET)
	public long findCounter(
			@RequestParam(name = "pageNumber", required = false, defaultValue = "0") int pageNumber,
			@RequestParam(name = "pageSize", required = false, defaultValue = "30") int pageSize) {
		long counter =geometryGisDataInfoService.findCounter(pageNumber, pageSize);
		return counter;
	}
	
	@RequestMapping(value = "/getGeometryGisDataInfoSummary", 
			method = RequestMethod.GET)
	public List<GeometryGisDataInfoSummary> getGeometryGisDataInfoSummary(
		@RequestParam(name = "pageNumber", required = false, defaultValue = "0") int pageNumber,
		@RequestParam(name = "pageSize", required = false, defaultValue = "30") int pageSize,
		@RequestParam(name = "adPostCode", required = false) String adPostCode) {
		List<GeometryGisDataInfoSummary> list =
				geometryGisDataInfoService.getGeometryGisDataInfoSummary(
				pageNumber, pageSize, adPostCode);
		return list;
	}
	
	
}
