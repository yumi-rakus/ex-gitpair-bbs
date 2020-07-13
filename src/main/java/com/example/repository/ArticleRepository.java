package com.example.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import com.example.domain.Article;

public class ArticleRepository {
	@Autowired
	private NamedParameterJdbcTemplate template;
	
	public void insert(Article article) {
		String sql="insert into articles (name,content) values (:name,:content)";
		
		SqlParameterSource param=new BeanPropertySqlParameterSource(article);
		
		template.update(sql,param);
	}
}
