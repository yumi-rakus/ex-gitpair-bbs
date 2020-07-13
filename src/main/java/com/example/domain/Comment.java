package com.example.domain;

public class Comment {
	private Integer id;
	
	private String name;
	
	private String content;
	
	private Integer article;
	
	public Comment() {
		
	}

	public Comment(Integer id, String name, String content, Integer article) {
		super();
		this.id = id;
		this.name = name;
		this.content = content;
		this.article = article;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getArticle() {
		return article;
	}

	public void setArticle(Integer article) {
		this.article = article;
	}
	
	
}
