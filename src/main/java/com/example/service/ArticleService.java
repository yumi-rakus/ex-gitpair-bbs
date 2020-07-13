package com.example.service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.Article;
import com.example.domain.Comment;
import com.example.repository.ArticleRepository;

@Service
@Transactional
public class ArticleService {
	@Autowired
	private ArticleRepository articleRepository;
	
	
	public List<Article> showList() {
		
		List<Article> articleList = articleRepository.findAll();

		Map<Integer, List<Comment>> commentMap = new LinkedHashMap<>();

		for (Article article : articleList) { // commentMapにArrayListを格納
			commentMap.put(article.getCommentList().get(0).getArticleId(), new ArrayList<Comment>());
		}

		for (Article article : articleList) { // commentMapにキー名articleIdでコメントリストにコメントを格納
			List<Comment> commentList = commentMap.get(article.getCommentList().get(0).getArticleId());
			commentList.add(article.getCommentList().get(0));
		}

		Map<Integer, Article> articleMap = new LinkedHashMap<>();

		for (Article article : articleList) { // articleMapにArticleオブジェクトを格納
			List<Comment> commentList = commentMap.get(article.getId());
			article.setCommentList(commentList);
			articleMap.put(article.getId(), article);
		}

		List<Article> distinctArticleList = new ArrayList<>(articleMap.values());

		return distinctArticleList;
		
	}
	
	public void insert(Article article) {
		articleRepository.insert(article);
	}
	
	public void delete(Integer id) {
		articleRepository.deleteByArticleId(id);
	}
	
	
}
