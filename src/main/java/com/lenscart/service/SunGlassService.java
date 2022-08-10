package com.lenscart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lenscart.entity.SunGlasses;
import com.lenscart.exception.IdNotFoundException;
import com.lenscart.exception.InvalidProductDataException;
import com.lenscart.exception.NoSuchProductFoundException;
import com.lenscart.repository.SunGlassRepository;

@Service
public class SunGlassService implements ISunGlassService {

	@Autowired
	private SunGlassRepository sunGlassRepo;

	@Override
	public SunGlasses addSunGlass(SunGlasses sunGlass) throws InvalidProductDataException {
		if (sunGlass.getPrice() <= 0) {
			throw new InvalidProductDataException("Product price should be greater than 0");
		}
		if (sunGlass.getWeight() <= 0) {
			throw new InvalidProductDataException("Product weight should be greater than 0");
		}
		return sunGlassRepo.save(sunGlass);
	}

	@Override
	public List<SunGlasses> getAllSunGlasses() {
		return sunGlassRepo.findAll();
	}

	@Override
	public SunGlasses getSunGlassById(Integer sunGlassId) throws IdNotFoundException {
		SunGlasses sunGlass = sunGlassRepo.findById(sunGlassId).get();
		if (sunGlass == null) {
			throw new IdNotFoundException("Enter correct product Id");
		}
		return sunGlass;
	}

	@Override
	public void deleteSunGlass(Integer sunGlassId) throws NoSuchProductFoundException {
		SunGlasses sunGlass = sunGlassRepo.findById(sunGlassId).get();
		if (sunGlass == null) {
			throw new NoSuchProductFoundException("No such product exist");
		}
		sunGlassRepo.deleteById(sunGlassId);
	}

	@Override
	public SunGlasses updateSunGlass(SunGlasses sunGlass) throws InvalidProductDataException {
		if (sunGlass.getPrice() <= 0) {
			throw new InvalidProductDataException("Product price should be greater than 0");
		}
		if (sunGlass.getWeight() <= 0) {
			throw new InvalidProductDataException("Product weight should be greater than 0");
		}
		return sunGlassRepo.save(sunGlass);
	}

}
