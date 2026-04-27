package com.example.fswebs19challenge.controller;

import com.example.fswebs19challenge.entity.Retweet;
import com.example.fswebs19challenge.service.RetweetService;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3200")
@RestController
@RequestMapping("/retweet")
public class RetweetController {
    private final RetweetService retweetService;

    public RetweetController(RetweetService retweetService) {
        this.retweetService = retweetService;
    }

    @PostMapping
    public Retweet save(@RequestParam Long tweetId, @RequestParam Long userId) {
        return retweetService.save(tweetId, userId);
    }

    @DeleteMapping("/{id}")
    public Retweet remove(@PathVariable Long id, @RequestParam Long userId) {
        return retweetService.remove(id, userId);
    }
}
