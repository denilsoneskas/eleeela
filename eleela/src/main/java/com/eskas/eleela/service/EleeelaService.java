package com.eskas.eleela.service;

import java.util.List;

import com.eskas.eleela.model.Post;

public interface EleeelaService {
	
	List<Post> findAll();
	
	Post findById(long id);
	
	Post save(Post post);

}
