
package allamvizsga;

import static allamvizsga.DataMining.createDatabaseConnection;
import edu.stanford.nlp.util.ArrayMap;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.io.IOException;
import static java.lang.System.in;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.paint.Color;
import javax.imageio.ImageIO;
import javax.json.JsonValue.ValueType;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.border.Border;
import static jdk.nashorn.internal.objects.NativeArray.map;
import static jdk.nashorn.internal.objects.NativeDebug.map;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.PieSectionLabelGenerator;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.RingPlot;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;


public class Form extends javax.swing.JFrame {

    ArrayList<Double> earningsResult = new ArrayList<>();
    
    public Form() {
        initComponents();
    }

    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        label1 = new java.awt.Label();
        inputChannelUrl = new javax.swing.JTextField();
        submitButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        answer = new javax.swing.JLabel();
        publishDate = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        analysisPanel = new javax.swing.JPanel();
        subscriberCount = new javax.swing.JLabel();
        totalVideoViews = new javax.swing.JLabel();
        uploadedVideoNumber = new javax.swing.JLabel();
        estimatedEarning = new javax.swing.JLabel();
        profilePictureOfChannel = new javax.swing.JLabel();

        label1.setText("label1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        inputChannelUrl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputChannelUrlActionPerformed(evt);
            }
        });

        submitButton.setText("SUBMIT");
        submitButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                submitButtonActionPerformed(evt);
            }
        });

        jLabel1.setText("YouTube channel ID");

        answer.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        answer.setText("Title");

        publishDate.setBorder(javax.swing.BorderFactory.createTitledBorder("Publish Date"));

        analysisPanel.setBackground(new java.awt.Color(0, 0, 0));
        analysisPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("ANALYSIS"));
        analysisPanel.setForeground(new java.awt.Color(255, 255, 255));
        analysisPanel.setLayout(new javax.swing.BoxLayout(analysisPanel, javax.swing.BoxLayout.LINE_AXIS));
        jScrollPane1.setViewportView(analysisPanel);

        subscriberCount.setBorder(javax.swing.BorderFactory.createTitledBorder("Subscribers"));

        totalVideoViews.setBorder(javax.swing.BorderFactory.createTitledBorder("Total Views"));

        uploadedVideoNumber.setBorder(javax.swing.BorderFactory.createTitledBorder("Uploads"));

        estimatedEarning.setBorder(javax.swing.BorderFactory.createTitledBorder("Estimated Worth"));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(6, 6, 6)
                                            .addComponent(inputChannelUrl, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(answer, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(profilePictureOfChannel, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(publishDate, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(subscriberCount, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGap(79, 79, 79)
                                        .addComponent(submitButton))
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGap(63, 63, 63)
                                        .addComponent(totalVideoViews, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(76, 76, 76)
                                        .addComponent(uploadedVideoNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(estimatedEarning, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 145, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inputChannelUrl, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(submitButton)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(uploadedVideoNumber))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(profilePictureOfChannel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(answer, javax.swing.GroupLayout.DEFAULT_SIZE, 73, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(subscriberCount)
                            .addComponent(publishDate)
                            .addComponent(totalVideoViews))))
                .addGap(18, 18, 18)
                .addComponent(estimatedEarning)
                .addGap(27, 27, 27)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 562, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void inputChannelUrlActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputChannelUrlActionPerformed

    }//GEN-LAST:event_inputChannelUrlActionPerformed

    private void submitButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_submitButtonActionPerformed
       
        /* 
         outputting the channel nanme 
         and the publish date of the channel
         */
        String inputID = this.inputChannelUrl.getText();
        addToChannelsTable(inputID);
        
        ArrayList<String> basicChannelStatistics = new ArrayList();
        ArrayList<String> channelData = new ArrayList();
        try {
            basicChannelStatistics = DataMining.getChannelStatistics(inputID);
            channelData = DataMining.getChannelTitleAndProfilePic(inputID);
            
        } catch (Exception ex) {
            Logger.getLogger(Form.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        this.answer.setText("Channel Title: " + channelData.get(0));
        this.publishDate.setText(channelData.get(1));
        this.subscriberCount.setText(basicChannelStatistics.get(0));
        this.totalVideoViews.setText(basicChannelStatistics.get(1));
        this.uploadedVideoNumber.setText(basicChannelStatistics.get(2));
        
        earningsResult = countLowerAndUpperBoundOfEarnings(basicChannelStatistics);
        
        this.estimatedEarning.setText("$" + String.valueOf(earningsResult.get(0)) + " - $" + String.valueOf(earningsResult.get(1)));
        
        URL url = null;
        String profilePictureUrl = channelData.get(2);
        Image image = null;
        try {
            //this.profilePictureOfChannel.setSize(20, 20);
            url = new URL(profilePictureUrl);
            image = ImageIO.read(url);
        
            this.profilePictureOfChannel.setIcon(new ImageIcon(image));

        } catch (MalformedURLException ex) {
            Logger.getLogger(Form.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Form.class.getName()).log(Level.SEVERE, null, ex);
        }
        
            
        /*
        outputting the channel's video titles 
        and the number of views of each
        */
        
        DefaultCategoryDataset defaultCategoryDataset =  new DefaultCategoryDataset();
        ArrayMap<String, Integer> titleViewPairs = new ArrayMap();
        try {
            titleViewPairs = DataMining.getDataFromVideosTable(inputID);
        } catch (SQLException ex) {
            Logger.getLogger(Form.class.getName()).log(Level.SEVERE, null, ex);
        }

        titleViewPairs.entrySet().forEach(entry->{
            //System.out.println(entry.getKey() + " " + entry.getValue());
            defaultCategoryDataset.setValue(entry.getValue(), "Marks", entry.getKey());
        });

        JFreeChart jchart = ChartFactory.createBarChart("Video Statistics", "Video Title", "Number of Views", defaultCategoryDataset, PlotOrientation.VERTICAL, true, true, false);
        CategoryPlot plot = jchart.getCategoryPlot();
        //plot.setRangeGridlinePaint(Color.black);
        ChartFrame chartFrame = new ChartFrame("Video Statistics", jchart, true);
        //chartFrame.setVisible(true);
        chartFrame.setSize(500, 400);
     
        /*
        Pie chart for sentiment scores of 
        the english comments
        */
        DefaultPieDataset defaultPieDataset =  new DefaultPieDataset();
        
        int[] countOfSentimentScores = new int[3];
        
        try {
            countOfSentimentScores = DataMining.getSentimentScorePercentage();
        } catch (SQLException ex) {
            Logger.getLogger(Form.class.getName()).log(Level.SEVERE, null, ex);
        }
        defaultPieDataset.setValue("Positive", countOfSentimentScores[0]);
        defaultPieDataset.setValue("Neutral", countOfSentimentScores[1]);
        defaultPieDataset.setValue("Negative", countOfSentimentScores[2]);
        
        JFreeChart pieChartForSentiment = ChartFactory.createPieChart("Sentiment Scores", defaultPieDataset, true, true, false);
        PiePlot piePlot = (PiePlot) pieChartForSentiment.getPlot();
        piePlot.setSimpleLabels(true);
        
       
        PieSectionLabelGenerator pieLabelGenerator = new StandardPieSectionLabelGenerator(
            "{0}: {1} ({2})", new DecimalFormat("0"), new DecimalFormat("0.0%"));
        piePlot.setLabelGenerator(pieLabelGenerator);
        
        JFrame pieChartFrame = new JFrame("Test");
        pieChartFrame.setSize(500, 400);
       
        /*
        Pie chart for percentage
        of each languages of comments
        */
        DefaultPieDataset pieDatasetForLanguages =  new DefaultPieDataset();
        ArrayMap<String, Integer> languageNumberPairs = new ArrayMap();
        try {
            languageNumberPairs = DataMining.getEachLanguageCount();
        } catch (SQLException ex) {
            Logger.getLogger(Form.class.getName()).log(Level.SEVERE, null, ex);
        }
        languageNumberPairs.entrySet().forEach(entry->{
            
            pieDatasetForLanguages.setValue(entry.getKey(), entry.getValue());
        });
        
        JFreeChart pieChartForLanguages = ChartFactory.createPieChart("Language Percentage Of Comments", pieDatasetForLanguages, true, true, false);
        PiePlot piePlotForLanguages = (PiePlot) pieChartForLanguages.getPlot();
        piePlotForLanguages.setSimpleLabels(true);
        
       
        PieSectionLabelGenerator pieLabelGeneratorForLanguages = new StandardPieSectionLabelGenerator(
            "{0}: {1} ({2})", new DecimalFormat("0"), new DecimalFormat("0.0%"));
        piePlotForLanguages.setLabelGenerator(pieLabelGeneratorForLanguages);
        
        JFrame pieChartFrameForLanguages = new JFrame("Test");
        pieChartFrameForLanguages.setSize(500, 400);
        
        /*
        The week in wich the most comments arrived
        */
        
        DefaultPieDataset pieDatasetForCommentTime = new DefaultPieDataset();
        ArrayMap<String, Integer> videoWeekOfMostCommentsPairs = new ArrayMap();
        Integer counter = 0;
        ArrayList<Integer> arrayOfWeekWithMostComments = new ArrayList<Integer>();
       
        try {
            videoWeekOfMostCommentsPairs = DataMining.calculateDuration();
        } catch (SQLException ex) {
            Logger.getLogger(Form.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        videoWeekOfMostCommentsPairs.forEach((key, value) -> arrayOfWeekWithMostComments.add(value));
        
       for (Map.Entry<String, Integer> entry : videoWeekOfMostCommentsPairs.entrySet()) {
           
           counter = countOccurancesOfEachWeek(entry.getValue(),arrayOfWeekWithMostComments);
           pieDatasetForCommentTime.setValue("number of week: " + entry.getValue() , counter);
          
       }
        
        JFreeChart pieChartForComments = ChartFactory.createRingChart("Week of most comments", pieDatasetForCommentTime, true, true, false);
        PiePlot piePlotForComments = (PiePlot) pieChartForComments.getPlot();
        piePlotForComments.setSimpleLabels(true);
        JFrame pieChartFrameForCommentTime = new JFrame("Test");
        pieChartFrameForCommentTime.setSize(500, 400);
       
        /* 
         adding the charts to the analysisPanel
        */
        ChartPanel chartPanel = new ChartPanel(jchart);
        ChartPanel pieChartPanel = new ChartPanel(pieChartForSentiment);
        ChartPanel pieChartPanelForLanguages = new ChartPanel(pieChartForLanguages);
        ChartPanel pieChartPanelForComments = new ChartPanel(pieChartForComments);
        analysisPanel.removeAll();
        analysisPanel.add(chartPanel);
        analysisPanel.add(pieChartPanel);
        analysisPanel.add(pieChartPanelForLanguages);
        analysisPanel.add(pieChartPanelForComments);
        
        analysisPanel.updateUI();

    }//GEN-LAST:event_submitButtonActionPerformed

    public static Integer countOccurancesOfEachWeek (Integer actualWeek, ArrayList<Integer> arrayOfWeeksWithMostComments)
    {
        int counter = 0;
        for(int j = 0;j<arrayOfWeeksWithMostComments.size();++j)
        {
            if(arrayOfWeeksWithMostComments.get(j) == actualWeek)
            {
                counter ++;
            }
        }
        return counter;
    }
    public static ArrayList<Double> countLowerAndUpperBoundOfEarnings(ArrayList<String> basicChannelStatistics)
    {
        ArrayList<Double> resultSetForEarnings = new ArrayList<>();
        Double estimatedWorthOfChannel = Double.parseDouble(basicChannelStatistics.get(1));
        estimatedWorthOfChannel = estimatedWorthOfChannel / 1000;
        Double lowerBoundOfEarning = estimatedWorthOfChannel / 2;
        Double upperBoundOfEarning = estimatedWorthOfChannel * 5;
        resultSetForEarnings.add(lowerBoundOfEarning); resultSetForEarnings.add(upperBoundOfEarning);
        return resultSetForEarnings;
    }
    public static void addToChannelsTable(String inputID) {
        try {
            Connection con = DataMining.createDatabaseConnection();
            PreparedStatement truncateTable = con.prepareStatement("INSERT INTO channels (channelId)\n"
                    + "SELECT * FROM (SELECT ?) AS tmp\n"
                    + "WHERE NOT EXISTS (\n"
                    + "    SELECT channelId FROM channels WHERE channelId = ?\n"
                    + ") LIMIT 1;");
            truncateTable.setString(1,inputID);
            truncateTable.setString(2,inputID);
            truncateTable.executeUpdate();

            /* PreparedStatement preparedStatement = con.prepareStatement("insert into channels (channelID) values(?)");
            preparedStatement.setString(1, inputID);
            preparedStatement.executeUpdate();*/
        } catch (SQLException ex) {
            Logger.getLogger(Form.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Form().setVisible(true);

            }
        });

    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel analysisPanel;
    private javax.swing.JLabel answer;
    private javax.swing.JLabel estimatedEarning;
    private javax.swing.JTextField inputChannelUrl;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private java.awt.Label label1;
    private javax.swing.JLabel profilePictureOfChannel;
    private javax.swing.JLabel publishDate;
    private javax.swing.JButton submitButton;
    private javax.swing.JLabel subscriberCount;
    private javax.swing.JLabel totalVideoViews;
    private javax.swing.JLabel uploadedVideoNumber;
    // End of variables declaration//GEN-END:variables
}
