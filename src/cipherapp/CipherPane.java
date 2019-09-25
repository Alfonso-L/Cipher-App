/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cipherapp;

import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.chart.Axis;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

/**
 *
 * @author AL
 */
public class CipherPane extends BorderPane {

    CipherLogic cipherlogic = new CipherLogic();
    PlainTextStatistics vocabStats = new PlainTextStatistics();

    GridPane middleGrid;
    HBox topBox;
    HBox bottomBox;
    VBox rightBox;
    VBox leftBox;

    //top variables
    Text title = new Text("Cipher Project");

    //middle variables
    Label inputPlainLabel = new Label("Enter text to encrypt");
    TextField inputPlainTextField = new TextField();
    Label inputKeyLabel = new Label("Enter encrypt key");
    TextField inputKeyTextField = new TextField();
    Label outputCipherLabel = new Label("Encrypted text");
    TextField outputCipherTextField = new TextField();
    Image lockImage = new Image("file:closedlock.png");
    ImageView LockView = new ImageView(lockImage);
    Button encryptButton = new Button("Encrypt", LockView);

    Label inputCipherLabel = new Label("Enter text to decrypt");
    TextField inputCipherTextField = new TextField();
    Label inputKeyLabel2 = new Label("Enter decrypt key");
    TextField inputKey2TextField = new TextField();
    Label outputPlainLabel = new Label("Decrypted text");
    TextField outputPlainTextField = new TextField();
    Image openlockImage = new Image("file:openlock.png");
    ImageView openLockView = new ImageView(openlockImage);
    Button dencryptButton = new Button("Dencrypt", openLockView);

    //
    Image updateImage = new Image("file:update.png");
    ImageView updateView = new ImageView(updateImage);
    Button updateAnalisisBarChartButton = new Button("Update Cipher Chart", updateView);

    //Buttom variables
    Label KeyInformationLabel = new Label("The key is: ");
    TextField KeyInformationTextField = new TextField();
    
    //Bar chart
    //chart 1
    CategoryAxis xAxis = new CategoryAxis();
    NumberAxis yAxis = new NumberAxis();
    BarChart<String, Number> ctGraph = new BarChart<String, Number>(xAxis, yAxis);
    //XYChart.Series series1 = new XYChart.Series();

    //chart 2
    CategoryAxis xAxis2 = new CategoryAxis();
    NumberAxis yAxis2 = new NumberAxis();
    BarChart<String, Number> pTGraph = new BarChart<String, Number>(xAxis2, yAxis2);
    //XYChart.Series series2_1 = new XYChart.Series();

    //is the graph full
    boolean isGraphFull = false; // not used

    //String fields
    String plainText;
    String encrptedText;
    String encrytedToPlainText;
    String plainTextToEncryted;

    String masterAnalyeCipherString = "";

    public CipherPane() throws FileNotFoundException {
        GuiSetup();
        
    }

    public void GuiSetup() throws FileNotFoundException {

        Opereation();

        //Top
        topBox = new HBox();
        title.setFont(new Font("AppleGothic", 30));
        title.setWrappingWidth(200);
        title.setTextAlignment(TextAlignment.JUSTIFY);
        topBox.getChildren().add(title);
        this.setTop(topBox);

        //middle
        middleGrid = new GridPane();
        middleGrid.setHgap(10);
        middleGrid.setVgap(10);
        middleGrid.setPadding(new Insets(10, 10, 10, 10));
        middleGrid.add(inputPlainLabel, 0, 0);
        middleGrid.add(inputPlainTextField, 0, 1);
        middleGrid.add(inputKeyLabel, 0, 2);
        middleGrid.add(inputKeyTextField, 0, 3);
        middleGrid.add(outputCipherLabel, 0, 4);
        middleGrid.add(outputCipherTextField, 0, 5);

        LockView.setFitHeight(35);
        LockView.setFitWidth(35);
        middleGrid.add(encryptButton, 0, 6);

        updateView.setFitHeight(30);
        updateView.setFitWidth(35);
        middleGrid.add(updateAnalisisBarChartButton, 0, 7);

        middleGrid.add(inputCipherLabel, 1, 0);
        middleGrid.add(inputCipherTextField, 1, 1);
        middleGrid.add(inputKeyLabel2, 1, 2);
        middleGrid.add(inputKey2TextField, 1, 3);
        middleGrid.add(outputPlainLabel, 1, 4);
        middleGrid.add(outputPlainTextField, 1, 5);

        openLockView.setFitHeight(35);
        openLockView.setFitWidth(35);
        middleGrid.add(dencryptButton, 1, 6);

        this.setCenter(middleGrid);

        //bottom
        HBox pieChartArea = new HBox(50);
        ctGraph.setTitle("Cipher Histogram");
        xAxis.setLabel("Character");
        yAxis.setLabel("Frequency");

        pieChartArea.getChildren().add(ctGraph);
       

        pTGraph.setTitle("PlainText Histogram");
        xAxis2.setLabel("Character");
        yAxis2.setLabel("Frequency");

        PopPlainTextGraph(pTGraph);
        pieChartArea.getChildren().add(pTGraph);

        VBox dataInformationBox = new VBox(10);
        dataInformationBox.getChildren().add(KeyInformationLabel);
        dataInformationBox.getChildren().add(KeyInformationTextField);
        
        pieChartArea.getChildren().add(dataInformationBox);
        this.setBottom(pieChartArea);
        
        //disable textboxes for output fields
        outputCipherTextField.setEditable(false);
        outputPlainTextField.setEditable(false);

    }

    public void Opereation() {
        encryptButton.setOnAction(new EnryptButton());
        dencryptButton.setOnAction(new DecryptButton());
        updateAnalisisBarChartButton.setOnAction(new UpdateButton());
    }

    public class EnryptButton implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {
            plainText = inputPlainTextField.getText();
            int keyEncrypt = Integer.parseInt(inputKeyTextField.getText());
            plainTextToEncryted = cipherlogic.doEncryption(plainText, keyEncrypt);
            outputCipherTextField.setText(plainTextToEncryted);

        }

    }

    public class DecryptButton implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {
            encrptedText = inputCipherTextField.getText();
            int key2 = Integer.parseInt(inputKey2TextField.getText());
            encrytedToPlainText = cipherlogic.doDecryption(encrptedText, key2);
            outputPlainTextField.setText(plainText);

        }

    }

    //seting the plaintext gragh
    public void PopPlainTextGraph(BarChart<String, Number> plainTextBarGraph) throws FileNotFoundException {
        char[] alphabet = cipherlogic.getAlphabetCharacters(); //26
        int[] plainTextData = vocabStats.GetAlphabetStats(); //26
        String[] alphabetToString = new String[alphabet.length]; //26
        XYChart.Series[] bars = new XYChart.Series[alphabet.length]; //26

        for (int i = 0; i < alphabet.length; i++) {
            alphabetToString[i] = String.valueOf(alphabet[i]);
            bars[i] = new XYChart.Series();
            bars[i].setName(alphabetToString[i]);

            bars[i].getData().add(new XYChart.Data(alphabetToString[i], plainTextData[i]));

        }

        plainTextBarGraph.getData().addAll(bars);

    }

    public class UpdateButton implements EventHandler<ActionEvent> {

        @Override
        public void handle(ActionEvent event) {

            //System.out.println("Master String: "+ masterAnalyeCipherString);
            try {
                masterAnalyeCipherString += plainTextToEncryted;
                int[] cipherVocabCount = vocabStats.GetCipherStats(masterAnalyeCipherString);
                int[] plainVocabCount = vocabStats.GetAlphabetStats();
                PopCipherTextGraph(ctGraph, cipherVocabCount, plainVocabCount);

            } catch (FileNotFoundException ex) {
                Logger.getLogger(CipherPane.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public void PopCipherTextGraph(BarChart<String, Number> plainCipherBarGraph, int[] cipherVocStats, int[] plainVocStats) throws FileNotFoundException {

        char[] alphabet = cipherlogic.getAlphabetCharacters(); //26
        int[] cipherVocStats2 = cipherVocStats;
        String[] alphabetToString = new String[alphabet.length]; //26
        XYChart.Series[] bars = new XYChart.Series[alphabet.length]; //26

        plainCipherBarGraph.getData().clear();
        plainCipherBarGraph.getData().removeAll(bars);
        plainCipherBarGraph.getData().clear();

        for (int i = 0; i < alphabet.length; i++) {
            alphabetToString[i] = String.valueOf(alphabet[i]);
            bars[i] = new XYChart.Series();
            bars[i].setName(alphabetToString[i]);
            bars[i].getData().add(new XYChart.Data(alphabetToString[i], cipherVocStats2[i]));
        }
        plainCipherBarGraph.getData().addAll(bars);

        //comparing keys
        int biggestCipherInt = 0;
        int currentCipherBiggestInt = 0;
        int indexOfCipherBigesst = 0;

        //getting index for biggest number from the calculated statistics: Cipher
        for (int i = 0; i < cipherVocStats2.length; i++) {

            currentCipherBiggestInt = cipherVocStats2[i];

            if (currentCipherBiggestInt > biggestCipherInt) {
                biggestCipherInt = currentCipherBiggestInt;
                indexOfCipherBigesst = i+1;

            }

        }

        int biggestPlainTInt = 0;
        int currentPlainTBiggestInt = 0;
        int indexOfPlainTBigesst = 0;

        for (int i = 0; i < plainVocStats.length; i++) {
            currentPlainTBiggestInt = plainVocStats[i];

            if (currentPlainTBiggestInt < biggestPlainTInt) {
                biggestPlainTInt = currentPlainTBiggestInt;
                indexOfPlainTBigesst = i+1;
            }

        }
        
        int indexOfE = 0;
        for (int i = 0; i < alphabet.length; i++) {
            if (alphabet[i] == 'e') {
                indexOfE = i+1;
                System.out.println("e index is :" + indexOfE);
            }
            
        }
        
        int diffDistanceOfKey;
        
        if (indexOfPlainTBigesst < indexOfCipherBigesst ) {
             diffDistanceOfKey = indexOfCipherBigesst - indexOfPlainTBigesst;
            diffDistanceOfKey = Math.abs(diffDistanceOfKey);
            
        }
        else
        {
           diffDistanceOfKey =  indexOfPlainTBigesst - indexOfCipherBigesst;
           diffDistanceOfKey = Math.abs(diffDistanceOfKey);
        }
        int mny = Math.abs(diffDistanceOfKey - indexOfE);
        System.out.println("Key is: "+ (diffDistanceOfKey));
        System.out.println("New key: "+ mny);
        KeyInformationTextField.setText(String.valueOf(mny));
        int differenceBetweenTheIndexes = indexOfCipherBigesst - indexOfPlainTBigesst;
            differenceBetweenTheIndexes = Math.abs(differenceBetweenTheIndexes);
            
            
    }

//    //seting the plaintext gragh
//    public XYChart.Series[] PopPainGraph(BarChart<String, Number> plainTextBarGraph) {
//        char[] alphabet = cipherlogic.getAlphabetCharacters(); //26
//        String[] alphabetToString = new String[alphabet.length]; //26
//        XYChart.Series[] bars = new XYChart.Series[26]; //26
//
//        for (int i = 0; i < alphabet.length; i++) {
//            alphabetToString[i] = String.valueOf(alphabet[i]);
//            bars[i] = new XYChart.Series();
//            bars[i].setName(alphabetToString[i]);
//
//        }
//        
//        
//
//        return bars;
//    }
}
