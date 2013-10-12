package com.sm.mnc.service;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.sm.mnc.model.Region;

@Stateless
public class RegionService {

	@Inject
	EntityManager em;
	
	public void saveRegion(Region region) {
		em.persist(region);
	}

}
