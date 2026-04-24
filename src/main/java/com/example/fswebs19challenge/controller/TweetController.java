package com.example.fswebs19challenge.controller;

import com.example.fswebs19challenge.entity.Tweet;
import com.example.fswebs19challenge.service.TweetService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3200")
@RestController
@RequestMapping("/tweet")
public class TweetController {
    private final TweetService tweetService;

    public TweetController(TweetService tweetService) {
        this.tweetService = tweetService;
    }

    @GetMapping
    public List<Tweet> findAll() {
        return tweetService.findAll();
    }

    @GetMapping("/findById")
    public Tweet findById(@RequestParam long id) {
        return tweetService.findById(id);
    }

    @PostMapping
    public Tweet save(@RequestBody Tweet tweet) {
        return tweetService.save(tweet);
    }

    @PutMapping("/{id}")
    public Tweet update(@PathVariable long id, @RequestParam long userId, @RequestBody Tweet tweet) {
        return tweetService.update(id, tweet,userId);
    }

    @GetMapping("/findByUserId")
        public List<Tweet> findAllByUserId(@RequestParam long  userId) {
            return tweetService.findAllByUserId(userId);
        }

        @DeleteMapping("/{id}")
          public Tweet remove(@PathVariable long id, @RequestParam long userId) {
             return tweetService.remove(id,userId);
        }
    }

