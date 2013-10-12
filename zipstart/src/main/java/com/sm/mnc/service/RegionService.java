package com.sm.mnc.service;

import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.sm.mnc.model.Region;
import com.sm.mnc.qualifier.Created;

@Stateless
public class RegionService {

	@Inject
	EntityManager em;
	
	@Inject	@Created Event<Region> regionEvent;
	
	public void saveRegion(Region region) {
		em.persist(region);
		regionEvent.fire(region);
	}

}
