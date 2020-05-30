package uvsoftgroup.registrationapi.model;

import java.io.Serializable;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="geometry_gis_info")
public class GeometryGisInfo implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	long geoId;
	@Embedded
	GeometryGisData geometryGisData;
	// default constructor method
	public GeometryGisInfo() {
		super();
	}
	// standard getter and setter method
	public GeometryGisInfo(GeometryGisData geometryGisData) {
		this.geometryGisData=geometryGisData;
	}
	
	public GeometryGisData getGeometryGisData() {
		return geometryGisData;
	}
	public void setGeometryGisData(GeometryGisData geometryGisData) {
		this.geometryGisData = geometryGisData;
	}
	
	public long getGeoId() {
		return geoId;
	}
	public void setGeoId(long geoId) {
		this.geoId = geoId;
	}
	
}
