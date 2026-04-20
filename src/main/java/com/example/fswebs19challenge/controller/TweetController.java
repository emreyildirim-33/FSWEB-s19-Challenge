package com.example.fswebs19challenge.controller;

import com.example.fswebs19challenge.entity.Tweet;
import com.example.fswebs19challenge.service.TweetService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tweets")
public class TweetController {
    private final TweetService tweetService;

    public TweetController(TweetService tweetService) {
        this.tweetService = tweetService;
    }

    @GetMapping
    public List<Tweet> findAll() {
        return tweetService.findAll();
    }

    @PostMapping
    public Tweet save(@RequestBody Tweet tweet) {
        return tweetService.save(tweet);
    }

    @GetMapping("/user/{userId}")
        public List<Tweet> findAllByUserId(@PathVariable long  userId) {
            return tweetService.findAllByUserId(userId);
        }
    }

