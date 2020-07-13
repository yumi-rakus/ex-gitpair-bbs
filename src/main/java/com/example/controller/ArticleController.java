package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Article;
import com.example.form.ArticleForm;
import com.example.service.ArticleService;

public class ArticleController {
	@ModelAttribute
	private ArticleForm ArticleForm() {
		return new ArticleForm();
	}
	
	@Autowired
	private ArticleService articleService;
	
	@RequestMapping("/insert")
	public String insert(ArticleForm articleForm) {
		Article article=new Article();
		article.setName(articleForm.getName());
		article.setContent(articleForm.getContent());
		articleService.insert(article);
		return "articleList";
	}
}
