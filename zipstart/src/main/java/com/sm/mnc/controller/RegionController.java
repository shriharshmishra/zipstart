package com.sm.mnc.controller;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.inject.Model;
import javax.enterprise.inject.Produces;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import com.sm.mnc.model.Region;
import com.sm.mnc.service.RegionService;

@Model
public class RegionController {

	@EJB
	private RegionService regionService;
	
	@Inject
	private FacesContext facesContext;
	
	@Named
	@Produces
	private Region editedRegion;
	
	@PostConstruct
	public void initNewRegion() {		
		editedRegion =  new Region();
	}
	
	public String saveRegion(Region region) {
		try {
			regionService.saveRegion(region);
			facesContext.addMessage(null, new FacesMessage("Region created successfully."));
			return "regions";
		} catch (Exception e){
			facesContext.addMessage(null, new FacesMessage("Region creation failed."));
			return "createRegion";
		}
	}

}
