package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.example.form.ArticleForm;
import com.example.service.ArticleService;

public class ArticleController {
	@ModelAttribute
	private ArticleForm ArticleForm() {
		return new ArticleForm();
	}
	
	@Autowired
	private ArticleService articleService;
	
	public void insert() {
		
	}
}
