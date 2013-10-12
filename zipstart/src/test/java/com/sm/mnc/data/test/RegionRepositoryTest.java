package com.sm.mnc.data.test;

import static org.junit.Assert.*;

import javax.inject.Inject;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.WebArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.sm.mnc.data.RegionRepository;
import com.sm.mnc.model.Region;

@RunWith(Arquillian.class)
public class RegionRepositoryTest {
	
	@Deployment
	public static WebArchive deployment() {
        return ShrinkWrap.create(WebArchive.class, "test.war")
                 .addPackages(true, RegionRepository.class.getPackage().getName())
                 .addPackages(true, Region.class.getPackage().getName())
                .addAsResource("META-INF/test-persistence.xml", "META-INF/persistence.xml")
                .addAsWebInfResource("test-ds.xml", "mnc-ds.xml")
                .addAsWebInfResource(EmptyAsset.INSTANCE, "beans.xml");
                
    }

	@Inject
	RegionRepository regionRepository;
	
	@Test
	public void testGetAllRegions() {
		assertNotNull(regionRepository.getAllRegions());
		assertNotSame(0, regionRepository.getAllRegions().size());
	}

}
