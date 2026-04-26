package com.example.fswebs19challenge.repository;

import com.example.fswebs19challenge.entity.LikeRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LikeRecordRepository extends JpaRepository<LikeRecord, Long> {
    Optional<LikeRecord> findByUser_IdAndTweet_Id(Long userId, Long tweetId);
}
