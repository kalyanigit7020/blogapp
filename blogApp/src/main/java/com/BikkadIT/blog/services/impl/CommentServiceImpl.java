package com.BikkadIT.blog.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BikkadIT.blog.entities.Comment;
import com.BikkadIT.blog.entities.Post;
import com.BikkadIT.blog.exceptions.ResourceNotFoundException;
import com.BikkadIT.blog.payloads.CommentDto;
import com.BikkadIT.blog.repositories.CommentRepo;
import com.BikkadIT.blog.repositories.PostRepo;
import com.BikkadIT.blog.services.CommentService;

@Service
public class CommentServiceImpl implements CommentService {
	@Autowired
	private CommentRepo commentRepo;
	
	
	@Autowired
	private PostRepo postRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Override
	public CommentDto createComment(CommentDto commentDto, Integer postId) {
		Post post = this.postRepo.findById(postId).orElseThrow(()-> new ResourceNotFoundException("Post","postId", postId));
		Comment comment = this.modelMapper.map(commentDto, Comment.class);
		comment.setPost(post);
		Comment saved = this.commentRepo.save(comment);
		
		return this.modelMapper.map(saved, CommentDto.class);
	}

	@Override
	public void deleteComment(Integer commentId) {
	Comment comment = this.commentRepo.findById(commentId).orElseThrow(()-> new ResourceNotFoundException("Comment","commentId", commentId));
	this.commentRepo.delete(comment);
	
		
	}

}
