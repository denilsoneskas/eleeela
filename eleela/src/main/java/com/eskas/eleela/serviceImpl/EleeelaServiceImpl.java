package com.eskas.eleela.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eskas.eleela.model.Post;
import com.eskas.eleela.repository.EleeelaRepository;
import com.eskas.eleela.service.EleeelaService;

@Service
public class EleeelaServiceImpl implements EleeelaService {
	
	@Autowired
	EleeelaRepository eleeelaRepository;
	
	@Override
	public List<Post> findAll() {
		return eleeelaRepository.findAll();
	}

	@Override
	public Post findById(long id) {
		return eleeelaRepository.findById(id).get();
	}

	@Override
	public Post save(Post post) {
		return eleeelaRepository.save(post);
	}
	
	@Override
	public Post deleteById(long id) {
		eleeelaRepository.deleteById(id);
		return null;
	}

	@Override
	public void delete(Post post) {
		eleeelaRepository.delete(post);
	}
	
}
