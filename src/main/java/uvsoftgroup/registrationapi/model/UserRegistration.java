/**
 * 
 */
package uvsoftgroup.registrationapi.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "userregistration")
public class UserRegistration implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long userRegistrationId;
	private Long userAddressId;
	private String userRegistrationFName, userRegistrationMName, userRegistrationLName, 
	 userRegistrationfullName;
	private String userRegistrationName,userRegistrationPassword;
	private String userNaId,userBirthId,userPassNum;
	private Date userRegistrationCrDate, userRegistrationLDate;
	private String userMail, userPhoneNr, userMobileNr, userWww;
	byte [] userPicture, userNaIdPicture, userPassPicture;

	@OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "ur_ur_id")
	private List<UserRole> userRoles = new ArrayList<UserRole>();
	
	public UserRegistration() {
		super();
	}

	public String getUserMail() {
		return userMail;
	}

	public void setUserMail(String userMail) {
		this.userMail = userMail;
	}

	public String getUserPhoneNr() {
		return userPhoneNr;
	}

	public void setUserPhoneNr(String userPhoneNr) {
		this.userPhoneNr = userPhoneNr;
	}

	public String getUserMobileNr() {
		return userMobileNr;
	}

	public void setUserMobileNr(String userMobileNr) {
		this.userMobileNr = userMobileNr;
	}

	public String getUserWww() {
		return userWww;
	}

	public void setUserWww(String userWww) {
		this.userWww = userWww;
	}

	public Long getUserRegistrationId() {
		return userRegistrationId;
	}

	public void setUserRegistrationId(Long userRegistrationId) {
		this.userRegistrationId = userRegistrationId;
	}

	public Long getUserAddressId() {
		return userAddressId;
	}

	public void setUserAddressId(Long userAddressId) {
		this.userAddressId = userAddressId;
	}

	public String getUserRegistrationFName() {
		return userRegistrationFName;
	}

	public void setUserRegistrationFName(String userRegistrationFName) {
		this.userRegistrationFName = userRegistrationFName;
	}

	public String getUserRegistrationMName() {
		return userRegistrationMName;
	}

	public void setUserRegistrationMName(String userRegistrationMName) {
		this.userRegistrationMName = userRegistrationMName;
	}

	public String getUserRegistrationLName() {
		return userRegistrationLName;
	}

	public void setUserRegistrationLName(String userRegistrationLName) {
		this.userRegistrationLName = userRegistrationLName;
	}

	public String getUserRegistrationName() {
		return userRegistrationName;
	}

	public void setUserRegistrationName(String userRegistrationName) {
		this.userRegistrationName = userRegistrationName;
	}

	public String getUserRegistrationPassword() {
		return userRegistrationPassword;
	}

	public void setUserRegistrationPassword(String userRegistrationPassword) {
		this.userRegistrationPassword = userRegistrationPassword;
	}

	public String getUserRegistrationfullName() {
		return userRegistrationfullName;
	}

	public void setUserRegistrationfullName(String userRegistrationfullName) {
		this.userRegistrationfullName = userRegistrationfullName;
	}

	public Date getUserRegistrationCrDate() {
		return userRegistrationCrDate;
	}

	public void setUserRegistrationCrDate(Date userRegistrationCrDate) {
		this.userRegistrationCrDate = userRegistrationCrDate;
	}

	public Date getUserRegistrationLDate() {
		return userRegistrationLDate;
	}

	public void setUserRegistrationLDate(Date userRegistrationLDate) {
		this.userRegistrationLDate = userRegistrationLDate;
	}

	public List<UserRole> getUserRoles() {

		if (userRoles == null) {
			userRoles = new ArrayList<UserRole>();
		}

		return userRoles;
	}

	public void setUserRoles(List<UserRole> userRoles) {
		this.userRoles = userRoles;
	}

	public String getUserNaId() {
		return userNaId;
	}

	public void setUserNaId(String userNaId) {
		this.userNaId = userNaId;
	}

	public String getUserBirthId() {
		return userBirthId;
	}

	public void setUserBirthId(String userBirthId) {
		this.userBirthId = userBirthId;
	}

	public String getUserPassNum() {
		return userPassNum;
	}

	public void setUserPassNum(String userPassNum) {
		this.userPassNum = userPassNum;
	}

	public byte[] getUserPicture() {
		return userPicture;
	}

	public void setUserPicture(byte[] userPicture) {
		this.userPicture = userPicture;
	}

	public byte[] getUserNaIdPicture() {
		return userNaIdPicture;
	}

	public void setUserNaIdPicture(byte[] userNaIdPicture) {
		this.userNaIdPicture = userNaIdPicture;
	}

	public byte[] getUserPassPicture() {
		return userPassPicture;
	}

	public void setUserPassPicture(byte[] userPassPicture) {
		this.userPassPicture = userPassPicture;
	}

	
}
