package com.dodi.bookstore.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dodi.bookstore.domain.Categoria;
import com.dodi.bookstore.domain.Livro;
import com.dodi.bookstore.repositories.CategoriaRepository;
import com.dodi.bookstore.repositories.LivroRepository;

@Service
public class DBService {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private LivroRepository livroRepository;

	public void instanciaBaseDeDados() {
		
		Categoria cat1 = new Categoria(null, "Informática", "Livros de TI" );
		Categoria cat2 = new Categoria(null, "Ficção Científica", "Ficção Científica" );
		Categoria cat3 = new Categoria(null, "Biografias", "Livros de Biografias" );
		
		Livro l1 = new Livro(null, "Clean Code", "Robert Martin", "Lorem Ipsum", cat1);
		Livro l2 = new Livro(null, "Engenharia de Software", "Louis V. Gerstner", "Lorem Ipsum", cat1);
		Livro l3 = new Livro(null, "The Time Machine", "H.G Wells", "Lorem Ipsum", cat2);
		Livro l4 = new Livro(null, "The Wor Of The Words", "H.G Wells", "Lorem Ipsum", cat2);
		Livro l5 = new Livro(null, "I, Robot", "Issac Asimov", "Lorem Ipsum", cat2);
		
		cat1.getLivros().addAll(Arrays.asList(l1,l2));
		cat2.getLivros().addAll(Arrays.asList(l3,l4,l5));
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		livroRepository.saveAll(Arrays.asList(l1,l2,l3,l4,l5));
		
		System.out.println(cat1.getLivros().addAll(Arrays.asList(l1,l2)));
		
	}
}
