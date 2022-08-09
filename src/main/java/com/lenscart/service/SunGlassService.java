package com.lenscart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lenscart.entity.SunGlasses;
import com.lenscart.repository.SunGlassRepository;

@Service
public class SunGlassService implements ISunGlassService {

	@Autowired
	private SunGlassRepository sunGlassRepo;

	@Override
	public SunGlasses addSunGlass(SunGlasses sunGlass) {
		return sunGlassRepo.save(sunGlass);
	}

	@Override
	public List<SunGlasses> getAllSunGlasses() {
		return sunGlassRepo.findAll();
	}

	@Override
	public SunGlasses getSunGlassById(Integer sunGlassId) {
		return sunGlassRepo.findById(sunGlassId).get();
	}

}
