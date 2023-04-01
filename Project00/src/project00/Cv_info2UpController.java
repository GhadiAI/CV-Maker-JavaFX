/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project00;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * FXML Controller class
 *
 * @author Ghadi
 */
public class Cv_info2UpController implements Initializable {

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
        Dgree.setPromptText(gloabl.user.cv.education.getDgree());
        NameOfUni.setPromptText(gloabl.user.cv.education.getUniName());
        graduateYaar.setPromptText(gloabl.user.cv.education.getGradDate());
        JobTitle.setPromptText(gloabl.user.cv.experience.getJopTitle());
        CompName.setPromptText(gloabl.user.cv.experience.getCompName());
        StartDate.setPromptText(gloabl.user.cv.experience.getStartDate());
        EndDate.setPromptText(gloabl.user.cv.experience.getEndDate());

// TODO
    }
    // mediaplayer.play();

    @FXML
    private void Next_info2(ActionEvent event) throws IOException {

        Session session1 = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session1.beginTransaction();
        boolean flag = false;
        boolean eduFlag = false;
        education edu = gloabl.user.cv.getEducation();
        if (!(Dgree.getText().isEmpty())) {
            edu.setDgree(Dgree.getText());
            eduFlag = true;
        }
        if (!(NameOfUni.getText().isEmpty())) {
            edu.setUniName(NameOfUni.getText());
            eduFlag = true;
        }
        if (!(graduateYaar.getText().equals(""))) {
            edu.setGradDate(graduateYaar.getText());
            eduFlag = true;
        }
//              
        gloabl.user.cv.setEducation(edu);

        if (eduFlag) {
            session1.update(gloabl.user.cv.getEducation());
            // session1.getTransaction().commit();
            eduFlag = false;
        }
        System.out.println(gloabl.user.cv.getEducation());

        boolean expFlag = false;
        experience exp = gloabl.user.cv.getExperience();
        if (!(JobTitle.getText().isEmpty())) {
            exp.setJopTitle(JobTitle.getText());
        }
            //expFlag = true;
//        } else {
//            exp.setJopTitle(gloabl.user.cv.experience.getJopTitle());
//        }
        if (!(CompName.getText().isEmpty())) {
            exp.setCompName(CompName.getText());
        }
            //expFlag = true;
//        } else {
//            exp.setJopTitle(gloabl.user.cv.experience.getCompName());
//        }
        if (!(StartDate.getText().isEmpty())) {
            exp.setStartDate(StartDate.getText());
        }
            //expFlag = true;
//        } else {
//            exp.setJopTitle(gloabl.user.cv.experience.getStartDate());
//        }
        if (!(EndDate.getText().isEmpty())) {
            exp.setEndDate(EndDate.getText());
            expFlag = true;
        }

        exp.setCVID(gloabl.user.cv.getCVID());
        gloabl.user.cv.setExperience(exp);

        session1.update(gloabl.user.cv.getExperience());
        //session1.getTransaction().commit();

        session1.getTransaction().commit();
        session1.close();

        Parent root = FXMLLoader.load(getClass().getResource("Cv_info3Up.fxml"));
        Scene scene = new Scene(root);

        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
        mediaplayer.play();
    }

    /*@FXML
    private void Back_Cvinfo1(ActionEvent event) throws IOException {
     Parent root = FXMLLoader.load(getClass().getResource("Cv_info1Up.fxml"));
     Scene scene = new Scene(root);
    
    // gets stage info
     Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
     stage.setScene(scene);
     stage.show();
     mediaplayer.play();
    }*/

        
        }
