package allamvizsga;

import com.cybozu.labs.langdetect.Detector;
import com.cybozu.labs.langdetect.DetectorFactory;
import com.cybozu.labs.langdetect.LangDetectException;
import com.fasterxml.jackson.core.JsonFactory;
import com.google.api.client.auth.oauth2.BearerToken;
import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.HttpTransport;
import edu.stanford.nlp.util.ArrayMap;
import java.awt.Font;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL; 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.swing.JLabel;
import org.jfree.ui.RefineryUtilities;
import org.json.JSONArray;
import org.json.JSONObject;

public class DataMining {
    
    private static String token = "";
    private static Integer commentCount = 0;
    private static Detector detector;
    private static String videoId;
    //private static String path = "C:\\Users\\Alida\\Desktop\\shuyo\\language-detection-master\\profiles";
    private static String path = "C:\\Users\\Alida\\Documents\\NetBeansProjects\\shuyo\\language-detection-master\\profiles";
    private static String inputChannelId = "UCIqiLefbVHsOAXDAxQJH7Xw";
    //private static String APIKey = "AIzaSyAyTt7Bna-NCzt0QHHO49DwfVFDKzIhqBg";
    private static String APIKey = "AIzaSyAliNkHr1GFgo1Yj3b09gXZO_X1s3Lpxag";
    private static String AccessToken = "ya29.a0AfH6SMA14VHSckfEnSLdFB5yLMXEwgPpR9HaFcMVg3VIJuT8eqzFHoPYOOBZBSVnLBvzTvk7L1n7KvWSEUsN6u1EnBRYv8wfNmdvJAT7axv2BePY3TrSjvN4LU7_dsNlJ15dNAQsEfLYIzWMP8ljTAaRZthjcGBbg8M";
    private static String tokenForTitle = "";
    
    private static ArrayList<String> totalComments = new ArrayList<>();
    private static ArrayList<String> totalVideoIds = new ArrayList<>();
    private static ArrayList<Integer> totalLikeCounts = new ArrayList<>();
    private static ArrayList<Integer> totalCommentCounts = new ArrayList<>();
    private static ArrayList<String> totalLanguages = new ArrayList<>();
    private static ArrayList<String> totalPublishDates = new ArrayList<>();
    private static ArrayList<String> totalAuthorChannelIds = new ArrayList<>();
    private static ArrayList<Integer> sentimentScores = new ArrayList<>();
    private static ArrayList<String> allVideoIds = new ArrayList<>();
    private static ArrayList<String> allVideoTitles = new ArrayList<>();
    private static ArrayList<String> allViewCountOfVideo = new ArrayList<>();
    private static ArrayList<String> allLikeCountOfVideo = new ArrayList<>();
    private static ArrayList<String> allDislikeCountOfVideo = new ArrayList<>();
    private static ArrayList<String> allCommentCountOfVideo = new ArrayList<>();
    private static ArrayList<String> allPublishDatesOfVideo = new ArrayList<>();
    private static ArrayList<Integer> totalTopLevels = new ArrayList<>();
     
    
    public static void main(String[] args) throws LangDetectException {
        
       DetectorFactory.loadProfile(path);
       
       try {
         
         Form form = new Form();
         form.setVisible(true);
        
         /*ArrayList<Integer> arrayOfWeeksWithMostComments = new ArrayList<Integer>(Arrays.asList(264, 348, 348, 348, 284, 214, 348, 348, 348, 348, 284, 348, 348, 348, 348, 284, 348, 348, 348, 348, 284, 284, 284, 348, 348, 284));
         Integer actualWeek = 284;
         Integer counter = 0;
         counter = Form.countOccurancesOfEachWeek (actualWeek, arrayOfWeeksWithMostComments);
         System.out.println(counter);*/
      // getCommentsAndStatisticsSpec("UC9m2XDfCnrS4QTzVBTrD89w");     
        // getReplies("UC9m2XDfCnrS4QTzVBTrD89w");
        
        
        /*ArrayMap<String,Integer> m = new ArrayMap<>();
         ArrayList<String> years = new ArrayList<String>(Arrays.asList("2019","2011","2013"));
         MonthWithCommentCount2("UCIqiLefbVHsOAXDAxQJH7Xw",years);*/
         
        // AverageCommentNumberPerPerson("UCIqiLefbVHsOAXDAxQJH7Xw");
       
        //calculateDuration("UC9m2XDfCnrS4QTzVBTrD89w");
       // ArrayList<Integer> det = new ArrayList<Integer>(Arrays.asList(26, 128, 40, 12, 6, 6, 2, 3, 2, 4, 1, 2, 3, 1, 2, 1, 2, 3, 2, 1, 2, 0, 3, 1, 4, 0, 2, 0, 0, 5, 10, 0, 4, 2, 3, 1, 7, 6, 3, 6, 4, 5, 3, 7, 4, 2, 3, 4, 2, 3, 9, 1, 1, 5, 4, 5, 3, 1, 4, 6, 7, 13, 11, 4, 0, 0, 6, 1, 1, 1, 1, 3, 1, 0, 1, 2, 3, 0, 5, 4, 2, 2, 10, 3, 1, 1, 9, 6, 4, 7, 4, 2, 2, 3, 8, 4, 7, 4, 0, 2, 5, 5, 4, 3, 3, 5, 4, 2, 3, 2, 7, 1, 3, 5, 2, 2, 1, 4, 0, 4, 6, 5, 3, 2, 5, 1, 4, 2, 2, 4, 7, 5, 6, 1, 5, 5, 2, 5, 2, 5, 4, 3, 0, 1, 1, 3, 2, 3, 4, 4, 2, 2, 0, 0, 5, 3, 1, 2, 1, 1, 2, 0, 2, 1, 1, 0, 2, 2, 3, 4, 0, 2, 0, 0, 4, 1, 1, 1, 1, 1, 1, 1, 1, 2, 3, 1, 3, 3, 0, 2, 1, 0, 2, 3, 1, 4, 1, 0, 0, 0, 2, 2, 2, 1, 0, 2, 1, 0, 2, 1, 0, 1, 1, 2, 2, 2, 1, 0, 1, 2, 0, 1, 0, 1, 0, 1, 1, 2, 1, 1, 0, 1, 0, 1, 2, 2, 3, 4, 2, 1, 1, 1, 7, 1, 2, 0, 2, 0, 0, 0, 0, 4, 1, 1, 1, 2, 3, 0, 4, 2, 1, 0, 2, 3, 1, 3, 2, 2, 3, 0, 2, 0, 0, 0, 0, 1, 1, 2, 1, 1, 2, 1, 1, 2, 1, 3, 2, 2, 0, 2, 2, 0, 2, 7, 2, 1, 1, 3, 1, 0, 2, 2, 4, 1, 2, 1, 0, 0, 4, 0, 4, 3, 2, 3, 2, 1, 0, 2, 1, 3, 0, 0, 2, 0, 1, 6, 1, 2, 3, 1, 1, 0, 3, 2, 0, 1, 4, 1, 0, 2, 0, 1, 6, 4, 4, 1, 0, 3, 4, 1, 5, 3, 1, 1, 1, 2, 0, 1, 2, 1, 3, 4, 0, 3, 2, 2, 2, 1, 3, 2, 1, 2, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 3, 1, 0, 2, 0, 2, 0, 2, 1, 3, 2, 2, 2, 1, 3, 1, 6, 5, 3, 4, 3, 4, 2, 4, 4, 4, 1, 4, 1, 4, 0, 3, 2, 3, 4, 8, 2, 5, 6, 0, 5, 3, 4, 5, 3, 1, 0, 0, 1, 2, 4, 0, 2, 1, 1, 2, 0, 1, 1, 3, 7, 0, 3, 4, 7, 4, 1, 11, 13, 7, 8, 21, 10, 10, 11, 53, 34, 26, 10, 3, 13, 4, 4, 2, 1));
        
      //ArrayList<Integer> proba  = new ArrayList<Integer>(Arrays.asList(7,13,14,21,22,23,34));
      //determineRange(proba);
        
        //selectCountryNamesFromComments();
    
        } catch (Exception e) {
            
         e.printStackTrace();
       }
      
    }
    
    public static int detectSentimentOfComment(String comment, String languageOfComment) {

        int sentimentScore = 0;
        NLP.init();
        String english = new String("en");

        if (languageOfComment != null && languageOfComment.equals(english)) {

            sentimentScore = NLP.computeSentiment(comment);
        } else {
            sentimentScore = -1;
        }

        return sentimentScore;
    }
    /*
    Lekeri a YouTube API-n keresztul az egyes videok adatait
   */

   
      public static void getVideoStatisticsSpec2(String inputChannelId) throws Exception {
       
        while(true)
     {
        //String urlAddress = "https://www.googleapis.com/youtube/v3/activities?part=snippet,contentDetails&channelId=" + inputChannelId + "&key=" + APIKey + "&maxResults=50&pageToken=" + tokenForTitle; // az AlgoRythmicsnel kiadta az osszes video listat udiprodnal nem
       
        String urlAddress = "https://www.googleapis.com/youtube/v3/search?order=date&part=snippet&channelId=" + inputChannelId+ "&maxResults=25&key=" + APIKey + "&pageToken=" + tokenForTitle;
        JSONObject videoTitleAndIdResponse = makingGetRequest(urlAddress);
        JSONArray items = new JSONArray(videoTitleAndIdResponse.getJSONArray("items").toString());

        String titleOfVideo = "",videoId = "",viewCount="",likeCount="",dislikeCount="",commentCount="",publishedAt="";
        

        for (int i = 0; i < items.length(); i++) {

            JSONObject snippet = new JSONObject(items.getJSONObject(i).getJSONObject("snippet").toString());
            JSONObject id = new JSONObject(items.getJSONObject(i).getJSONObject("id").toString());
            
            if(id.has("videoId") & snippet.has("title"))
            {
                videoId = id.getString("videoId");
                titleOfVideo = snippet.getString("title");
                System.out.println(videoId);
            }

            else {
                continue;
            }
            if(videoId.equals("DNbd1EFQ_1o") || videoId.equals("r-erNO-WICo") || videoId.equals("ZSJGf5Ngw18") || videoId.equals("NVIjHj-lrT4") ||videoId.equals("vIDkfrSdID8") ||videoId.equals("QbRoyhGdjnA") ||videoId.equals("q4wzJ_uw4aE") ||videoId.equals("uc5LdcqrblQ") ||videoId.equals("DaPJkYo2quc") ||videoId.equals("Xu5ia5x2Vsw") ||videoId.equals("AYehFa-oKCA") ||videoId.equals("ob49RukGnAw") ||videoId.equals("7AX3p8y4s9c") ||videoId.equals("67ta5WTjjUo") ||videoId.equals("Tmq1UkL7xeU") ||videoId.equals("EdcWAw4Hcu0") ||videoId.equals("njClLBoEbfI") ||videoId.equals("LyRWppObda4") ||videoId.equals("Cq7SMsQBEUw") ||videoId.equals("ZRPoEKHXTJg") ||videoId.equals("_bkow6IykGM") ||videoId.equals("8oJS1BMKE64") ||videoId.equals("9IqV6ZSjuaI") ||videoId.equals("8hEyhs3OV1w") ||videoId.equals("92BfuxHn2XE") ||videoId.equals("n4sk-SzGvZA"))
            {
                System.out.println("egyenlo");
                 publishedAt = snippet.getString("publishedAt");
            
                String videoStatisticsUrl = "https://www.googleapis.com/youtube/v3/videos?part=contentDetails,statistics&id=" + videoId + "&t=212s,-VoFbH8jTzE,RPNDXrAvAMg,gmQmYc9-zcg&key=" + APIKey;
                JSONObject videoStatisticsResponse = makingGetRequest(videoStatisticsUrl);
                JSONArray videoStatisticsItems = new JSONArray(videoStatisticsResponse.getJSONArray("items").toString());
                JSONObject statistics = new JSONObject(videoStatisticsItems.getJSONObject(0).getJSONObject("statistics").toString());
                viewCount = statistics.getString("viewCount");
                likeCount = statistics.getString("likeCount");
                dislikeCount = statistics.getString("dislikeCount");
                commentCount = statistics.getString("commentCount");

                allVideoIds.add(videoId);
                allVideoTitles.add(titleOfVideo);
                allViewCountOfVideo.add(viewCount);
                allLikeCountOfVideo.add(likeCount);
                allDislikeCountOfVideo.add(dislikeCount);
                allCommentCountOfVideo.add(commentCount);
                allPublishDatesOfVideo.add(publishedAt);
            }           
        }
        
        if(videoTitleAndIdResponse.has("nextPageToken"))
        {
            tokenForTitle = videoTitleAndIdResponse.getString("nextPageToken"); // itt eredetileg csak sima token volt !!!
        
        }
        else{
            System.out.println("No more pages available");
            break;
        }
     }
        System.out.println(allVideoTitles); 

        addToVideosTable(allVideoIds,allVideoTitles,allViewCountOfVideo,allLikeCountOfVideo,allDislikeCountOfVideo,allCommentCountOfVideo,allPublishDatesOfVideo,inputChannelId);
        
    }
    
    public static void getVideoStatistics(String inputChannelId) throws Exception {
       
        while(true)
     {
        //String urlAddress = "https://www.googleapis.com/youtube/v3/activities?part=snippet,contentDetails&channelId=" + inputChannelId + "&key=" + APIKey + "&maxResults=50&pageToken=" + tokenForTitle; // az AlgoRythmicsnel kiadta az osszes video listat udiprodnal nem
       
        String urlAddress = "https://www.googleapis.com/youtube/v3/search?order=date&part=snippet&channelId=UCcf4LQogGFtYzPhq05uHE4g&maxResults=25&key=" + APIKey + "&pageToken=" + tokenForTitle;
        JSONObject videoTitleAndIdResponse = makingGetRequest(urlAddress);
        JSONArray items = new JSONArray(videoTitleAndIdResponse.getJSONArray("items").toString());

        String titleOfVideo = "",videoId = "",viewCount="",likeCount="",dislikeCount="",commentCount="",publishedAt="";
        

        for (int i = 0; i < items.length(); i++) {

            JSONObject snippet = new JSONObject(items.getJSONObject(i).getJSONObject("snippet").toString());
            JSONObject id = new JSONObject(items.getJSONObject(i).getJSONObject("id").toString());
            
            if(id.has("videoId") & snippet.has("title"))
            {
                videoId = id.getString("videoId");
                titleOfVideo = snippet.getString("title");
            }

            else {
                continue;
            }
            
            publishedAt = snippet.getString("publishedAt");
            
            String videoStatisticsUrl = "https://www.googleapis.com/youtube/v3/videos?part=contentDetails,statistics&id=" + videoId + "&t=212s,-VoFbH8jTzE,RPNDXrAvAMg,gmQmYc9-zcg&key=" + APIKey;
            JSONObject videoStatisticsResponse = makingGetRequest(videoStatisticsUrl);
            JSONArray videoStatisticsItems = new JSONArray(videoStatisticsResponse.getJSONArray("items").toString());
            JSONObject statistics = new JSONObject(videoStatisticsItems.getJSONObject(0).getJSONObject("statistics").toString());
            viewCount = statistics.getString("viewCount");
            likeCount = statistics.getString("likeCount");
            dislikeCount = statistics.getString("dislikeCount");
            commentCount = statistics.getString("commentCount");
                      
            allVideoIds.add(videoId);
            allVideoTitles.add(titleOfVideo);
            allViewCountOfVideo.add(viewCount);
            allLikeCountOfVideo.add(likeCount);
            allDislikeCountOfVideo.add(dislikeCount);
            allCommentCountOfVideo.add(commentCount);
            allPublishDatesOfVideo.add(publishedAt);
           // System.out.println(videoId); System.out.println(titleOfVideo);System.out.println(viewCount);System.out.println(likeCount);System.out.println(dislikeCount);System.out.println(commentCount);
        }
        
        if(videoTitleAndIdResponse.has("nextPageToken"))
        {
            tokenForTitle = videoTitleAndIdResponse.getString("nextPageToken"); // itt eredetileg csak sima token volt !!!
            //System.out.println("next page token: " + tokenForTitle);
            
        }
        else{
            System.out.println("No more pages available");
            break;
        }
     }
       
        addToVideosTable(allVideoIds,allVideoTitles,allViewCountOfVideo,allLikeCountOfVideo,allDislikeCountOfVideo,allCommentCountOfVideo,allPublishDatesOfVideo,inputChannelId);
        
    }
    
    public static void getReplies(String inputChannelId)throws Exception {
        
        Integer counter = 0;
        Integer toplevel = 1;
        while (true) {
            String urlAddress = "https://www.googleapis.com/youtube/v3/commentThreads?part=replies&allThreadsRelatedToChannelId=" + inputChannelId + "&key=" + APIKey + "&pageToken=" + token;
            JSONObject myResponse = makingGetRequest(urlAddress);
            JSONArray items = new JSONArray(myResponse.getJSONArray("items").toString());
            for (int i = 0; i < items.length(); i++) {

                if (items.getJSONObject(i).has("replies")) {

                    JSONObject replies = new JSONObject(items.getJSONObject(i).getJSONObject("replies").toString());
                    JSONArray comments = new JSONArray(replies.getJSONArray("comments").toString());

                    for (int j = 0; j < comments.length(); ++j) {
                       
                        JSONObject snippet = new JSONObject(comments.getJSONObject(j).getJSONObject("snippet").toString());
                        if (snippet.has("videoId")) {
                            String videoIdReply = snippet.getString("videoId");
                            if (videoIdReply.equals("DNbd1EFQ_1o") || videoIdReply.equals("r-erNO-WICo") || videoIdReply.equals("ZSJGf5Ngw18") || videoIdReply.equals("NVIjHj-lrT4") || videoIdReply.equals("vIDkfrSdID8") || videoIdReply.equals("QbRoyhGdjnA") || videoIdReply.equals("q4wzJ_uw4aE") || videoIdReply.equals("uc5LdcqrblQ") || videoIdReply.equals("DaPJkYo2quc") || videoIdReply.equals("Xu5ia5x2Vsw") || videoIdReply.equals("AYehFa-oKCA") || videoIdReply.equals("ob49RukGnAw") || videoIdReply.equals("7AX3p8y4s9c") || videoIdReply.equals("67ta5WTjjUo") || videoIdReply.equals("Tmq1UkL7xeU") || videoIdReply.equals("EdcWAw4Hcu0") || videoIdReply.equals("njClLBoEbfI") || videoIdReply.equals("LyRWppObda4") || videoIdReply.equals("Cq7SMsQBEUw") || videoIdReply.equals("ZRPoEKHXTJg") || videoIdReply.equals("_bkow6IykGM") || videoIdReply.equals("8oJS1BMKE64") || videoIdReply.equals("9IqV6ZSjuaI") || videoIdReply.equals("8hEyhs3OV1w") || videoIdReply.equals("92BfuxHn2XE") || videoIdReply.equals("n4sk-SzGvZA")) {
                                counter++;
                                System.out.println(counter);
                                String text = snippet.getString("textOriginal");
                                Integer likeReply = snippet.getInt("likeCount");
                                String publishedAtReply = snippet.getString("publishedAt").toString();
                                JSONObject authorChannelIdReply = new JSONObject(snippet.getJSONObject("authorChannelId").toString());
                                String authorChannelIdValue = authorChannelIdReply.getString("value");
                                String languageOfComment = DataMining.detectLanguage(text);
                                int sentimentScore = 0;
                                sentimentScore = detectSentimentOfComment(text, languageOfComment);

                                totalVideoIds.add(videoIdReply);
                                totalComments.add(text);
                                totalLikeCounts.add(likeReply);
                                totalPublishDates.add(publishedAtReply);
                                totalLanguages.add(languageOfComment);
                                totalAuthorChannelIds.add(authorChannelIdValue);
                                sentimentScores.add(sentimentScore);
                            }
                        }

                    }

                    /*String videoIdReply = snippetReplies.getString("videoId");
                                if (videoIdReply.equals("DNbd1EFQ_1o") || videoIdReply.equals("r-erNO-WICo") || videoIdReply.equals("ZSJGf5Ngw18") || videoIdReply.equals("NVIjHj-lrT4") || videoIdReply.equals("vIDkfrSdID8") || videoIdReply.equals("QbRoyhGdjnA") || videoIdReply.equals("q4wzJ_uw4aE") || videoIdReply.equals("uc5LdcqrblQ") || videoIdReply.equals("DaPJkYo2quc") || videoIdReply.equals("Xu5ia5x2Vsw") || videoIdReply.equals("AYehFa-oKCA") || videoIdReply.equals("ob49RukGnAw") || videoIdReply.equals("7AX3p8y4s9c") || videoIdReply.equals("67ta5WTjjUo") || videoIdReply.equals("Tmq1UkL7xeU") || videoIdReply.equals("EdcWAw4Hcu0") || videoIdReply.equals("njClLBoEbfI") || videoIdReply.equals("LyRWppObda4") || videoIdReply.equals("Cq7SMsQBEUw") || videoIdReply.equals("ZRPoEKHXTJg") || videoIdReply.equals("_bkow6IykGM") || videoIdReply.equals("8oJS1BMKE64") || videoIdReply.equals("9IqV6ZSjuaI") || videoIdReply.equals("8hEyhs3OV1w") || videoIdReply.equals("92BfuxHn2XE") || videoIdReply.equals("n4sk-SzGvZA"))
                                {
                                    String reply = snippetReplies.getString("textOriginal");
                                    System.out.println("Reply: " + reply);
                                    Integer likeReply = snippetReplies.getInt("likeCount");
                                    String publishedAtReply = snippetReplies.getString("publishedAt").toString();
                                    JSONObject authorChannelIdReply = new JSONObject(snippetReplies.getJSONObject("authorChannelId").toString());
                                   
                                }  */
                }
            }

            if (myResponse.has("nextPageToken")) {
                token = myResponse.getString("nextPageToken");

            } else {
                System.out.println("No more pages available");
                break;
            }
        }
        addToCommentsTable(totalVideoIds, totalComments, totalLikeCounts, totalPublishDates, totalLanguages, totalAuthorChannelIds, sentimentScores, toplevel);

    }
 
     public static void getCommentsAndStatisticsSpec(String inputChannelId) throws Exception {
   
         Integer counter = 0,toplevelComment=0;
         while (true) {

             //String urlAddress = "https://www.googleapis.com/youtube/v3/commentThreads?part=snippet&allThreadsRelatedToChannelId=" + inputChannelId + "&key=" + APIKey + "&pageToken=" + token;
             //String urlAddress = "https://www.googleapis.com/youtube/v3/commentThreads?key=AIzaSyAyTt7Bna-NCzt0QHHO49DwfVFDKzIhqBg&t&videoId=-PuqKbu9K3U&part=snippet,replies&maxResult=50";
             String urlAddress = "https://www.googleapis.com/youtube/v3/commentThreads?part=snippet,replies&allThreadsRelatedToChannelId=" + inputChannelId + "&key=" + APIKey+ "&pageToken=" + token;
             JSONObject myResponse = makingGetRequest(urlAddress);
             JSONArray items = new JSONArray(myResponse.getJSONArray("items").toString());

             for (int i = 0; i < items.length(); i++) {

                 JSONObject snippet = new JSONObject(items.getJSONObject(i).getJSONObject("snippet").toString());

                 JSONObject toplevel = new JSONObject(snippet.getJSONObject("topLevelComment").toString());

                 JSONObject nextLevelSnippet = new JSONObject(toplevel.getJSONObject("snippet").toString());

                 JSONObject authorChannelId = new JSONObject(nextLevelSnippet.getJSONObject("authorChannelId").toString());

                 String authorChannelIdValue = authorChannelId.getString("value");

                 if (nextLevelSnippet.has("videoId")) {
                     videoId = nextLevelSnippet.getString("videoId").toString();
                 }

                 if (videoId.equals("DNbd1EFQ_1o") || videoId.equals("r-erNO-WICo") || videoId.equals("ZSJGf5Ngw18") || videoId.equals("NVIjHj-lrT4") || videoId.equals("vIDkfrSdID8") || videoId.equals("QbRoyhGdjnA") || videoId.equals("q4wzJ_uw4aE") || videoId.equals("uc5LdcqrblQ") || videoId.equals("DaPJkYo2quc") || videoId.equals("Xu5ia5x2Vsw") || videoId.equals("AYehFa-oKCA") || videoId.equals("ob49RukGnAw") || videoId.equals("7AX3p8y4s9c") || videoId.equals("67ta5WTjjUo") || videoId.equals("Tmq1UkL7xeU") || videoId.equals("EdcWAw4Hcu0") || videoId.equals("njClLBoEbfI") || videoId.equals("LyRWppObda4") || videoId.equals("Cq7SMsQBEUw") || videoId.equals("ZRPoEKHXTJg") || videoId.equals("_bkow6IykGM") || videoId.equals("8oJS1BMKE64") || videoId.equals("9IqV6ZSjuaI") || videoId.equals("8hEyhs3OV1w") || videoId.equals("92BfuxHn2XE") || videoId.equals("n4sk-SzGvZA"))
                 {
                     String textOriginal = nextLevelSnippet.getString("textOriginal");
                     System.out.println(textOriginal);
                     Integer likeCount = nextLevelSnippet.getInt("likeCount");
                     String publishedAt = nextLevelSnippet.getString("publishedAt").toString();

                    String languageOfComment = DataMining.detectLanguage(textOriginal);     
                    int sentimentScore = 0;           
                    sentimentScore = detectSentimentOfComment(textOriginal,languageOfComment);
                    /* if (items.getJSONObject(i).has("replies")) {
                         JSONObject replies = new JSONObject(items.getJSONObject(i).getJSONObject("replies").toString());
                         //System.out.println(replies);
                         JSONArray comments = new JSONArray(replies.getJSONArray("comments").toString());
                         //System.out.println(comments);
                         for (int j = 0; j < comments.length(); ++j) {
                             
                                JSONObject snippetReplies = new JSONObject(comments.getJSONObject(i).getJSONObject("snippet").toString());
                                String reply = snippetReplies.getString("textOriginal");
                                System.out.println("Reply: " + reply);
                                String videoIdReply = snippetReplies.getString("videoId");
                                Integer likeReply = snippetReplies.getInt("likeCount");
                                String publishedAtReply = snippetReplies.getString("publishedAt").toString();
                                JSONObject authorChannelIdReply = new JSONObject(snippetReplies.getJSONObject("authorChannelId").toString());*/
                                /* String languageOfReply = DataMining.detectLanguage(reply);     
                               int sentimentScoreReply = 0;           
                               sentimentScoreReply = detectSentimentOfComment(reply,languageOfReply);*/
                     
                        // }
                    // }

                    counter++;
                    System.out.println(counter);
                    totalVideoIds.add(videoId);
                    totalComments.add(textOriginal);
                    totalLikeCounts.add(likeCount);
                    totalPublishDates.add(publishedAt);
                    totalLanguages.add(languageOfComment);
                    totalAuthorChannelIds.add(authorChannelIdValue);
                    sentimentScores.add(sentimentScore);

                 }

             }

             if (myResponse.has("nextPageToken")) {
                token = myResponse.getString("nextPageToken");

            } else {
                System.out.println("No more pages available");
                break;
            }
         }

         addToCommentsTable(totalVideoIds, totalComments, totalLikeCounts, totalPublishDates, totalLanguages, totalAuthorChannelIds, sentimentScores, toplevelComment);
   }
 
    public static void getCommentsAndStatistics(String inputChannelId) throws Exception {
   
        Integer counter = 0,toplevelComment = 0;
        while (true) {
               
            String urlAddress = "https://www.googleapis.com/youtube/v3/commentThreads?part=snippet&allThreadsRelatedToChannelId=" + inputChannelId + "&key=" + APIKey + "&pageToken=" + token;
            //System.out.println("Token: " + token);
            JSONObject myResponse = makingGetRequest(urlAddress);
            JSONArray items = new JSONArray(myResponse.getJSONArray("items").toString());

            ArrayList<String> listOfComments = new ArrayList<>();

            for (int i = 0; i < items.length(); i++) {

                JSONObject snippet = new JSONObject(items.getJSONObject(i).getJSONObject("snippet").toString());

                JSONObject toplevel = new JSONObject(snippet.getJSONObject("topLevelComment").toString());

                JSONObject nextLevelSnippet = new JSONObject(toplevel.getJSONObject("snippet").toString());
               
                    
                JSONObject authorChannelId = new JSONObject(nextLevelSnippet.getJSONObject("authorChannelId").toString());
                
                String authorChannelIdValue = authorChannelId.getString("value");

                if (nextLevelSnippet.has("videoId")) {
                    videoId = nextLevelSnippet.getString("videoId").toString();
                }

                String textOriginal = nextLevelSnippet.getString("textOriginal");
                //System.out.println(textOriginal);
                Integer likeCount = nextLevelSnippet.getInt("likeCount");
                String publishedAt = nextLevelSnippet.getString("publishedAt").toString();
                
                String languageOfComment = DataMining.detectLanguage(textOriginal);     
                int sentimentScore = 0;
               
                sentimentScore = detectSentimentOfComment(textOriginal,languageOfComment);
                counter++;
                System.out.println(counter);
                totalVideoIds.add(videoId);
                totalComments.add(textOriginal);
                totalLikeCounts.add(likeCount);
                totalPublishDates.add(publishedAt);
                totalLanguages.add(languageOfComment);
                totalAuthorChannelIds.add(authorChannelIdValue);
                sentimentScores.add(sentimentScore);

                listOfComments.add(textOriginal);
                commentCount++;           
            }

            if (myResponse.has("nextPageToken")) {
                token = myResponse.getString("nextPageToken");

            } else {
                System.out.println("No more pages available");
                break;
            }

        }
        
        addToCommentsTable(totalVideoIds, totalComments, totalLikeCounts, totalPublishDates, totalLanguages, totalAuthorChannelIds, sentimentScores, toplevelComment);

   }
    
    public static JSONObject makingGetRequest(String urlAddress) throws Exception
    {
        URL urlObject = new URL(urlAddress);
        HttpURLConnection connection = (HttpURLConnection) urlObject.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("User-Agent", "Mozilla/5.0");

//        int responseCode = connection.getResponseCode();

        BufferedReader in = new BufferedReader(
                new InputStreamReader(connection.getInputStream()));
        String inputLine;

        StringBuffer responseBuffer = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {

            responseBuffer.append(inputLine);

        }
        in.close();
        JSONObject myResponse = new JSONObject(responseBuffer.toString());
       
        return myResponse;
    }
    
    public static ArrayList<String> getChannelStatistics(String inputChannelId) throws Exception {
        
        ArrayList<String> basicChannelData = new ArrayList();
        
        String urlAddress = "https://www.googleapis.com/youtube/v3/channels?part=statistics&id=" + inputChannelId + "&key=" + APIKey;
        String urlAddressToChannelName = "https://www.googleapis.com/youtube/v3/channels?part=snippet&id=" + inputChannelId + "&key=" + APIKey;

        JSONObject myResponse = makingGetRequest(urlAddress);
        JSONArray items = new JSONArray(myResponse.getJSONArray("items").toString());

        JSONObject statistics = new JSONObject(items.getJSONObject(0).getJSONObject("statistics").toString());
        String viewCount = statistics.getString("viewCount");
        String subscriberCount = statistics.getString("subscriberCount");
        String videoCount = statistics.getString("videoCount");
        
        JSONObject myResponseChannelName = makingGetRequest(urlAddressToChannelName);
        JSONArray itemsChannelName = new JSONArray(myResponseChannelName.getJSONArray("items").toString());
        JSONObject snippet = new JSONObject(itemsChannelName.getJSONObject(0).getJSONObject("snippet").toString());
        String channelTitle = snippet.getString("title");
        String profilePictureUrl = snippet.getJSONObject("thumbnails").getJSONObject("default").getString("url");
        String publishedAt = snippet.getString("publishedAt");
        String dateOfPublish = formatDate(publishedAt);

        basicChannelData.add(subscriberCount);
        basicChannelData.add(viewCount);
        basicChannelData.add(videoCount);
        
        basicChannelData.add(channelTitle);
        basicChannelData.add(dateOfPublish);
        basicChannelData.add(profilePictureUrl);

        addToChannelsTable(inputChannelId,basicChannelData);
        return basicChannelData;
    }
    
    public static ArrayList<String> GetAgeAndGenderDistribution(String inputChannelId) throws Exception {
        
        ArrayList<String> ageGenderPercentage2 = new ArrayList();
        String urlAddress = "https://youtubeanalytics.googleapis.com/v2/reports?dimensions=ageGroup%2Cgender&endDate=2020-05-22&ids=channel%3D%3D" + inputChannelId +"&metrics=viewerPercentage&sort=gender%2CageGroup&startDate=2011-03-29&key=" + APIKey + "&access_token=" + AccessToken; 
        JSONObject myResponse = makingGetRequest(urlAddress);
        JSONArray rows = new JSONArray(myResponse.getJSONArray("rows").toString());
       
         for (int i = 0; i < rows.length(); i++) {

               JSONArray actIndex = new JSONArray(rows.getJSONArray(i).toString());
               
               String age = actIndex.getString(0);
               String gender = actIndex.getString(1);
               String percent = String.valueOf(actIndex.getDouble(2));
               ArrayList<String> ageGenderPercentage = new ArrayList();
               ageGenderPercentage.add(age);ageGenderPercentage.add(gender);ageGenderPercentage.add(percent);
               System.out.println(ageGenderPercentage);
               AddToAgeGenderDistributionTable(inputChannelId, ageGenderPercentage);
               
         }
        
        return ageGenderPercentage2;
    
    }
    
     public static void AddToAgeGenderDistributionTable(String inputChannelId, ArrayList<String> ageGenderPercentage) throws SQLException
    {
        Connection con = createDatabaseConnection();
        PreparedStatement insert = con.prepareStatement("INSERT INTO agegenderdistribution (AgeGroup,Gender,AgeGenderPercentage,channelId) VALUES(?,?,?,?)");
        insert.setString(1, ageGenderPercentage.get(0));
        insert.setString(2, ageGenderPercentage.get(1));
        insert.setString(3, ageGenderPercentage.get(2));
        insert.setString(4, inputChannelId);
        insert.execute();
       
    }
    
    public static void addToChannelsTable(String inputChannelId, ArrayList<String> channelData) throws SQLException
    {
        Integer exists = 0;
        Connection con = createDatabaseConnection();
        PreparedStatement idAlreadyExists = con.prepareStatement("SELECT EXISTS(SELECT channelId FROM channels WHERE channelId = ?);");
        idAlreadyExists.setString(1, inputChannelId);
        ResultSet idAlreadyExistsRes = idAlreadyExists.executeQuery();
        if(idAlreadyExistsRes.next())
        {
            exists = idAlreadyExistsRes.getInt(1); // exists = 1 if the channelId is already in the channels table, else its 0
        }
        
        if(exists == 0)
        {
            PreparedStatement insertData = con.prepareStatement("INSERT INTO channels (channelId,title,profilePictureUrl,publishDate,subscriberCount,totalViews,uploads)\n" +
                                                                "VALUES (?,?,?,?,?,?,?);");
            insertData.setString(1, inputChannelId);
            insertData.setString(2, channelData.get(3));
            insertData.setString(3, channelData.get(5));
            insertData.setString(4, channelData.get(4));
            insertData.setString(5, channelData.get(0));
            insertData.setString(6, channelData.get(1));
            insertData.setString(7, channelData.get(2));
            
            insertData.execute();
        }
        else{
            PreparedStatement updateRow = con.prepareStatement("update channels\n" +
                                                               "set title = ?, profilePictureUrl = ?, publishDate=?, subscriberCount = ?,totalViews = ?,uploads = ?" +
                                                               "where channelId = ?;");
            updateRow.setString(1, channelData.get(3));
            updateRow.setString(2, channelData.get(5));
            updateRow.setString(3, channelData.get(4));
            updateRow.setString(4, channelData.get(0));
            updateRow.setString(5, channelData.get(1));
            updateRow.setString(6, channelData.get(2));
            updateRow.setString(7, inputChannelId);
            
            updateRow.execute();
            
        }
        
    }
     
    public static void addToVideosTable(ArrayList<String> allVideoIds, ArrayList<String> allVideoTitles, ArrayList<String> allViewCountOfVideo, ArrayList<String> allLikeCountOfVideo, ArrayList<String> allDislikeCountOfVideo, ArrayList<String> allCommentCountOfVideo, ArrayList<String> allPublishDatesOfVideo, String inputChannelId) {
        try {

            Connection con = createDatabaseConnection();

            // !!!! PreparedStatement dropTableIfExists = con.prepareStatement("drop table if exists videos;");
            PreparedStatement truncateTableComments = con.prepareStatement("DELETE FROM comments\n"
                    + "WHERE videoId IN (\n"
                    + "SELECT videoId\n"
                    + "FROM videos\n"
                    + "WHERE channelId = ?\n"
                    + ");"); // elobb a comments table tartalmat torlom, mivel a videoId foreign key itt, ezt kell elobb
            truncateTableComments.setString(1, inputChannelId);
            truncateTableComments.executeUpdate();

            PreparedStatement truncateTableVideos = con.prepareStatement("delete from videos where channelId = ?; ");
            truncateTableVideos.setString(1, inputChannelId);
            truncateTableVideos.executeUpdate();

            PreparedStatement createVideosTable = con.prepareStatement("create table if not exists videos(videoId varchar(30) not null, title varchar(100) not null, viewCount integer not null, likeCount integer not null, dislikeCount integer not null, commentCount integer not null, publishedAt varchar(30) not null, channelId varchar(50) not null, PRIMARY KEY(videoId), FOREIGN KEY(channelId) references channels(channelId))");
            createVideosTable.executeUpdate();

            for (int i = 0; i < allVideoIds.size(); ++i) {
                // String dateOfPublish = formatDate(allPublishDatesOfVideo.get(i));
                PreparedStatement insertDataToTable = con.prepareStatement("insert into videos (videoId,title,viewCount,likeCount,dislikeCount,commentCount,publishedAt,channelId) values(?,?,?,?,?,?,?,?)");
                insertDataToTable.setString(1, allVideoIds.get(i));
                insertDataToTable.setString(2, allVideoTitles.get(i));
                insertDataToTable.setString(3, allViewCountOfVideo.get(i));
                insertDataToTable.setString(4, allLikeCountOfVideo.get(i));
                insertDataToTable.setString(5, allDislikeCountOfVideo.get(i));
                insertDataToTable.setString(6, allCommentCountOfVideo.get(i));
                //insertDataToTable.setString(7, dateOfPublish);
                insertDataToTable.setString(7, allPublishDatesOfVideo.get(i));
                insertDataToTable.setString(8, inputChannelId);
                insertDataToTable.executeUpdate();
            }

        } catch (SQLException ex) {
            Logger.getLogger(DataMining.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

     public static void addToCommentsTable(ArrayList<String> videoId, ArrayList<String> comment, ArrayList<Integer> likeCount, ArrayList<String> publishedAt, ArrayList<String> language, ArrayList<String> channelId, ArrayList<Integer> sentiment, Integer toplevel) {
       
         try {

             Connection con = createDatabaseConnection();
            // !!!! PreparedStatement truncateTable = con.prepareStatement("truncate table `comments`");

             for (int i = 0; i < comment.size(); ++i) {
                 /*PreparedStatement formatDate = con.prepareStatement("select date (?)");
                 formatDate.setString(1, publishedAt.get(i));
                 ResultSet resultSet = formatDate.executeQuery();
                 String dateOfPublish = null;
                 if (resultSet.next()) {
                     dateOfPublish = resultSet.getString(1);
                 }*/

                 PreparedStatement preparedStatement = con.prepareStatement("insert into comments (videoId,text,likeCount,publishedAt,language,authorChannelId,sentimentScore,toplevel) values(?,?,?,?,?,?,?,?)");
                 preparedStatement.setString(1, videoId.get(i));
                 preparedStatement.setString(2, comment.get(i));
                 preparedStatement.setInt(3, likeCount.get(i));
                // preparedStatement.setInt(4, commentId.get(i));
                // preparedStatement.setString(5, dateOfPublish);
                 preparedStatement.setString(4, publishedAt.get(i));
                 preparedStatement.setString(5, language.get(i));
                 preparedStatement.setString(6, channelId.get(i));
                 preparedStatement.setInt(7, sentiment.get(i));
                 preparedStatement.setInt(8, toplevel);
                 preparedStatement.executeUpdate();

             }

         } catch (SQLException ex) {
             Logger.getLogger(DataMining.class.getName()).log(Level.SEVERE, null, ex);
         }

    }
    
      public static ArrayMap<String, Integer> getDataFromVideosTable(String inputChannelId) throws SQLException {
        ArrayMap<String, Integer> titleViewPairs = new ArrayMap<>();
        Connection connection = createDatabaseConnection();
        PreparedStatement getVideoTitlesAndViews = connection.prepareStatement("select title, viewCount from videos where channelId = ?;");
        getVideoTitlesAndViews.setString(1,inputChannelId);
        ResultSet resultSet = getVideoTitlesAndViews.executeQuery();
        while (resultSet.next()) {
            String title = resultSet.getString(1);
            Integer numberOfViews = resultSet.getInt(2);
            titleViewPairs.put(title, numberOfViews);
        }

        return titleViewPairs;
    }
    
     public static ArrayList<String> getDataFromChannelsTable(String inputChannelId) throws SQLException
     {
        ArrayList<String> channelData = new ArrayList<>();
        Connection connection = createDatabaseConnection();
        PreparedStatement getData = connection.prepareStatement("select subscriberCount, totalViews, uploads, title, date(publishDate), profilePictureUrl\n" +
                                                                "from channels where channelId = ?;");
        getData.setString(1, inputChannelId);
        ResultSet getDataRes = getData.executeQuery();
        while(getDataRes.next())
        {
            channelData.add(getDataRes.getString(1));
            channelData.add(getDataRes.getString(2));
            channelData.add(getDataRes.getString(3));
            channelData.add(getDataRes.getString(4));
            channelData.add(getDataRes.getString(5));
            channelData.add(getDataRes.getString(6));
        }
         return channelData;
     }
      
    public static String detectLanguage(String text) throws LangDetectException {

        String langDetected = null;
        String filterEmojisRegex = "([\\u20a0-\\u32ff\\ud83c\\udc00-\\ud83d\\udeff\\udbb9\\udce5-\\udbb9\\udcee])";
        String textWithoutPunctuations = text.replaceAll("[^a-zA-Z ]", "");
        String whitespaceRegex = "^\\s*$";

        if (textWithoutPunctuations.length() == 0 || textWithoutPunctuations.matches(whitespaceRegex)) {//result2.length() == 0 || result2.matches(whitespc) || result2.matches(".") || result2.matches("--------->") || text.matches("...") || text.matches("<3<3") || text.matches(":\\)") || result2.matches("2:04 689...") || text.matches("[0-9]+")) {

            langDetected = null;

        } else {

            try {

                detector = DetectorFactory.create();
                detector.append(textWithoutPunctuations);
                langDetected = detector.detect();
            } catch (LangDetectException e) {
                throw e;
            }

        }

        return langDetected;

    }
    
    public static String formatDate(String date)
    {
        String dateOfPublish = null;
        try {

            Connection connection = createDatabaseConnection();
            PreparedStatement formatDate = connection.prepareStatement("select date (?)");
            formatDate.setString(1, date);
            ResultSet resultSet = formatDate.executeQuery();

            if (resultSet.next()) {
                dateOfPublish = resultSet.getString(1);

            }

        } catch (SQLException ex) {
            Logger.getLogger(DataMining.class.getName()).log(Level.SEVERE, null, ex);
        }

        return dateOfPublish;
    }
        
    public static Connection createDatabaseConnection() throws SQLException
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // loading mysql driver to the program
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DataMining.class.getName()).log(Level.SEVERE, null, ex);
        }
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/algorythmicsdb?serverTimezone=UTC", "root", "ijo435aha373");
        
        return connection;
    }
    
    public static void selectCountryNamesFromComments(String inputChannelId) throws SQLException {
        ArrayList<String> comments = new ArrayList();

        Connection connection = createDatabaseConnection();
        PreparedStatement getVideoTitlesAndViews = connection.prepareStatement("select text from comments where language = 'en' and channelId = ?;");
        getVideoTitlesAndViews.setString(1, inputChannelId);
        ResultSet resultSet = getVideoTitlesAndViews.executeQuery();
        while (resultSet.next()) {
            String text = resultSet.getString(1);
            comments.add(text);         
        }

        String[] list = {"Romania", "romania", "hungary", "Hungary", "europe"};
        String address = "";
        for (int i = 0; i < comments.size(); ++i) {
            address = comments.get(i);
            for (String s : list) {
                if (address.contains(s)) {
                    System.out.println(address);

                }
            }
        }

        /*for (int i = 0; i < comments.size(); ++i) {
           String temp = comments.get(i);
           if(temp.matches(".*\\bromania\\b.*") || temp.matches(".*\\bhungary\\b.*") || temp.matches(".*\\beurope\\b.*"))
           {
               System.out.println(temp);
           }
       }*/
    }
    
    public static int[] getSentimentScorePercentage(String inputChannelId) throws SQLException {
        Integer positiveCommentCount = 0, neutralCommentCount = 0, negativeCommentCount = 0;

        Connection connection = createDatabaseConnection();
        PreparedStatement numberOfPositiveComments = connection.prepareStatement("select count(commentsId) \n" +
                                                                                 "from comments c join videos v on c.videoId = v.videoId join channels ch on v.channelId = ch.channelId \n"
                                                                                 + " where (sentimentScore = 3 or sentimentScore = 4) and ch.channelId = ? and c.toplevel = 0;");
        numberOfPositiveComments.setString(1,inputChannelId);
        PreparedStatement numberOfNeutralComments = connection.prepareStatement("select count(commentsId) \n" +
                                                                                "from comments c join videos v on c.videoId = v.videoId join channels ch on v.channelId = ch.channelId\n" +
                                                                                "where sentimentScore = 2 and ch.channelId = ? and c.toplevel = 0;");
        numberOfNeutralComments.setString(1,inputChannelId);
        PreparedStatement numberOfNegativeComments = connection.prepareStatement("select count(c.commentsId) \n" +
                                                                                 "from comments c join videos v on c.videoId = v.videoId join channels ch on v.channelId = ch.channelId\n" +
                                                                                 "where (sentimentScore = 0 or sentimentScore = 1) and ch.channelId = ? and c.toplevel = 0;");
        numberOfNegativeComments.setString(1,inputChannelId);
        
        ResultSet positiveCountResult = numberOfPositiveComments.executeQuery();
        if (positiveCountResult.next()) {
            positiveCommentCount = positiveCountResult.getInt(1);

        }
        ResultSet neutralCountResult = numberOfNeutralComments.executeQuery();
        if (neutralCountResult.next()) {
            neutralCommentCount = neutralCountResult.getInt(1);

        }
        ResultSet negativeCountResult = numberOfNegativeComments.executeQuery();
        if (negativeCountResult.next()) {
            negativeCommentCount = negativeCountResult.getInt(1);

        }
        int[] totalCountOfSentimentScores = new int[]{positiveCommentCount, neutralCommentCount, negativeCommentCount};

        return totalCountOfSentimentScores;

    }
    
     public static ArrayMap<String, Integer> getEachLanguageCount(String inputChannelId) throws SQLException {
        ArrayMap<String, Integer> languageNumberPairs = new ArrayMap<>();
        Connection connection = createDatabaseConnection();
        PreparedStatement getLanguagesAndCounts = connection.prepareStatement("select c.language, count(c.videoId) \n" +
                                                                              "from comments c join videos v on c.videoId = v.videoId join channels ch on v.channelId = ch.channelId\n" +
                                                                              "where ch.channelId = ? \n" +
                                                                              "group by language;");
        getLanguagesAndCounts.setString(1,inputChannelId); 
        ResultSet resultSet = getLanguagesAndCounts.executeQuery();
        while (resultSet.next()) {
            if(resultSet.getString(1) != null)
            {
                String language = resultSet.getString(1);
                Integer numberOfLanguages = resultSet.getInt(2);
                languageNumberPairs.put(language, numberOfLanguages);
            }
            
        }
       
        return languageNumberPairs;
    }
     
     public static ArrayMap <String, Integer> calculateDuration(String inputChannelId) throws SQLException
     {
        ArrayMap <String, Integer> videoWeekOfMostCommentsPairs = new ArrayMap<>();
        ArrayList<Long> daysBetweenVideoAndComments = new ArrayList<>();
        long daysBetween = 0; Integer maxIndex = 0;
        
        Instant publishedDateOfVideoInstant, publishDateOfCorrespondingCommentInstant;
        String publishedAt, videoId, publishedAtForComment, title;

        Connection connection = createDatabaseConnection();

        PreparedStatement getPublishDateOfVideo = connection.prepareStatement("select v.title, v.videoId, v.publishedAt \n" +
                                                                              "from videos v join channels ch on v.channelId = ch.channelId\n" +
                                                                              "where v.channelId = ?;");
        getPublishDateOfVideo.setString(1,inputChannelId);
        ResultSet resultSetForPublishDate = getPublishDateOfVideo.executeQuery();
        while (resultSetForPublishDate.next()) {
            
            title = resultSetForPublishDate.getString(1);
            videoId = resultSetForPublishDate.getString(2);
            publishedAt = resultSetForPublishDate.getString(3);
           
            publishedDateOfVideoInstant = Instant.parse(publishedAt);
            
            PreparedStatement getPublishDateOfCorrespondingComment = connection.prepareStatement("select c.publishedAt \n" +
                                                                                                 "from comments c join videos v on c.videoId = v.videoId join channels ch on v.channelId = ch.channelId \n" +
                                                                                                 "where c.videoId = ? and ch.channelId = ?;");
            getPublishDateOfCorrespondingComment.setString(1, videoId);
            getPublishDateOfCorrespondingComment.setString(2, inputChannelId);
            ResultSet resultSetForPublishDateOfCorrespondingComment = getPublishDateOfCorrespondingComment.executeQuery();
            
            while (resultSetForPublishDateOfCorrespondingComment.next()) {
                
                publishedAtForComment = resultSetForPublishDateOfCorrespondingComment.getString(1);
                publishDateOfCorrespondingCommentInstant = Instant.parse(publishedAtForComment);
                daysBetween = ChronoUnit.DAYS.between(publishedDateOfVideoInstant, publishDateOfCorrespondingCommentInstant);
                daysBetweenVideoAndComments.add(daysBetween);
                Collections.sort(daysBetweenVideoAndComments);               
            }
         
           ArrayList<Integer> numberOfOccurances = new ArrayList<>();
           numberOfOccurances = determineRange(daysBetweenVideoAndComments);
           maxIndex = determineMaxValueOfWeek(numberOfOccurances);
           videoWeekOfMostCommentsPairs.put(title, maxIndex);         
        }
        
       //videoWeekOfMostCommentsPairs.forEach((key, value) -> System.out.println(key + ":" + value));      
       return videoWeekOfMostCommentsPairs;
    }
     
     /*
     Counting the number of comments that
     was left in each week
     */
     
    private static ArrayList<Integer> determineRange(ArrayList<Long> listOfDaysBetween)
    {
        //System.out.println(listOfDaysBetween);
        int count = 0, startingPosition = 0;
        long numberOfWeek = 0;
        int size = listOfDaysBetween.size() - 1;
        
        if(listOfDaysBetween.get(size) % 7 == 0)
        {
            numberOfWeek = listOfDaysBetween.get(size);
        }
        else
        {
            numberOfWeek = listOfDaysBetween.get(size) + 7;
        }
       
        ArrayList<Integer> numberOfOccurances = new ArrayList<>();
        for (int i=7;i<=numberOfWeek;i = i+7)
        {
            for (int j = startingPosition; j < listOfDaysBetween.size(); ++j)
            {
                if(listOfDaysBetween.get(j) <= i )
                {
                   if(j == listOfDaysBetween.size() - 1)
                   {
                       count ++;
                       numberOfOccurances.add(count);
                   }
                   count ++;                   
                }
                else{
                    numberOfOccurances.add(count);
                    startingPosition = j;
                    
                    count = 0;
                    break;
                }               
                
            }
        }
        
        //System.out.println(numberOfOccurances);
        return numberOfOccurances;
       
    }
    
    private static Integer determineMaxValueOfWeek(ArrayList<Integer> numberOfOccurances)          
    {
        int maxValueOfArray = Integer.MIN_VALUE, index = 0;
        
        for(int i=0;i<numberOfOccurances.size();++i)
        {
            if(numberOfOccurances.get(i) > maxValueOfArray)
            {
                maxValueOfArray = numberOfOccurances.get(i);
                index = i;
            }
        }
       
       return (index + 1); // index = the number of week in wich the most comments arrived
    }
    
    public static ArrayMap<String,Double> getViewAndLikeRatio(String inputChannelId) throws SQLException
    {
        String title;
        Double ratio;
        ArrayMap<String, Double> viewLikeRatios = new ArrayMap();
        Connection connection = createDatabaseConnection();
        PreparedStatement getRatio = connection.prepareStatement("select title, viewCount/likeCount\n" +
                                                                              "from videos \n" +
                                                                              "where channelId = ?");
        getRatio.setString(1,inputChannelId);
        ResultSet resultSetForRatio = getRatio.executeQuery();
        while (resultSetForRatio.next()) {
            
            title = resultSetForRatio.getString(1);
            ratio = resultSetForRatio.getDouble(2);
            viewLikeRatios.put(title,ratio);           
        }
        
        return viewLikeRatios;
    }
    
     public static ArrayMap<String,Double> getViewAndDislikeRatio(String inputChannelId) throws SQLException
    {
        String title;
        Double ratio;
        ArrayMap<String, Double> viewDislikeRatios = new ArrayMap();
        Connection connection = createDatabaseConnection();
        PreparedStatement getRatio = connection.prepareStatement("select title, viewCount/dislikeCount\n" +
                                                                              "from videos \n" +
                                                                              "where channelId = ?");
        getRatio.setString(1,inputChannelId);
        ResultSet resultSetForRatio = getRatio.executeQuery();
        while (resultSetForRatio.next()) {
            
            title = resultSetForRatio.getString(1);
            ratio = resultSetForRatio.getDouble(2);
            viewDislikeRatios.put(title,ratio);           
        }
        
        return viewDislikeRatios;
    }
    
    public static ArrayList<ArrayList<String>> AverageCommentNumberPerPerson(String inputChannelId) throws SQLException
    {
        ArrayList<ArrayList<String>> transactions = new ArrayList<ArrayList<String>>();
        ArrayList<ArrayList<String>> mostFrequentVideos = new ArrayList<ArrayList<String>>();
       
        Connection connection = createDatabaseConnection();
        Integer sum = 0,numberOfVideos=0;
        Double commentersNumber;
        String authorChannelId,nr = null,videoTitle;
        PreparedStatement numberOfCommenters = connection.prepareStatement("select count(distinct(c.authorChannelId)) \n" +
                                                                           "from comments c join videos v on c.videoId = v.videoId\n" +
                                                                           "where v.channelId = ? and c.toplevel = 0;");
        numberOfCommenters.setString(1,inputChannelId);
        ResultSet nrCommenters = numberOfCommenters.executeQuery();
        if(nrCommenters.next())
        {
            nr = nrCommenters.getString(1);
        }
        
        commentersNumber = Double.parseDouble(nr);
       // ki hany videohoz kommentelt
        PreparedStatement commentNumberPerPerson = connection.prepareStatement("select c.authorChannelId, count(distinct(c.videoId))\n" +
                                                                               "from comments c join videos v on c.videoId = v.videoId\n" +
                                                                               "where v.channelId = ? and c.toplevel = 0 \n" + 
                                                                               "group by c.authorChannelId\n" +
                                                                                "order by count(distinct(c.videoId)) desc;");
        commentNumberPerPerson.setString(1,inputChannelId);
        ResultSet result = commentNumberPerPerson.executeQuery();
        
         while (result.next()) {
            
            authorChannelId = result.getString(1);
            numberOfVideos = result.getInt(2);
            sum += numberOfVideos;   
            
            if(numberOfVideos > 1)
            {
                PreparedStatement personsCommentCount = connection.prepareStatement("select distinct(v.title) from videos v join comments c on v.videoId = c.videoId\n" +
                                                                                    "where c.authorChannelId = ? and v.channelId = ? and c.toplevel = 0;");
                personsCommentCount.setString(1,authorChannelId);
                personsCommentCount.setString(2,inputChannelId);
                ResultSet personsCommentCountResult = personsCommentCount.executeQuery();
                ArrayList<String> transaction = new ArrayList<>();
                while(personsCommentCountResult.next())
                {
                    videoTitle = personsCommentCountResult.getString(1);
                    transaction.add(videoTitle);
                }
                
                transactions.add(transaction);
            }  
        }
         
        mostFrequentVideos =  Apriori.myApriori(transactions);
        //System.out.println("Atlagban hany videohoz kommentel egy szemely:" + (sum/commentersNumber));
        
        return mostFrequentVideos;
    }
    
    public static ArrayList<String> Years(String inputChannelId) throws SQLException
    {
        String year;
        ArrayList<String> years = new ArrayList<>();
        Connection connection = createDatabaseConnection();
        PreparedStatement yearWithMostComments = connection.prepareStatement("select count(c.publishedAt), DATE_FORMAT(c.publishedAt, '%Y')\n" +
                                                                            "from comments c join videos v on c.videoId = v.videoId join channels ch on ch.channelId = v.channelId\n" +
                                                                            "where ch.channelId = ?\n" +
                                                                            "GROUP BY DATE_FORMAT(c.publishedAt, '%Y')\n" +
                                                                            "order by count(c.publishedAt) desc\n" +
                                                                            "Limit 2;");
        yearWithMostComments.setString(1, inputChannelId);
        ResultSet resultSetForYear = yearWithMostComments.executeQuery();
        while(resultSetForYear.next())
        {
            year = resultSetForYear.getString(2);
            years.add(year);
        }  
        
        return years;
    }
        
     public static ArrayList <HashMap<Integer,Integer>> MonthWithCommentCount2 (String inputChannelId, ArrayList<String> years) throws SQLException {
        
        ArrayList <HashMap<Integer,Integer>> monthsCommentsNr = new ArrayList<>();
        ArrayList<String> det = new ArrayList<String>(Arrays.asList("12","11","10","09","08","07","06","05","04","03","02","01"));
        String commentNrPerMonth,month; Integer commentNr;
        
        Connection connection = createDatabaseConnection();
        
        for (int i=0;i<years.size();++i)
        {
             ArrayMap<String, Integer> commentNrMonthPair = new ArrayMap<>();
             PreparedStatement commentCountOfMonths = connection.prepareStatement("select count(c.publishedAt), DATE_FORMAT(c.publishedAt, '%m')\n"
                + "from comments c join videos v on c.videoId = v.videoId join channels ch on ch.channelId = v.channelId\n"
                + "where ch.channelId = ? and DATE_FORMAT(c.publishedAt, '%Y') = ?\n"
                + "GROUP BY DATE_FORMAT(c.publishedAt, '%m');");
            commentCountOfMonths.setString(1, inputChannelId);
            commentCountOfMonths.setString(2, years.get(i));

            ResultSet resultForCommentCountOfMonths = commentCountOfMonths.executeQuery();
            while (resultForCommentCountOfMonths.next()) {
                commentNrPerMonth = resultForCommentCountOfMonths.getString(1);
                commentNr = Integer.parseInt(commentNrPerMonth);
                month = resultForCommentCountOfMonths.getString(2);
                commentNrMonthPair.put(month, commentNr);

            }
            
            for (int j=0;j<det.size();++j)
            {
                 if(!commentNrMonthPair.keySet().contains(det.get(j)))
                 {
                     commentNrMonthPair.put(det.get(j), 0);
                 }
            }
            HashMap<Integer, Integer> finalH = new HashMap<>();
            finalH = sortMapOfStrings(commentNrMonthPair);
            
            monthsCommentsNr.add(finalH);
            
        }
      
        return monthsCommentsNr;

    }
    public static HashMap<Integer, Integer> sortMapOfStrings(ArrayMap<String, Integer> map)
    {
       ArrayMap<Integer, Integer> conv = new ArrayMap<>();
        map.entrySet().forEach(entry->{   
              if(entry.getKey().equals("01") || entry.getKey().equals("02") || entry.getKey().equals("03") || entry.getKey().equals("04") || entry.getKey().equals("05") || entry.getKey().equals("06") || entry.getKey().equals("07") || entry.getKey().equals("08") || entry.getKey().equals("09"))
                    map.put(entry.getKey().substring(1), map.remove(entry.getKey()));                       
        });
        
        map.entrySet().forEach(entry->{
               conv.put(Integer.parseInt(entry.getKey()),entry.getValue());
        });
        
        List<Map.Entry<Integer, Integer> > list = 
               new LinkedList<Map.Entry<Integer, Integer> >(conv.entrySet()); 
  
    
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer> >() { 
            public int compare(Map.Entry<Integer, Integer> o1,  
                               Map.Entry<Integer, Integer> o2) 
            { 
                return (o1.getKey()).compareTo(o2.getKey()); 
            } 
        }); 
          
        HashMap<Integer, Integer> temp = new LinkedHashMap<Integer, Integer>(); 
        for (Map.Entry<Integer, Integer> aa : list) { 
            temp.put(aa.getKey(), aa.getValue()); 
        } 
       
       
         temp.entrySet().forEach(entry->{
             String str1 = Integer.toString(entry.getKey());
             //System.out.println(Integer.toString(entry.getKey()) + " " + entry.getValue());
             
        });
      
         return temp;
    }
    
    public static String convertToMonthName(Integer monthNr) throws SQLException
    {
        String monthName = null;
        Connection connection = createDatabaseConnection();
        PreparedStatement convert = connection.prepareStatement("select MONTHNAME(STR_TO_DATE(?,'%m'))from dual;");
        convert.setInt(1, monthNr);
        ResultSet resConvert = convert.executeQuery();
        if(resConvert.next())
        {
            monthName = resConvert.getString(1);
        }
        
        return monthName;
    }
    
    public static List<Double> getSubsOfLast30Days(String inputChannelId) throws SQLException
    {
        List<Double> subscribers = new ArrayList<>();
        Connection connection = createDatabaseConnection();
        PreparedStatement getSubs = connection.prepareStatement("select count from subscribercount where channelId = ?;");
        getSubs.setString(1, inputChannelId);
        ResultSet subResult = getSubs.executeQuery();
        while(subResult.next())
        {
            subscribers.add(Double.parseDouble(subResult.getString(1)));
        }
       
        return subscribers;
    }
    
    public static String getFirstDateOfSubsCount(String inputChannelId) throws SQLException
    {
        String date = null;
        Connection connection = createDatabaseConnection();
        PreparedStatement getDate = connection.prepareStatement("select date(date) from subscribercount where channelId = ? limit 1;");
        getDate.setString(1, inputChannelId);
        ResultSet dateResult = getDate.executeQuery();
        if(dateResult.next())
        {
            date = dateResult.getString(1);
        }
        return date;
    }
    
     public static ArrayMap<String,Integer> CommentCountPerYear(String inputChannelId) throws SQLException
    {
        String year;
        ArrayMap<String,Integer> years = new ArrayMap<>();
        Connection connection = createDatabaseConnection();
        PreparedStatement yearWithMostComments = connection.prepareStatement("select count(c.publishedAt), DATE_FORMAT(c.publishedAt, '%Y')\n" +
                                                                            "from comments c join videos v on c.videoId = v.videoId join channels ch on ch.channelId = v.channelId\n" +
                                                                            "where ch.channelId = ?\n" +
                                                                            "GROUP BY DATE_FORMAT(c.publishedAt, '%Y')\n" +
                                                                            "order by count(c.publishedAt) desc;");
                                                                            
        yearWithMostComments.setString(1, inputChannelId);
        ResultSet resultSetForYear = yearWithMostComments.executeQuery();
        while(resultSetForYear.next())
        {
            year = resultSetForYear.getString(2);
            //years.add(year);
            years.put(year, resultSetForYear.getInt(1));
        }  
        
        return years;
    }
     
     public static ArrayList<String> AgeGenderPercentage(String inputChannelId) throws SQLException
    {
        ArrayList<String> percentage = new ArrayList<>();
        Connection connection = createDatabaseConnection();
        PreparedStatement statement = connection.prepareStatement("select AgeGroup from agegenderdistribution where channelId = ? limit 7;");
                                                                                                                                               
        statement.setString(1, inputChannelId);
        ResultSet resultSet = statement.executeQuery();
        while(resultSet.next())
        {
            percentage.add(resultSet.getString(1));        
        }  
        
        return percentage;      
    }
        
    public static ArrayList<Double> FemalePercentageOfDemographics(String inputChannelId) throws SQLException
    {
        ArrayList<Double> femalesPerc = new ArrayList<>();
        Connection connection = createDatabaseConnection();
        PreparedStatement statement = connection.prepareStatement("select AgeGroup, AgeGenderPercentage from agegenderdistribution where  Gender = \"female\" and channelId = ?;");
                                                                          
                                                                            
        statement.setString(1, inputChannelId);
        ResultSet resultSet = statement.executeQuery();
        while(resultSet.next())
        {
            femalesPerc.add(resultSet.getDouble(2));
           
        }  
        
        return femalesPerc;      
    }
    
    public static ArrayList<Double> MalePercentageOfDemographics(String inputChannelId) throws SQLException {
        ArrayList<Double> malePerc = new ArrayList<>();
        Connection connection = createDatabaseConnection();
        PreparedStatement statement = connection.prepareStatement("select AgeGroup, AgeGenderPercentage from agegenderdistribution where  Gender = \"male\" and channelId = ?;");

        statement.setString(1, inputChannelId);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            malePerc.add(resultSet.getDouble(2));
        }

        return malePerc;
    }
    
    public static ArrayList<Double> SumOfAgeDistributions(String inputChannelId) throws SQLException
    {
        ArrayList<Double> sumAges = new ArrayList<>();
        Connection connection = createDatabaseConnection();
        PreparedStatement statement = connection.prepareStatement("select sum(AgeGenderPercentage) \n" +
                                                                  "from agegenderdistribution\n" +
                                                                  "where channelId = ?\n" +
                                                                  "group by AgeGroup;");

        statement.setString(1, inputChannelId);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            sumAges.add(resultSet.getDouble(1));
        }

        return sumAges;
    }
    public static Boolean exists(ArrayList<String> array, String element)
    {
        for(int i=0;i<array.size();++i)
        {
            if(array.get(i).equals(element))
            {
                return true;
            }
        }
        return false;
    }
   
    public static ArrayList<ArrayList<String>> CommentOrderPerPerson(String inputChannelId) throws SQLException
    {
        ArrayList<ArrayList<String>> listOfTitles = new ArrayList<>();
        ArrayList<String> listWithDuplicates = new ArrayList<>();
        ArrayList<String> listNoDuplicates = new ArrayList<>();
        ArrayList<ArrayList<String>> array = new ArrayList<>();
        Connection connection = createDatabaseConnection();
        String authorChannelId = null;
        PreparedStatement statement = connection.prepareStatement("select b.temp, b.authorChannelId\n" +
                                                                    "from\n" +
                                                                    "	(select c.authorChannelId, count(distinct(c.videoId)) as temp\n" +
                                                                    "	from comments c join videos v on c.videoId = v.videoId\n" +
                                                                    "	where v.channelId = ? \n" +
                                                                    "	group by c.authorChannelId\n" +
                                                                    "	order by count(distinct(c.videoId)) desc) b\n" +
                                                                    "where b.temp > 1\n" +
                                                                    "order by b.temp asc;");
        statement.setString(1,inputChannelId);
        ResultSet result = statement.executeQuery();
       
                
        while(result.next())
        {
            authorChannelId = result.getString(2);
 
            PreparedStatement statement2 = connection.prepareStatement("select UNIX_TIMESTAMP(c.publishedAt) as date, v.title from comments c join videos v on c.videoId = v.videoId join channels ch on v.channelId = ch.channelId\n" +
                                                                        "where ch.channelId = ? and c.authorChannelId = ?\n" +
                                                                        "order by date asc;");
            statement2.setString(1,inputChannelId);
            statement2.setString(2,authorChannelId);
            listWithDuplicates = new ArrayList<>();
            listNoDuplicates = new ArrayList<>();
            ResultSet result2 = statement2.executeQuery();
            while(result2.next())
            {
                listWithDuplicates.add(result2.getString(2));
            }
            
             for(int i=0;i<listWithDuplicates.size();++i)
            {
                String temp = listWithDuplicates.get(i);
                
                for (int j=0; j<= i ;++j)
                {
                   
                    if(!exists(listNoDuplicates,temp))
                    {
                        listNoDuplicates.add(temp);
                    }
                   
                }
                
            }
            listOfTitles.add(listNoDuplicates);       
        }
        
        array = CountOrderOfVideos(inputChannelId,listOfTitles);
        return array;
    }
    
     public static ArrayList<ArrayList<String>> CountOrderOfVideos(String inputChannelId, ArrayList<ArrayList<String>> array) throws SQLException
    {
        Connection connection = createDatabaseConnection();
        ArrayList<String> videos = new ArrayList<>();
        ArrayList<ArrayList<String>> arrayOfVideoOrders = new ArrayList<>();
      
        Integer maxSize = array.get(array.size() - 1).size();
        
        PreparedStatement statement = connection.prepareStatement("select title from videos where channelId =?;");
        statement.setString(1, inputChannelId);
        ResultSet result = statement.executeQuery();
        while (result.next()) {
            videos.add(result.getString(1));
        }
        for (int x = 0; x < videos.size(); ++x) {
            String title = videos.get(x);

            ArrayList<Integer> counter = new ArrayList<Integer>(Collections.nCopies(maxSize, 0));

            for (int i = 0; i < array.size(); ++i) {

                ArrayList<String> tempArray = new ArrayList<>();
                tempArray = array.get(i);

                for (int k = 0; k < counter.size(); ++k) {

                    if (tempArray.size() - 1 < k) {
                        counter.set(k, 0);
                    } else {

                        if (tempArray.get(k).equals(title)) {

                            counter.set(k, counter.get(k) + 1);

                        }
                    }

                }

            }
            ArrayList<String> content = new ArrayList<>();
            content.add(title);
            for(int y=0;y<counter.size();++y)
            {
                
                content.add(counter.get(y).toString());
            }
            
            arrayOfVideoOrders.add(content);
        }
        /*for (int i = 0; i < arrayOfVideoOrders.size(); ++i) {
            ArrayList<String> tempArray = new ArrayList<>();
            tempArray = arrayOfVideoOrders.get(i);
            System.out.println(tempArray);

        }*/
        return arrayOfVideoOrders;
    }
}