package com.sm.mnc.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;


/**
 * Entity implementation class for Entity: Region
 *
 */
@Entity
@Table(name="REGION", uniqueConstraints = @UniqueConstraint(columnNames = "REGION_NAME"))
public class Region extends BaseEntity implements Serializable {

	
	private Long regionId;
	private String regionName;
	private static final long serialVersionUID = 1L;
	private List<Country> countries;

	public Region() {
		super();
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="REGION_ID")
	public Long getRegionId() {
		return this.regionId;
	}

	public void setRegionId(Long regionId) {
		this.regionId = regionId;
	}   
	
	@NotNull(message = "Region name can't be blank.")
	@Length(min=3, max=25, message = "Region name should have at least 2 or maximum 25 characters.")
	@Column(name="REGION_NAME")	
	public String getRegionName() {
		return this.regionName;
	}

	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}
	
	//bi-directional many-to-one association to Country
	@OneToMany(mappedBy="region")
	public List<Country> getCountries() {
		return this.countries;
	}

	public void setCountries(List<Country> countries) {
		this.countries = countries;
	}

	public Country addCountry(Country country) {
		getCountries().add(country);
		country.setRegion(this);

		return country;
	}

	public Country removeCountry(Country country) {
		getCountries().remove(country);
		country.setRegion(null);

		return country;
	}
   
}
