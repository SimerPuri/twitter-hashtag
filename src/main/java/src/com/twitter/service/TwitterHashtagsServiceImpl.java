package src.com.twitter.service;

import src.com.twitter.dao.TwitterHashtagsDataManager;
import src.com.twitter.utils.TwitterHashtagsUtils;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import static src.com.twitter.utils.TwitterHashtagsUtils.NO_TAG_TRENDING;

/**
 * The type Twitter hashtags service.
 */
public class TwitterHashtagsServiceImpl implements TwitterHashtagsService {

    private TwitterHashtagsDataManager dataManager;

    /**
     * Instantiates a new Twitter hashtags service.
     *
     * @param dataManager the data manager
     */
    public TwitterHashtagsServiceImpl(TwitterHashtagsDataManager dataManager) {
        this.dataManager = dataManager;
    }

    public void getTopNHashTags(int n, List<String> tweets) {
        Map<String, Integer> hashtag = dataManager.getAllTwitterHashTags(tweets);
        if(hashtag == null || hashtag.isEmpty()) {
            System.out.println(NO_TAG_TRENDING);
        }

        hashtag = TwitterHashtagsUtils.sortHashTagsByValue(hashtag);

        System.out.println(String.format("TOP %s hashTags are: ", n));
        Iterator<Map.Entry<String, Integer>> itr = hashtag.entrySet().iterator();
        while (itr.hasNext() && n>0) {
            System.out.println(itr.next().getKey());
            n--;
        }
    }
}
