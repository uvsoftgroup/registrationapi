package uvsoftgroup.registrationapi.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.vividsolutions.jts.geom.Geometry;

@Entity
@Table(name="address_info")
public class AddressInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long adId;
	private Long userRefNrId;
	private Long adRefId;
	private String adType, adCat;
	private String adCity;
	private String adRoad,adRoadType;
	private String adHouseNumber;
	private String adPostCode;
	private String adCountry;
	private String geoType, wktToGeometry;
    Geometry geom;
	
	public AddressInfo() {
		super();
		
	}

	public Long getAdId() {
		return adId;
	}

	public void setAdId(Long adId) {
		this.adId = adId;
	}

	public Long getUserRefNrId() {
		return userRefNrId;
	}

	public void setUserRefNrId(Long userRefNrId) {
		this.userRefNrId = userRefNrId;
	}

	public Long getAdRefId() {
		return adRefId;
	}

	public void setAdRefId(Long adRefId) {
		this.adRefId = adRefId;
	}

	public String getAdType() {
		return adType;
	}

	public void setAdType(String adType) {
		this.adType = adType;
	}

	public String getAdCity() {
		return adCity;
	}

	public void setAdCity(String adCity) {
		this.adCity = adCity;
	}

	public String getAdRoad() {
		return adRoad;
	}

	public void setAdRoad(String adRoad) {
		this.adRoad = adRoad;
	}

	public String getAdRoadType() {
		return adRoadType;
	}

	public void setAdRoadType(String adRoadType) {
		this.adRoadType = adRoadType;
	}

	public String getAdHouseNumber() {
		return adHouseNumber;
	}

	public void setAdHouseNumber(String adHouseNumber) {
		this.adHouseNumber = adHouseNumber;
	}

	public String getAdPostCode() {
		return adPostCode;
	}

	public void setAdPostCode(String adPostCode) {
		this.adPostCode = adPostCode;
	}

	public String getAdCountry() {
		return adCountry;
	}

	public void setAdCountry(String adCountry) {
		this.adCountry = adCountry;
	}

	public String getGeoType() {
		return geoType;
	}

	public void setGeoType(String geoType) {
		this.geoType = geoType;
	}

	public String getWktToGeometry() {
		return wktToGeometry;
	}

	public void setWktToGeometry(String wktToGeometry) {
		this.wktToGeometry = wktToGeometry;
	}

	public Geometry getGeom() {
		return geom;
	}

	public void setGeom(Geometry geom) {
		this.geom = geom;
	}

	public String getAdCat() {
		return adCat;
	}

	public void setAdCat(String adCat) {
		this.adCat = adCat;
	}
	
}
