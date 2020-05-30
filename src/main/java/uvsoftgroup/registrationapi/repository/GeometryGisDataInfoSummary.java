package uvsoftgroup.registrationapi.repository;

public interface GeometryGisDataInfoSummary {
	long getGgdId();
	Long getAdRefId();
	Long getReferenceNr();
	String getAdType();
	String getAdCity();
	String getAdRoad();
	String getAdRoadType();
	String getAdHouseNumber();
	String getAdPostCode();
	String getWktToGeometry();
	String getGeoType();
	String getAdCountry();
}
