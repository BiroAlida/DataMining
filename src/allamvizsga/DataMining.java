package allamvizsga;

import com.cybozu.labs.langdetect.Detector;
import com.cybozu.labs.langdetect.DetectorFactory;
import com.cybozu.labs.langdetect.LangDetectException;
import com.fasterxml.jackson.core.JsonFactory;
import com.google.api.client.auth.oauth2.BearerToken;
import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.extensions.java6.auth.oauth2.AuthorizationCodeInstalledApp;
import com.google.api.client.googleapis.auth.oauth2.GoogleAuthorizationCodeFlow;
import com.google.api.client.googleapis.auth.oauth2.GoogleClientSecrets;
import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import static com.google.api.client.googleapis.testing.auth.oauth2.MockGoogleCredential.REFRESH_TOKEN;
import com.google.api.client.http.GenericUrl;
import com.google.api.client.http.HttpRequestFactory;
import com.google.api.client.http.HttpResponse;
import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.youtube.model.CommentListResponse;
import edu.stanford.nlp.util.ArrayMap;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL; 
import java.security.GeneralSecurityException;
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
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
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
     
    
    public static void main(String[] args) throws LangDetectException {
        
       DetectorFactory.loadProfile(path);
       
       try {
         
        // getDataFromVideosTable();
         //getVideoStatistics();
        // getCommentsAndStatistics();
         
        /* Form form = new Form();
         form.setVisible(true);*/
        GoogleOAuthServer g = new GoogleOAuthServer();
        g.main();
       // calculateDuration();
       // ArrayList<Integer> det = new ArrayList<Integer>(Arrays.asList(26, 128, 40, 12, 6, 6, 2, 3, 2, 4, 1, 2, 3, 1, 2, 1, 2, 3, 2, 1, 2, 0, 3, 1, 4, 0, 2, 0, 0, 5, 10, 0, 4, 2, 3, 1, 7, 6, 3, 6, 4, 5, 3, 7, 4, 2, 3, 4, 2, 3, 9, 1, 1, 5, 4, 5, 3, 1, 4, 6, 7, 13, 11, 4, 0, 0, 6, 1, 1, 1, 1, 3, 1, 0, 1, 2, 3, 0, 5, 4, 2, 2, 10, 3, 1, 1, 9, 6, 4, 7, 4, 2, 2, 3, 8, 4, 7, 4, 0, 2, 5, 5, 4, 3, 3, 5, 4, 2, 3, 2, 7, 1, 3, 5, 2, 2, 1, 4, 0, 4, 6, 5, 3, 2, 5, 1, 4, 2, 2, 4, 7, 5, 6, 1, 5, 5, 2, 5, 2, 5, 4, 3, 0, 1, 1, 3, 2, 3, 4, 4, 2, 2, 0, 0, 5, 3, 1, 2, 1, 1, 2, 0, 2, 1, 1, 0, 2, 2, 3, 4, 0, 2, 0, 0, 4, 1, 1, 1, 1, 1, 1, 1, 1, 2, 3, 1, 3, 3, 0, 2, 1, 0, 2, 3, 1, 4, 1, 0, 0, 0, 2, 2, 2, 1, 0, 2, 1, 0, 2, 1, 0, 1, 1, 2, 2, 2, 1, 0, 1, 2, 0, 1, 0, 1, 0, 1, 1, 2, 1, 1, 0, 1, 0, 1, 2, 2, 3, 4, 2, 1, 1, 1, 7, 1, 2, 0, 2, 0, 0, 0, 0, 4, 1, 1, 1, 2, 3, 0, 4, 2, 1, 0, 2, 3, 1, 3, 2, 2, 3, 0, 2, 0, 0, 0, 0, 1, 1, 2, 1, 1, 2, 1, 1, 2, 1, 3, 2, 2, 0, 2, 2, 0, 2, 7, 2, 1, 1, 3, 1, 0, 2, 2, 4, 1, 2, 1, 0, 0, 4, 0, 4, 3, 2, 3, 2, 1, 0, 2, 1, 3, 0, 0, 2, 0, 1, 6, 1, 2, 3, 1, 1, 0, 3, 2, 0, 1, 4, 1, 0, 2, 0, 1, 6, 4, 4, 1, 0, 3, 4, 1, 5, 3, 1, 1, 1, 2, 0, 1, 2, 1, 3, 4, 0, 3, 2, 2, 2, 1, 3, 2, 1, 2, 1, 1, 1, 1, 1, 0, 1, 1, 1, 0, 3, 1, 0, 2, 0, 2, 0, 2, 1, 3, 2, 2, 2, 1, 3, 1, 6, 5, 3, 4, 3, 4, 2, 4, 4, 4, 1, 4, 1, 4, 0, 3, 2, 3, 4, 8, 2, 5, 6, 0, 5, 3, 4, 5, 3, 1, 0, 0, 1, 2, 4, 0, 2, 1, 1, 2, 0, 1, 1, 3, 7, 0, 3, 4, 7, 4, 1, 11, 13, 7, 8, 21, 10, 10, 11, 53, 34, 26, 10, 3, 13, 4, 4, 2, 1));
        
      //ArrayList<Integer> proba  = new ArrayList<Integer>(Arrays.asList(7,13,14,21,22,23,34));
      //determineRange(proba);
        
        //selectCountryNamesFromComments();
          //getSentimentScorePercentage();
         
         //DataMining.getMetrics();
         //DataMining.getChannelStatistics();
        
        } catch (Exception e) {
            
         e.printStackTrace();
       }
      
    }
    
    public static void getMetrics() throws Exception
    {
       
        String url = "https://www.googleapis.com/youtube/analytics/v1/reports?ids=channel%3D%3DUCIqiLefbVHsOAXDAxQJH7Xw&start-date=2016-02-25&end-date=2016-03-30&metrics=watch_time_minutes&dimensions=country_code&key=AIzaSyAliNkHr1GFgo1Yj3b09gXZO_X1s3Lpxag";
        //JSONObject videoTitleAndIdResponse = makingGetRequest(url);
       HttpTransport transport = null;
       JsonFactory jsonFactory = null;
       GenericUrl url2 = new GenericUrl(new URL(url));
       
       executeGet(transport,jsonFactory,"ya29.Il-7B2Fqo5eECPkuYogzZoe2aMw5gx54FJaQUe_HKdzjYoc8l2SqBTc4-3mxKhll78a0I2FYM-QjfXqYtmUD7MUNd47PvJeTc1t3DnyvV2PK-9mdYYLzUZdd7pVFmBWfuQ",url2); 
       
    }
    
    public static HttpResponse executeGet(
      HttpTransport transport, JsonFactory jsonFactory, String accessToken, GenericUrl url)
      throws IOException, Exception {
    Credential credential =
        new Credential(BearerToken.authorizationHeaderAccessMethod()).setAccessToken(accessToken);
    HttpRequestFactory requestFactory = transport.createRequestFactory(credential);
    
    
    return requestFactory.buildGetRequest(url).execute();
    //JSONObject videoTitleAndIdResponse = makingGetRequest(url);
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


    public static void getVideoStatistics() throws Exception {
        
        while(true)
     {
        String urlAddress = "https://www.googleapis.com/youtube/v3/activities?part=snippet,contentDetails&channelId=" + inputChannelId + "&key=AIzaSyAliNkHr1GFgo1Yj3b09gXZO_X1s3Lpxag&maxResults=50&pageToken=" + tokenForTitle;
       
        JSONObject videoTitleAndIdResponse = makingGetRequest(urlAddress);
        JSONArray items = new JSONArray(videoTitleAndIdResponse.getJSONArray("items").toString());

        String titleOfVideo = "",videoId = "",viewCount="",likeCount="",dislikeCount="",commentCount="",publishedAt="";
        

        for (int i = 0; i < items.length(); i++) {

            JSONObject snippet = new JSONObject(items.getJSONObject(i).getJSONObject("snippet").toString());

            if (snippet.has("title")) {
                titleOfVideo = snippet.getString("title");
            } else {
                continue;
            }
            
            publishedAt = snippet.getString("publishedAt");
            JSONObject contentDetails = new JSONObject(items.getJSONObject(i).getJSONObject("contentDetails").toString());

            JSONObject upload = new JSONObject(contentDetails.getJSONObject("upload").toString());
            videoId = upload.getString("videoId");
            
            String videoStatisticsUrl = "https://www.googleapis.com/youtube/v3/videos?part=contentDetails,statistics&id=" + videoId + "&t=212s,-VoFbH8jTzE,RPNDXrAvAMg,gmQmYc9-zcg&key=AIzaSyAliNkHr1GFgo1Yj3b09gXZO_X1s3Lpxag";
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
            //System.out.println(videoId); System.out.println(titleOfVideo);System.out.println(viewCount);System.out.println(likeCount);System.out.println(dislikeCount);System.out.println(commentCount);

        }
        
        if(videoTitleAndIdResponse.has("nextPageToken"))
        {
            token = videoTitleAndIdResponse.getString("nextPageToken");
            
        }
        else{
            System.out.println("No more pages available");
            break;
        }
     }
       
        addToVideosTable(allVideoIds,allVideoTitles,allViewCountOfVideo,allLikeCountOfVideo,allDislikeCountOfVideo,allCommentCountOfVideo,allPublishDatesOfVideo);
        
    }
    
    public static void getCommentsAndStatistics() throws Exception {
   
        int flag = 0;

        while (true) {
            flag += 1;
            String urlAddress = "https://www.googleapis.com/youtube/v3/commentThreads?part=snippet&allThreadsRelatedToChannelId=" + inputChannelId + "&key=AIzaSyAliNkHr1GFgo1Yj3b09gXZO_X1s3Lpxag&pageToken=" + token;

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
                Integer likeCount = nextLevelSnippet.getInt("likeCount");
                String publishedAt = nextLevelSnippet.getString("publishedAt").toString();
                
                String comment = textOriginal.replaceAll(",", "").toString();

                String languageOfComment = DataMining.detectLanguage(comment);

                int sentimentScore = 0;
               
                sentimentScore = detectSentimentOfComment(comment,languageOfComment);
                  
                totalVideoIds.add(videoId);
                totalComments.add(comment);
                totalLikeCounts.add(likeCount);
                totalCommentCounts.add(commentCount);
                totalPublishDates.add(publishedAt);
                totalLanguages.add(languageOfComment);
                totalAuthorChannelIds.add(authorChannelIdValue);
                sentimentScores.add(sentimentScore);

                listOfComments.add(comment);
                commentCount++;

            }

            if (myResponse.has("nextPageToken")) {
                token = myResponse.getString("nextPageToken");

            } else {
                System.out.println("No more pages available");
                break;
            }

        }
        addToCommentsTable(totalVideoIds, totalComments, totalLikeCounts, totalCommentCounts, totalPublishDates, totalLanguages, totalAuthorChannelIds, sentimentScores);
        // detectSentimentOfComment(englishComments);

   }
    
    public static JSONObject makingGetRequest(String urlAddress) throws Exception
    {
        URL urlObject = new URL(urlAddress);
        HttpURLConnection connection = (HttpURLConnection) urlObject.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("User-Agent", "Mozilla/5.0");

        int responseCode = connection.getResponseCode();

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
    
    public static ArrayList<String> getChannelTitleAndProfilePic(String inputChannelId) throws Exception {
        ArrayList<String> channelData = new ArrayList();
        String urlAddressToChannelName = "https://www.googleapis.com/youtube/v3/channels?part=snippet&id=" + inputChannelId + "&key=AIzaSyAliNkHr1GFgo1Yj3b09gXZO_X1s3Lpxag";
        JSONObject myResponseChannelName = makingGetRequest(urlAddressToChannelName);
        JSONArray itemsChannelName = new JSONArray(myResponseChannelName.getJSONArray("items").toString());
        JSONObject snippet = new JSONObject(itemsChannelName.getJSONObject(0).getJSONObject("snippet").toString());
        String channelTitle = snippet.getString("title");
        String profilePictureUrl = snippet.getJSONObject("thumbnails").getJSONObject("default").getString("url");
        String publishedAt = snippet.getString("publishedAt");
        String dateOfPublish = formatDate(publishedAt);
        channelData.add(channelTitle);
        channelData.add(dateOfPublish);
        channelData.add(profilePictureUrl);
        return channelData;

    }
    
    public static ArrayList<String> getChannelStatistics(String inputChannelId) throws Exception {
        ArrayList<String> basicChannelData = new ArrayList();
        String urlAddress = "https://www.googleapis.com/youtube/v3/channels?part=statistics&id=" + inputChannelId + "&key=AIzaSyAliNkHr1GFgo1Yj3b09gXZO_X1s3Lpxag";

        JSONObject myResponse = makingGetRequest(urlAddress);

        JSONArray items = new JSONArray(myResponse.getJSONArray("items").toString());

        JSONObject statistics = new JSONObject(items.getJSONObject(0).getJSONObject("statistics").toString());
        String viewCount = statistics.getString("viewCount");
        String subscriberCount = statistics.getString("subscriberCount");
        String videoCount = statistics.getString("videoCount");

        basicChannelData.add(subscriberCount);
        basicChannelData.add(viewCount);
        basicChannelData.add(videoCount);

        return basicChannelData;

    }
    
     public static void addToVideosTable(ArrayList<String> allVideoIds, ArrayList<String> allVideoTitles, ArrayList<String> allViewCountOfVideo,  ArrayList<String> allLikeCountOfVideo,  ArrayList<String> allDislikeCountOfVideo,  ArrayList<String> allCommentCountOfVideo, ArrayList<String> allPublishDatesOfVideo)
    {
        try {

            Connection con = createDatabaseConnection();

            PreparedStatement dropTableIfExists = con.prepareStatement("drop table if exists videos;");
            dropTableIfExists.executeUpdate();
            
            

            PreparedStatement createVideosTable = con.prepareStatement("create table if not exists videos(videoId varchar(30) not null primary key, title varchar(100) not null, viewCount integer not null, likeCount integer not null, dislikeCount integer not null, commentCount integer not null, publishedAt varchar(30) not null)");
            createVideosTable.executeUpdate();

            for (int i = 0; i < allVideoIds.size(); ++i) {
               // String dateOfPublish = formatDate(allPublishDatesOfVideo.get(i));
                PreparedStatement insertDataToTable = con.prepareStatement("insert into videos (videoId,title,viewCount,likeCount,dislikeCount,commentCount,publishedAt) values(?,?,?,?,?,?,?)");
                insertDataToTable.setString(1, allVideoIds.get(i));
                insertDataToTable.setString(2, allVideoTitles.get(i));
                insertDataToTable.setString(3, allViewCountOfVideo.get(i));
                insertDataToTable.setString(4, allLikeCountOfVideo.get(i));
                insertDataToTable.setString(5, allDislikeCountOfVideo.get(i));
                insertDataToTable.setString(6, allCommentCountOfVideo.get(i));
                //insertDataToTable.setString(7, dateOfPublish);
                insertDataToTable.setString(7, allPublishDatesOfVideo.get(i));
                insertDataToTable.executeUpdate();
            }

        } catch (SQLException ex) {
            Logger.getLogger(DataMining.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
     public static void addToCommentsTable(ArrayList<String> videoId, ArrayList<String> comment, ArrayList<Integer> likeCount, ArrayList<Integer> commentId, ArrayList<String> publishedAt, ArrayList<String> language, ArrayList<String> channelId, ArrayList<Integer> sentiment) {
       
         try {

             Connection con = createDatabaseConnection();
             PreparedStatement truncateTable = con.prepareStatement("truncate table `comments`");
             truncateTable.executeUpdate();

             for (int i = 0; i < comment.size(); ++i) {
                 /*PreparedStatement formatDate = con.prepareStatement("select date (?)");
                 formatDate.setString(1, publishedAt.get(i));
                 ResultSet resultSet = formatDate.executeQuery();
                 String dateOfPublish = null;
                 if (resultSet.next()) {
                     dateOfPublish = resultSet.getString(1);
                 }*/

                 PreparedStatement preparedStatement = con.prepareStatement("insert into comments (videoId,text,likeCount,commentsId,publishedAt,language,authorChannelId,sentimentScore) values(?,?,?,?,?,?,?,?)");
                 preparedStatement.setString(1, videoId.get(i));
                 preparedStatement.setString(2, comment.get(i));
                 preparedStatement.setInt(3, likeCount.get(i));
                 preparedStatement.setInt(4, commentId.get(i));
                // preparedStatement.setString(5, dateOfPublish);
                 preparedStatement.setString(5, publishedAt.get(i));
                 preparedStatement.setString(6, language.get(i));
                 preparedStatement.setString(7, channelId.get(i));
                 preparedStatement.setInt(8, sentiment.get(i));
                 preparedStatement.executeUpdate();

             }

         } catch (SQLException ex) {
             Logger.getLogger(DataMining.class.getName()).log(Level.SEVERE, null, ex);
         }

    }

    public static String detectLanguage(String text) throws LangDetectException {

        String langDetected = null;

        String filterEmojisRegex = "([\\u20a0-\\u32ff\\ud83c\\udc00-\\ud83d\\udeff\\udbb9\\udce5-\\udbb9\\udcee])";

        String result2 = text.replaceAll(filterEmojisRegex, "");

        if (result2.length() == 0 || result2.matches(".") || result2.matches("--------->") || text.matches("...") || text.matches("<3<3") || text.matches(":\\)") || result2.matches("2:04 689...") || text.matches("[0-9]+")) {

            langDetected = null;

        } else {

            try {

                detector = DetectorFactory.create();
                detector.append(result2);
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
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/algorythmicsdb", "root", "ijo435aha373");
        
        return connection;
    }
    
    public static ArrayMap<String, Integer> getDataFromVideosTable() throws SQLException {
        ArrayMap<String, Integer> titleViewPairs = new ArrayMap<>();
        Connection connection = createDatabaseConnection();
        PreparedStatement getVideoTitlesAndViews = connection.prepareStatement("select title, viewCount from videos;");
        ResultSet resultSet = getVideoTitlesAndViews.executeQuery();
        while (resultSet.next()) {
            String title = resultSet.getString(1);
            Integer numberOfViews = resultSet.getInt(2);
            titleViewPairs.put(title, numberOfViews);
        }

        return titleViewPairs;
    }
    
    public static void selectCountryNamesFromComments() throws SQLException {
        ArrayList<String> comments = new ArrayList();

        Connection connection = createDatabaseConnection();
        PreparedStatement getVideoTitlesAndViews = connection.prepareStatement("select text from comments where language = 'en';");
        ResultSet resultSet = getVideoTitlesAndViews.executeQuery();
        while (resultSet.next()) {
            String text = resultSet.getString(1);
            comments.add(text);
            /* Pattern pattern = Pattern.compile(filterCountriesRegex, Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(text);
            if (matcher.matches()) {
                System.out.println(text);
            }*/

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
    
    public static int[] getSentimentScorePercentage() throws SQLException {
        Integer positiveCommentCount = 0, neutralCommentCount = 0, negativeCommentCount = 0;

        Connection connection = createDatabaseConnection();
        PreparedStatement numberOfPositiveComments = connection.prepareStatement("select count(commentsId) from comments where sentimentScore = 3 or sentimentScore = 4;");
        PreparedStatement numberOfNeutralComments = connection.prepareStatement("select count(commentsId) from comments where sentimentScore = 2;");
        PreparedStatement numberOfNegativeComments = connection.prepareStatement("select count(commentsId) from comments where sentimentScore = 0 or sentimentScore = 1;");
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
    
     public static ArrayMap<String, Integer> getEachLanguageCount() throws SQLException {
        ArrayMap<String, Integer> languageNumberPairs = new ArrayMap<>();
        Connection connection = createDatabaseConnection();
        PreparedStatement getLanguagesAndCounts = connection.prepareStatement("select language, count(videoId) from comments group by language;");
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
     
     public static ArrayMap <String, Integer> calculateDuration() throws SQLException
     {
        ArrayMap <String, Integer> videoWeekOfMostCommentsPairs = new ArrayMap<>();
        ArrayList<Long> daysBetweenVideoAndComments = new ArrayList<>();
        long daysBetween = 0; Integer maxIndex = 0;
        
        Instant publishedDateOfVideoInstant, publishDateOfCorrespondingCommentInstant;
        String publishedAt, videoId, publishedAtForComment, title;

        Connection connection = createDatabaseConnection();

        PreparedStatement getPublishDateOfVideo = connection.prepareStatement("select title, videoId, publishedAt from videos;");
        ResultSet resultSetForPublishDate = getPublishDateOfVideo.executeQuery();
        while (resultSetForPublishDate.next()) {
            
            title = resultSetForPublishDate.getString(1);
            videoId = resultSetForPublishDate.getString(2);
            publishedAt = resultSetForPublishDate.getString(3);
            //System.out.println(videoId + " " + title + " " + publishedAt);
            publishedDateOfVideoInstant = Instant.parse(publishedAt);
            
            PreparedStatement getPublishDateOfCorrespondingComment = connection.prepareStatement("select publishedAt from comments where videoId = ?");
            getPublishDateOfCorrespondingComment.setString(1, videoId);
            ResultSet resultSetForPublishDateOfCorrespondingComment = getPublishDateOfCorrespondingComment.executeQuery();
            
            while (resultSetForPublishDateOfCorrespondingComment.next()) {
                
                publishedAtForComment = resultSetForPublishDateOfCorrespondingComment.getString(1);
                publishDateOfCorrespondingCommentInstant = Instant.parse(publishedAtForComment);
                daysBetween = ChronoUnit.DAYS.between(publishedDateOfVideoInstant, publishDateOfCorrespondingCommentInstant);
                daysBetweenVideoAndComments.add(daysBetween);
                Collections.sort(daysBetweenVideoAndComments);
                //System.out.println(ChronoUnit.DAYS.between(publishedDateOfVideoInstant, publishDateOfCorrespondingCommentInstant));
                //System.out.println(publishedAtForComment);
            }
           // System.out.println(daysBetweenVideoAndComments);          
           ArrayList<Integer> numberOfOccurances = new ArrayList<>();
           numberOfOccurances = determineRange(daysBetweenVideoAndComments);
           maxIndex = determineMaxValueOfWeek(numberOfOccurances);
          // System.out.println(numberOfOccurances);System.out.println(maxIndex);
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
    
  
    /*private Credential generateCredentialWithUserApprovedToken() throws IOException,GeneralSecurityException {
        
        JacksonFactory jsonFactory = JacksonFactory.getDefaultInstance();
        HttpTransport httpTransport = GoogleNetHttpTransport.newTrustedTransport();
       
        InputStreamReader inputStreamReader =
            new InputStreamReader(jsonFileResourceForClient.getInputStream());
        GoogleClientSecrets clientSecrets = GoogleClientSecrets.load(jsonFactory, inputStreamReader);
        return new GoogleCredential.Builder().setTransport(httpTransport).setJsonFactory(jsonFactory)
            .setClientSecrets(clientSecrets).build().setRefreshToken(REFRESH_TOKEN);
  }*/
}