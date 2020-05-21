
package allamvizsga;
import javax.swing.table.*;
import edu.stanford.nlp.util.ArrayMap;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Label;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.PieSectionLabelGenerator;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
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
        jLabel2 = new javax.swing.JLabel();
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
        subscriberPanel = new javax.swing.JPanel();
        subscriberPanelLabel1 = new javax.swing.JLabel();
        subscriberPanelLabel2 = new javax.swing.JLabel();
        subscriberPanelLabel3 = new javax.swing.JLabel();
        subscriberPanelLabel4 = new javax.swing.JLabel();

        label1.setText("label1");

        jLabel2.setText("jLabel2");

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

        subscriberPanel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 3));

        subscriberPanelLabel1.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        subscriberPanelLabel1.setForeground(new java.awt.Color(0, 0, 0));
        subscriberPanelLabel1.setText("AlgoRythmics");

        subscriberPanelLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        subscriberPanelLabel2.setForeground(new java.awt.Color(0, 0, 0));
        subscriberPanelLabel2.setText("should reach");

        subscriberPanelLabel3.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        subscriberPanelLabel3.setForeground(new java.awt.Color(0, 0, 0));
        subscriberPanelLabel3.setText("30800 Subscribers");

        subscriberPanelLabel4.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        subscriberPanelLabel4.setForeground(new java.awt.Color(0, 0, 0));
        subscriberPanelLabel4.setText("around May 24th 2020");

        javax.swing.GroupLayout subscriberPanelLayout = new javax.swing.GroupLayout(subscriberPanel);
        subscriberPanel.setLayout(subscriberPanelLayout);
        subscriberPanelLayout.setHorizontalGroup(
            subscriberPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(subscriberPanelLayout.createSequentialGroup()
                .addGroup(subscriberPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(subscriberPanelLayout.createSequentialGroup()
                        .addGap(131, 131, 131)
                        .addComponent(subscriberPanelLabel3))
                    .addGroup(subscriberPanelLayout.createSequentialGroup()
                        .addGap(182, 182, 182)
                        .addComponent(subscriberPanelLabel1))
                    .addGroup(subscriberPanelLayout.createSequentialGroup()
                        .addGap(208, 208, 208)
                        .addComponent(subscriberPanelLabel4))
                    .addGroup(subscriberPanelLayout.createSequentialGroup()
                        .addGap(249, 249, 249)
                        .addComponent(subscriberPanelLabel2)))
                .addContainerGap(146, Short.MAX_VALUE))
        );
        subscriberPanelLayout.setVerticalGroup(
            subscriberPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(subscriberPanelLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(subscriberPanelLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(subscriberPanelLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(subscriberPanelLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(subscriberPanelLabel4)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
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
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(63, 63, 63)
                                .addComponent(totalVideoViews, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(76, 76, 76)
                                .addComponent(uploadedVideoNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(79, 79, 79)
                                .addComponent(submitButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                                .addComponent(subscriberPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(estimatedEarning, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(inputChannelUrl, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(submitButton)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(28, 28, 28)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(profilePictureOfChannel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(answer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(subscriberCount)
                            .addComponent(publishDate)
                            .addComponent(totalVideoViews)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(subscriberPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(uploadedVideoNumber)))
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
       
       
        String inputID = this.inputChannelUrl.getText();
        addToChannelsTable(inputID);
        
        OutputChannelDataOnPanel(inputID);
        //CollectData(inputID);
            
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
            defaultCategoryDataset.setValue(entry.getValue(), "View Count", entry.getKey());
        });

        JFreeChart jchart = ChartFactory.createBarChart("View Count of Videos", "Video Title", "Number of Views", defaultCategoryDataset, PlotOrientation.VERTICAL, true, true, false);
        CategoryPlot plot = jchart.getCategoryPlot();
        
        ChartFrame chartFrame = new ChartFrame("View Count of Videos", jchart, true);
        //chartFrame.setVisible(true);
        chartFrame.setSize(500, 400);
     
        /*
        Pie chart for sentiment scores of 
        the english comments
        */
        DefaultPieDataset defaultPieDataset =  new DefaultPieDataset();
        
        int[] countOfSentimentScores = new int[3];
        
        try {
            countOfSentimentScores = DataMining.getSentimentScorePercentage(inputID);
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
            languageNumberPairs = DataMining.getEachLanguageCount(inputID);
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
        
       /* JFrame pieChartFrameForLanguages = new JFrame("Test");
        pieChartFrameForLanguages.setSize(500, 400);*/
        
        /*
        The week in wich the most comments arrived
        */
        
        DefaultPieDataset pieDatasetForCommentTime = new DefaultPieDataset();
        ArrayMap<String, Integer> videoWeekOfMostCommentsPairs = new ArrayMap();
        Integer counter = 0;
        ArrayList<Integer> arrayOfWeekWithMostComments = new ArrayList<Integer>();
       
        try {
            videoWeekOfMostCommentsPairs = DataMining.calculateDuration(inputID);
        } catch (SQLException ex) {
            Logger.getLogger(Form.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        videoWeekOfMostCommentsPairs.forEach((key, value) -> arrayOfWeekWithMostComments.add(value));
        
       for (Map.Entry<String, Integer> entry : videoWeekOfMostCommentsPairs.entrySet()) {
           
           //System.out.println(entry.getKey() + " " + entry.getValue());
           counter = countOccurancesOfEachWeek(entry.getValue(),arrayOfWeekWithMostComments);
           pieDatasetForCommentTime.setValue("number of week: " + entry.getValue() , counter);
          
       }
        
        JFreeChart pieChartForComments = ChartFactory.createRingChart("Week of most comments", pieDatasetForCommentTime, true, true, false);
        PiePlot piePlotForComments = (PiePlot) pieChartForComments.getPlot();
        piePlotForComments.setSimpleLabels(true);
       
        /*
       View - Like Ratio
       */
        DefaultCategoryDataset defaultRatioDataset =  new DefaultCategoryDataset();
        ArrayMap<String, Double> viewLikeRatios = new ArrayMap();
        try {
            viewLikeRatios = DataMining.getViewAndLikeRatio(inputID);
        } catch (SQLException ex) {
            Logger.getLogger(Form.class.getName()).log(Level.SEVERE, null, ex);
        }

        viewLikeRatios.entrySet().forEach(entry->{
            defaultRatioDataset.setValue(entry.getValue(), "View - Like Ratio", entry.getKey());
        });

        JFreeChart jchartRatio = ChartFactory.createBarChart("View - Like Ratio of Videos", "Video Title", "Ratio", defaultRatioDataset, PlotOrientation.VERTICAL, true, true, false);
        CategoryPlot plotRatio = jchartRatio.getCategoryPlot();
        
         /*
       View - Dislike Ratio
       */
        DefaultCategoryDataset defaultDislikeRatioDataset =  new DefaultCategoryDataset();
        ArrayMap<String, Double> viewDislikeRatios = new ArrayMap();
        try {
            viewDislikeRatios = DataMining.getViewAndDislikeRatio(inputID);
        } catch (SQLException ex) {
            Logger.getLogger(Form.class.getName()).log(Level.SEVERE, null, ex);
        }

        viewDislikeRatios.entrySet().forEach(entry->{
            
            defaultDislikeRatioDataset.setValue(entry.getValue(), "View - Dislikeike Ratio", entry.getKey());
        });

        JFreeChart jchartDislikeRatio = ChartFactory.createBarChart("View - Dislike Ratio of Videos", "Video Title", "Ratio", defaultDislikeRatioDataset, PlotOrientation.VERTICAL, true, true, false);
        CategoryPlot plotDislikeRatio = jchartDislikeRatio.getCategoryPlot();
        
        CategoryPlot plotDislike = jchartDislikeRatio.getCategoryPlot();
        BarRenderer barRenderer = (BarRenderer)plotDislike.getRenderer();
        barRenderer.setSeriesPaint(0, Color.BLUE);
        
        
        /*
        WORD CLOUD
        */
      
        JPanel wordCloudPanel = new JPanel(new GridLayout(13, 10, 3, 3));
        wordCloudPanel.setBackground(java.awt.Color.white);
        wordCloudPanel.setBorder(BorderFactory.createLineBorder(Color.black));
        wordCloudPanel.setBorder (BorderFactory.createTitledBorder (BorderFactory.createEtchedBorder (),
                                                            "Occurances of words in most watched video",
                                                            TitledBorder.CENTER,
                                                            TitledBorder.TOP));
       
         ArrayList<String> arr = new ArrayList<>();
         HashMap<String,Integer> words = new HashMap<String,Integer>();
        try {
            arr = WordCloud.getEnglishCommentsFromDatabase(inputID);
        } catch (SQLException ex) {
            Logger.getLogger(Form.class.getName()).log(Level.SEVERE, null, ex);
        }
         words = WordCloud.countOccurancesofWords(arr);
          for (Map.Entry<String, Integer> en : words.entrySet()) { 
              if(en.getValue() > 7 )
                {
                    JLabel word = new JLabel();
                    word = WordCloud.SetSizeOfWords(en.getKey(),en.getValue());               
                    wordCloudPanel.add(word);                 
                }       
          }
          
          /*
          Frequent transactions(video pairs) with Apriori
          */
          
          JPanel tablePanel = new JPanel (new GridBagLayout());
          GridBagConstraints gbc = new GridBagConstraints();
          gbc.fill = GridBagConstraints.BOTH;
          gbc.weightx = 1;
          gbc.weighty = 0;
          
          tablePanel.setBorder (BorderFactory.createTitledBorder (BorderFactory.createEtchedBorder (),
                                                            "Most frequent Videos that has been commented on",
                                                            TitledBorder.CENTER,
                                                            TitledBorder.TOP));
        ArrayList<ArrayList<String>> mostFrequentVideos = new ArrayList<ArrayList<String>>();
         
        try {
            mostFrequentVideos = DataMining.AverageCommentNumberPerPerson(inputID);
        } catch (SQLException ex) {
            Logger.getLogger(Form.class.getName()).log(Level.SEVERE, null, ex);
        }
       
           
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Col1");
        JTable table = new JTable(model);   
        for(int i=0;i<mostFrequentVideos.size();++i){
                
                model.insertRow(i, new Object[] { mostFrequentVideos.get(i) });     
         }
       
        table.setRowHeight(60);
        table.setShowHorizontalLines(true);
        tablePanel.add(table,gbc);
        table.setFont(new Font("Arial", Font.BOLD, 12));
        
        
       /*
        When did the most comments arrived monthly 
        in each year
        */
       
        ArrayList<String> years = new ArrayList<>();
        ArrayList<HashMap<Integer, Integer>> monthsCommentsNr = new ArrayList<>();
        try {
            years = DataMining.Years(inputID);
            monthsCommentsNr = DataMining.MonthWithCommentCount2(inputID, years);
        } catch (SQLException ex) {
            Logger.getLogger(Form.class.getName()).log(Level.SEVERE, null, ex);
        }

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();

        for (int j = 0; j < monthsCommentsNr.size(); ++j) {
            HashMap<Integer, Integer> commentNrMonthPair = new HashMap();
            commentNrMonthPair = monthsCommentsNr.get(j);
            String series1 = years.get(j);
            commentNrMonthPair.entrySet().forEach(entry -> {
                try {
                    dataset.addValue(entry.getValue(), series1, DataMining.convertToMonthName(entry.getKey()));
                } catch (SQLException ex) {
                    Logger.getLogger(Form.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
        }

        JFreeChart chart = ChartFactory.createLineChart(  
        "Number of comments in each Month", // Chart title  
        "Months", // X-Axis Label  
        "Number of Comments", // Y-Axis Label  
        dataset 
        );  
    
        ArrayList<String> dateAndSubs = new ArrayList<>();
        try {
            dateAndSubs = LinearRegression.Reg(inputID);
        } catch (SQLException ex) {
            Logger.getLogger(Form.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        ArrayList<String> channelData = new ArrayList();
        try {
            channelData = DataMining.getChannelTitleAndProfilePic(inputID);
        } catch (Exception ex) {
            Logger.getLogger(Form.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        this.subscriberPanelLabel1.setText(channelData.get(0));
        this.subscriberPanelLabel2.setText("should reach");
        this.subscriberPanelLabel3.setText(dateAndSubs.get(0) + " Subscribers");
        this.subscriberPanelLabel4.setText("around " + dateAndSubs.get(1));
        
        /* 
         adding the charts to the analysisPanel
        */
        analysisPanel.setLayout(new GridLayout(4, 1));
        ChartPanel chartPanel = new ChartPanel(jchart);
        ChartPanel pieChartPanel = new ChartPanel(pieChartForSentiment);
        ChartPanel pieChartPanelForLanguages = new ChartPanel(pieChartForLanguages);
        ChartPanel pieChartPanelForComments = new ChartPanel(pieChartForComments);
        ChartPanel chartPanelRatio = new ChartPanel(jchartRatio);
        ChartPanel chartPanelDislikeRatio = new ChartPanel(jchartDislikeRatio);
        ChartPanel chartPanelMonth = new ChartPanel(chart);
        
        analysisPanel.removeAll();
        analysisPanel.add(chartPanel);
        analysisPanel.add(chartPanelRatio);
        analysisPanel.add(chartPanelDislikeRatio);
        analysisPanel.add(wordCloudPanel);
        analysisPanel.add(pieChartPanel);
        analysisPanel.add(pieChartPanelForLanguages); 
        analysisPanel.add(tablePanel);
        analysisPanel.add(pieChartPanelForComments);       
        analysisPanel.add(chartPanelMonth);
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
            PreparedStatement truncateTable = con.prepareStatement("INSERT INTO channels (channelId)\n" //inserting the chennelId into the channels table ONLY IF it doesent exist in it already
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
    public void OutputChannelDataOnPanel(String inputID)
    {
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
        
    }
    public static void CollectData(String inputID)
    {
         try {          
           // DataMining.getVideoStatistics(inputID);  
            DataMining.getCommentsAndStatistics(inputID);
            
        } catch (Exception ex) {
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
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private java.awt.Label label1;
    private javax.swing.JLabel profilePictureOfChannel;
    private javax.swing.JLabel publishDate;
    private javax.swing.JButton submitButton;
    private javax.swing.JLabel subscriberCount;
    private javax.swing.JPanel subscriberPanel;
    private javax.swing.JLabel subscriberPanelLabel1;
    private javax.swing.JLabel subscriberPanelLabel2;
    private javax.swing.JLabel subscriberPanelLabel3;
    private javax.swing.JLabel subscriberPanelLabel4;
    private javax.swing.JLabel totalVideoViews;
    private javax.swing.JLabel uploadedVideoNumber;
    // End of variables declaration//GEN-END:variables

}
