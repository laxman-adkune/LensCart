package com.lenscart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lenscart.entity.SunGlasses;
import com.lenscart.exception.IdNotFoundException;
import com.lenscart.exception.InvalidProductDataException;
import com.lenscart.exception.NoSuchProductFoundException;
import com.lenscart.service.ISunGlassService;

@RestController
@RequestMapping("/lenscart")
public class SunGlassController {
	@Autowired
	private ISunGlassService sunglassService;

	@GetMapping("sunglass")
	public ResponseEntity<List<SunGlasses>> getAllSunGlasses() {
		return new ResponseEntity<List<SunGlasses>>(sunglassService.getAllSunGlasses(), HttpStatus.OK);
	}

	@GetMapping("sunglass/{sunglassId}")
	public ResponseEntity<SunGlasses> getSunGlassById(@PathVariable("sunglassId") Integer sunglassId)
			throws IdNotFoundException {
		return new ResponseEntity<SunGlasses>(sunglassService.getSunGlassById(sunglassId), HttpStatus.OK);
	}

	@PostMapping("sunglass")
	public ResponseEntity<SunGlasses> addSunGlass(@RequestBody SunGlasses sunGlass) throws InvalidProductDataException {
		return new ResponseEntity<SunGlasses>(sunglassService.addSunGlass(sunGlass), HttpStatus.OK);
	}

	@DeleteMapping("sunglass/{sunglassId}")
	public ResponseEntity<SunGlasses> deleteSunGlass(@PathVariable("sunglassId") Integer sunglassId)
			throws NoSuchProductFoundException {
		sunglassService.deleteSunGlass(sunglassId);
		return new ResponseEntity<>(null, HttpStatus.OK);
	}

	@PutMapping("sunglass")
	public ResponseEntity<SunGlasses> updateSunGlass(@RequestBody SunGlasses sunGlass)
			throws InvalidProductDataException {
		return new ResponseEntity<SunGlasses>(sunglassService.updateSunGlass(sunGlass), HttpStatus.OK);
	}

}
