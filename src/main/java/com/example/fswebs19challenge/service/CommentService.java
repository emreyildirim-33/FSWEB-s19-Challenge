package com.example.fswebs19challenge.service;

import com.example.fswebs19challenge.entity.Comment;
import com.example.fswebs19challenge.entity.Tweet;
import com.example.fswebs19challenge.entity.User;
import com.example.fswebs19challenge.repository.CommentRepository;
import com.example.fswebs19challenge.repository.TweetRepository;
import com.example.fswebs19challenge.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class CommentService {
    private final CommentRepository commentRepository;
    private final UserRepository userRepository;
    private final TweetRepository tweetRepository;

    public CommentService(CommentRepository commentRepository,UserRepository userRepository,TweetRepository tweetRepository) {
        this.commentRepository = commentRepository;
        this.userRepository = userRepository;
        this.tweetRepository = tweetRepository;
    }

    public Comment save(Long tweetId, Long userId, String text) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Kullanıcı bulunamadı!"));

        Tweet tweet = tweetRepository.findById(tweetId)
                .orElseThrow(() -> new RuntimeException("Tweet bulunamadı!"));

        Comment comment = new Comment();

        comment.setText(text);
        comment.setUser(user);
        comment.setTweet(tweet);

        return commentRepository.save(comment);
    }

    public Comment remove(Long commentId, Long requestUserId) {
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new RuntimeException("İstenen yorum bulunamadı!"));

        boolean isCommentOwner = (comment.getUser().getId() == requestUserId);
        boolean isTweetOwner = (comment.getTweet().getUser().getId() == requestUserId);

        if (!isCommentOwner && !isTweetOwner) {
            throw new RuntimeException("Hata: Sadece kendi yorumunuzu veya kendi tweetinize yapılan yorumları silebilirsiniz!");

        }
        commentRepository.delete(comment);

        return comment;
    }

    public Comment update(Long commentId, Long requestUserId, String newText) {
        Comment comment = commentRepository.findById(commentId)
                .orElseThrow(() -> new RuntimeException("İstenen yorum bulunamadı!"));

        boolean isCommentOwner = (comment.getUser().getId() == requestUserId);

        if(!isCommentOwner ) {
            throw  new RuntimeException("Hata:Sadece kendi yorumunuzu güncelleyebilirsiniz!");
        }
        comment.setText(newText);

        return commentRepository.save(comment);
    }
}
