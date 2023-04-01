/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project00;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * FXML Controller class
 *
 * @author Ghadi
 */
public class Cv_info3UpController implements Initializable {

    String path = "\\Users\\koka_\\Desktop\\UQU\\7th semester\\APproject\\Audio\\click-on-mouse.mp3";
    Media media = new Media(new File(path).toURI().toString());
    MediaPlayer mediaplayer = new MediaPlayer(media);

//    @FXML
//    private TextField Language1;
    @FXML
    private TextField Level1;

//    @FXML
//    private TextField Language2;
    @FXML
    private TextField Level2;

    @FXML
    private TextField Skill1;

    @FXML
    private TextField Skill2;

    @FXML
    private TextField Skill3;
//    @FXML
//    private TextField Language1;
//    @FXML
//    private TextField Language2;
    @FXML
    private Text Language1;
    @FXML
    private Text Language2;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Language1.setText(gloabl.user.cv.language.get(0).getLanguage());
        Level1.setPromptText(gloabl.user.cv.language.get(0).getLevel());
        Language2.setText(gloabl.user.cv.language.get(1).getLanguage());
        Level2.setPromptText(gloabl.user.cv.language.get(1).getLevel());

        Skill1.setPromptText(gloabl.user.cv.Skill.get(0).getSkillName());

        Skill2.setPromptText(gloabl.user.cv.Skill.get(1).getSkillName());

        Skill3.setPromptText(gloabl.user.cv.Skill.get(2).getSkillName());

    }

    /* @FXML
    private void Back_info2(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("Cv_info2Up.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage)((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
       
    }*/
    @FXML
    private void Next_CvTamplet(ActionEvent event) throws IOException {
        Session session1 = HibernateUtil.getSessionFactory().openSession();
        session1 = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session1.beginTransaction();

        List<languages> lang = gloabl.user.cv.language;
        if (!(Level1.getText().isEmpty())) {
            languages lan1 = new languages();
            lan1.setLevel(Level1.getText());
            lan1.setLanguage(Language1.getText());
            lan1.setCVID(gloabl.user.cv.getCVID());
            session1.update(lan1);
            lang.add(0, lan1);
        }if(!(Level2.getText().isEmpty())) {
            languages lan2 = new languages();
            lan2.setLevel(Level2.getText());
            lan2.setLanguage(Language2.getText());
            lan2.setCVID(gloabl.user.cv.getCVID());
            session1.update(lan2);
            lang.add(1, lan2);}
        gloabl.user.cv.language = lang;


        List<skill> sk = gloabl.user.cv.getSkill();

        if (!(Skill1.getText().isEmpty())) {
            skill skill = new skill();
            skill.setSkillName(Skill1.getText());
            skill.setSkillNo(1);
            skill.setCVID(gloabl.user.cv.getCVID());
            session1.update(skill);
            sk.add(0, skill);
        }

        if (!(Skill2.getText().isEmpty())) {
            skill skill = new skill();
            skill.setSkillName(Skill2.getText());
            skill.setSkillNo(2);
            skill.setCVID(gloabl.user.cv.getCVID());
            session1.update(skill);
            sk.add(1, skill);
        }
        if (!(Skill3.getText().isEmpty())) {
            skill skill = new skill();
            skill.setSkillName(Skill3.getText());
            skill.setSkillNo(3);
            skill.setCVID(gloabl.user.cv.getCVID());
            session1.update(skill);
            sk.add(2, skill);

        }
        gloabl.user.cv.Skill = sk;

        session1.getTransaction().commit();
        session1.close();
        Parent root = FXMLLoader.load(getClass().getResource("Cv_Home.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
        mediaplayer.play();
    }
}