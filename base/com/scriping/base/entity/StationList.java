package com.scriping.base.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "STATION_LIST")
public class StationList  implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "ID")
	private Long id;

	@Column(name = "PROVINCE_STATE_CODE")
	private String provinceStateCode;
	
	@Column(name = "STATION_CATEGORIES")
	private String stationCategories;
	
	@Column(name = "NAME",columnDefinition="text")
	private String name;
	
	@Column(name = "MAC_CODE")
	private String macCode;
	
	@Column(name = "COUNTRY_CODE")
	private String countryCode;
	
	@Column(name = "CODE")
	private String code;
	
	@Column(name = "SHORT_NAME")
	private String shortName;

	public String getProvinceStateCode() {
		return provinceStateCode;
	}

	public void setProvinceStateCode(String provinceStateCode) {
		this.provinceStateCode = provinceStateCode;
	}

	public String getStationCategories() {
		return stationCategories;
	}

	public void setStationCategories(String stationCategories) {
		this.stationCategories = stationCategories;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMacCode() {
		return macCode;
	}

	public void setMacCode(String macCode) {
		this.macCode = macCode;
	}

	public String getCountryCode() {
		return countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}
	
	
	
}