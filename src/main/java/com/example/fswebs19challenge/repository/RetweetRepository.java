package com.example.fswebs19challenge.repository;

import com.example.fswebs19challenge.entity.Retweet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RetweetRepository extends JpaRepository<Retweet, Long> {
    Optional<Retweet> findByUser_IdAndTweet_Id(Long userId, Long tweetId);

}
