package com.example.fswebs19challenge.controller;

import com.example.fswebs19challenge.entity.LikeRecord;
import com.example.fswebs19challenge.service.LikeService;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins =   "http://localhost:3200")
@RestController
@RequestMapping("/like")
public class LikeController {
    private final LikeService likeService;

    public LikeController(LikeService likeService) {
        this.likeService = likeService;
    }

    @PostMapping
    public LikeRecord save(@RequestParam Long tweetId, @RequestParam Long userId) {
        return likeService.save(tweetId,userId);
    }

    @DeleteMapping("{id}")
    public LikeRecord remove(@PathVariable Long id, @RequestParam Long userId) {
        return likeService.remove(id, userId);
    }
}
