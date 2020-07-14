package src.com.twitter.dao;

import java.util.List;
import java.util.Map;

/**
 * The interface Twitter hash tag data manager.
 */
public interface TwitterHashtagsDataManager {

    /**
     * Gets all twitter hash tags.
     *
     * @param tweets the tweets
     * @return the all twitter hash tags
     */
    Map<String, Integer> getAllTwitterHashTags(List<String> tweets);

    /**
     * Gets twitter hashtags in single tweet.
     *
     * @param tweet the tweet
     * @return the twitter hashtags in single tweet
     */
    List<String> getTwitterHashtagsInSingleTweet(String tweet);

}
