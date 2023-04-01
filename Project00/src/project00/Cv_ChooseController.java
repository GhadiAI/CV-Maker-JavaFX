/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project00;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * FXML Controller class
 *
 * @author Ghadi
 */


public class Cv_ChooseController implements Initializable {
String path ="\\Users\\koka_\\Desktop\\UQU\\7th semester\\APproject\\Audio\\click-on-mouse.mp3";
    Media media=new Media(new File(path).toURI().toString());
    MediaPlayer mediaplayer =new MediaPlayer(media);
    @FXML
    private Pane MPane;
    @FXML
    private Pane FPane;
    @FXML
    private Rectangle rec;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
       MPane.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent e) {
                if (e.getCode() == KeyCode.F) {
                    try {
                        Parent root;
                        root = FXMLLoader.load(Cv_ChooseController.this.getClass().getResource("Export.fxml"));
                        
                        Scene scene = new Scene(root);
                        // gets stage info
                        Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
                        stage.setScene(scene);
                        stage.show();
                        mediaplayer.play();// TODO
                    } catch (IOException ex) {
                        Logger.getLogger(CvTamplte0Controller.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        });
    }    

    
    
    @FXML
    private void Back_info3(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Cv_Home.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    
    
  
    
//    @FXML
//    private void Choose_1(ActionEvent event) throws IOException {
//        Parent root = FXMLLoader.load(getClass().getResource("CvTamplte0.fxml"));
//        Scene scene = new Scene(root);
//        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
//        stage.setScene(scene);
//        stage.show();
//    }

//    @FXML
//    private void Choose_2(ActionEvent event) throws IOException {
//        Parent root = FXMLLoader.load(getClass().getResource("CvTamplte1.fxml"));
//        Scene scene = new Scene(root);
//        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
//        stage.setScene(scene);
//        stage.show();
//    }
//    




    @FXML
    private void Choose1(MouseEvent event)  throws IOException{
                Parent root = FXMLLoader.load(getClass().getResource("CvTamplte1.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    private void Choose0(MouseEvent event)  throws IOException{
        
         Parent root = FXMLLoader.load(getClass().getResource("CvTamplte0.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
    
}
