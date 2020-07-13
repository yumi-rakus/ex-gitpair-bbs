package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Article;
import com.example.domain.Comment;
import com.example.form.ArticleForm;
import com.example.form.CommentForm;
import com.example.service.ArticleService;
import com.example.service.CommentService;

@Controller
@RequestMapping("")
public class ArticleController {

	@ModelAttribute
	private ArticleForm ArticleForm() {
		return new ArticleForm();
	}

	@ModelAttribute
	private CommentForm CommentForm() {
		return new CommentForm();
	}

	@Autowired
	private ArticleService articleService;
<<<<<<< HEAD

=======
	
	@Autowired
	private CommentService CommentService;
	
>>>>>>> feature/postComment
	@RequestMapping("")
	public String index(Model model) {

		List<Article> articleList = articleService.showList();

		if (articleList.isEmpty()) {
			model.addAttribute("articleNotExist", "記事が1件も存在しません。");
		} else {
			model.addAttribute("articleList", articleList);
		}

		return "bbs";
	}

	@RequestMapping("/insert")
	public String insert(ArticleForm articleForm, Model model) {
		Article article = new Article();
		article.setName(articleForm.getName());
		article.setContent(articleForm.getContent());
		articleService.insert(article);
		return index(model);
	}
	
	@RequestMapping("/postComment")
	public String postComment(CommentForm commentForm,Model model) {
		Comment comment=new Comment();
		comment.setName(commentForm.getName());
		comment.setContent(commentForm.getContent());
		comment.setArticleId(commentForm.getArticleId());
		CommentService.postComment(comment);
		return index(model);
	}
}
