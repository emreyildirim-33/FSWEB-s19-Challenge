package com.example.fswebs19challenge.service;

import com.example.fswebs19challenge.entity.Retweet;
import com.example.fswebs19challenge.entity.Tweet;
import com.example.fswebs19challenge.entity.User;
import com.example.fswebs19challenge.repository.RetweetRepository;
import com.example.fswebs19challenge.repository.TweetRepository;
import com.example.fswebs19challenge.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RetweetService {
    private final RetweetRepository retweetRepository;
    private final UserRepository userRepository;
    private final TweetRepository tweetRepository;

    public RetweetService(RetweetRepository retweetRepository, UserRepository userRepository, TweetRepository tweetRepository) {
        this.retweetRepository = retweetRepository;
        this.userRepository = userRepository;
        this.tweetRepository = tweetRepository;
    }


    public Retweet save(Long tweetId, Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Kullanıcı bulunamadı!"));

        Tweet tweet = tweetRepository.findById(tweetId)
                .orElseThrow(() -> new RuntimeException("Tweet bulunamadı!"));

        Optional<Retweet> existingRetweet = retweetRepository.findByUser_IdAndTweet_Id(userId, tweetId);
        if(existingRetweet.isPresent()) {
            throw new RuntimeException("Hata: Bu tweeti zaten retweetlediniz!");
        }

        Retweet retweet = new Retweet();
        retweet.setUser(user);
        retweet.setTweet(tweet);

        return retweetRepository.save(retweet);
    }


    public Retweet remove(Long retweetId, Long requestUserId) {
        Retweet retweet = retweetRepository.findById(retweetId)
                .orElseThrow(() -> new RuntimeException("Retweet bulunamadı!"));

        boolean isRetweetOwner = (retweet.getUser().getId() == requestUserId);

        if(!isRetweetOwner) {
            throw new RuntimeException("Hata: Sadece kendi retweetinizi silebilirsiniz!");
        }

        retweetRepository.delete(retweet);

        return retweet;
    }
}
