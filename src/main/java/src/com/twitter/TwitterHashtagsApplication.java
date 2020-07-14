package src.com.twitter;

import src.com.twitter.dao.TwitterHashtagsDataManager;
import src.com.twitter.dao.TwitterHashtagsDataManagerImpl;
import src.com.twitter.service.TwitterHashtagsService;
import src.com.twitter.service.TwitterHashtagsServiceImpl;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * The type Twitter hashtags application.
 */
public class TwitterHashtagsApplication {

    /**
     * The entry point of application.
     *
     * @param args the input arguments
     * @throws Exception the exception
     */
    public static void main(String[] args) throws Exception {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Enter a number to fetch trending hashtags.");
            int topN = Integer.parseInt(reader.readLine());
            if(topN <= 0) {
                throw new Exception("Please enter a valid positive number.");
            }
            reader = new BufferedReader(new FileReader("src/main/resources/twitter-hashtags.txt"));
            String line = reader.readLine();
            List<String> tweets = new ArrayList<>();
            while (line != null) {
                tweets.add(line);
                line = reader.readLine();
            }

            TwitterHashtagsDataManager dataManager = new TwitterHashtagsDataManagerImpl();
            TwitterHashtagsService extractHashtags = new TwitterHashtagsServiceImpl(dataManager);
            extractHashtags.getTopNHashTags(topN, tweets);
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
            throw new Exception("File Not found.");
        }
    }
}
