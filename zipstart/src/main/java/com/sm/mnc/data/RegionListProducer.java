package com.sm.mnc.data;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;

import com.sm.mnc.model.Region;

@RequestScoped
public class RegionListProducer {

	List<Region> regions;
	
	@Inject 
	RegionRepository regionRepository;
	
	public RegionListProducer() {		
	}
	
	
	@Produces
	@Named
	public List<Region> getAllRegions() {
		return this.regions;
	}
	
	@PostConstruct
	public void fetchRegionList() {
		this.regions = this.regionRepository.getAllRegions();
	}

}
