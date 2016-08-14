package org.ims.beans;

import javax.persistence.*;

@Entity
@Table(name="IMS_ADDRESS")
public class AddressBean {
	
	@Id
	@Column(name="ABBRV_ID")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int addressId;
	@Column(name="STREET_ADDRESS_1")
	private String streetAddress1;
	@Column(name="STREET_ADDRESS_2")
	private String streetAddress2;
	@Column(name="ADDRESS_CITY")
	private String addressCity;
	@Column(name="STATE_ID")
	private int stateId;
	@Column(name="ADDRESS_ZIP")
	private String addressZip;
	@ManyToOne
	@JoinColumn(name="ADDRESS_STATE_ABBRV")
	private StateAbbrvBean stateAbbrv;
	
	public int getAddressId() {
		return addressId;
	}
	public void setAddressId(int addressId) {
		this.addressId = addressId;
	}
	public String getStreetAddress1() {
		return streetAddress1;
	}
	public void setStreetAddress1(String streetAddress1) {
		this.streetAddress1 = streetAddress1;
	}
	public String getStreetAddress2() {
		return streetAddress2;
	}
	public void setStreetAddress2(String streetAddress2) {
		this.streetAddress2 = streetAddress2;
	}
	public String getAddressCity() {
		return addressCity;
	}
	public void setAddressCity(String addressCity) {
		this.addressCity = addressCity;
	}
	public int getStateId() {
		return stateId;
	}
	public void setStateId(int stateId) {
		this.stateId = stateId;
	}
	public String getAddressZip() {
		return addressZip;
	}
	public void setAddressZip(String addressZip) {
		this.addressZip = addressZip;
	}
	public AddressBean() {
		super();
		// TODO Auto-generated constructor stub
	}
	public AddressBean(int addressId, String streetAddress1, String streetAddress2, String addressCity, int stateId,
			String addressZip, StateAbbrvBean stateAbbrv) {
		super();
		this.addressId = addressId;
		this.streetAddress1 = streetAddress1;
		this.streetAddress2 = streetAddress2;
		this.addressCity = addressCity;
		this.stateId = stateId;
		this.addressZip = addressZip;
		this.stateAbbrv = stateAbbrv;
	}
	
}
