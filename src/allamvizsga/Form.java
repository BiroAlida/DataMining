
package allamvizsga;
import javax.swing.table.*;
import edu.stanford.nlp.util.ArrayMap;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Label;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.font.TextAttribute;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.chart.Axis;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.StackedBarChart;
import javafx.scene.chart.XYChart;
import static javafx.scene.paint.Color.color;
import javafx.stage.Stage;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.Renderer;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.AxisLocation;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.NumberTickUnit;
import org.jfree.chart.axis.SymbolAxis;
import org.jfree.chart.axis.TickUnit;
import org.jfree.chart.axis.TickUnits;
import org.jfree.chart.labels.PieSectionLabelGenerator;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.Plot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.PolarPlot;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DatasetUtilities;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.xy.DefaultXYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.RefineryUtilities;


public class Form extends javax.swing.JFrame {

    ArrayList<Double> earningsResult = new ArrayList<>();
    
    public Form() {
        initComponents();
        /*showHintLabel.addMouseListener(new MouseAdapter() {
         public void mouseEntered(MouseEvent evt) {
            imgLabel.setVisible(true);
            imgLabel.setText("itt");
         }
         public void mouseExited(MouseEvent evt) {
            imgLabel.setVisible(false);
         }
      });*/
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
        showHintLabel = new javax.swing.JLabel();
        imgLabel = new javax.swing.JLabel();

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

        subscriberPanel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        subscriberPanelLabel1.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        subscriberPanelLabel1.setForeground(new java.awt.Color(0, 0, 0));

        subscriberPanelLabel2.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        subscriberPanelLabel2.setForeground(new java.awt.Color(0, 0, 0));

        subscriberPanelLabel3.setFont(new java.awt.Font("Dialog", 1, 36)); // NOI18N
        subscriberPanelLabel3.setForeground(new java.awt.Color(0, 0, 0));

        subscriberPanelLabel4.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        subscriberPanelLabel4.setForeground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout subscriberPanelLayout = new javax.swing.GroupLayout(subscriberPanel);
        subscriberPanel.setLayout(subscriberPanelLayout);
        subscriberPanelLayout.setHorizontalGroup(
            subscriberPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(subscriberPanelLayout.createSequentialGroup()
                .addGroup(subscriberPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(subscriberPanelLayout.createSequentialGroup()
                        .addGap(131, 131, 131)
                        .addComponent(subscriberPanelLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(subscriberPanelLayout.createSequentialGroup()
                        .addGap(182, 182, 182)
                        .addComponent(subscriberPanelLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(subscriberPanelLayout.createSequentialGroup()
                        .addGap(208, 208, 208)
                        .addComponent(subscriberPanelLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(subscriberPanelLayout.createSequentialGroup()
                        .addGap(249, 249, 249)
                        .addComponent(subscriberPanelLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(146, Short.MAX_VALUE))
        );
        subscriberPanelLayout.setVerticalGroup(
            subscriberPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(subscriberPanelLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addComponent(subscriberPanelLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(subscriberPanelLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(subscriberPanelLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(subscriberPanelLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                .addContainerGap(46, Short.MAX_VALUE))
        );

        showHintLabel.setText("Show hint");
        showHintLabel.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseMoved(java.awt.event.MouseEvent evt) {
                showHintLabelMouseMoved(evt);
            }
        });
        showHintLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                showHintLabelMouseClicked(evt);
            }
        });

        imgLabel.setIcon(new javax.swing.ImageIcon("C:\\Users\\Alida\\Desktop\\Datamining Pics\\id.png")); // NOI18N
        imgLabel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        imgLabel.setVisible(false);

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
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(45, 45, 45)
                                .addComponent(totalVideoViews, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(76, 76, 76)
                                .addComponent(uploadedVideoNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(showHintLabel)
                                        .addGap(43, 43, 43)
                                        .addComponent(submitButton))
                                    .addComponent(imgLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 510, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 106, Short.MAX_VALUE)
                                .addComponent(subscriberPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addComponent(estimatedEarning, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(inputChannelUrl, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addComponent(showHintLabel)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(profilePictureOfChannel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(answer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(subscriberPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(submitButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(imgLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(subscriberCount, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(publishDate, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(totalVideoViews, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(uploadedVideoNumber))
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
        //CollectData(inputID);
        OutputChannelDataOnPanel(inputID);  
            
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
       // piePlotForLanguages.setLabelGenerator(pieLabelGeneratorForLanguages);
        
        
        /*
        The week in wich the most comments arrived (Donut Chart)
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
        DefaultCategoryDataset defaultRatioDataset = new DefaultCategoryDataset();
        ArrayMap<String, Double> viewLikeRatios = new ArrayMap();
        try {
            viewLikeRatios = DataMining.getViewAndLikeRatio(inputID);
        } catch (SQLException ex) {
            Logger.getLogger(Form.class.getName()).log(Level.SEVERE, null, ex);
        }
        viewLikeRatios.entrySet().forEach(entry -> {
            defaultRatioDataset.setValue(entry.getValue(), "View - Like Ratio", entry.getKey());
        });
        JFreeChart jchartRatio = ChartFactory.createBarChart("View - Like Ratio of Videos", "Video Title", "Ratio", defaultRatioDataset, PlotOrientation.VERTICAL, true, true, false);
        

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
            arr = WordCloud.getEnglishCommentsFromDatabase(inputID,"ywWBy6J5gz8");
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
    
        /* mikorra eri el a csatorna a 30800 feliratkozot
        (linearis regresszio)
        */
        ArrayList<String> dateAndSubs = new ArrayList<>();
        try {
            dateAndSubs = LinearRegression.Reg(inputID);
        } catch (SQLException ex) {
            Logger.getLogger(Form.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        ArrayList<String> channelData = new ArrayList();
        try {
            channelData = DataMining.getDataFromChannelsTable(inputID);
        } catch (Exception ex) {
            Logger.getLogger(Form.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        this.subscriberPanelLabel1.setText(channelData.get(3));  
        this.subscriberPanelLabel2.setText("should reach");
        this.subscriberPanelLabel3.setText(dateAndSubs.get(0) + " Subscribers");
        this.subscriberPanelLabel4.setText("around " + dateAndSubs.get(1));
        
        /*
        Bar Chart for years
        */
        
        DefaultCategoryDataset commentCountYearDataset = new DefaultCategoryDataset();
        ArrayMap<String, Integer> commentNrYear = new ArrayMap();
        try {
            commentNrYear = DataMining.CommentCountPerYear(inputID);
        } catch (SQLException ex) {
            Logger.getLogger(Form.class.getName()).log(Level.SEVERE, null, ex);
        }
        commentNrYear.entrySet().forEach(entry -> {
            //System.out.println(entry.getKey() + " " + entry.getValue());
            commentCountYearDataset.setValue(entry.getValue(), "View - Like Ratio", entry.getKey());
        });
       
        JFreeChart jchartCommentNrYear = ChartFactory.createBarChart("Comment count Per Year", "Year", "Comment Count", commentCountYearDataset, PlotOrientation.HORIZONTAL, true, true, false);
        jchartCommentNrYear.setBackgroundPaint(Color.lightGray);
        
        /*CategoryPlot plotCommentYear = jchartCommentNrYear.getCategoryPlot();
        plotCommentYear.setRangeAxisLocation(AxisLocation.BOTTOM_OR_LEFT);
        
        
        final NumberAxis rangeAxis = (NumberAxis) plotCommentYear.getRangeAxis();
        rangeAxis.setRange(0.0, 100.0);
        rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());*/
        
        /*
        Gender-Age Distribution of the viewers
        */
        String series1 = "Men";
        String series2 = "Women";
        DefaultCategoryDataset datasetD = new DefaultCategoryDataset();
        /*String category1 = "age13-15";
        String category2 = "age15-18";
        String category3 = "age18-24";
        String category4 = "age25-30";
        String category5 = "age30-";

        DefaultCategoryDataset datasetD = new DefaultCategoryDataset();

        datasetD.addValue(1.0, series1, category1);
        datasetD.addValue(4.0, series1, category2);
        datasetD.addValue(3.0, series1, category3);
        datasetD.addValue(5.0, series1, category4);
        datasetD.addValue(5.0, series1, category5);

        datasetD.addValue(5.0, series2, category1);
        datasetD.addValue(6.0, series2, category3);
        datasetD.addValue(8.0, series2, category4);
        datasetD.addValue(4.0, series2, category5);*/
        
        ArrayList<Double> femalePerc = new ArrayList();
        ArrayList<Double> maleDistribution = new ArrayList<>();
        ArrayList<String> categories = new ArrayList<>();
        try {
            femalePerc = DataMining.FemalePercentageOfDemographics(inputID);
            maleDistribution  = DataMining.MalePercentageOfDemographics(inputID);
            categories = DataMining.AgeGenderPercentage(inputID);
        } catch (SQLException ex) {
            Logger.getLogger(Form.class.getName()).log(Level.SEVERE, null, ex);
        }
        
       
        for (int i=0;i<categories.size();++i)
        {
            String category = categories.get(i);
            datasetD.addValue(maleDistribution.get(i), series1, category);
        }
        for (int i=0;i<categories.size();++i)
        {
            String category = categories.get(i);
            datasetD.addValue(femalePerc.get(i), series2, category);
        }
        
        JFreeChart jchartD = ChartFactory.createBarChart("Demographic-Age distribution", "Age Group", "Percentage", datasetD, PlotOrientation.VERTICAL, true, true, false);

        CategoryPlot plotD = jchartD.getCategoryPlot();
        BarRenderer barRendererD = (BarRenderer)plotD.getRenderer();
        barRendererD.setItemMargin(0.0);
        barRendererD.setSeriesPaint(0, Color.GREEN);
        
        /*
        Age Distribution of Viewers
        */
        
        ArrayList<String> ages = new ArrayList<>();
        ArrayList<Double> sumPercentages = new ArrayList<>();
        try {
            sumPercentages = DataMining.SumOfAgeDistributions(inputID);
            ages = DataMining.AgeGenderPercentage(inputID);
        } catch (SQLException ex) {
            Logger.getLogger(Form.class.getName()).log(Level.SEVERE, null, ex);
        }

        DefaultCategoryDataset datasetAgeDistribution = new DefaultCategoryDataset();
        for(int i=0;i<ages.size();++i)
        {
            datasetAgeDistribution.addValue(sumPercentages.get(i), "Dispersion", ages.get(i));
        }
       

        JFreeChart chartAgeDistribution = ChartFactory.createLineChart(  
        "Age distribution of the viewers", // Chart title  
        "Age Groups", // X-Axis Label  
        "Percentage", // Y-Axis Label  
        datasetAgeDistribution 
        );  
        
        CategoryPlot plotAge = (CategoryPlot) chartAgeDistribution.getPlot();
        plotAge.getRenderer().setSeriesStroke(0, new BasicStroke(2.0f)); // cahnging thickness of the line
       
        /*
        Order in wich the videos are watched
        */
           
        ArrayList<ArrayList<String>> arrayOfVideoOrders = new ArrayList<>();
        try {
            arrayOfVideoOrders = DataMining.CommentOrderPerPerson(inputID);
        } catch (SQLException ex) {
            Logger.getLogger(Form.class.getName()).log(Level.SEVERE, null, ex);
        }
        Integer nrOfSeries = arrayOfVideoOrders.get(0).size() ; // annyi series lesz amennyi sorrend van -> ebben az esetben 6
        XYSeriesCollection xySeriesCollection = new XYSeriesCollection();
        
        for (int j = 1; j < nrOfSeries; ++j) {
             XYSeries s = new XYSeries("Order of comment: " + j);
            for (int i = 0; i < arrayOfVideoOrders.size(); ++i) {
                ArrayList<String> tempArray = new ArrayList<>();
                tempArray = arrayOfVideoOrders.get(i);
                if(!tempArray.get(j).equals("0"))
                {
                    s.add(Integer.parseInt(tempArray.get(j)), i);
                }
                
            }
            xySeriesCollection.addSeries(s);
        }
        
        JFreeChart chartO = ChartFactory.createScatterPlot(
        "Order of Videos ", 
        "Nummber of comments left", "Videos", xySeriesCollection,PlotOrientation.HORIZONTAL,true,true,false);
        
        XYPlot plotO = (XYPlot) chartO.getPlot();
        
        String[] videos =  new String[arrayOfVideoOrders.size()];
        for(int i=0;i<arrayOfVideoOrders.size();++i)
        {
            String name = arrayOfVideoOrders.get(i).get(0);
            String splitArray[] = name.split(" ", 2);
            String firstWord = splitArray[0]; 
            videos[i] = firstWord;
        }
       
        SymbolAxis rangeAxis = new SymbolAxis("Videos",videos);
         if(inputID.equals("UC9m2XDfCnrS4QTzVBTrD89w"))
        {
            rangeAxis.setVerticalTickLabels(true);
        }
        
        rangeAxis.setTickUnit(new NumberTickUnit(1));
        plotO.setRangeAxis(rangeAxis);
        /*XYSeriesCollection xySeriesCollection = new XYSeriesCollection();
        XYSeries s1 = new XYSeries("Elso");      
        s1.add(3, 0);
        s1.add(5, 1);
        s1.add(6, 2);
        s1.add(3, 3);
        s1.add(2, 4);
        s1.add(1, 5);
        s1.add(9, 6);
        
        XYSeries s2 = new XYSeries("Masodik");
        s2.add(10, 0);
        s2.add(30, 1);
        s2.add(2, 2);
        s2.add(0, 3);
        s2.add(9, 4);
        
        xySeriesCollection.addSeries(s1);
        xySeriesCollection.addSeries(s2);
             
        JFreeChart chartO = ChartFactory.createScatterPlot(
        "Order of Videos", 
        "X-Axis", "Y-Axis", xySeriesCollection,PlotOrientation.HORIZONTAL,true,true,false);
        
        XYPlot plotO = (XYPlot) chartO.getPlot();
        //plotO.setForegroundAlpha(0.5f);

        String[] grade =  new String[7];
        grade[0] = "Quick";
        grade[1] = "Bubble";
        grade[2] = "Merge";
        grade[3] = "Select";
        grade[4] = "Shell";
        grade[5] = "Radix";
        grade[6] = "Gnome";
             
        SymbolAxis rangeAxis = new SymbolAxis("Videos",grade);   
        rangeAxis.setTickUnit(new NumberTickUnit(1));
        plotO.setRangeAxis(rangeAxis);*/
        
        
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
        ChartPanel chartPanelCommentCountPerYaer = new ChartPanel(jchartCommentNrYear);
        ChartPanel chartPanelDemographics = new ChartPanel(jchartD);
        ChartPanel chartPanelAgeDistributions = new ChartPanel(chartAgeDistribution);
        ChartPanel panelO = new ChartPanel(chartO);
     
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
        analysisPanel.add(chartPanelCommentCountPerYaer);
        if(inputID.equals("UCIqiLefbVHsOAXDAxQJH7Xw"))
        {
            analysisPanel.add(chartPanelDemographics);
            analysisPanel.add(chartPanelAgeDistributions);
        }
        
        analysisPanel.add(panelO);
        analysisPanel.updateUI();    
       
    }//GEN-LAST:event_submitButtonActionPerformed

    private void showHintLabelMouseMoved(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_showHintLabelMouseMoved
        
        showHintLabel.addMouseListener(new java.awt.event.MouseAdapter() {
    @Override
    public void mouseEntered(java.awt.event.MouseEvent evt) {
        
       imgLabel.setVisible(true);
       Font font = showHintLabel.getFont();
       Map attributes = font.getAttributes();
       attributes.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);
       showHintLabel.setFont(font.deriveFont(attributes));     
    }

    public void mouseExited(java.awt.event.MouseEvent evt) {
        
        imgLabel.setVisible(false);
        Font font = showHintLabel.getFont();
        Map attributes = font.getAttributes();
        attributes.put(TextAttribute.UNDERLINE, -1);
        showHintLabel.setFont(font.deriveFont(attributes));       
    }
});
       
    }//GEN-LAST:event_showHintLabelMouseMoved
    
    public Form(JPanel analysisPanel, JLabel answer, JLabel estimatedEarning, JLabel imgLabel, JTextField inputChannelUrl, JLabel jLabel1, JLabel jLabel2, JScrollPane jScrollPane1, Label label1, JLabel profilePictureOfChannel, JLabel publishDate, JLabel showHintLabel, JButton submitButton, JLabel subscriberCount, JPanel subscriberPanel, JLabel subscriberPanelLabel1, JLabel subscriberPanelLabel2, JLabel subscriberPanelLabel3, JLabel subscriberPanelLabel4, JLabel totalVideoViews, JLabel uploadedVideoNumber) throws HeadlessException {
        this.analysisPanel = analysisPanel;
        this.answer = answer;
        this.estimatedEarning = estimatedEarning;
        this.imgLabel = imgLabel;
        this.inputChannelUrl = inputChannelUrl;
        this.jLabel1 = jLabel1;
        this.jLabel2 = jLabel2;
        this.jScrollPane1 = jScrollPane1;
        this.label1 = label1;
        this.profilePictureOfChannel = profilePictureOfChannel;
        this.publishDate = publishDate;
        this.showHintLabel = showHintLabel;
        this.submitButton = submitButton;
        this.subscriberCount = subscriberCount;
        this.subscriberPanel = subscriberPanel;
        this.subscriberPanelLabel1 = subscriberPanelLabel1;
        this.subscriberPanelLabel2 = subscriberPanelLabel2;
        this.subscriberPanelLabel3 = subscriberPanelLabel3;
        this.subscriberPanelLabel4 = subscriberPanelLabel4;
        this.totalVideoViews = totalVideoViews;
        this.uploadedVideoNumber = uploadedVideoNumber;
    }
    
    private void showHintLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_showHintLabelMouseClicked
       
    }//GEN-LAST:event_showHintLabelMouseClicked

    public static Integer countOccurancesOfEachWeek (Integer actualWeek, ArrayList<Integer> arrayOfWeeksWithMostComments)
    {
        int counter = 0;
        for(int j = 0;j<arrayOfWeeksWithMostComments.size();++j)
        {
            if(arrayOfWeeksWithMostComments.get(j).equals(actualWeek))
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
  
    public void OutputChannelDataOnPanel(String inputID)
    {
        ArrayList<String> basicChannelStatistics = new ArrayList();
        
        try {
            //basicChannelStatistics = DataMining.getChannelStatistics(inputID);
            basicChannelStatistics = DataMining.getDataFromChannelsTable(inputID);
             
        } catch (Exception ex) {
            Logger.getLogger(Form.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        this.answer.setText("Channel Title: " + basicChannelStatistics.get(3));
        this.publishDate.setText(basicChannelStatistics.get(4));
        this.subscriberCount.setText(basicChannelStatistics.get(0));
        this.totalVideoViews.setText(basicChannelStatistics.get(1));
        this.uploadedVideoNumber.setText(basicChannelStatistics.get(2));
        
        earningsResult = countLowerAndUpperBoundOfEarnings(basicChannelStatistics);
        
        this.estimatedEarning.setText("$" + String.valueOf(earningsResult.get(0)) + " - $" + String.valueOf(earningsResult.get(1)));
         URL url = null;
        String profilePictureUrl = basicChannelStatistics.get(5);
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
            // DataMining.getChannelStatistics(inputID);
            //DataMining.getVideoStatisticsSpec2(inputID);  
            DataMining.getCommentsAndStatisticsSpec(inputID);
            DataMining.getReplies(inputID);
            
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
    private static javax.swing.JLabel imgLabel;
    private javax.swing.JTextField inputChannelUrl;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private java.awt.Label label1;
    private javax.swing.JLabel profilePictureOfChannel;
    private javax.swing.JLabel publishDate;
    private static javax.swing.JLabel showHintLabel;
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
