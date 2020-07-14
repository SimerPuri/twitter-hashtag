package src.com.twitter.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The type Twitter hash tag data manager.
 */
public class TwitterHashtagsDataManagerImpl implements TwitterHashtagsDataManager {
    private final HashMap<String, Integer> hashtag = new HashMap<>();

    @Override
    public Map<String, Integer> getAllTwitterHashTags(List<String> tweets) {
        if (tweets.isEmpty()) {
            return null;
        }

        tweets.stream().map(this::getTwitterHashtagsInSingleTweet)
                .forEach(hashTags -> hashTags.forEach(tag -> {
                    if (hashtag.containsKey(tag)) {
                        hashtag.put(tag, hashtag.get(tag) + 1);
                    } else {
                        hashtag.put(tag, 1);
                    }
                }));

        return hashtag;
    }

    @Override
    public List<String> getTwitterHashtagsInSingleTweet(String tweet) {
        List<String> singleTweetHashtags = new ArrayList<>();

        if(tweet.isEmpty()) {
            return singleTweetHashtags;
        }

        String regex = "#\\w+";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(tweet);
        while (m.find()) {
            singleTweetHashtags.add(m.group());
        }
        return singleTweetHashtags;
    }
}
