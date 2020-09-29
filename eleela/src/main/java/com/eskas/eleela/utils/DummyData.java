package com.eskas.eleela.utils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.eskas.eleela.model.Post;
import com.eskas.eleela.repository.EleeelaRepository;

@Component
public class DummyData {
	
	@Autowired
	EleeelaRepository eleeelaRepository;
	
//	@PostConstruct
	public void savePosts() {
		List<Post> postList = new ArrayList<>();
		Post post1 = new Post();
		post1.setAutor("Denilson Martins");
		post1.setData(LocalDate.now());
		post1.setTitulo("Teste 001");
		post1.setTexto("Lorem Ipsum é simplesmente uma simulação de texto da indústria tipográfica e de impressos, e vem sendo utilizado desde o século XVI, quando um impressor desconhecido pegou uma bandeja de tipos e os embaralhou para fazer um livro de modelos de tipos. Lorem Ipsum sobreviveu não só a cinco séculos, como também ao salto para a editoração eletrônica, permanecendo essencialmente inalterado. Se popularizou na década de 60, quando a Letraset lançou decalques contendo passagens de Lorem Ipsum, e mais recentemente quando passou a ser integrado a softwares de editoração eletrônica como Aldus PageMaker");
		
		Post post2 = new Post();
		post2.setAutor("Denilson Eskas");
		post2.setData(LocalDate.now());
		post2.setTitulo("Teste 002");
		post2.setTexto("Lorem Ipsum é simplesmente uma simulação de texto da indústria tipográfica e de impressos, e vem sendo utilizado desde o século XVI, quando um impressor desconhecido pegou uma bandeja de tipos e os embaralhou para fazer um livro de modelos de tipos. Lorem Ipsum sobreviveu não só a cinco séculos, como também ao salto para a editoração eletrônica, permanecendo essencialmente inalterado. Se popularizou na década de 60, quando a Letraset lançou decalques contendo passagens de Lorem Ipsum, e mais recentemente quando passou a ser integrado a softwares de editoração eletrônica como Aldus PageMaker");
		
		postList.add(post1);
		postList.add(post2);
		
		for (Post post : postList) {
			Post postSaved = eleeelaRepository.save(post);
			System.out.println(postSaved);
		}
	}
}
