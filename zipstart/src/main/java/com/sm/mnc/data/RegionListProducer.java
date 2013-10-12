package com.sm.mnc.data;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.event.Observes;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;

import com.sm.mnc.model.Region;
import com.sm.mnc.qualifier.Created;

@SessionScoped
public class RegionListProducer implements Serializable {

	private static final long serialVersionUID = -7515623913865629072L;

	List<Region> regions;
	
	@Inject 
	RegionRepository regionRepository;
	
	@Inject
	Logger log;
	
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
	
	public void onRegionCreated(@Observes @Created Region region) {
		this.regions.add(region);
		log.info("Region was created with name - " + region.getRegionName());		
	}

}
