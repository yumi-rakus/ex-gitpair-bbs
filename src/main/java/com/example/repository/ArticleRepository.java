package com.example.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.example.domain.Article;
import com.example.domain.Comment;

@Repository
public class ArticleRepository {
	
	private static final RowMapper<Article> ARTICLE_ROW_MAPPER
	= (rs, i) -> {
		
		Article article = new Article();
		
		article.setId(rs.getInt("id"));
		article.setName(rs.getString("name"));
		article.setContent(rs.getString("content"));
		
		Comment comment = new Comment();
		
		comment.setId(rs.getInt("com_id"));
		comment.setName(rs.getString("com_name"));
		comment.setContent(rs.getString("com_content"));
		comment.setArticleId(rs.getInt("article_id"));
		
		List<Comment> commentList = new ArrayList<>();
		
		commentList.add(comment);
		
		article.setCommentList(commentList);
		
		return article;
	};
	
	@Autowired
	private NamedParameterJdbcTemplate template;
	
	public List<Article> findAll(){
		
		StringBuilder sql = new StringBuilder();
		
		sql.append("SELECT ");
		sql.append("art.id AS id, ");
		sql.append("art.name AS name, ");
		sql.append("art.content AS content, ");
		sql.append("com.id AS com_id, ");
		sql.append("com.name AS com_name, ");
		sql.append("com.content AS com_content, ");
		sql.append("com.article_id AS article_id ");
		sql.append("FROM articles AS art ");
		sql.append("LEFT OUTER JOIN ");
		sql.append("comments AS com ");
		sql.append("ON art.id = com.article_id ");
		sql.append("ORDER BY art.id desc, com.id;");
		
		List<Article> articleList = template.query(sql.toString(), ARTICLE_ROW_MAPPER);
		
		return articleList;
	}
	
	public void insert(Article article) {
		String sql="insert into articles (name,content) values (:name,:content)";

		SqlParameterSource param=new BeanPropertySqlParameterSource(article);

		template.update(sql,param);
	}
}
