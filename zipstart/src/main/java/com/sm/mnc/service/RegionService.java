package com.sm.mnc.service;

import javax.ejb.Stateful;
import javax.enterprise.context.ConversationScoped;
import javax.enterprise.event.Event;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import com.sm.mnc.model.Region;
import com.sm.mnc.qualifier.Created;

@Stateful
@ConversationScoped
public class RegionService {

	@PersistenceContext(type = PersistenceContextType.EXTENDED)
	EntityManager em;
	
	@Inject	@Created Event<Region> regionEvent;
	
	Region editedRegion;
	
	@Produces
	@Named
	public Region getEditedRegion() {
		return editedRegion;
	}

	public void saveRegion(Region region) {
		em.persist(region);
		regionEvent.fire(region);
	}
	
	public void loadRegion(Region region) {
		editedRegion = em.find(Region.class, region.getRegionId());
	}
	
	public void createNewRegion() {		
		this.editedRegion = new Region();
	}

}
