package uvsoftgroup.registrationapi.repository;

public interface AddressInfoSummary {
	Long getAdId();
	Long getUserRefNrId();
	Long getAdRefId();
	Long getReferenceNr();
	String getAdType();
	String getAdCat();
	String getAdCity();
	String getAdRoad();
	String getAdRoadType();
	String getAdHouseNumber();
	String getAdPostCode();
	String getWktToGeometry();
	String getGeoType();
	String getAdCountry();
}
