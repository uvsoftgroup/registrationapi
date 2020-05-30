package uvsoftgroup.registrationapi.service;

import java.util.List;

import uvsoftgroup.registrationapi.model.AddressInfo;
import uvsoftgroup.registrationapi.repository.AddressInfoSummary;

public interface AddressInfoService {
	List<AddressInfoSummary> getAddressInfoSummary(int pageNumber, int pageSize);
	long findCounter(int pageNumber, int pageSize);
	AddressInfo saveAddressInfo(AddressInfo addressInfo) throws Exception;
	AddressInfo updateAddressInfo(AddressInfo addressInfo) throws Exception;
	List<AddressInfo> findByUserRefNrId(int pageNumber, int pageSize, long userRefNrId);

}
