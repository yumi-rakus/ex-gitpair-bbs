package com.example.form;

import javax.validation.constraints.NotBlank;

public class CommentForm {
	private Integer articleId;

	@NotBlank(message = "入力必須項目です")
	private String name;
	@NotBlank(message = "入力必須項目です")
	private String content;

	private Integer index;

	public Integer getArticleId() {
		return articleId;
	}

	public void setArticleId(Integer articleId) {
		this.articleId = articleId;
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

	public Integer getIndex() {
		return index;
	}

	public void setIndex(Integer index) {
		this.index = index;
	}

	@Override
	public String toString() {
		return "Comment [articleId=" + articleId + ", name=" + name + ", content=" + content + "]";
	}

}
