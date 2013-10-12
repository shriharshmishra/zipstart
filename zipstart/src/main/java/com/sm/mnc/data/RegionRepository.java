package com.sm.mnc.data;

import java.util.List;
import java.util.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.sm.mnc.model.Region;

@ApplicationScoped
public class RegionRepository {

	@Inject
	private EntityManager em;
	
	public RegionRepository() {		
	}
	
	@Inject
	private Logger log;

	
	public List<Region> getAllRegions() {
		String query = " select r from Region r order by r.regionName ";
		log.info("JPQL Query for Region - " + query);
		return em.createQuery(query, Region.class).getResultList();
	}

}
