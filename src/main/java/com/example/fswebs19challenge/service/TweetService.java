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

    public Tweet findById(Long id) {
        return tweetRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tweet bulunamadı! ID: " + id));
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

    public Tweet update(Long id, Tweet updatedTweet,Long requestUserId) {
        Tweet existingTweet = findById(id);

        if(existingTweet.getUser().getId() != requestUserId) {
            throw new RuntimeException("Hata: Sadece kendi tweetiniz güncelleyebilirsiniz!");
        }
        existingTweet.setMessage(updatedTweet.getMessage());
        return tweetRepository.save(existingTweet);
    }

    public Tweet remove( Long id, Long requestUserId) {
        Tweet foundTweet =findById(id);

        if(foundTweet.getUser().getId() != requestUserId) {
            throw new RuntimeException("Hata: Sadece kendi tweetinizi silebilirsiniz!");
        }

        tweetRepository.delete(foundTweet);

        return foundTweet;

    }
}
