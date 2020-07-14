package src.com.twitter.utils;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * The type Twitter hashtags utils.
 */
public final class TwitterHashtagsUtils {

    private TwitterHashtagsUtils() { }

    /**
     * The constant NO_TAG_TRENDING.
     */
    public static final String NO_TAG_TRENDING = "No hashTag is trending right now!";

    /**
     * Sort hash tags by value hash map.
     *
     * @param input the input
     * @return the hash map
     */
    public static HashMap<String, Integer> sortHashTagsByValue(Map<String, Integer> input) {
        List<Map.Entry<String, Integer>> list = new LinkedList<>(input.entrySet());

        list.sort((a, b) -> b.getValue().compareTo(a.getValue()));

        HashMap<String, Integer> map = new LinkedHashMap<>();

        for (Map.Entry<String, Integer> element : list) {
            map.put(element.getKey(), element.getValue());
        }
        return map;
    }
}
