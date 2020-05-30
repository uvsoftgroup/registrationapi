package uvsoftgroup.registrationapi.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import uvsoftgroup.registrationapi.model.AddressInfo;
import uvsoftgroup.registrationapi.repository.AddressInfoSummary;
import uvsoftgroup.registrationapi.service.AddressInfoService;

@RestController
@RequestMapping(value = "/addressinfo")
public class AddressInfoController {
	@Autowired
	private AddressInfoService addressInfoService;

	@RequestMapping(value = "/saveAddressInfo", method = RequestMethod.POST)
	public AddressInfo saveAddressInfo(@Valid @RequestBody AddressInfo addressInfo) throws Exception {
		return addressInfoService.saveAddressInfo(addressInfo);
	}

	@RequestMapping(value = "/updateAddressInfo", method = RequestMethod.POST)
	public AddressInfo updateAddressInfo(@Valid @RequestBody AddressInfo addressInfo) throws Exception {
		return addressInfoService.updateAddressInfo(addressInfo);
	}
	
	@RequestMapping(value = "/findAllByList", method = RequestMethod.GET)
	public List<AddressInfoSummary> findAllByList(
			@RequestParam(name = "pageNumber", required = false, defaultValue = "0") int pageNumber,
			@RequestParam(name = "pageSize", required = false, defaultValue = "30") int pageSize) {
		List<AddressInfoSummary> list = addressInfoService.getAddressInfoSummary(pageNumber, pageSize);
		return list;
	}

	@RequestMapping(value = "/findCounter", method = RequestMethod.GET)
	public long findCounter(
			@RequestParam(name = "pageNumber", required = false, defaultValue = "0") int pageNumber,
			@RequestParam(name = "pageSize", required = false, defaultValue = "10000") int pageSize) {
		long counter = addressInfoService.findCounter(pageNumber, pageSize);
		return counter;
	}

	
	@RequestMapping(value = "/findByUserRefNrId", method = RequestMethod.GET)
	public List<AddressInfo> findByUserRefNrId(
			@RequestParam(name = "pageNumber", required = false, defaultValue = "0") int pageNumber,
			@RequestParam(name = "pageSize", required = false, defaultValue = "30") int pageSize,
			@RequestParam(name = "userRefNrId", required = false) long userRefNrId) {
		List<AddressInfo> list = addressInfoService.findByUserRefNrId(pageNumber, pageSize, userRefNrId);
		return list;
	}
	

}
