package com.example.fswebs19challenge.repository;

import com.example.fswebs19challenge.entity.Tweet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TweetRepository extends JpaRepository<Tweet, Long> {
    List<Tweet> findAllByUserId(Long userId);
}
