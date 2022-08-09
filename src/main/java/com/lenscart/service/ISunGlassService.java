package com.lenscart.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lenscart.entity.SunGlasses;

@Service
public interface ISunGlassService {
	
	public List<SunGlasses> getAllSunGlasses();

	public SunGlasses getSunGlassById(Integer sunGlassId);

	//public List<SunGlasses> deleteSunGlass(Integer productId);

	public SunGlasses addSunGlass(SunGlasses sunGlass);
	
}
