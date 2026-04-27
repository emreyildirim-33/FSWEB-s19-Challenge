package com.example.fswebs19challenge.service;

import com.example.fswebs19challenge.entity.LikeRecord;
import com.example.fswebs19challenge.entity.Tweet;
import com.example.fswebs19challenge.entity.User;
import com.example.fswebs19challenge.repository.LikeRecordRepository;
import com.example.fswebs19challenge.repository.TweetRepository;
import com.example.fswebs19challenge.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class LikeService {
    private final LikeRecordRepository likeRecordRepository;
    private final UserRepository userRepository;
    private final TweetRepository tweetRepository;

    public LikeService(LikeRecordRepository likeRecordRepository,UserRepository userRepository, TweetRepository tweetRepository) {
        this.likeRecordRepository = likeRecordRepository;
        this.userRepository = userRepository;
        this.tweetRepository = tweetRepository;
    }

    public LikeRecord save(Long tweetId, Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Kullanıcı bulunamadı!"));

        Tweet tweet = tweetRepository.findById(tweetId)
                .orElseThrow(() -> new RuntimeException("Tweet bulunamadı!"));

        java.util.Optional<LikeRecord> existingLike = likeRecordRepository.findByUser_IdAndTweet_Id(userId, tweetId);
        if(existingLike.isPresent()) {
            throw  new RuntimeException("Hata: Bu tweeti zaten beğendiniz!");
        }
        LikeRecord likeRecord = new LikeRecord();

        likeRecord.setUser(user);
        likeRecord.setTweet(tweet);

        return likeRecordRepository.save(likeRecord);

    }
    public LikeRecord remove (Long likeId, Long requestUserId) {
        LikeRecord likeRecord = likeRecordRepository.findById(likeId)
                .orElseThrow(() -> new RuntimeException("Beğeni bulunamadı!"));

        boolean isLikeOwner = (likeRecord.getUser().getId() == requestUserId);

        if(!isLikeOwner) {
            throw new RuntimeException("Hata: Sadece kendi beğeninizi silebilirsiniz!");
        }
        likeRecordRepository.delete(likeRecord);

        return likeRecord;
    }



}
