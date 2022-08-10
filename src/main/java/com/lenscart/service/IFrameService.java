package com.lenscart.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.lenscart.entity.Frames;
import com.lenscart.exception.IdNotFoundException;
import com.lenscart.exception.InvalidProductDataException;
import com.lenscart.exception.NoSuchProductFoundException;


@Service
public interface IFrameService {

	public Frames addFrame(Frames frame) throws InvalidProductDataException;

	public List<Frames> getAllFrames();

	public Frames getFrameById(Integer frameId)throws IdNotFoundException;

	public void deleteFrame(Integer frameId) throws NoSuchProductFoundException;

	public Frames updateFrame(Frames frame)throws InvalidProductDataException;
}
