package com.sm.mnc.data;

import java.util.List;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.sm.mnc.model.Region;

@ApplicationScoped
public class RegionRepository {

	@PersistenceContext
	private EntityManager em;
	
	public RegionRepository() {		
	}
	
	@SuppressWarnings("unchecked")
	public List<Region> getAllRegions() {
		String query = " select r from Region r order by r.regionName ";
		return em.createQuery(query).getResultList();
	}

}
