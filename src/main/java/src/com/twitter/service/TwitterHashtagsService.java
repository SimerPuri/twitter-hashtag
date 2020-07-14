package src.com.twitter.service;

import java.util.List;

/**
 * The interface Twitter hashtags service.
 */
public interface TwitterHashtagsService {

    /**
     * Gets top n hash tags.
     *
     * @param n      the n
     * @param tweets the tweets
     */
    void getTopNHashTags(int n, List<String> tweets);
}
