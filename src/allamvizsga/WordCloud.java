package allamvizsga;

import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import javax.swing.JLabel;


public class WordCloud {
    
    public static HashMap<String,Integer> countOccurancesofWords(ArrayList<String> text)
    {
        HashMap<String,Integer> words = new HashMap<String,Integer>();
       
        for (int i=0;i<text.size();++i)
        {
            if(text.get(i).matches(".*\\w.*"))
            {
                String word = text.get(i);
                Integer count = words.getOrDefault(word, 0);
                words.put(word,++count);
            }
               
        }
      
        return words;
    }
    
    public static ArrayList<String> getEnglishCommentsFromDatabase(String inputChannelId) throws SQLException
    {
        ArrayList<String> comments = new ArrayList<String>();
       String text,mostWatchedVideoId = null;
       String[] list = {"end","aI","algorithms","guys","dancing","notch","sorting","computer","quick","is","i","okay","youve","notched","doing","inside","hey","back","today","were","c","ill","however","s","using","same","do","anyone","quite","a","other","come","comp","lets","where","meg","used","hats","doesnt","ok","going","one","id","everytime","been","he","done","watched","nothing","says","well","years","again","sci","fi","put","took","me","boys","wins","minecraft","gay","gonna","turn","ten","o","m","anybody","variable","guy","much","more","way","dont","video","sort","not","most","now","should","see","one","know","like","i","do","so","or","x","n","p","d","you","im","i","u","a","the", "this", "is","to","of","it","and","in","my","that","have","for","they","on","with","but","be", "was","me","are","am","just","as","if" ,"an","at","than","here","ever","now","can","would","all","so","about","when","im","its","seen","your","Ive","only","really","thing","very","by","up","get","what","will","there","its","them","it","some","now","thats","who","still","actually","could","did","out","cant","you","has","we","then","didnt","their","if","because","does","and","got","next","from","whats","too","even","these","us","my","had","hat","fuck","after","sure","also","id","need","every","make","something","two","very","youre","left","fucking","both","looks","those","through","thought","many","being","made","before","things","try","list","wish","makes","which","theyre","around","shit","understood","ear","array","version","part","found","god","data","our","legnyes","wtf","im","explained","needs","imagine","until","oh","no","already","new","always","just","happens","guess","instead","can","whole","though","into","feel","thats","anything","place","zzanzare","complete","knee","go","section","show","might","came","implemented","stop","believe","may","doesent","universe","down","his","someone","means","lot","yet","probably","must","almost","working","uralkodj","withot","seeing","once","bit","big","keep","rest","name","call","of","saying","least","happening","oszd","value","clearly","cells","internet","since","man","men","kkllementi","comes","mean","point","day","having","start","items","each","want","let","worked","army","arrow","taking","thank","those","damn","reading","Hungry","while","everything","ij","over","form","heights","win","game","totally","few","sides","give","play","ass","has","such","structures","taken","java","any","my","real","ago","ive","am","theres","itself","integers","forever","someone","height","did","would","little"};
       //String[] list = {" the ", "i ", " this ", " is "," to "," a "," of "," it "," and "," in "," my "," that "," have "," for "," they "," on "," with "," but "," be "," was "," me "," are "," am "," just "," as "," if " ," an "," at "," so "," than "," here "," ever "," now "," can "," would "," d"," all "," so "," about "," when "," im "," its "," seen "," your "," Ive "," only "," really "," thing "," very "," by "," up "," get "," what "," will "," or "," there "," its "," them "," it "," some "," now "," thats "," who "," still "," actually "," could "," did "," out "," cant "," you "," has "," we "," then "," didnt "," their "," if " ," because "," does "," and "," a "," got "," next " ," from "," whats "," too "," even "," these "," us "," my "," had "," hat "," fuck "," after "," sure "," also "," id "," need "," every "," make "," something "," two "," very "," youre "," left "," fucking "," both "," looks "," those "," through "," thought "," many "," being "," made "," before "," things "," try "," list "," wish "," makes "," which "," theyre "," around "," shit "," understood "," ear "," array "," version "," part "," found "," god "," s "," data "," our "," legnyes "," wtf "," im "," explained "," needs "," imagine "," until "," oh "," no "," already "," new "," always "," just "," happens "," guess "," instead "," can "," whole "," though "," into "," feel "," thats "," anything "," place "," zzanzare "," complete "," knee "," go "," section "," show "," might "," came "," implemented "," stop "," believe "," may "," doesent "," universe "," down "," his "," someone "," means "," lot "," yet "," probably "," must "," almost "," working "," uralkodj ", " p " ," withot "," seeing "," once "," bit "," big "," keep "," rest "," name "," call "," of "," saying "," least "," happening "," oszd "," value "," clearly "," cells "," internet "," since "," man "," men "," kkllementi "," comes "," mean "," point "," day "," having "," start "," items "," each "," want "," let "," worked "," army "," arrow "," taking "," thank "," x "," n "," those "," damn "," reading "," Hungry "," while "," everything "," ij "," over "," form "," heights "," win "," game "," totally "," few "," sides "," give "," play "," ass "," has "," such "," structures "," taken "," java "," any "," my "," real "," ago "," ive "," am "," theres "," itself "," integers "," forever "," someone "," height "," did "," would "," little ","this "};

      
        Connection connection = DataMining.createDatabaseConnection();
        
        PreparedStatement getIdOfMostWatchedVideo = connection.prepareStatement("select videoId\n" +
                                                                                "from videos\n" +
                                                                                "where channelId =  ?\n" +
                                                                                "order by viewCount desc\n" +
                                                                                "limit 1;");
        getIdOfMostWatchedVideo.setString(1,inputChannelId);
        ResultSet resultSetForMostWatchedVideo = getIdOfMostWatchedVideo.executeQuery();
        if(resultSetForMostWatchedVideo.next())
        {
            mostWatchedVideoId  = resultSetForMostWatchedVideo.getString(1);
        }
        
        PreparedStatement getComments = connection.prepareStatement("select c.text \n" +
                                                                    "from comments c join videos v on c.videoId = v.videoId join  channels ch on v.channelId = ch.channelId\n" +
                                                                    "where language = 'en' and ch.channelId = ? and v.videoId = ?;");
        getComments.setString(1,inputChannelId);
        getComments.setString(2,mostWatchedVideoId);
        ResultSet resultSetForComments = getComments.executeQuery();
        
        while (resultSetForComments.next()) {
            text = resultSetForComments.getString(1);
            text = text.toLowerCase();
            text = text.replaceAll("[^a-zA-Z ]", "");
            for (String s : list) {
                String tempWord = " " + s + " "; // the case in wich the searched word is somewhere in the middle of the sentence
               // String tempWord2 = s + " "; 
                if (text.contains(tempWord)) {
                   
                    text = text.replaceAll(tempWord, " ");  
                    
                }
                /*
                covering the cases where the searched word is in the beginning
                or at the end of the sentence
                */
                if(text.contains("this"))  
                    text = text.replace("this", " ");   
                if(text.contains("thats "))               
                    text = text.replace("thats ", " ");   
                if(text.contains("take "))               
                    text = text.replace("take ", " ");  
                if(text.contains("one "))               
                    text = text.replace("one ", " ");  
                if(text.contains("they "))               
                    text = text.replace("they ", " ");  
                /*if(text.contains("it "))               
                    text = text.replace("it ", " ");  */
                 if(text.contains("im "))               
                    text = text.replace("im ", " ");  
                if(text.contains("i "))                
                    text = text.replace("i ", " ");
                if(text.contains("is "))                
                    text = text.replace("is ", " ");
                if(text.contains("thank "))                
                    text = text.replace("thank ", " ");
               /* if(text.contains("and "))                
                    text = text.replace("and ", " ");*/
                 if(text.contains("my "))               
                    text = text.replace("my ", " ");          
                if(text.contains("its "))              
                    text = text.replace("its "," ");               
                if(text.contains("the "))               
                    text = text.replace("the ", " ");                           
                if(text.contains("so "))             
                    text = text.replace("so ", " ");  
                if(text.endsWith(" d"))
                    text = text.replace(" d", " ");
                if(text.endsWith(" here"))
                    text = text.replace(" here", " ");
                if(text.endsWith(" it"))
                    text = text.replace(" it", " ");                  
            }
 
            String[] arr = text.split(" ");
            for ( String ss : arr) {
                comments.add(ss);
            }
        }
      
       return comments;
    }
    
     public static HashMap<String, Integer> sortByValue(HashMap<String, Integer> hm) 
    { 
        // Create a list from elements of HashMap 
        List<Map.Entry<String, Integer> > list = 
               new LinkedList<Map.Entry<String, Integer> >(hm.entrySet()); 
  
        // Sort the list 
        Collections.sort(list, new Comparator<Map.Entry<String, Integer> >() { 
            public int compare(Map.Entry<String, Integer> o1,  
                               Map.Entry<String, Integer> o2) 
            { 
                return (o1.getValue()).compareTo(o2.getValue()); 
            } 
        }); 
          
        // put data from sorted list to hashmap  
        HashMap<String, Integer> temp = new LinkedHashMap<String, Integer>(); 
        for (Map.Entry<String, Integer> aa : list) { 
            temp.put(aa.getKey(), aa.getValue()); 
        } 
        return temp; 
    } 
     
    public static JLabel SetSizeOfWords(String word, Integer occurance) {
        
        JLabel actWord = new JLabel();
        
        if (occurance <= 10) {

            actWord.setFont(new Font(Font.DIALOG, Font.BOLD, 10));
            actWord.setText(word);
            return actWord;

        }
        if (occurance <= 14 && occurance > 10) {

            actWord.setFont(new Font(Font.DIALOG, Font.BOLD, 11));
            actWord.setText(word);
            return actWord;

        }
        if (occurance <= 18 && occurance > 14) {

            actWord.setFont(new Font(Font.DIALOG, Font.BOLD, 12));
            actWord.setText(word);
            return actWord;

        }

        if (occurance <= 22 && occurance > 18) {

            actWord.setFont(new Font(Font.DIALOG, Font.BOLD, 13));
            actWord.setText(word);
            return actWord;

        }
        if (occurance <= 27 && occurance > 22) {

            actWord.setFont(new Font(Font.DIALOG, Font.BOLD, 15));
            actWord.setText(word);
            return actWord;

        }

        if (occurance <= 35 && occurance > 27) {

            actWord.setFont(new Font(Font.DIALOG, Font.BOLD, 16));
            actWord.setText(word);
            return actWord;

        }
        if (occurance <= 40 && occurance > 35) {

            actWord.setFont(new Font(Font.DIALOG, Font.BOLD, 17));
            actWord.setText(word);
            return actWord;

        }
        if (occurance <= 50 && occurance > 40) {

            actWord.setFont(new Font(Font.DIALOG, Font.BOLD, 18));
            actWord.setText(word);
            return actWord;

        }
        if (occurance <= 60 && occurance > 50) {

            actWord.setFont(new Font(Font.DIALOG, Font.BOLD, 19));
            actWord.setText(word);
            return actWord;

        }
        if (occurance <= 70 && occurance > 60) {

            actWord.setFont(new Font(Font.DIALOG, Font.BOLD, 20));
            actWord.setText(word);
            return actWord;
        }
        if (occurance <= 80 && occurance > 70) {

            actWord.setFont(new Font(Font.DIALOG, Font.BOLD, 21));
            actWord.setText(word);
            return actWord;
        }

        if (occurance <= 90 && occurance > 80) {

            actWord.setFont(new Font(Font.DIALOG, Font.BOLD, 22));
            actWord.setText(word);
            return actWord;

        }
        if (occurance <= 100 && occurance > 90) {

            actWord.setFont(new Font(Font.DIALOG, Font.BOLD, 23));
            actWord.setText(word);
            return actWord;

        }
        if (occurance > 100) {

            actWord.setFont(new Font(Font.DIALOG, Font.BOLD, 24));
            actWord.setText(word);
            return actWord;

        }

        return actWord;

    }

}
