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
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * FXML Controller class
 *
 * @author Ghadi
 */
public class Cv_info2Controller implements Initializable {

    String path = "\\Users\\koka_\\Desktop\\UQU\\7th semester\\APproject\\Audio\\click-on-mouse.mp3";
    Media media = new Media(new File(path).toURI().toString());
    MediaPlayer mediaplayer = new MediaPlayer(media);

    @FXML
    private TextField Dgree;

    @FXML
    private TextField NameOfUni;

    @FXML
    private TextField graduateYaar;

    @FXML
    private TextField JobTitle;

    @FXML
    private TextField CompName;

    @FXML
    private TextField StartDate;

    @FXML
    private TextField EndDate;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO

    }
    // mediaplayer.play();

    @FXML
    private void Next_info2(ActionEvent event) throws IOException {
        Session session1 = HibernateUtil.getSessionFactory().openSession();
        session1 = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session1.beginTransaction();

        education edu = new education();
        edu.setDgree(Dgree.getText());
        edu.setUniName(NameOfUni.getText());
        edu.setGradDate(graduateYaar.getText());
        edu.setCVID(gloabl.user.cv.getCVID());
        gloabl.user.cv.education = edu;
        gloabl.user.cv.setEducation(edu);

        experience exp = new experience();
        exp.setJopTitle(JobTitle.getText());
        exp.setCompName(CompName.getText());
        exp.setStartDate(StartDate.getText());
        exp.setEndDate(EndDate.getText());
        exp.setCVID(gloabl.user.cv.getCVID());
        gloabl.user.cv.experience = exp;

        session1.save(exp);
        session1.save(edu);

        session1.getTransaction().commit();
        session1.close();
        Parent root = FXMLLoader.load(getClass().getResource("Cv_info3.fxml"));
        Scene scene = new Scene(root);

        // gets stage info
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
        mediaplayer.play();
    }

    /*@FXML
    private void Back_Cvinfo1(ActionEvent event) throws IOException {
     Parent root = FXMLLoader.load(getClass().getResource("Cv_info1.fxml"));
     Scene scene = new Scene(root);
    
    // gets stage info
     Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
     stage.setScene(scene);
     stage.show();
     mediaplayer.play();
    }*/
}
