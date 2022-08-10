package com.lenscart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lenscart.entity.Frames;
import com.lenscart.exception.IdNotFoundException;
import com.lenscart.exception.InvalidProductDataException;
import com.lenscart.repository.FrameRepository;

@Service
public class FrameService implements IFrameService {
	
	@Autowired
	private FrameRepository frameRepo;

	@Override
	public Frames addFrame(Frames frame) throws InvalidProductDataException{
		if (frame.getPrice() <= 0) {
			throw new InvalidProductDataException("Product price should be greater than 0");
		}
		return frameRepo.save(frame);
	}

	@Override
	public List<Frames> getAllFrames() {
		return frameRepo.findAll();
	}

	@Override
	public Frames getFrameById(Integer frameId) throws IdNotFoundException{
		return frameRepo.findById(frameId).get();
	}

	@Override
	public void deleteFrame(Integer frameId) {
		frameRepo.deleteById(frameId);
	}

	@Override
	public Frames updateFrame(Frames frame) {
		return frameRepo.save(frame);
	}
	
	
}
