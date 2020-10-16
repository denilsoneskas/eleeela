package com.eskas.eleela.service;

import java.util.List;

import com.eskas.eleela.model.Post;

public interface EleeelaService {
	
	List<Post> findAll();
	
	Post findById(long id);
	
	Post save(Post post);
	
	public void delete(Post post);
	
	Post deleteById(long id);
	
}
