package com.example.fswebs19challenge.service;

import com.example.fswebs19challenge.entity.Tweet;
import com.example.fswebs19challenge.repository.TweetRepository;
import com.example.fswebs19challenge.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TweetService {
    private final UserRepository userRepository;
    private final TweetRepository tweetRepository;

    public TweetService(UserRepository userRepository, TweetRepository tweetRepository) {
        this.userRepository = userRepository;
        this.tweetRepository = tweetRepository;
    }

    public List<Tweet> findAll() {
        return tweetRepository.findAll();
    }

    public Tweet save(Tweet tweet) {
        if(tweet.getMessage() == null || tweet.getMessage().trim().isEmpty()) {
            throw new RuntimeException("Tweet içeriği boş olamaz, bir şeyler yazmalısın!");
        }
        return tweetRepository.save(tweet);
    }

    public List<Tweet> findAllByUserId(Long userId) {
        return tweetRepository.findAllByUserId(userId);
    }
}
