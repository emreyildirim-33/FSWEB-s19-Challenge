package com.example.fswebs19challenge.controller;

import com.example.fswebs19challenge.entity.Comment;
import com.example.fswebs19challenge.service.CommentService;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3200")
@RestController
@RequestMapping("/comment")
public class CommentController {

    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping
    public Comment save(@RequestParam Long tweetId, @RequestParam Long userId, @RequestBody Comment comment) {
       return commentService.save(tweetId, userId, comment.getText());
    }

    @PutMapping("/{id}")
    public Comment update(@PathVariable Long id, @RequestParam Long userId, @RequestBody Comment comment) {
        return commentService.update(id,userId, comment.getText());
    }
}
