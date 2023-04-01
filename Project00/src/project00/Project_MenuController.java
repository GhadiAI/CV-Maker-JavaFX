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
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * FXML Controller class
 *
 * @author R tech
 */
public class Project_MenuController implements Initializable {

    String path = "\\Users\\koka_\\Desktop\\UQU\\7th semester\\APproject\\Audio\\click-on-mouse.mp3";
    Media media = new Media(new File(path).toURI().toString());
    MediaPlayer mediaplayer = new MediaPlayer(media);

    @Override
    public void initialize(URL location, ResourceBundle resources) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    // Changing the Scene 
    @FXML
    public void cv_page(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Cv_Home.fxml"));
        Scene scene = new Scene(root);

        // gets stage info
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
        mediaplayer.play();
    }

    @FXML
    public void Goals_page(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Goals.fxml"));
        Scene scene = new Scene(root);

        // gets stage info
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
        mediaplayer.play();
    }

    @FXML
    private void LogOut(MouseEvent event) throws IOException{
    gloabl.user=null;
        gloabl.user.cv=null;
        Parent root = FXMLLoader.load(getClass().getResource("Log_in.fxml"));
        Scene scene = new Scene(root);

        // gets stage info
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
        mediaplayer.play();
    }

    @FXML
    private void LogOut1(MouseEvent event)throws IOException {
        gloabl.user=null;
        gloabl.user.cv=null;
        Parent root = FXMLLoader.load(getClass().getResource("Log_in.fxml"));
        Scene scene = new Scene(root);

        // gets stage info
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
        mediaplayer.play();
    }

}
