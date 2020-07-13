package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.domain.Article;
import com.example.repository.ArticleRepository;

public class ArticleService {
	@Autowired
	private ArticleRepository articleRepository;
	
	public void insert(Article article) {
		articleRepository.insert(article);
	}
}
